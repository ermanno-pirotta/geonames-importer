package geonames.importer.postalcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.couchbase.client.protocol.views.ComplexKey;
import com.couchbase.client.protocol.views.Query;

@Service
public class PostalCodeFinder {
	@Autowired
	private PostalCodeRepository repository;
	
	public PostalCode findByPlaceNameAndPostalCode(String placeName, String postalCode){
		if(StringUtils.isEmpty(StringUtils.trimAllWhitespace(placeName)) || StringUtils.isEmpty(StringUtils.trimAllWhitespace(postalCode))){
			throw new IllegalArgumentException("all arguments must not be null or empty");
		}
		
		Query query = new Query();
		query.setKey(ComplexKey.of(placeName.toLowerCase(),postalCode.toLowerCase()).forceArray(true));
		PostalCode place = this.repository.findByPlaceNameAndPostalCode(query); 
		return place;
	}
}
