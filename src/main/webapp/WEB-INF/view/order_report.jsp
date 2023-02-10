<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Report - PPM </title>
        <s:url var="url_css" value="/static/css/style.css"/>
        <link href="${url_css}" rel="stylesheet" type="text/css"/>
        <s:url var="url_jqlib" value="/static/js/jquery-3.2.1.min.js" />
        <script src="${url_jqlib}"></script>
        <script>
            $(document).ready(function () {
                $("#filterVal2").hide();
                $("#fil").click(function () {
                    var selVal = $("#fil").val();
                    $("#filterVal2").hide();
                    console.log(selVal + " = log");
                    if (selVal == "byDateRange") {
                        console.log(selVal + " = log inside");
                        $("#filterVal2").show();

                    }
                });
            });
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
                    <c:if test="${param.err != null}">
                        <p class="error">${param.err}</p>
                    </c:if>
                    <table width="100%">
                        <tr>
                            <td align="left" >
                                <form action="<s:url value="/order_filter"/>">
                                    <select name="filter" id="fil">  
                                        <option value="byDate" label="By Date"/>    
                                        <option value="byMonth" label="By Month"/>  
                                        <option value="byYear" label="By Year"/>  
                                        <option value="byFuel" label="By Fuel"/>   
                                        <option value="byDateRange" label="By Date Range"/>    
                                    </select>
                                    <input id="filterVal" type="text" name="val" value="${param.val}" placeholder="Month:2023-01"/>
                                    <input id="filterVal2" type="date" name="val2" value="${param.val2}" placeholder="Month:2023-01"/>
                                    <button>Filter</button>
                                </form>
                            </td>                           
                            <td align="right" >
                                <form action="<s:url value="/order/order_search"/>">
                                    <input type="text" name="freeText" value="${param.freeText}" placeholder="Enter Text To Search">
                                    <button>Find</button>
                                </form>
                            </td>                           
                        </tr>
                    </table>

                    <table  border="1" cellpadding="3"  width="100%">
                        <tr>
                            <td>ID</td>
                            <td>DATE</td>
                            <td>FUEL</td>
                            <td>QUANTITY</td>
                            <td>RATE</td>
                            <td>TOTAL</td>
                        </tr>

                        <c:if test="${empty orderList}">
                            <p class="error">No Fuel Present</p>
                        </c:if>
                        <c:forEach var="c" items="${orderList}" varStatus="st">
                            <tr>
                                <td>${c.orderId}</td>
                                <td>${c.date}</td>
                                <td>
                                    <s:url var="item"  value="${c.fuelId}"/>
                                    <c:if test="${item == '1'}">Petrol</c:if>
                                    <c:if test="${item != '1'}">Diesel</c:if>
                                    </td>
                                    <td>${c.qty}</td>
                                <td>${c.rate}</td>
                                <td>${c.total}</td>
                            </tr>
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
