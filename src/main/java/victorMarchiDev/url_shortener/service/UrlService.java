package victorMarchiDev.url_shortener.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import victorMarchiDev.url_shortener.domain.Url;
import victorMarchiDev.url_shortener.repository.UrlRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String shortenUrl(String originalUrl) {
        String id;
        do {
            id = RandomStringUtils.randomAlphanumeric(5, 10);
        } while (urlRepository.existsById(id));

        urlRepository.save(new Url(id, originalUrl, LocalDateTime.now().plusMinutes(1)));
        return id;
    }

    public Optional<Url> getUrlById(String id) {
        return urlRepository.findById(id);
    }
}
