<%@tag description="The generic page template. Uses bootstrap, jquery and navbar"
       pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@attribute name="scripts" fragment="true"%>
<%@attribute name="head" fragment="true"%>
<%@attribute name="content" fragment="true"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application"/>

<!DOCTYPE html>
<html>
    <head>
        <t:defaulthead />
        <jsp:invoke fragment="head"/>
        <script type="text/javascript">var props = {cp: "${contextPath}"};</script>
    </head>
    <body>
        <jsp:invoke fragment="content"/>

        <jsp:invoke fragment="scripts"/>
    </body>
</html>