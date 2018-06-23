# NOTES

### JAVA 8
#### Features:
1. Lambda expression − Adds functional processing capability to Java.
2. Method references − Referencing functions by their names instead of invoking them directly. Using functions as parameter.
3. Default method − Interface to have default method implementation.
4. New tools − New compiler tools and utilities are added like ‘jdeps’ to figure out dependencies.
5. Stream API − New stream API to facilitate pipeline processing.
6. Date Time API − Improved date time API.
7. Optional − Emphasis on best practices to handle null values properly.
8. Nashorn, JavaScript Engine − A Java-based engine to execute JavaScript code.

#### Method references **explained**
A method reference is the shorthand syntax for a lambda expression that executes just **ONE** method.  
> a method reference can't be used for any method. They can only be used to replace a single-method lambda expression.  
Instead of using AN ANONYMOUS CLASS you can use A LAMBDA EXPRESSION And if this just calls one method, you can use
A METHOD REFERENCE  

* static method reference:  
`(args) -> Class.staticMethod(args)` to `Class::staticMethod`  
* Instance method reference of an object of a particular type:  
`(obj, args) -> obj.instanceMethod(args)` to `ObjectType::instanceMethod`
* Instance method reference of an existing object:  
`(args) -> obj.instanceMethod(args)` to `obj::instanceMethod`
* Constructor method reference:  
`(args) -> new ClassName(args)` to `ClassName::new`  

#### Stream API
[monad](https://en.wikipedia.org/wiki/Monad_%28functional_programming%29)

