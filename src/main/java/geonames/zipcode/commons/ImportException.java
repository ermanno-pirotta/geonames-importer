package geonames.zipcode.commons;

public class ImportException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ImportException(String message, java.lang.Throwable cause){
		super(message, cause);
	}
}
