<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Analysis Report</title>
        <script type="text/javascript" src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>  
        <script type="text/javascript" src="https://canvasjs.com/assets/script/jquery.canvasjs.min.js"></script>
    </head>
    <s:url var="url_css" value="/static/css/style.css"/>
    <link href="${url_css}" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">

        window.onload = function () {

        var mAmtWise = {
        title: {
        text: "Monthly Report By Amount"
        },
                toolTip: {
                shared: true
                },
                legend: {
                cursor: "pointer",
//		itemclick: toggleDataSeries
                },
                subtitles: [{
                text: "Total Budget"
                }],
                animationEnabled: true,
                theme: "light",
                data: [
                {
                //dataSeries - first quarter
                /*** Change type "column" to "bar", "area", "line" or "pie"***/
                type: "column",
                        name: "Petrol Amount",
                        showInLegend: "true",
                        legendText: "Petrol",
                        dataPoints: [
        <c:forEach var="c" items="${pMonthList}" varStatus="st">
                        {label: "${c.year}-" + "${c.month}", y: ${c.total}},
        </c:forEach>

                        ]
                },
                {
//second column
                type: "column",
                        name: "Diesel Amount",
                        showInLegend: "true",
                        legendText: "Diesel",
                        dataPoints: [
        <c:forEach var="c" items="${dMonthList}" varStatus="st">
                        {label: "${c.year}-" + "${c.month}", y: ${c.total}},
        </c:forEach>
                        ]
                },
                ]
        };
        //// next chart for quantity wise

        var mQtyWise = {
        title: {
        text: "Monthly Report By Qty"
        },
                toolTip: {
                shared: true
                },
                legend: {
                cursor: "pointer",
                },
                subtitles: [{
                text: "Total Budget"
                }],
                animationEnabled: true,
                theme: "light",
                data: [
                {
                //dataSeries - first quarter
                /*** Change type "column" to "bar", "area", "line" or "pie"***/
                type: "column",
                        name: "Petrol Amount",
                        showInLegend: "true",
                        legendText: "Petrol",
                        dataPoints: [
        <c:forEach var="c" items="${dMonthList}" varStatus="st">
                        {label: "${c.year}-" + "${c.month}", y: ${c.qty}},
        </c:forEach>

                        ]
                },
                {

                type: "column",
                        name: "Diesel Amount",
                        showInLegend: "true",
                        legendText: "Diesel",
                        dataPoints: [
        <c:forEach var="c" items="${dMonthList}" varStatus="st">
                        {label: "${c.year}-" + "${c.month}", y: ${c.qty}},
        </c:forEach>
                        ]
                },
               
                ]
        };
        ///////next ROW Daily Sale
        var dAmtWise = {
        title: {
        text: "Daily Report By Amount"
        },
                toolTip: {
                shared: true
                },
                legend: {
                cursor: "pointer",
//		itemclick: toggleDataSeries
                },
                subtitles: [{
                text: "Total Budget"
                }],
                animationEnabled: true,
                theme: "light",
                data: [
                {
                //dataSeries - first quarter
                /*** Change type "column" to "bar", "area", "line" or "pie"***/
                type: "column",
                        name: "Petrol Amount",
                        showInLegend: "true",
                        legendText: "Petrol",
                        dataPoints: [
        <c:forEach var="c" items="${pDayList}" varStatus="st">
                        {label: "${c.year}-" + "${c.month}-"+${c.day}, y: ${c.total}},
        </c:forEach>

                        ]
                },
                {//dataSeries - second quarter

                type: "column",
                        name: "Diesel Amount",
                        showInLegend: "true",
                        legendText: "Diesel",
                        dataPoints: [
        <c:forEach var="c" items="${dDayList}" varStatus="st">
                        {label: "${c.year}-" + "${c.month}-"+${c.day}, y: ${c.total}},
        </c:forEach>
                        ]
                },
//                
                ]
        };
        //// next chart for quantity wise

        var dQtyWise = {
        title: {
        text: "Daily Report By Qty"
        },
                toolTip: {
                shared: true
                },
                legend: {
                cursor: "pointer",
//		itemclick: toggleDataSeries
                },
                subtitles: [{
                text: "Total Budget"
                }],
                animationEnabled: true,
                theme: "light",
                data: [
                {
                //dataSeries - first quarter
                /*** Change type "column" to "bar", "area", "line" or "pie"***/
                type: "column",
                        name: "Petrol Amount",
                        showInLegend: "true",
                        legendText: "Petrol",
                        dataPoints: [
        <c:forEach var="c" items="${pDayList}" varStatus="st">
                        {label: "${c.year}-" + "${c.month}-"+${c.day}, y: ${c.qty}},
        </c:forEach>

                        ]
                },
                {//dataSeries - second quarter

                type: "column",
                        name: "Diesel Amount",
                        showInLegend: "true",
                        legendText: "Diesel",
                        dataPoints: [
        <c:forEach var="c" items="${dDayList}" varStatus="st">
                        {label: "${c.year}-" + "${c.month}-"+${c.day}, y: ${c.qty}},
        </c:forEach>
                        ]
                },
//                
                ]
        };
        $("#reportChart").CanvasJSChart(mAmtWise);
        $("#reportChart2").CanvasJSChart(mQtyWise);
        $("#reportChart3").CanvasJSChart(dAmtWise);
        $("#reportChart4").CanvasJSChart(dQtyWise);
        }
    </script>
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
                <td>
                    <table border width="100%" align="center">
                        <tr>
                            <td>
                                <div id="reportChart" style="width: 100%; height: 300px;display: inline-block;"></div>
                            </td>
                            <td>
                                <div id="reportChart2" style="width: 100%; height: 300px;display: inline-block;"></div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div id="reportChart3" style="width: 100%; height: 300px;display: inline-block;"></div>
                            </td>
                            <td>
                                <div id="reportChart4" style="width: 100%; height: 300px;display: inline-block;"></div>
                            </td>
                        </tr>
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
