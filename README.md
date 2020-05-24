# springboot-manu-service

Read Me First
The following was discovered as part of building this project:

The original package name 'com.pramod.' is invalid and this project uses 'com.pramod' instead.
Getting Started
Reference Documentation
For further reference, please consider the following sections:

Official Apache Maven documentation
Spring Boot Maven Plugin Reference Guide
Create an OCI image
Spring Web
Spring Data JPA
Spring Boot DevTools
Guides
The following guides illustrate how to use some features concretely: 1)http://localhost:8091/savemenu Method :- post request payload details- { "manuName": "Cloths", "submanuList": [ { "subManuName": "Jeans", "productList": [ { "productName": "Levis", "itemList": [ { "itemName": "levis-jeans" } ] } ] } ] }

2)http://localhost:8091/displaymenubyId/{Manu-id}/ Method-get

3)http://localhost:8091/displayAllmenu Method-get For Creating data firstTime 4)http://localhost:8091/saveDummyData method -get
