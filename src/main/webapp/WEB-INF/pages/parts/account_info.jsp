<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="well">
    <h4>Account Info</h4>

    <sec:authorize access="isAnonymous()">
        <a class="btn btn-lg btn-primary" href="/reg">
            <i class="glyphicon glyphicon-user pull-left"></i><span> SignIn<br></span></a>
    </sec:authorize>


    <sec:authorize access="isAuthenticated()">
        <a class="btn btn-lg btn-success " href="">
            <i class="glyphicon glyphicon-dashboard pull-left"></i><span>Account<br></span></a>

        <a class="btn btn-lg btn-danger" href="/logout">
            <i class="glyphicon glyphicon-tasks pull-left"></i><span>Log out<br></span></a>

    </sec:authorize>
</div>

<script>
    loadCSS('/resources/css/acc_info.css');
</script>