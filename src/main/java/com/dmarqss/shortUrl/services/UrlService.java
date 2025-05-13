package com.dmarqss.shortUrl.services;


import com.dmarqss.shortUrl.models.UrlModel;
import com.dmarqss.shortUrl.models.UrlModelRequestDto;
import com.dmarqss.shortUrl.models.UrlModelResponseDto;
import com.dmarqss.shortUrl.repositorys.UrlRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UrlService {
    @Autowired
    UrlRespository urlRespository;

    private boolean existsShortUrl(String url){
        try {
            urlRespository.findByShortUrl(url);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private String shortGenerate(){
        UUID uuid = UUID.randomUUID();
        String randomString = uuid.toString();
        randomString = randomString.substring(0,15);
        return randomString;
    }

    private UrlModelResponseDto showUrlResponse(UrlModel data){
        return new UrlModelResponseDto(data.getId(), data.getUrl(), data.getShortUrl(), data.getCreatedAt(), data.getUpdatedAt());
    }

    private void viewUrl(String shortUrl){
        UrlModel model = urlRespository.findByShortUrl(shortUrl);
        model.setAccessCount(model.getAccessCount() + 1);
        urlRespository.save(model);
    }

    public UrlModelResponseDto create(UrlModelRequestDto data) {
        UrlModel newUrl = urlRespository.insert(new UrlModel(data.url(),
                shortGenerate(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                0));
        return showUrlResponse(newUrl);
    }

    public UrlModelResponseDto retrieve(String shortUrl){
        UrlModel urlModel = urlRespository.findByShortUrl(shortUrl);
        viewUrl(shortUrl);
        return showUrlResponse(urlModel);
    }

    public UrlModelResponseDto update(String shortUrl, String newUrl){
        UrlModel urlModel = urlRespository.findByShortUrl(shortUrl);
        urlModel.setUrl(newUrl);
        urlModel.setUpdatedAt(LocalDateTime.now());
        urlRespository.save(urlModel);

        return showUrlResponse(urlModel);
    }

    public void delete(String shortUrl){
        UrlModel urlModel = urlRespository.findByShortUrl(shortUrl);
        urlRespository.delete(urlModel);
    }

    public UrlModel showStats(String shortUrl){
        return urlRespository.findByShortUrl(shortUrl);
    }
}
