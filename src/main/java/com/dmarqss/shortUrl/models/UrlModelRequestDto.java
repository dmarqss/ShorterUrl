package com.dmarqss.shortUrl.models;

import jakarta.validation.constraints.NotBlank;

public record UrlModelRequestDto(@NotBlank String url) {}
