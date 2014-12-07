<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:defaultpage>

    <jsp:attribute name="head">
        <title>Вход</title>
        <link href="${contextPath}/assets/css/signin.css" rel="stylesheet" media="screen" type="text/css">
    </jsp:attribute>

    <jsp:attribute name="scripts">
    </jsp:attribute>


    <jsp:attribute name="content">
        <div class="container">
            <form class="form-signin" role="form" method="post" action="<c:url value='/j_spring_security_check' />">
                <h2 class="form-signin-heading">Выполните вход</h2>
                <label for="inputEmail" class="sr-only">Логин</label>
                <input type="text" id="inputEmail" name="j_username" class="form-control" placeholder="Логин" required autofocus>
                <label for="inputPassword" class="sr-only">Пароль</label>
                <input type="password" id="inputPassword" name="j_password" class="form-control" placeholder="Пароль" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Вход</button>
            </form>

        </div>
    </jsp:attribute>

</t:defaultpage>
