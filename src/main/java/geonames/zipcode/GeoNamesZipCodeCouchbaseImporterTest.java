package geonames.zipcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:test.properties")
@Import(CouchbaseConfiguration.class)
public class GeoNamesZipCodeCouchbaseImporterTest {

    public static void main(String[] args) {
        SpringApplication.run(GeoNamesZipCodeCouchbaseImporterTest.class, args);
    }
}
