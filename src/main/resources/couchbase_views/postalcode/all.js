function (doc, meta) {
  if(doc._class == "geonames.zipcode.importers.PostalCode") {
    emit(null, null);
  }
}