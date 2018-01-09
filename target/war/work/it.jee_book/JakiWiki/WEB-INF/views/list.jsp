<%-- 
    Document   : list
    Created on : 25-mag-2016, 21.57.11
    Author     : morgoth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/jakiwiki.tld" prefix="jakiwiki" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JakiWiki: ${intestazione}</title>
    </head>
    <body style="font-family: Verdana; font-size: 16px;">
        <div id="title" style="font-family: Verdana; font-size: 16px; font-variant: small-caps;">
            JakiWiki: ${intestazione}
        </div>
        
        <table style="width: 80%; height: 600px;">
            <tr>
                <td>
                    <jakiwiki:lista_pagine pagine="${lista}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <hr>
                    <c:import url="fragments/pulsantiera.jsp" />
                </td>
            </tr>
        </table>
    </body>
</html>
