package com.dmarqss.shortUrl.Controller;


import com.dmarqss.shortUrl.models.UrlModelRequestDto;
import com.dmarqss.shortUrl.services.UrlService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "urlShorter")
public class UrlController {
    @Autowired
    UrlService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UrlModelRequestDto data){
        try{
            return new ResponseEntity<>(service.create(data),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/{shortUrl}")
    public ResponseEntity<?> retrieve(@PathVariable("shortUrl") String shortUrl){
        try {
            return new ResponseEntity<>(service.retrieve(shortUrl), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/{shortUrl}")
    public ResponseEntity<?> updateUrl(@PathVariable("shortUrl") String shortUrl, @RequestBody String newUrl){
        try {
            return new ResponseEntity<>(service.update(shortUrl, newUrl), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/{shortUrl}")
    public ResponseEntity<?> deleteUrl(@PathVariable("shortUrl") String shortUrl){
        try {
            service.delete(shortUrl);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/{shortUrl}/stats")
    public ResponseEntity<?> statsUrl(@PathVariable("shortUrl") String shortUrl){
        try {
            return new ResponseEntity<>(service.showStats(shortUrl) ,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
