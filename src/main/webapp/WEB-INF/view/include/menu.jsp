<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <s:url var="url_order_report" value="/order_report"/>
    <s:url var="url_analysis_report" value="/report_analysis"/>
    <s:url var="url_refill" value="/fuel_manager"/>
    <s:url var="url_index" value="/index"/>
    <a href="${url_index}">Home</a> | <a href="${url_order_report}">Order Report</a> | <a href="${url_refill}">Fuel Manager</a> | <a href="${url_analysis_report}">Analysis Report</a> | <a href="#">Help</a>   




