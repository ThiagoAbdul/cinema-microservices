package com.abdul.cinemamoviesservice.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.Year;

public record MovieRequest(@NotBlank String title, String description, Year releaseYear) {
}
