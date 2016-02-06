package geonames.importer.postalcode.test.builders;

import geonames.importer.postalcode.PostalCode;

public class PostalCodePlaceBuilder {

	private PostalCode instance;
	
	public PostalCodePlaceBuilder(){
		this.instance = new PostalCode();		
	}
		
	public PostalCode build(){
		this.instance.id = PostalCode.buildIdFromPostalCodeAndPlaceName(this.instance.getPostalCode(),this.instance.getPlaceName());
		return this.instance;
	}
	
	public PostalCodePlaceBuilder withPlaceName(String placeName){
		this.instance.setPlaceName(placeName);
		return this;
	}
	
	public PostalCodePlaceBuilder withPostalCode(String postalCode){
		this.instance.setPostalCode(postalCode);
		return this;
	}
}
