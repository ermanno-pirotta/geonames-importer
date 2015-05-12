package geonames.zipcode.importers;

import geonames.zipcode.commons.ImportException;
import geonames.zipcode.commons.ImportResult;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

@Component
public class ZipCodeImporter {

	@Autowired
	private ZipCodePlaceRepository repository;

	public ImportResult importFromFile(String pathTofileToImport)
			throws ImportException {		
		try{
			List<ZipCodePlace> places = this.readPlacesFromFile(pathTofileToImport);
			return storePlaces(places);		
		}
		catch(Exception e){
			throw new ImportException(e.getMessage(),e);
		}
	}

	//TODO: check why this does not work
	private List<ZipCodePlace> readPlacesFromFile(String pathTofileToImport)
			throws FileNotFoundException {
		CSVReader reader = new CSVReader(new FileReader(pathTofileToImport), '\t');

		ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
		strat.setType(ZipCodePlace.class);
		String[] columns = new String[] { "countryCode", "postalCode",
											"placeName", "adminName1", "adminCode1", "adminName2",
											"adminCode2", "adminName3", "adminCode3", "latitude",
											"longitude", "accuracy" }; // the fields to bind do in your
																		// JavaBean
		strat.setColumnMapping(columns);

		CsvToBean csv = new CsvToBean();
		return csv.parse(strat, reader);
	}

	private ImportResult storePlaces(List<ZipCodePlace> places) {
		int importCount = places.size();
		int errorCount = 0;

		for(int i=0;i<places.size();i++){
			ZipCodePlace savedPlace = repository.save(places.get(i));
			if(savedPlace==null){
				errorCount++;
			}
		}

		return new ImportResult(importCount, errorCount);
	}
}
