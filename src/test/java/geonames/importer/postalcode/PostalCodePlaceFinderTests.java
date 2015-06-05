package geonames.importer.postalcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import geonames.importer.PostalCodeCouchbaseImporterTest;
import geonames.importer.postalcode.test.builders.PostalCodePlaceBuilder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PostalCodeCouchbaseImporterTest.class)
@TestPropertySource("/application-test.properties")
@ActiveProfiles("test")
public class PostalCodePlaceFinderTests{

	@Autowired
	private PostalCodeFinder finder;
	
	private final String placeName = "Barete Abruzzi";
	private final String postalCode = "67010";

	@Autowired
	private PostalCodeRepository repository;
	
	@Before
	public void setup(){
		repository.deleteAll();
	}
	
	@Test
	public void shouldFindByCityAndZipCode() {
		// given
		PostalCode postalCodeToFind = this.buildAndSavePlace(placeName,
				postalCode);
		// when
		PostalCode postalCodeFound = finder.findByPlaceNameAndPostalCode(
				placeName, postalCode);

		// then
		assertThat(postalCodeToFind.equals(postalCodeFound), is(true));
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowAnExceptionWhenSearchingWithNullPlaceName() {
		// given
		this.buildAndSavePlace(placeName, postalCode);
		// when
		finder.findByPlaceNameAndPostalCode(null, postalCode);
		// then
		// illegal argument exception
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowAnExceptionWhenSearchingWithNullPostalCode() {
		// given
		this.buildAndSavePlace(placeName, postalCode);
		// when
		finder.findByPlaceNameAndPostalCode(placeName, null);
		// then
		// illegal argument exception
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowAnExceptionWhenSearchingWithEmptyPlaceName() {
		// given
		this.buildAndSavePlace(placeName, postalCode);
		// when
		finder.findByPlaceNameAndPostalCode(" ", postalCode);
		// then
		// illegal argument exception
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowAnExceptionWhenSearchingWithEmptyPostalCode() {
		// given
		this.buildAndSavePlace(placeName, postalCode);
		// when
		finder.findByPlaceNameAndPostalCode(placeName, " ");
		// then
		// illegal argument exception
	}

	private PostalCode buildAndSavePlace(String placeName, String postalCode) {
		PostalCode placeToFind = new PostalCodePlaceBuilder()
				.withPlaceName(placeName).withPostalCode(postalCode).build();
		return repository.save(placeToFind);
	}
}
