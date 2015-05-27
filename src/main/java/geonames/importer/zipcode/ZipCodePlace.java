package geonames.importer.zipcode;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class ZipCodePlace {
	@Id
	public final String id = "Place_" + UUID.randomUUID().toString();
	
	@Field
	private String countryCode; // iso country code, 2 characters
	@Field
	private String postalCode; // varchar(20)
	@Field
	private String placeName; // varchar(180)
	@Field
	private String adminName1; // 1. order subdivision (state) varchar(100)
	@Field
	private String adminCode1; // 1. order subdivision (state) varchar(20)
	@Field
	private String adminName2; // 2. order subdivision (county/province)
								// varchar(100)
	@Field
	private String adminCode2; // 2. order subdivision (county/province)
								// varchar(20)
	@Field
	private String adminName3; // 3. order subdivision (community) varchar(100)
	@Field
	private String adminCode3; // 3. order subdivision (community) varchar(20)
	@Field
	private Double latitude; // estimated latitude (wgs84)
	@Field
	private Double longitude; // estimated longitude (wgs84)
	@Field
	private Integer accuracy; // accuracy of lat/lng from 1=estimated to
								// 6=centroid
	
	public ZipCodePlace(){
		
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getAdminName1() {
		return adminName1;
	}

	public void setAdminName1(String adminName1) {
		this.adminName1 = adminName1;
	}

	public String getAdminCode1() {
		return adminCode1;
	}

	public void setAdminCode1(String adminCode1) {
		this.adminCode1 = adminCode1;
	}

	public String getAdminName2() {
		return adminName2;
	}

	public void setAdminName2(String adminName2) {
		this.adminName2 = adminName2;
	}

	public String getAdminCode2() {
		return adminCode2;
	}

	public void setAdminCode2(String adminCode2) {
		this.adminCode2 = adminCode2;
	}

	public String getAdminName3() {
		return adminName3;
	}

	public void setAdminName3(String adminName3) {
		this.adminName3 = adminName3;
	}

	public String getAdminCode3() {
		return adminCode3;
	}

	public void setAdminCode3(String adminCode3) {
		this.adminCode3 = adminCode3;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Integer getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(Integer accuracy) {
		this.accuracy = accuracy;
	}

	public String getId() {
		return id;
	}		
}
