<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:defaultpage>

    <jsp:attribute name="head">
        <title>Домашняя страница</title>
        <link href="${contextPath}/assets/css/index.css" rel="stylesheet" media="screen" type="text/css">
    </jsp:attribute>

    <jsp:attribute name="scripts">
    </jsp:attribute>


    <jsp:attribute name="content">
        <c:set var="roleM" value="ROLE_MANAGER"/>
        <div class="container">
            <div class="header">
                <nav>
                    <ul class="nav nav-pills pull-right">
                        <li role="presentation" class="active"><a href="/">Главная</a></li>
                        <c:if test="${employee.role eq roleM}">
                            <li role="presentation"><a href="/get_inventory">Инвентарная опись</a></li>
                        </c:if>
                        <li role="presentation"><a href="/j_spring_security_logout">Выход</a></li>
                    </ul>
                </nav>
                <h3 class="text-muted">Лабораторная работа по ТП</h3>
            </div>

            <div class="jumbotron">
                <h1>${employee.firstName} ${employee.lastName}</h1>

                <p class="lead">Добро пожаловать, вы вошли как управляющий магазином!</p>
            </div>
            <footer class="footer">
                <p>&copy; FPMI BSU 2014</p>
            </footer>
        </div>

    </jsp:attribute>

</t:defaultpage>
