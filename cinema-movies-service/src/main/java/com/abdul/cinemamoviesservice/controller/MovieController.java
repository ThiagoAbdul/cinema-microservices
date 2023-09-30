package com.abdul.cinemamoviesservice.controller;

import com.abdul.cinemamoviesservice.dto.MallResponse;
import com.abdul.cinemamoviesservice.dto.MovieRequest;
import com.abdul.cinemamoviesservice.dto.MovieResponse;
import com.abdul.cinemamoviesservice.dto.MovieWithMalls;
import com.abdul.cinemamoviesservice.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    List<MovieResponse> findAllMoviesInTheater(){
        return movieService.listAllMoviesInTheater();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    MovieResponse addMovieToCatalog(@Valid @RequestBody final MovieRequest movieRequest){
        return movieService.addMovieToCatalog(movieRequest);
    }

    @GetMapping("/available-units/{id}")
    List<MallResponse> availableUnits(@PathVariable final UUID id){
        return movieService.availableUnitsForMovie(id);
    }

    @GetMapping("/malls")
    Page<MovieWithMalls> findMoviesWithMalls(Pageable pageable){
        return movieService.findPaginated(pageable);
    }
}
