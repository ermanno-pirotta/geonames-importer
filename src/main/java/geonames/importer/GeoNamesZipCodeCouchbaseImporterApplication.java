package geonames.importer;

import geonames.importer.configuration.CouchbaseConfiguration;
import geonames.importer.zipcode.ZipCodeImporter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Import(CouchbaseConfiguration.class)
@Profile("prod")
public class GeoNamesZipCodeCouchbaseImporterApplication implements CommandLineRunner{

	@Autowired
	private ZipCodeImporter importer;
	
	@Value("${geonames.zipcode.file}")
	private String fileToImportPath;
	
	@Override
	public void run(String... args) {
		System.out.println(importer.importFromFile(fileToImportPath));
	}
	
    public static void main(String[] args) {
        SpringApplication.run(GeoNamesZipCodeCouchbaseImporterApplication.class, args);
        
    }
}
