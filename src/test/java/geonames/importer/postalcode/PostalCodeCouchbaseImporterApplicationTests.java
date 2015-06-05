package geonames.importer.postalcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import geonames.importer.PostalCodeCouchbaseImporterTest;
import geonames.importer.commons.ImportException;
import geonames.importer.commons.ImportResult;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PostalCodeCouchbaseImporterTest.class)
@TestPropertySource("/application-test.properties")
@ActiveProfiles("test")
public class PostalCodeCouchbaseImporterApplicationTests {
	@Autowired
	PostalCodeImporter importer;

	@Autowired
	PostalCodeRepository repository;
	
	@Autowired
	ApplicationContext context;

	@Before
	public void setup() {
		repository.deleteAll();
	}

	@Test
	public void shouldImportAllPlacesFromFile() throws ImportException, IOException {
		Resource resource = context.getResource("file:src/main/resources/test-postalcode.txt");
		assertThat(resource.exists(),is(true));
		
		ImportResult result = importer.importFromFile(resource.getFile().getAbsolutePath());
		assertThat(result.getErrorCount(), is(0));
	}

	@Test(expected = ImportException.class)
	public void shouldThrowAnExceptionWhenFileMissing() throws ImportException {
		importer.importFromFile("NOT_EXISTING");
	}
	
	@Test(expected = ImportException.class)
	public void shouldThrowAnExceptionWhenEmptyFile() throws ImportException {
		importer.importFromFile("test-empty.txt");
	}
}
