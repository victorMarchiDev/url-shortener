package victorMarchiDev.url_shortener.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import victorMarchiDev.url_shortener.controller.dto.ShortenUrlRequest;
import victorMarchiDev.url_shortener.controller.dto.ShortenUrlResponse;
import victorMarchiDev.url_shortener.service.UrlService;

import java.net.URI;

@RestController
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping(value = "/shorten-url")
    public ResponseEntity<ShortenUrlResponse> shortenUrl(@RequestBody ShortenUrlRequest request,
                                                         HttpServletRequest servletRequest) {

        String id = urlService.shortenUrl(request.url());
        var redirectUrl = servletRequest.getRequestURL().toString().replace("shorten-url", id);

        return ResponseEntity.ok(new ShortenUrlResponse(redirectUrl));
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> redirect(@PathVariable("id") String id) {
        return urlService.getUrlById(id)
                .map(url -> {
                    HttpHeaders headers = new HttpHeaders();
                    headers.setLocation(URI.create(url.getFullUrl()));
                    return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
