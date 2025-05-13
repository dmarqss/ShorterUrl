package com.dmarqss.shortUrl.models;


import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "UrlModel")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UrlModel {
    @Id
    private String id;
    @Indexed(unique = true)
    private String url;
    @Indexed(unique = true)
    private String shortUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int accessCount;

    public UrlModel(String url, String shortUrl, LocalDateTime created, LocalDateTime updated, int accessCount) {
        this.url = url;
        this.shortUrl = shortUrl;
        this.createdAt = created;
        this.updatedAt = updated;
        this.accessCount = accessCount;
    }
}
