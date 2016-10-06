/**
 * Created by MEUrena on 10/6/16.
 */

// DataTables
$(document).ready(function() {
    var table = $('table#article-table').DataTable({
        'ajax': '/data/articles',
        'serverSide': true,
        columns: [{
            data: 'id'
        }, {
            data: 'name'
        }, {
            data: 'quantity'
        }, {
            data: 'cost'
        }]
    });
    var table = $('#user-table').DataTable({
        'ajax': '/data/users',
        'serverSide': true,
        columns: [{
            data: 'id'
        }, {
            data: 'username'
        }, {
            data: 'email'
        }]
    });
});