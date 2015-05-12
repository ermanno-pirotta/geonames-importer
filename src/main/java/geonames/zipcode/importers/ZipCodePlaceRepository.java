package geonames.zipcode.importers;

import org.springframework.data.repository.CrudRepository;

public interface ZipCodePlaceRepository extends CrudRepository<ZipCodePlace, String> {
}
