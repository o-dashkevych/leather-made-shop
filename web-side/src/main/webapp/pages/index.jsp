<%@include file="/fragments/encoding.jspf" %>
<%@include file="/fragments/taglib.jspf" %>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Leather Shop</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-homepage.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<%-- <%@include file="/WEB-INF/fragments/header.jspf" %> --%>

</head>

<body>


<%@include file="/fragments/navigation.jspf" %>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-md-9">

            <div class="row carousel-holder">

                <div class="col-md-12">
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item active">
                                <img class="slide-image" src="../images/products/strap_1.jpg" alt="">
                            </div>
                            <div class="item">
                                <img class="slide-image" src="../images/products/clutch_1.jpg" alt="">
                            </div>
                            <div class="item">
                                <img class="slide-image" src="../images/products/strap_3.jpg" alt="">
                            </div>
                        </div>
                        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                        </a>
                    </div>
                </div>

            </div>

            <div class="row">

                <div class="col-sm-4 col-lg-4 col-md-4">
                    <div class="thumbnail">
                        <img src="../images/products/strap_1.jpg" alt="">
                        <div class="caption">
                            <h4>$24.99</h4>
                            <h4><a href="">Ремешок для часов "NATO"</a>
                            </h4>
                            <p>Аксессуар сделан из качественной натуральной кожи. <a target="_blank"
                                                                                     href="http://weareable.com.ua/products/80/81/369.htm">We
                                are able</a>.</p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-lg-4 col-md-4">
                    <div class="thumbnail">
                        <img src="../images/products/strap_2.jpg" alt="">
                        <div class="caption">
                            <h4>$64.99</h4>
                            <h4><a href="#">Браслет "Спираль"</a>
                            </h4>
                            <p>Браслет сделан из качественной натуральной кожи с металлической фурнитурой.</p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-lg-4 col-md-4">
                    <div class="thumbnail">
                        <img src="../images/products/strap_3.jpg" alt="">
                        <div class="caption">
                            <h4>$74.99</h4>
                            <h4><a href="#">Браслет "Спираль"</a>
                            </h4>
                            <p>Браслет сделан из качественной натуральной кожи с металлической фурнитурой. </p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-lg-4 col-md-4">
                    <div class="thumbnail">
                        <img src="../images/products/clutch_1.jpg" alt="">
                        <div class="caption">
                            <h4>$84.99</h4>
                            <h4><a href="#">Клатч "Клевер"</a>
                            </h4>
                            <p>Удобная и функциональная модель клатча, которую можно использовать как кошелек или чехол
                                для документов.</p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-lg-4 col-md-4">
                    <div class="thumbnail">
                        <img src="../images/products/purse_1.jpg" alt="">
                        <div class="caption">
                            <h4>$94.99</h4>
                            <h4><a href="#">Портмоне "Луна"</a>
                            </h4>
                            <p>Удобный и практичный кошелек из натуральной кожи с металлической фурнитурой.</p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 col-lg-4 col-md-4">
                    <h4><a href="#">Like this template?</a>
                    </h4>
                    <p>If you like this template, then check out <a target="_blank"
                                                                    href="http://maxoffsky.com/code-blog/laravel-shop-tutorial-1-building-a-review-system/">this
                        tutorial</a> on how to build a working review system for your online store!</p>
                    <a class="btn btn-primary" target="_blank"
                       href="http://maxoffsky.com/code-blog/laravel-shop-tutorial-1-building-a-review-system/">View
                        Tutorial</a>
                </div>

            </div>

        </div>

    </div>

</div>
<!-- /.container -->

<div class="container">

    <hr>

    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; Your Website 2014</p>
            </div>
        </div>
    </footer>

</div>
<!-- /.container -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>

</html>