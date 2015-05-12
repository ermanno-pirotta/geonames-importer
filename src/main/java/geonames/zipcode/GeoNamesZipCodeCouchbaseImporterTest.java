package geonames.zipcode;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Import(CouchbaseConfiguration.class)
@Profile("test")
public class GeoNamesZipCodeCouchbaseImporterTest {

}
