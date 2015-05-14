<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="post" items="${postsEntries}">
    <!-- First Blog Post -->
    <h2>
        <a href="<c:out value="/app/post/${post.id}"/>"><c:out value="${post.title}"/></a>
    </h2>

    <p class="lead">
        by <a href="/app/user/${post.author.login}"><c:out value="${post.author.login}"/></a>
    </p>

    <p><span class="glyphicon glyphicon-time"></span> Posted on <c:out value="${post.created}"/></p>
    <hr>
    <%--<img class="img-responsive" src="http://placehold.it/900x300" alt="">--%>
    <%--<hr>--%>
    <p><c:out value="${post.text}"/></p>
    <a class="btn btn-primary" href="#">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>

    <hr>
</c:forEach>

<!-- Pager -->
<ul class="pager">
    <li class="previous">
        <a href="#">&larr; Older</a>
    </li>
    <li class="next">
        <a href="#">Newer &rarr;</a>
    </li>
</ul>
