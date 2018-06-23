# User service
#### Handles user registration, authentication etc.

#### Technologies:

* Servlet API
* Database: mysql - root-localhost:3306-sifra123
* Database connector - 
* 

*IMPORTANT*  
* _eclipse spacing issue_:  
Go to project -> properties -> formatters and make custom one!  

* _Maven archtype-webapp doesn't create java and test folders by default_:  
Solution: add folders manually and do maven -> update project  
**Better Solution** - make new project with archtype-quickstart, go to  
pom.xml and change paching to **war**

* **@WebServlet** not working:  
When I run the app on default server (J2EE preview) annotation wasn't working.  
When I switched to tomcat everything went great.

* **HOT RELOADING** Works when deployed to tomcat!

* WebServlet and url patterns:  
You can do: `@WebServlet(urlPatterns={"/HelloWorld", "/HiWorld","/ItsASmallWorld"})`  
but you **can not use wild cards and patterns**

* _TODO_ Java snippets(Scrapbook) - [link](https://help.eclipse.org/mars/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2FgettingStarted%2Fqs-15.htm)

* _META-INF_ - when I created _plainproject_ with _maven_ in target I got:  
--groupID  
  |  
  --META-INF (MANIFEST.MF + maven folder)  
  |  
  --artifactID folder (with class files)  
  **MANIFEST.MF** contains info like created-By, built-By, built-jdk, (should probably contain "main class entry",  
  but when I built with maven it wasn't there. This is why the the first command fails and the second one passes:  
  `java -jar .\plainproject-0.0.1-SNAPSHOT.jar`  
  `java -classpath .\plainproject-0.0.1-SNAPSHOT.jar projectvice.plainproject.App`

* **WAR** packing: when unzip, in the root of the folder there are META-INF, WEB-INF folders and everything from  
webapp folder (there could be jsp pages, html, js etc.) WEB-INF folder has /class folder and web.xml file!.

* web.xml - Deployment Descriptor - Easy to modify with _design_ view in eclipse
