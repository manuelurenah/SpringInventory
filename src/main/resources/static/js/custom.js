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

    $('.datepicker').datepicker();

    $('#family').change(function(e) {
        // Fix subfamilies
        var id = e.target.value;
        $('#family-placeholder').remove();
        console.log(id);
        $.ajax({
            url: '/family/subfamilies?familyId=' + id,
            method: 'GET',
            dataType: 'json',
            success: function(data) {
                var html = "";
                for(var i = 0; i < data.subfamilies.length; i++) {
                    var elem = data.subfamilies[i];
                    html+= "<option value='" + elem.id +"'>" + elem.name + "</option>";
                }
                $('#subfamilies').html(html);
            }
        })
    });
});