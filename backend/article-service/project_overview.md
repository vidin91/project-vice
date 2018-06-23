## Project Overview
Service that deals with articles. Articles are linked to users, and hold some text.  
Technologies:  
* JAX-RS for API (Jersey implementation)
* MongoDB as database


### Important notes:

* Web dynamic module version (downgrade from 3.0 to 2.5 since tomcat 7.0 doesn't support newer) -  
project properties -> project Facets -> Dynamic Web Module. **First uncheck, then change version, then check again**  
This version is also part of web.xml

* Issue with _Jersey servlet_ mapping:  
`<url-pattern>/api/*</url-pattern>` - it actually prepends /api/ to paths. I had `@Path('/api/test')`  
but this was actually mapped to /api/api/test !!!

* IllegalArgumentException

* 