package geonames.importer.postalcode;

import geonames.importer.commons.ImportException;
import geonames.importer.commons.ImportResult;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

@Component
public class PostalCodeImporter {

	private static final Logger logger = LoggerFactory.getLogger(PostalCodeImporter.class);
	
	@Autowired
	private PostalCodeRepository repository;

	public ImportResult importFromFile(String pathTofileToImport)
			throws ImportException {				
		logger.info(String.format("Import of file %s started", pathTofileToImport));
		try{			
			logger.info("importing file data in memory..");
			List<PostalCode> places = this.readPlacesFromFile(pathTofileToImport);			
			
			logger.info("saving data in storage");
			List<PostalCode> storedPlaces = storePlaces(places);		
			int importedNr = places.size();
			int savedNr = storedPlaces.size();
			
			logger.info(String.format("Import of file %s completed (number of imported data = %d, number of saved data = %d)", 
										pathTofileToImport, importedNr, savedNr));
			
			return new ImportResult(importedNr,importedNr - savedNr);
		}
		catch(Exception e){
			logger.error(String.format("Unexpected exception while importing the file (message = %s)",e.getMessage()),e);
			throw new ImportException(e.getMessage(),e);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<PostalCode> readPlacesFromFile(String pathTofileToImport)
			throws FileNotFoundException {
		CSVReader reader = new CSVReader(new FileReader(pathTofileToImport), '\t');

		ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
		strat.setType(PostalCode.class);
		String[] columns = new String[] { "countryCode", "postalCode",
											"placeName", "adminName1", "adminCode1", "adminName2",
											"adminCode2", "adminName3", "adminCode3", "latitude",
											"longitude", "accuracy" }; // the fields to bind do in your
																		// JavaBean
		strat.setColumnMapping(columns);

		CsvToBean csv = new CsvToBean();
		return csv.parse(strat, reader);
	}

	private List<PostalCode> storePlaces(List<PostalCode> places) {		
		List<PostalCode> storedPlaces = new ArrayList<PostalCode>(places.size());
		
		for(int i=0;i<places.size();i++){
			PostalCode savedPlace = repository.save(places.get(i));
			if(savedPlace!=null){
				storedPlaces.add(savedPlace);
			}
		}

		return storedPlaces;
	}
}
