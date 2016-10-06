<#if user??>
<div class="container">
    <#if message?? >
        <div class="row">
            <div class="col-xs-12">
                <div class="alert alert-${message_type!"success"}">${message}</div>
            </div>
        </div>
    </#if>
    <div class="row">
        <div class="col-xs-6">
            <h3><@spring.message "user.view.username_title"></@spring.message></h3>
            <p>${user}</p>
        </div>
        <div class="col-xs-6">
            <h3><@spring.message "user.view.name_title"></@spring.message></h3>
            <p>${user.getName()} ${user.getLastName()}</p>
        </div>
        <div class="col-xs-6">
            <h3><@spring.message "user.view.email_title"></@spring.message></h3>
            <p>${user.getEmail()}</p>
        </div>
        <div class="col-xs-6">
            <h3><@spring.message "user.view.roles_title"></@spring.message></h3>
            <p>
                <#list user.getRoles() as role>
                    ${role.getRole()}
                    <#if role?has_next> | </#if>
                </#list>
            </p>
        </div>
    </div>
</div>
<#else>
<div class="container">
    <div class="row">
        <br>
        <div class="alert alert-danger"><@spring.message "user_not_found"></@spring.message></div>
    </div>
</div>
</#if>
