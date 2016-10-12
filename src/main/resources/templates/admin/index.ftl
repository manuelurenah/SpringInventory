<div class="container">
    <div class="row">
        <h2>Admin Site.</h2>
        <h4>This site is still under development...</h4>
        <div class="col-xs-2">
            <a class="btn btn-primary" style="{width: 100%}" href="/admin/reports"><@spring.message "admin_view_reports" /></a>
        </div>
    </div>
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