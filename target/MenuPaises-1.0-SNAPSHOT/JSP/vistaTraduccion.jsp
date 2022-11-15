<%--
    Document   : vistaTraduccion
    Created on : 06-nov-2022, 17:56:40
    Author     : dcc_s
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Husos Horarios</title>
        <style><%@include file="../CSS/paises.css" %></style>
    </head>
    <body>
        <c:if test="${requestScope.pais.gmt!=''}">
            <fmt:setTimeZone value="${pais.gmt}"/>
            <fmt:setLocale value="${pais.codigo}" scope="page"/>
        </c:if>
        <c:set var="now" value="<%=new java.util.Date()%>"/>
        <a href="Paises" class="volver">VOLVER</a>
        <div class="header">
           <h1>
                <c:out value="${requestScope.pais.nombre}" default="${requestScope.paisDefault}"/> 
                - 
                <c:out value="${requestScope.pais.husosHorarios}" default="Husos horarios"/>
            </h1>
            <p><fmt:formatDate type="time" value="${now}"/></p> 
        </div>
        
        <div class="container">
            
            <div class="container__menu">
                <h2>Algunas expresiones conocidas</h2>
                <ul>
                    <li>Buenos días: <c:out value="${pais.saludo}" default="No tenemos expresiones para esta región."/></li>
                    <li>Adiós: <c:out value="${pais.despedida}" default="No tenemos expresiones para esta región."/></li>
                </ul>
                <br>
                <h2>Fechas</h2>
                <ul>
                    <li>Formato personalizado: <fmt:formatDate pattern="MM/dd/yyy" value="${now}"/></li>
                    <li>Formato corto: <fmt:formatDate type="date" dateStyle="short"  value="${now}"/></li>
                    <li>Formato medio: <fmt:formatDate type="date" dateStyle="medium"  value="${now}"/></li>
                    <li>Formato largo: <fmt:formatDate type="date" dateStyle="long"  value="${now}"/></li>
                    <li>Formato completo: <fmt:formatDate type="date" dateStyle="full" value = "${now}" /></li>
                </ul>
                <br>
                <h2>Horas</h2>
                <ul>
                   <li>Formato personalizado: <fmt:formatDate type="time" value="${now}"/></li>
                    <li>Formato de fecha y hora: <fmt:formatDate type="both" dateStyle="short" timeStyle="medium" value="${now}"/></li>
                    <li>Formato corto de fecha y hora: <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${now}"/></li>
                    <li>Formato medio de fecha y hora: <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${now}"/></li>
                    <li>Formato largo de fecha y hora: <fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${now}"/></li> 
                </ul>
                <br>
                <h2>Números</h2>
                <ul>
                   <c:set var="valor" value="111.1111" />
                    <li>Formato personalizado: <fmt:formatNumber type="number" maxIntegerDigits="3" value="${valor}"/></li>
                    <li>Moneda: <fmt:formatNumber type="currency" value="${valor}"/></li>
                    <li>Formato con dos decimales: <fmt:formatNumber type="number" maxFractionDigits="2" value="${valor}"/></li>
                    <li>Tanto por ciento: <fmt:formatNumber type="percent" maxIntegerDigits="3" value="${valor}"/></li> 
                </ul>
            </div>
            
            <div class="container__video">
                <video autoplay muted loop>
                    <source src="VIDEO/particles.mp4" type="video/mp4">
                </video>
            </div>
            
        </div>
        

    </body>
</html>