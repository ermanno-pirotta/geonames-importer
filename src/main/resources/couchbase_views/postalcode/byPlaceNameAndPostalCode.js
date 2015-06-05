function (doc, meta) {
  if(doc._class && doc._class==="geonames.importer.postalcode.PostalCode" && doc.placeName && doc.postalCode){    
	emit([doc.placeName.toLowerCase(),doc.postalCode.toLowerCase()], null);
  }
}