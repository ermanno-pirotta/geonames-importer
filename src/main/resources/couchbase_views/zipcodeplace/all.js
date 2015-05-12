function (doc, meta) {
  if(doc._class == "geonames.zipcode.importers.ZipCodePlace") {
    emit(null, null);
  }
}