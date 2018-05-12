# microservices-spring

1) common-data - This is the module on which our upload and download micro-service is dependent. This module contains database operation with mysql database for saving and retrieving files

2) discovery-server: This module is eureka discovery  server running on port 8761. 

3) file-upload : This module is our eureka discovery client for uploading file. This service will dynamically select port and 
register itself on eureka server. The endpoint for file upload is as below

4) file-download: This module is our eureka discovery client for download file. This service will dynamically select port and register itself on eureka server. 

5) api-gateway: This module is our api gateway based on zuul.  There are 2 routes in this api-gateway . 1st is pointing to download named microservice through eureka server and 2nd is  pointing to upload named microservice through eureka server. 

The endpoint of zuul api gateway are as below

Uploading file:
POST: http://localhost:9999/fileUploadService/uploadFile and choose the file to uplaod (I have used Postman to upload the file)

List all files:
GET: http://localhost:9999/fileDownloadService/listAllFiles

List a specific file from id:
http://localhost:9999/fileDownloadService/listAllFiles/4

note here that in the url fileUploadService and fileDownloadService are the routes to named microservices.

6) You need to use mysql database and create a schema name test. table with name 'file'  will automatically gets created.

7) Both the upload and download microservice is reading the configuration from git and the configuraiton application.yml file is here: https://github.com/jaydattdesai/Spring-cloud-config/blob/master/application.yml


8) discovery-server-client.png - This image represents the discovery server and client applications running on pcf

9) client-registration-pcf-discovery-server.png - This image represents the discovery server on pcf . In that discovery server you can see client registration

10) pcf free account has capacity of 2 GB only. so we can at max run 2 microservices only . Else entire above scenario can be replicated on pcf.
