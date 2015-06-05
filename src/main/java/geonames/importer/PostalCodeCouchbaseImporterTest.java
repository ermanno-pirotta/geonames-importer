package geonames.importer;

import geonames.importer.configuration.CouchbaseConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Import(CouchbaseConfiguration.class)
@Profile("test")
public class PostalCodeCouchbaseImporterTest{

    public static void main(String[] args) {
        SpringApplication.run(PostalCodeCouchbaseImporterTest.class, args);
        
    }
}
