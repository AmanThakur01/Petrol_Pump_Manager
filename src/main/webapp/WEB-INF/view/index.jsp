<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Fuel - PPM </title>
        <s:url var="url_css" value="/static/css/style.css"/>
        <link href="${url_css}" rel="stylesheet" type="text/css"/>
        <s:url var="url_jqlib" value="/static/js/jquery-3.2.1.min.js" />
        <script src="${url_jqlib}"></script>
        <script>
            $("#amt_msg").show();
            setTimeout(function () {
                $("#amt_msg").hide();
            }, 8000);
        </script>
    </head>
    <s:url var="url_bg" value="/static/images/bg.jpg"/>
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
                    <c:if test="${param.act eq 'uf'}">
                        <p class="error">Fuel Tank UnderFlow</p>
                    </c:if>
                    <c:if test="${param.err != null}">
                        <p class="error">${param.err}</p>
                    </c:if>
                    <c:if test="${param.act eq 'sv'}">
                        <p id="amt_msg" class="error" align="center">Thanks For REFUELING. Please Pay ${param.amount} Rs./-</p>

                    </c:if>
                    <c:if test="${param.minLevel eq 'ml'}">
                        <p class="success">Fuel Reached To Minimum Level</p>
                    </c:if>
                    <c:if test="${empty fuelList}">
                        <p class="error">No Fuel Present</p>
                    </c:if>
                    <table  width="40%" align = "center">
                        <tr>
                            <c:forEach var="c" items="${fuelList}" varStatus="st">
                                <td><h5>${c.fuelname}</h5></td>
                                <td><h5>${c.rate} Rs./L</h5></td>
                            </c:forEach>
                        </tr>
                    </table>
                    <s:url var="url_reg"  value="/order"/>
                    <f:form action="${url_reg}" modelAttribute="command"> 
                        <table cellpadding="3"  width="40%" align = "center" class="border">
                            <tr>
                                <c:forEach var="a" items="${fuelList}" varStatus="st">
                                    <td>${a.fuelname} 
                                        <f:radiobutton path="fuelid" value="${a.fuelid}"/>  
                                    </td>
                                </c:forEach>
                            </tr>
                            <tr>
                                <td colspan="2">  
                                    <f:input path="value" placeholder="Enter Your Digits" type="number"/>
                                </td>
                            </tr>
                            <tr>
                                <td>By Amount 
                                    <f:radiobutton path="byType" value="amount"/>  
                                </td>
                                <td>By Quantity  
                                    <f:radiobutton path="byType" value="qty"/>  
                                </td>
                            </tr>
                            <tr >
                                <td colspan="2" align="right">
                                    <button style="width:100%">Process</button> 
                                </td>
                            </tr>
                        </table>
                    </f:form>
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
