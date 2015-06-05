package geonames.importer.postalcode;

import org.springframework.data.couchbase.core.view.View;
import org.springframework.data.repository.CrudRepository;

import com.couchbase.client.protocol.views.Query;

public interface PostalCodeRepository extends CrudRepository<PostalCode, String> {
	
	@View(designDocument = "postalcode", viewName = "byPlaceNameAndPostalCode")
	PostalCode findByPlaceNameAndPostalCode(Query query);	
}
