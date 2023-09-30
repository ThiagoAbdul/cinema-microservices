package com.abdul.cinemamoviesservice.dto;

import java.time.Year;
import java.util.UUID;

public record MovieResponse(UUID id, String title, String description, Year releaseYear) {
}
