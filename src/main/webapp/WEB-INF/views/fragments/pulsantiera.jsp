<%-- 
    Document   : pulsantiera
    Created on : 22-mag-2016, 15.54.39
    Author     : morgoth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="pulsantiera.action" name="pulsantieraForm">
            <input type="hidden" name="titolo" value="${titolo}" />
            <input type="submit" name="principale" style="font-family: Verdana; font-size: 16px;" value="PRINCIPALE" />
            <input type="submit" name="tutte" style="font-family: Verdana; font-size: 16px;" value="TUTTE" />
            <input type="submit" name="recenti" style="font-family: Verdana; font-size: 16px;" value="RECENTI" />
            <input type="submit" id="email" name="email" style="font-family: Verdana; font-size: 16px;" value="EMAIL" disabled="true" />
        </form>
        <br />
        <div id="title" style="font-family: Verdana; font-size: 16px;" >
            JakiWiki - a cool Java Wiki
        </div>
    </body>
</html>
