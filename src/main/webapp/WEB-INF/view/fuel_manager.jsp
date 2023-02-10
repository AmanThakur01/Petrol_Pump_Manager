<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fuel Manager</title>
        <s:url var="url_css" value="/static/css/style.css"/>
        <link href="${url_css}" rel="stylesheet" type="text/css"/>
    </head>
    <body background="${url_bg}">
        <table border="1" width="80%" align="center">
            <tr>
                <td height="80px">
                    <%-- Header --%>
                    <jsp:include page="include/header.jsp"/>
                </td>
            </tr>
            <tr>
                <td height="25px">
                    <%-- Menu --%>
                    <jsp:include page="include/menu.jsp"/>
                </td>
            </tr>
            <tr>
                <td height="350px" valign="top">
                    <%-- Page Content Area--%>
                    <c:if test="${param.act eq 'sv'}">
                        <p class="error" align="center">Fuel Updated Successfully.</p>

                    </c:if>

                    <s:url var="url_fuel"  value="/save_fuel"/>
                    
                        <table  border="1" cellpadding="3"  width="100%">
                            <tr>
                                <td>SR</td>
                                <td>Container</td>
                                <td>MAX Capacity(Ltr)</td>
                                <td>MIN Stock Level(Ltr)</td>
                                <td>Per Ltr Rate (INR)</td>
                            </tr>

                            <c:if test="${empty fuelList}">
                                <p class="error">No Fuel Present</p>
                            </c:if>
                            <c:forEach var="c" items="${fuelList}" varStatus="st">
                                <f:form action="${url_fuel}" modelAttribute="fuelCommand">
                                   <f:input path="fuelid" value="${c.fuelid}" type="hidden"/> 
                                <tr>
                                    <td>${st.count}</td>
                                    <td>${c.fuelname}</td>
                                    <td>${c.maxsize}   <f:input path="avaliablesize" value="${c.avaliablesize}" type="number" max="${c.maxsize}" min="${c.avaliablesize}"/> Ltr</td>
                                    <td>${c.minstocklevel} Ltr</td>
                                    <td><f:input path="rate" value="${c.rate}"/>Rs./Ltr</td>
                                    <td><button>Submit</button></td>
                                </tr>
                                </f:form>
                            </c:forEach>

                        </table>
                    
                </td>
            </tr>
            <tr>
                <td height="25px">
                    <%-- Footer --%>
                    <jsp:include page="include/footer.jsp"/>
                </td>
            </tr>
        </table>
    </body>
</html>
