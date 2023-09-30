package com.abdul.cinemamoviesservice.mapper;

import com.abdul.cinemamoviesservice.dto.MallResponse;
import com.abdul.cinemamoviesservice.dto.MovieRequest;
import com.abdul.cinemamoviesservice.dto.MovieResponse;
import com.abdul.cinemamoviesservice.dto.MovieWithMalls;
import com.abdul.cinemamoviesservice.model.Movie;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieMapper {

    public MovieResponse toResponse(final Movie movie){
        return new MovieResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getDescription(),
                movie.getReleaseYear()
        );
    }

    public Movie toMovie(final MovieRequest movieRequest){
        final var movie = new Movie();
        BeanUtils.copyProperties(movieRequest, movie);
        return movie;
    }

    public MovieWithMalls withMalls(final Movie movie, final List<MallResponse> mallsResponses){
        return withMalls(toResponse(movie), mallsResponses);
    }

    public MovieWithMalls withMalls(final MovieResponse movieResponse,
                                   final List<MallResponse> mallsResponse){
        return new MovieWithMalls(
                movieResponse.id(),
                movieResponse.title(),
                movieResponse.description(),
                movieResponse.releaseYear(),
                mallsResponse
        );
    }
}
