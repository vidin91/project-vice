<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div>
    name:  ${user.name}
  </div>
  <div>
    last name:  ${user.lastname}
  </div>
  <div>
    born:  ${user.born}
  </div>
  <div>
    enabled:  ${user.enabled}
  </div>
  <div>
    registered:  ${user.registered}
  </div>
  <div>
    <a href="../logout">logout</a>
  </div>
</body>
</html>