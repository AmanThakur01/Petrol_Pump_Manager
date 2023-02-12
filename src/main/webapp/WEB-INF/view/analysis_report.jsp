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
<!--        <script>
            $(document).ready(function () {
                $("#filterVal2").hide();
                $("#filterVal").hide();
                $("#reportChart6").hide();
                $("#reportChart5").hide();
                $("#fil").click(function () {
                    var selVal = $("#fil").val();
                    console.log(selVal + " = log");
                    if (selVal == "byDateRange") {
                        console.log(selVal + " = log inside");
                        $("#filterVal2").show();
                        $("#filterVal").show();

                    }
                    if (selVal == "byQty") {
                        console.log(selVal + " = log inside");
                        $("#reportChart6").show();
                        $("#reportChart5").hide();

                    }
                    if (selVal == "byAmt") {
                        console.log(selVal + " = log inside");
                        $("#reportChart5").show();
                        $("#reportChart6").hide();

                    }
                });
            });
        </script>-->
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
                        {label: "${c.year}-" + "${c.month}-" +${c.day}, y: ${c.total}},
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
                        {label: "${c.year}-" + "${c.month}-" +${c.day}, y: ${c.total}},
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
                        {label: "${c.year}-" + "${c.month}-" +${c.day}, y: ${c.qty}},
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
                        {label: "${c.year}-" + "${c.month}-" +${c.day}, y: ${c.qty}},
        </c:forEach>
                        ]
                },
//                
                ]
        };
//        pie total sale
        var pSale = {
        exportEnabled: true,
        title: {
        text: "Net Sale Amount"
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
                type: "pie",
                        showInLegend: "true",
                        toolTipContent: "{name}: <strong>{y}</strong>",
                        indexLabel: "{name} - {y}Rs.",
                        dataPoints: [
        <c:forEach var="c" items="${pNetSale}" varStatus="st">
                        {y: ${c.total}, name: "${c.fuel}"},
                        
        </c:forEach>

                ]
                }

                ]
        };
        var dSale = {
        exportEnabled: true,
                animationEnabled: true,
                legend:{
                cursor: "pointer",
                },
                title: {
                text: "Net Sale Qty"
                },
                subtitles: [{
                text: "Total Budget"
                }],
                
                theme: "light",
                data: [
                {
                type: "pie",
                        showInLegend: "true",
                        toolTipContent: "{name}: <strong>{y}</strong>",
                        indexLabel: "{name} - {y}",
                        dataPoints: [
        <c:forEach var="c" items="${pNetSale}" varStatus="st">
                        {y: ${c.qty}, name: "${c.fuel}"},
        </c:forEach>
                        ]
                },
                ]
        };
        $("#reportChart").CanvasJSChart(mAmtWise);
        $("#reportChart2").CanvasJSChart(mQtyWise);
        $("#reportChart3").CanvasJSChart(dAmtWise);
        $("#reportChart4").CanvasJSChart(dQtyWise);
        $("#reportChart5").CanvasJSChart(pSale);
        $("#reportChart6").CanvasJSChart(dSale);
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
                                <div id="reportChart5" style="width: 100%; height: 300px;display: inline-block;"></div>
                            </td>
                            <td>
                                <div id="reportChart6" style="width: 100%; height: 300px;display: inline-block;"></div>
                            </td>
                        </tr>
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
                        <tr>
                            <td colspan="2">
                                <form action="<s:url value="/netSale_filter"/>">
                                    
                                    <label>By Date Range</label>    
                                    <input id="filterVal" type="date" name="val" value="${param.val}"/>
                                    <input id="filterVal2" type="date" name="val2" value="${param.val2}"/>
                                    <button>Filter</button>
                                </form>
                            </td>
                            
                        </tr>
                        <tr>
                            <td></td>
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
