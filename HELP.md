# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.pramod.' is invalid and this project uses 'com.pramod' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/reference/htmlsingle/#using-boot-devtools)

### Guides
The following guides illustrate how to use some features concretely:
1)http://localhost:8091/savemenu
Method :- post
request payload details-
{
  "manuName": "Cloths",
  "submanuList": [
    {
      "subManuName": "Jeans",
      "productList": [
        {
          "productName": "Levis",
          "itemList": [
            {
              "itemName": "levis-jeans"
            }
          ]
        }
      ]
    }
  ]
}

2)http://localhost:8091/displaymenubyId/{Manu-id}/
Method-get

3)http://localhost:8091/displayAllmenu
Method-get
For Creating data firstTime
4)http://localhost:8091/saveDummyData
method -get

