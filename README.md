# geonames-couchbase-importer
Imports data from geonames zipcode files to couchbase. 

The document structure maps the geonames field names. 
## Standalone usage

1. Download & unzip US geonames postal codes [http://download.geonames.org/export/zip/US.zip](http://download.geonames.org/export/zip/US.zip)
2. Add to your Couchbase destination bucket a view "all" as specified in this [README file](https://github.com/ermanno-pirotta/geonames-couchbase-importer/blob/master/src/main/resources/couchbase_views/README)
3. Run the command: `mvn spring-boot:run-Drun.arguments="--address=COUCHBASE_ADDRESS,--bucket=BUCKET_NAME,--password=BUCKET_PWD,--file=FILE_TO_IMPORT_FULL_PATH" `

## Usage as dependency
In case you would like to use the importer programmatically in your project, you can do the following:
1. Checkout the project locally
2. Add to your Couchbase destination bucket a view "all" as specified in this [README file](https://github.com/ermanno-pirotta/geonames-couchbase-importer/blob/master/src/main/resources/couchbase_views/README)
3. Cmd to the project's root directory
4. Run `mvn package`. Make sure that you have maven version 3.2 or greater installed on your computer.
5. Install the jar with the  `mvn install:install-file -Dfile=FULL_PATH_TO_JAR -DgroupId=org.piro84 -DartifactId=geonames-couchbase-importer -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar -DgeneratePom=true`
6. Add the dependency to your project's pom file as follows:
```	
<dependency>
       	<groupId>org.piro84</groupId>
       	<artifactId>geonames-couchbase-importer</artifactId>
      	<version>0.0.1-SNAPSHOT</version>
</dependency>
```
7. Add to your project's couchbase configuration the `geonames.importer.zipcode`package for repository automatic scan
