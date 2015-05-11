<%--
  Created by IntelliJ IDEA.
  User: vladislav
  Date: 11.05.2015
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/blog-home.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<!-- jQuery -->
<script src="resources/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/resources/js/bootstrap.min.js"></script>

<script type="text/javascript">

  //css file loader
  function loadCSS(filename){

    var file = document.createElement("link")
    file.setAttribute("rel", "stylesheet")
    file.setAttribute("type", "text/css")
    file.setAttribute("href", filename)

    if (typeof file !== "undefined")
      document.getElementsByTagName("head")[0].appendChild(file)
  }

</script>
