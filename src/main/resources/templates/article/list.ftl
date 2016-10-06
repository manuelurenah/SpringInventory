<#if articles??>
    <div class="container">
        <div class="row">
            <div class="col-xs-4">
                <a href="/article/add" class="btn btn-primary btn-lg"><i class="fa fa-plus"></i><@spring.message "article_form_add_msg" /></a>
            </div>
        </div>
        <br />
        <table id='article-table' class="table table-responsive table-hover">
            <thead>
            <th>Id</th>
            <th><@spring.message "user_form_name_msg" /></th>
            <th><@spring.message "article_form_quantity_msg" /></th>
            <th><@spring.message "article_form_cost_msg" /></th>
            <th>Action</th>
            </thead>
        </table>
    </div>
</#if>