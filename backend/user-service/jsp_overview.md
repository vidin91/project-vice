##Java Servlet Pages (JSP)

I first tried to put:  
`<div>name <%= user.getName() %> </div>`  
It wasn't working - couldn't resolve user! (not even ${user.name})  
1. Should `user` be in session (via set/get attribute) ?
2. <%@ page isThreadSafe="true" %> <%-- Default --%> - what about threading?  

JSP 1.2 : <jsp:useBean id="user" type="package.User"/>  
<jsp:getProperty name="user" property="name}/>;  
JSP 2.0 : ${user.name}

**_NOTE_** - be careful when mapping urls and redirect(forward) eg. If you have @WebServlet("/login") and  
login.jsp - If you open login.jsp and have `<form method="post">` , POST request is going to be send to  
/login.jsp - BUG!

