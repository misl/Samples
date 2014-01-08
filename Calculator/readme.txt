Calculator
----------

A simple calculator application to demonstrate the use of Apache Wicket in 
an Apache Karaf container with remote (REST + SOAP) access. Apache Shiro based security is added for role based access.


Prerequisites
-------------
The following components are required for this example.

  - Apache Maven 3+
  - Java 7

  
Build
-----
Building this example is as simple as running the following maven command
from the project root (where this readme is located).

  mvn clean instal

Building results in assemblies (both zip and tar.gz) containing the full 
application stack. These can be found in:

    assembly/target

    
Deploy
------
Take the assembly (zip or tar.gz) that best suits your environment and 
extract is to a location of you choice. This results in a folder with the
exact same name as the extracted assembly (with the file extension stripped).

Installation is now complete and no additional configuration is required.

Run
---
The only thing left is starting up the application. This is achieved by
running the 'bin/karaf' command. To start the application in the background 
use the 'bin/start' instead.

To test your installation open a browser to either of the following:

  http://<host>:8181/calculator
  http://<host>:8181/api/rest
  http://<host>:8181/api/soap
  
Where '<host>' is the host name where you deployed the application. If 
installed on you local computer you can use 'localhost'.  

To access the functionality, the following credentials are required.
  user/user
