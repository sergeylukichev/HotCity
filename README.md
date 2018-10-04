# HotCity
List cities and get the one where it is the hottest today

For demo and educational purposes only! Do not use in production!

Weather data is taken from https://www.metaweather.com/api/

Please, contact [metaweather](https://www.metaweather.com/api/) owner before you start using it.

## How to start

Just start App class in your IDE or from command line. 

Or, using Maven:
```
mvn spring-boot:run
```

Make sure Maven is installed and your JDK is in your JAVA_HOME variable. 

There are two end points:

## Rest end point (/api/weather/{cities})

Accepts a list of cities (ex: berlin,amsterdam,pairs) and returns a HotCity, which contains
city name and the temperature. Ignores cities, which cannot be found. 
If no cities are found, HTTP response 404 is returned.  

## Web site, using Thymeleaf (/weather)
Uses Thymeleaf to render two pages: index.html with the form to enter the list and 
city.html, which renders the hottest city. 

## On architecture
It is quite standard approach with three layers: 
- Web (HotCityResource.java)
- Business logic (WatherService.java)
- External service to get the weather (ExternalWeatherGateway.java)
- We throw a SomeCitiesNotFoundException when no cities are found and handle it with RestExceptionHandler.java
- All beans are configured in ExternalWeatherGatewayConfig.java, which can be improved, since now
it contains some other bean definitions, which are not relevant for the Gwateway. 
- Since external weather service is HTTPS, we disable some security checks in CustomRestTemplateCustomizer.java
- We print each request/response to console, by intercepting in CustomClientHttpRequestInterceptor.java
- The `telran.hotcities.clientmodel` package contains web model classes for servlet. 

## TO DO

- Increase test coverage
- Clean up here and there
- Add more features
- Add css to the html pages
