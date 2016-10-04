<div class="container">
<#if error_message?? >
    <br>
    <div class="row">
        <div class="col-xs-12">
            <div class="alert alert-danger">
            ${error_message}
            </div>
        </div>
    </div>
</#if>
    <div class="row">
        <div class="col-xs-12">
            <form action="#" method="post" role="form">
                <#--<legend><@spring.message "user_login_title" /></legend>-->

                <div class="form-group">
                    <label for="username"><i class="fa fa-user"></i> <@spring.message "user_form_username_msg" /></label>
                    <input type="text" class="form-control" name="username" id="username" placeholder="">
                </div>
                <div class="form-group">
                    <label for="password"><i class="fa fa-key"></i> <@spring.message "user_form_password_msg" /></label>
                    <input type="password" class="form-control" name="password" id="password" placeholder="">
                </div>
                <button type="submit" class="btn btn-primary btn-block"><@spring.message "login_msg" /></button>
            </form>
        </div>
    </div>
</div>
