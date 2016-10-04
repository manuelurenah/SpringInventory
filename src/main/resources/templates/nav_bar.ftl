<nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
    <div class="container topnav">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand topnav" href="/">Spring Inventory</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
            <#if !user??>
                <li>
                    <a href="/user/login"><@spring.message "login_msg" /></a>
                </li>
                <li>
                    <a href="/user/create"><@spring.message "register_msg" /></a>
                </li>
            <#else >
                <li class="disabled">
                    <a href="#">${user}</a>
                </li>
                <li>
                    <a href="#"><@spring.message "profile_msg" /></a>
                </li>

                <#if user.getAdmin()>
                    <li>
                        <a href="#">Admin</a>
                    </li>
                </#if>
                <li>
                    <a href="#"><@spring.message "logout_msg" /></a>
                </li>
            </#if>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<#if template_name?? && template_name == "index.ftl">
    <!-- Header -->
    <a name="about"></a>
    <div class="intro-header">
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message">
                        <h1>Spring Inventory</h1>
                        <h3><@spring.message "header_subtitle_message" /></h3>
                        <hr class="intro-divider">
                        <ul class="list-inline intro-social-buttons">
                            <#if !user??>
                                <li>
                                    <a href="/user/login" class="btn btn-default btn-lg"><i class="fa fa-user"></i><@spring.message "login_msg" /></a>
                                </li>
                                <li>
                                    <a href="/user/create" class="btn btn-default btn-lg"><i class="fa fa-check"></i><@spring.message "register_msg" /></a>
                                </li>
                            </#if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.container -->
    </div>
<!-- /.intro-header -->
<#else>
    <div class="container-fluid">
        <div class="jumbotron" id="header-small">
            <h1>Spring Inventory</h1>
        </div>
    </div>
</#if>
