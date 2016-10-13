<div class="container">
    <div class="row">
        <div class="col-xs-4">
            <a class="btn btn-primary btn-lg" href="/admin/reports"><@spring.message "admin_view_reports" /></a>
            <a class="btn btn-info btn-lg" href="/admin/to_be_returned"><@spring.message "admin_to_be_returned" /></a>
        </div>
    </div>
    <br />
    <div class="row">
        <table id='user-table' class="table table-responsive table-hover">
            <thead>
            <th>Id</th>
            <th><@spring.message "user.view.username_title" /></th>
            <th><@spring.message "user.view.email_title" /></th>
            <th>Action</th>
            </thead>
        </table>
    </div>
</div>