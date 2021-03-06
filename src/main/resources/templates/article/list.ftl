<#if articles??>
    <div class="container">
        <div class="row">
            <div class="col-xs-4">
                <a href="/article/add" class="btn btn-primary btn-lg"><i class="fa fa-plus"></i><@spring.message "article_form_add_msg" /></a>
            </div>
        </div>
        <br />
        <table id='article-table' class="table table-middle  table-responsive table-hover">
            <thead>
                <th>Id</th>
                <th><@spring.message "article_form_image_msg" /></th>
                <th><@spring.message "user_form_name_msg" /></th>
                <th><@spring.message "article_form_quantity_msg" /></th>
                <th><@spring.message "article_form_cost_msg" /></th>
                <th><@spring.message "article_form_family_msg" /></th>
                <th>Action</th>
            </thead>
            <tbody>
            <#list articles as article>
            <tr>
                <td>${article.getId()}</td>
                <td>
                    <img class="img img-circle img-table" src="${article.getImage()!"not found..."}">
                </td>
                <td>${article.getName()}</td>
                <td>${article.getQuantity()}</td>
                <td>${article.getCost()}</td>
                <td>${article.getFamily()}</td>
                <td>
                    <#if currentUser?? && currentUser.hasRole("ROLE_USER")>
                        <a href="/article/borrow/${article.getId()}" class="btn btn-success btn-sm"><@spring.message "article_borrow_button_title" /></a>
                    </#if>
                    <#if currentUser?? && currentUser.hasRole("ROLE_ADMIN")>
                        <a href="/article/${article.getId()}" class="btn btn-info btn-sm"><i class="fa fa-edit"></i> <@spring.message "form_edit_msg" /></a>
                        <a href="/article/delete/${article.getId()}" class="btn btn-danger btn-sm"><i class="fa fa-close"></i> <@spring.message "form_delete_msg" /></a>
                    </#if>

                </td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
</#if>