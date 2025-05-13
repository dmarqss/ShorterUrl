package com.dmarqss.shortUrl.models;

import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

public record UrlModelResponseDto(
        String id,
        String url,
        String shortUrl,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {
}
