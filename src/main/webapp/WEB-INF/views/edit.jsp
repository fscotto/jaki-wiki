<%-- 
    Document   : edit
    Created on : 25-mag-2016, 21.15.50
    Author     : morgoth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JakiWiki: Modifica di ${titolo}</title>
    </head>
    <body style="font-family: Verdana; font-size: 16px;">
        <div id="title" style="font-family: Verdana; font-size: 32px; font-variant: small-caps;" >
            JakiWiki: modifica '${titolo}'
        </div>
        <table style="width: 80%; height: 600px;">
            <form action="salva-pagina.action" method="post">
                <tr>
                    <td>
                        <textarea name="contenuto" cols="110" rows="15">
                            <c:out value="${contenuto}" />
                        </textarea>
                    </td>
                </tr>
                <tr>
                    <td style="height: 60px">
                        <input type="hidden" name="titolo" value="${titolo}" />
                        <input type="submit" style="font-family: Verdana; font-size: 16px" value="Salva" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <hr>
                        <c:import url="fragments/pulsantiera.jsp" />
                    </td>
                </tr>
            </form>
        </table>
    </body>
</html>
