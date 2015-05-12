# geonames-couchbase-importer
Imports data from geonames zipcode files to couchbase. 

The document structure maps the geonames field names. 
## Usage

1. Download & unzip US geonames postal codes [http://download.geonames.org/export/zip/US.zip](http://download.geonames.org/export/zip/US.zip)
2. Add to your Couchbase destination bucket a view "all" as specified in the [https://github.com/ermanno-pirotta/geonames-couchbase-importer/blob/master/src/main/resources/couchbase_views/README] (README file)
3. Run the command: `mvn spring-boot:run-Drun.arguments="--address=COUCHBASE_ADDRESS,--bucket=BUCKET_NAME,--password=BUCKET_PWD,--file=FILE_TO_IMPORT_FULL_PATH" `
