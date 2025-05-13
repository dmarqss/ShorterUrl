package com.dmarqss.shortUrl.repositorys;

import com.dmarqss.shortUrl.models.UrlModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRespository extends MongoRepository<UrlModel, String> {
    UrlModel findByShortUrl(String shortUrl);
}
