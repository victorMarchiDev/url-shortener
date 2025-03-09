package victorMarchiDev.url_shortener.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import victorMarchiDev.url_shortener.domain.Url;

public interface UrlRepository extends MongoRepository<Url, String> {
}
