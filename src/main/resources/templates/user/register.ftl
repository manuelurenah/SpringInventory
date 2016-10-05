<div class="container">
    <#if error_message?? >
        <br />
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
            <form method="post" role="form">
                <#--<legend><@spring.message "user_register_title" /></legend>-->
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <br>
                <div class="col-xs-6">
                    <div class="form-group">
                        <label for="username"><i class="fa fa-user"></i> <@spring.message "user_form_username_msg" /></label>
                        <input required type="text" class="form-control" name="username" id="username" placeholder="">
                    </div>
                </div>
                <div class="col-xs-6">
                    <div class="form-group">
                        <label for="email"><i class="fa fa-key"></i> <@spring.message "user_form_email_msg" /></label>
                        <input required type="email" class="form-control" name="email" id="email" placeholder="e.g: lrojas@gmail.com">
                    </div>
                </div>
                <div class="col-xs-6">
                    <div class="form-group">
                        <label for="password"><i class="fa fa-key"></i> <@spring.message "user_form_password_msg" /></label>
                        <input required type="password" class="form-control" name="password" id="password" placeholder="">
                    </div>
                </div>
                <div class="col-xs-6">
                    <div class="form-group">
                        <label for="password_2"><@spring.message "user_form_confirm_msg" /> <@spring.message "user_form_password_msg" /></label>
                        <input required type="password" class="form-control" name="retypePassword" id="password_2" placeholder="">
                    </div>
                </div>
                <div class="col-xs-6">
                    <div class="form-group">
                        <label for="firstName"><i class="fa fa-key"></i> <@spring.message "user_form_name_msg" /></label>
                        <input required type="text" class="form-control" name="firstName" id="firstName" placeholder="e.g: Pedro">
                    </div>
                </div>
                <div class="col-xs-6">
                    <div class="form-group">
                        <label for="lastName"><i class="fa fa-key"></i> <@spring.message "user_form_last_msg" /></label>
                        <input required type="text" class="form-control" name="lastName" id="lastName" placeholder="e.g: Zahran">
                    </div>
                </div>
                <button type="submit" class="btn btn-info btn-block"><@spring.message "register_msg" /></button>
            </form>
        </div>
    </div>
</div>
