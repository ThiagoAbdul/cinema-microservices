package com.abdul.cinemamoviesservice.repository;


import com.abdul.cinemamoviesservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {
    List<Movie> findByInTheaterTrue();
    Optional<Movie> findByTitleAndReleaseYear(String title, Year year);
}
