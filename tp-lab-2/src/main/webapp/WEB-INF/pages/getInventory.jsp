<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 06.12.2014
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>

<t:defaultpage>

    <jsp:attribute name="head">
        <title>Инвентарная опись</title>
        <link href="${contextPath}/assets/css/index.css" rel="stylesheet" media="screen" type="text/css">
    </jsp:attribute>

    <jsp:attribute name="scripts">
    </jsp:attribute>


    <jsp:attribute name="content">
        <div class="container">
            <div class="header">
                <nav>
                    <ul class="nav nav-pills pull-right">
                        <li role="presentation"><a href="/">Главная</a></li>
                        <li role="presentation" class="active"><a href="/get_inventory">Инвентарная опись</a>
                        </li>
                        <li role="presentation"><a href="/j_spring_security_logout">Выход</a></li>
                    </ul>
                </nav>
                <h3 class="text-muted">Лабораторная работа по ТП</h3>
            </div>
            <table class="table table-striped">
                <caption>Инвентарная опись</caption>
                <tr>
                    <th>№</th>
                    <th>Название</th>
                    <th>Цена</th>
                    <th>Количество</th>
                </tr>

                <c:forEach var="product" items="${inventory}" varStatus="st">
                    <tr>
                        <td>${product.id}</td>
                        <td>${catalog[st.index].productDesc}</td>
                        <td>${catalog[st.index].productCost}</td>
                        <td>${product.productCount}</td>
                    </tr>
                </c:forEach>
            </table>

            <footer class="footer">
                <p>&copy; FPMI BSU 2014</p>
            </footer>
        </div>

</jsp:attribute>

</t:defaultpage>
