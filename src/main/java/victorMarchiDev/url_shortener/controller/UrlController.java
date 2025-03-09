package victorMarchiDev.url_shortener.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import victorMarchiDev.url_shortener.controller.dto.ShortenUrlRequest;
import victorMarchiDev.url_shortener.domain.Url;
import victorMarchiDev.url_shortener.repository.UrlRepository;

import java.time.LocalDateTime;

@RestController
public class UrlController {

    private final UrlRepository repository;

    public UrlController(UrlRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/shorten-url")
    public ResponseEntity<Void> shortenUrl(@RequestBody ShortenUrlRequest request){
        String id;
        do{
            id = RandomStringUtils.randomAlphanumeric(5,10);
        } while(repository.existsById(id));



        repository.save(new Url(id, request.url(), LocalDateTime.now().plusMinutes(1)));



        return ResponseEntity.ok().build();
    }
}
