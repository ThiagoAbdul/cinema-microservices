package com.abdul.cinemamoviesservice.dto;

import java.time.Year;
import java.util.List;
import java.util.UUID;

public record MovieWithMalls(UUID id, String title, String description, Year releaseYear, List<MallResponse> malls) {
}
