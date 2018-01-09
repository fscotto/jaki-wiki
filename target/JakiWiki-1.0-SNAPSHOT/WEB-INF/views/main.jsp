<%-- 
    Document   : main
    Created on : 22-mag-2016, 15.37.31
    Author     : morgoth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JakiWiki: ${titolo}</title>
    </head>
    <body onload="document.getElementById('email').disabled = false;"
          style="font-family: Verdana; font-size: 16px;">
        
        <div id="title" style="font-family: Verdana; font-size: 32px; font-variant: small-caps;" >
            JakiWiki: ${titolo}
        </div>
        
        <table style="width: 80%; height: 600px;">
            <tr>
                <td>
                    <form name="modificaForm" action="edit.action" method="post">
                        <input type="hidden" name="titolo" value="${titolo}" />
                        <input type="submit" style="font-family: Verdana; font-size: 11px" value="Modifica" />
                    </form>
                </td>
            </tr>
            <tr>
                <td>
                    <c:out value="${contenuto}" default="" escapeXml="false" />
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
