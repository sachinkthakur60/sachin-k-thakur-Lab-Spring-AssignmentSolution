<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    
    <title>Spring Boot - Student Management</title>
    </head>
    
    <body>
    Spring Boot - Welcome to Student Management
        
        <c:url var="listUrl" value= "/students/list"/>

    <hr>
    <a href="${listUrl}">Back to Students List</a>

    
    </body>
</html>