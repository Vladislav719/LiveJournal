<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- Title -->
<h1><c:out value="${thePost.title}"/></h1>

<!-- Author -->
<p class="lead">
    by <a href="#"><c:out value="${thePost.author.login}"/></a>

    <h1>

    <c:out value="${thePost.author.id == currentUser.id}"/>
</h1>
    <c:if test="$[currentUser ne -1">
        <c:if test="${thePost.author.id == currentUser.id}">
            <a class="pull-right " href="/app/post/edit">
                <i class="glyphicon glyphicon-edit"></i>Edit
            </a>
        </c:if>

    </c:if>
</p>

<div class="lead">

</div>


<hr>

<!-- Date/Time -->
<p><span class="glyphicon glyphicon-time"></span> Posted on <c:out value="${thePost.created}"/></p>

<hr>

<!-- Preview Image -->
<%--<img class="img-responsive" src="http://placehold.it/900x300" alt="">--%>

<!-- Post Content -->
<%--<p class="lead">Важная ноовтсь здесь, часть новости</p>--%>

<p>
    <c:out value="${thePost.text}"/>
</p>

<hr>

<!-- Blog Comments -->

<!-- Comments Form -->
<div class="well">
    <h4>Leave a Comment:</h4>

    <form id="sendComment" action="/app/comment/add" method="post" role="form">
        <div class="form-group">
            <textarea id="text" name="text" class="form-control" rows="3"></textarea>
        </div>
        <input type="hidden" id="postId" name="postId" value="${thePost.id}"/>
        <button id="commentSendBtn" class="btn btn-primary">Submit</button>
    </form>
    <script>

        function timeConverter(UNIX_timestamp) {
            var a = new Date(UNIX_timestamp * 1000);
            var months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
            var year = a.getFullYear();
            var month = months[a.getMonth()];
            var date = a.getDate();
            var hour = a.getHours();
            var min = a.getMinutes();
            var sec = a.getSeconds();
            var time = date + ',' + month + ' ' + year + ' ' + hour + ':' + min + ':' + sec;
            return time;
        }

        var commentHtml = function (val) {
            var res = "<div class=\"media\"> <a class=\"pull-left\" href=\"#\">" +
                    "<img class=\"media-object\" src=\"http://placehold.it/64x64\" alt=\"\"></a>" + +"<div class=\"media-body\">" + +"<h4 class=\"media-heading\">" + val.author.login + +"<small>" + timeConverter(val.created) + "</small> </h4>" +
                    val.text + +"</div></div>";
            return res;
        };
        //        $('#commentSendBtn').on('click', function (e) {
        //            e.preventDefault();
        //            $.ajax({
        //                type: 'POST',
        //                url: '/app/comment',
        //                data: {text: $('#text').val(), postId: $('#postId').val()},
        //                success: function (result) {
        //                    console.log(result);
        //                    $('#comments-block').append(commentHtml(result));
        //                }
        //            });
        //        })
    </script>
</div>

<hr>

<!-- Posted Comments -->
<div id="comments-block">

    <c:forEach var="comment" items="${comments}">
        <div class="media">
            <a class="pull-left" href="#">
                <img class="media-object" src="http://placehold.it/64x64" alt="">
            </a>

            <div class="media-body">
                <h4 class="media-heading"><c:out value="${comment.author.login}"/>
                    <small>
                        <fmt:formatDate value="${comment.created}" pattern="MM/dd/yyyy HH:mm"/>
                    </small>
                </h4>
                <c:out value="${comment.text}"/>
            </div>
        </div>
    </c:forEach>
    <!-- Comment -->
    <%--<div class="media">--%>
    <%--<a class="pull-left" href="#">--%>
    <%--<img class="media-object" src="http://placehold.it/64x64" alt="">--%>
    <%--</a>--%>

    <%--<div class="media-body">--%>
    <%--<h4 class="media-heading">Start Bootstrap--%>
    <%--<small>August 25, 2014 at 9:30 PM</small>--%>
    <%--</h4>--%>
    <%--Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus--%>
    <%--odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.--%>
    <%--Donec lacinia congue felis in faucibus.--%>
    <%--</div>--%>
    <%--</div>--%>

    <%--<!-- Comment -->--%>
    <%--<div class="media">--%>
    <%--<a class="pull-left" href="#">--%>
    <%--<img class="media-object" src="http://placehold.it/64x64" alt="">--%>
    <%--</a>--%>

    <%--<div class="media-body">--%>
    <%--<h4 class="media-heading">Start Bootstrap--%>
    <%--<small>August 25, 2014 at 9:30 PM</small>--%>
    <%--</h4>--%>
    <%--Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus--%>
    <%--odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.--%>
    <%--Donec lacinia congue felis in faucibus.--%>
    <%--<!-- Nested Comment -->--%>
    <%--<div class="media">--%>
    <%--<a class="pull-left" href="#">--%>
    <%--<img class="media-object" src="http://placehold.it/64x64" alt="">--%>
    <%--</a>--%>

    <%--<div class="media-body">--%>
    <%--<h4 class="media-heading">Nested Start Bootstrap--%>
    <%--<small>August 25, 2014 at 9:30 PM</small>--%>
    <%--</h4>--%>
    <%--Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras--%>
    <%--purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate--%>
    <%--fringilla. Donec lacinia congue felis in faucibus.--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<!-- End Nested Comment -->--%>
    <%--</div>--%>
    <%--</div>--%>
</div>

<script>
    loadCSS('/resources/css/blog-post.css');
</script>