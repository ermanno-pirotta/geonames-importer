package geonames.importer.postalcode;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class PostalCode {
	@Id
	public final String id = "PostalCode_" + this.hashCode();
	
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
	
	public PostalCode(){
		
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accuracy == null) ? 0 : accuracy.hashCode());
		result = prime * result
				+ ((adminCode1 == null) ? 0 : adminCode1.hashCode());
		result = prime * result
				+ ((adminCode2 == null) ? 0 : adminCode2.hashCode());
		result = prime * result
				+ ((adminCode3 == null) ? 0 : adminCode3.hashCode());
		result = prime * result
				+ ((adminName1 == null) ? 0 : adminName1.hashCode());
		result = prime * result
				+ ((adminName2 == null) ? 0 : adminName2.hashCode());
		result = prime * result
				+ ((adminName3 == null) ? 0 : adminName3.hashCode());
		result = prime * result
				+ ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result
				+ ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result
				+ ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result
				+ ((placeName == null) ? 0 : placeName.hashCode());
		result = prime * result
				+ ((postalCode == null) ? 0 : postalCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PostalCode)) {
			return false;
		}
		PostalCode other = (PostalCode) obj;
		if (accuracy == null) {
			if (other.accuracy != null) {
				return false;
			}
		} else if (!accuracy.equals(other.accuracy)) {
			return false;
		}
		if (adminCode1 == null) {
			if (other.adminCode1 != null) {
				return false;
			}
		} else if (!adminCode1.equals(other.adminCode1)) {
			return false;
		}
		if (adminCode2 == null) {
			if (other.adminCode2 != null) {
				return false;
			}
		} else if (!adminCode2.equals(other.adminCode2)) {
			return false;
		}
		if (adminCode3 == null) {
			if (other.adminCode3 != null) {
				return false;
			}
		} else if (!adminCode3.equals(other.adminCode3)) {
			return false;
		}
		if (adminName1 == null) {
			if (other.adminName1 != null) {
				return false;
			}
		} else if (!adminName1.equals(other.adminName1)) {
			return false;
		}
		if (adminName2 == null) {
			if (other.adminName2 != null) {
				return false;
			}
		} else if (!adminName2.equals(other.adminName2)) {
			return false;
		}
		if (adminName3 == null) {
			if (other.adminName3 != null) {
				return false;
			}
		} else if (!adminName3.equals(other.adminName3)) {
			return false;
		}
		if (countryCode == null) {
			if (other.countryCode != null) {
				return false;
			}
		} else if (!countryCode.equals(other.countryCode)) {
			return false;
		}
		if (latitude == null) {
			if (other.latitude != null) {
				return false;
			}
		} else if (!latitude.equals(other.latitude)) {
			return false;
		}
		if (longitude == null) {
			if (other.longitude != null) {
				return false;
			}
		} else if (!longitude.equals(other.longitude)) {
			return false;
		}
		if (placeName == null) {
			if (other.placeName != null) {
				return false;
			}
		} else if (!placeName.equals(other.placeName)) {
			return false;
		}
		if (postalCode == null) {
			if (other.postalCode != null) {
				return false;
			}
		} else if (!postalCode.equals(other.postalCode)) {
			return false;
		}
		return true;
	}

	
}
