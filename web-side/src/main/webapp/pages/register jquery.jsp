<%@include file="/WEB-INF/fragments/encoding.jspf" %>
<%@include file="/WEB-INF/fragments/taglib.jspf" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Registration page</title>

    <!-- Bootstrap Core CSS -->
    <link href="/WEB-INF/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/WEB-INF/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/WEB-INF/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/WEB-INF/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">
                    <form role="form" action="index.html">
                        <fieldset>
                            <div id="loginDiv" class="form-group">
                                <input class="form-control" placeholder="Login" id="login" name="login" type="text"
                                       autofocus>
                            </div>
                            <div id="emailDiv" class="form-group">
                                <input class="form-control" placeholder="E-mail" id="email" name="email" type="text"
                                       autofocus>
                            </div>
                            <div id="emailRepeatDiv" class="form-group">
                                <input class="form-control" placeholder="Repeat e-mail" id="emailRepeat"
                                       name="emailRepeat" type="text" autofocus>
                            </div>
                            <div id="passwordDiv" class="form-group">
                                <input class="form-control" placeholder="Password" name="password" id="password" type="password"
                                       value="">
                            </div>
                            <div id="passwordRepeatDiv" class="form-group">
                                <input class="form-control" placeholder="Repeat password" id="passwordRepeat" name="passwordRepeat" type="password"
                                       value="">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                </label>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <input class="btn btn-lg btn-success btn-block" type="submit" id="registerSubmit" value="Register">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="/WEB-INF/bower_components/jquery/dist/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/WEB-INF/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="/WEB-INF/bower_components/metisMenu/dist/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="/WEB-INF/dist/js/sb-admin-2.js"></script>

<script type="text/javascript" src="/WEB-INF/js/jquery-registration-validation.js"></script>
</body>

</html>