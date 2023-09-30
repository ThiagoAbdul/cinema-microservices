package com.abdul.cinemamoviesservice.service;

import com.abdul.cinemamoviesservice.dto.MallResponse;
import com.abdul.cinemamoviesservice.dto.MovieRequest;
import com.abdul.cinemamoviesservice.dto.MovieResponse;
import com.abdul.cinemamoviesservice.dto.MovieWithMalls;
import com.abdul.cinemamoviesservice.exception.MovieAlreadyRegisteredException;
import com.abdul.cinemamoviesservice.mapper.MovieMapper;
import com.abdul.cinemamoviesservice.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final WebClient.Builder webClientBuilder;

    @Transactional(readOnly = true)
    public List<MovieResponse> listAllMoviesInTheater(){
        return movieRepository.findByInTheaterTrue()
                .stream().map(movieMapper::toResponse)
                .toList();
    }

    public List<MallResponse> availableUnitsForMovie(final UUID movieId){
        final var webClient = webClientBuilder
                .baseUrl("http://available-units-service/")
                .build();
        final var path = "/api/available-units/movie/" + movieId;
        return webClient.get()
                .uri(path)
                .retrieve()
                .bodyToFlux(MallResponse.class)
                .collectList()
                .block();
    }

    @Transactional
    public MovieResponse addMovieToCatalog(final MovieRequest movieRequest){
        final var movie = movieMapper.toMovie(movieRequest);
        movie.setInTheater(true);
        movieRepository.findByTitleAndReleaseYear(movie.getTitle(), movie.getReleaseYear())
                .ifPresent(m -> {
                    throw new MovieAlreadyRegisteredException();
                });
        movieRepository.save(movie);
        return movieMapper.toResponse(movie);
    }

    public Page<MovieWithMalls> findPaginated(Pageable pageable){
        return movieRepository.findAll(pageable)
                .map(movie -> {
                    List<MallResponse> mallResponses = availableUnitsForMovie(movie.getId());
                    return movieMapper.withMalls(movie, mallResponses);
                });

    }

}
