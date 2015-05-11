<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation -->
<jsp:include page="nav.jsp"/>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <!-- Blog Entries Column -->

        <%--switch --%>
        <div class="col-md-8">

            <h1 class="page-header">
                Page Heading
                <small>Secondary Text</small>
            </h1>
            <c:choose>
                <c:when test="${page == 'allPosts'}">
                    <jsp:include page="posts.jsp"/>
                </c:when>
                <c:when test="${page == 'auth'}">
                    <jsp:include page="../forms/login.jsp"/>
                </c:when>
                <c:when test="${page == 'reg'}">
                    <%--<jsp:include page="../forms"--%>
                </c:when>
                <c:otherwise>
                    <jsp:include page="posts.jsp"/>
                </c:otherwise>
            </c:choose>


        </div>
        <!-- Blog Sidebar Widgets Column -->
        <div class="col-md-4">

            <!-- Blog Search Well -->
            <jsp:include page="search.jsp"/>

            <!-- Blog Categories Well -->
            <jsp:include page="categories.jsp"/>

            <!-- Account Info -->
            <jsp:include page="account_info.jsp"/>

        </div>

    </div>
    <!-- /.row -->

    <hr>

    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; Your Website 2014</p>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </footer>

</div>
<!-- /.container -->
