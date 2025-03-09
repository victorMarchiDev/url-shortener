package victorMarchiDev.url_shortener.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import victorMarchiDev.url_shortener.controller.dto.ShortenUrlRequest;

@RestController
public class UrlController {

    @PostMapping(value = "/shorten-url")
    public ResponseEntity<Void> shortenUrl(@RequestBody ShortenUrlRequest request){


        return ResponseEntity.ok().build();
    }
}
