<%@include file="/fragments/encoding.jspf" %>
<%@include file="/fragments/taglib.jspf" %>

<html lang="en">

<head>

    <%@include file="/fragments/header.jspf" %>

</head>

<body>
<%@include file="/fragments/navigation.jspf" %>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">
                    <%@include file="/pages/forms/registration.jspf" %>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="dist/js/sb-admin-2.js"></script>

<script type="text/javascript" src="js/jquery-registration-validation.js"></script>
</body>

</html>