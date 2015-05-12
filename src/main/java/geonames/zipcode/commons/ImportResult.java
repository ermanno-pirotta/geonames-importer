package geonames.zipcode.commons;

public final class ImportResult {
	private final int importedCount;
	private final int errorCount;
	
	public ImportResult(int importedCount, int errorCount){
		this.importedCount = importedCount;
		this.errorCount = errorCount;
	}

	public int getImportedCount() {
		return importedCount;
	}

	public int getErrorCount() {
		return errorCount;
	}
}
