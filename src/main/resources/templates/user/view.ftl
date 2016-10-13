<#if user??>
<div class="container">
    <#if message?? >
        <div class="row">
            <div class="col-xs-12">
                <div class="alert alert-${message_type!"success"}">${message}</div>
            </div>
        </div>
    </#if>
    <#if user.getImage()?? >
    <div class="row">
        <div class="col-xs-6 col-xs-offset-3 fixed-image">
            <img class="img img-circle" src="${user.getImage()!"not found..."}"/>
        </div>
    </div>
    </#if>
    <#if user.getDocument()??>
    <div class="row">
        <div class="col-xs-6 col-xs-offset-3 text-center">
            <h3><@spring.message "user_form_document"></@spring.message></h3>
            <p>${user.getDocument()}</p>
        </div>
    </div>
    </#if>
    <div class="row">

        <div class="col-xs-6 text-center">
            <h3><@spring.message "user.view.username_title"></@spring.message></h3>
            <p>${user}</p>
        </div>
        <div class="col-xs-6 text-center">
            <h3><@spring.message "user.view.name_title"></@spring.message></h3>
            <p>${user.getName()} ${user.getLastName()}</p>
        </div>
        <div class="col-xs-6 text-center">
            <h3><@spring.message "user.view.email_title"></@spring.message></h3>
            <p>${user.getEmail()}</p>
        </div>
        <div class="col-xs-6 text-center">
            <h3><@spring.message "user.view.roles_title"></@spring.message></h3>
            <p>
                <#list user.getRoles() as role>
                    ${role.getRole()}
                    <#if role?has_next> | </#if>
                </#list>
            </p>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <h3><@spring.message "invoice"></@spring.message></h3>
            <table class="table table-responsive table-hover table-middle">
                <thead>
                <th>ID</th>
                <th><@spring.message "created_on"></@spring.message></th>
                <th><@spring.message "articles_msg"></@spring.message> <@spring.message "article_form_quantity_msg"></@spring.message></th>
                <th>Total</th>
                </thead>
                <tbody>
                    <#list user.getInvoices() as iv>
                        <tr>
                            <td>${iv.getId()}</td>
                            <td>${iv.getCreatedAt()}</td>
                            <td>${iv.countArticles()}</td>
                            <td>${iv.getTotal()}</td>
                        </tr>
                    </#list>
                </tbody>
            </table>
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
