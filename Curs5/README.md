**JSP**

JSP (JavaServer Pages) is a Java-based technology used to create dynamic web pages by embedding Java code within HTML pages. It is a server-side technology that allows the creation of dynamic web content, processing of form data, and generation of dynamic responses to HTTP requests. JSP pages are executed on the server and the results are returned to the client as HTML pages. JSP is part of the Java Enterprise Edition (Java EE) platform and is often used in conjunction with servlets.

**How it works?**

- Use of standard HTML code in most of the pages sections
- The entire JSP page is “translated” into Java servlet, and the servlet’s methods are called
for each HTTP request

> The examples added here are from the seminary

We do we use java bean? Because we can't give parameters in the ```jsp:useBean``` and a bean must have a constructor without arguments.


**JSP API**

Contains:
- JSP Expression ```<%= %>```
- JSP Scriplet ```<% %>```
- JSP Declaration ```<%! %>```
- JSP Page Directive ```<%@ page att="value" %>``` 
- JSP Include Directive ```<%@ include file="url"  %>``
- JSP Comment ```<%-- --%>```
- JSP Include Action ```<jsp:include />```
- JSP useBean Action ```<jsp:useBean att="val"  id="id" class="class/>```
- JSP setProperty Action ```<jsp:setProperty att="val"/>```
- JSP getProperty Action ```<jsp:getProperty name="propertyName" value="val"/>``
- JSP Forward Action ```<jsp:forward page="relative URL"/>```
- JSP Plugin aCTION ```<jsp:plugin attrivute="val"> ... </jsp:plugin>```