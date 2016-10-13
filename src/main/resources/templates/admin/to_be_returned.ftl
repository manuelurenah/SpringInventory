<#if borrowed_articles??>
<div class="container">
    <table id='rented-table' class="table table-middle  table-responsive table-hover">
        <thead>
        <th>Id</th>
        <th><@spring.message "article_form_name_msg" /></th>
        <th><@spring.message "client_msg" /></th>
        <th><@spring.message "article_taken_date" /></th>
        </thead>
        <tbody>
            <#list borrowed_articles as borrow>
            <tr>
                <td>${borrow.getId()}</td>
                <td>${borrow.getArticle()}</td>
                <td>${borrow.getClient()}</td>
                <td>${borrow.getTakenOn()}</td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</#if>