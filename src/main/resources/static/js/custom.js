/**
 * Created by MEUrena on 10/6/16.
 */

// Chart Implementation

var CHART_DATA = {
    loadArticleData: function () {
        var formattedArticleArray = [];
        $.ajax({
            async: false,
            url: '/chart/data',
            dataType: 'json',
            success: function (articleJsonData) {
                console.log(articleJsonData);
                $.each(articleJsonData, function (index, article) {
                    // This is for test purposes
                    formattedArticleArray.push(article.quantity);
                });
            }
        });
        return formattedArticleArray;
    },
    createChartData: function (jsonData) {
        console.log(jsonData);

        return {
            labels: ['Quantity'],
            datasets: [{
                label: 'Test Chart',
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)'
                ],
                borderWidth: 1,
                /*As Ajax response data is a multidimensional array, we have 'article' data in 0th position*/
                data : jsonData[0]
            }]
        };
    },
    renderArticleBarChart: function (barChartData) {
        var context = document.getElementById("report_chart").getContext("2d");
        var barChart = new Chart(context, {
            type: 'bar',
            data: barChartData,
            options: {
                scales: {
                    xAxes: [{
                        stacked: true
                    }],
                    yAxes: [{
                        stacked: true
                    }]
                }
            }
        });

        return barChart;
    },
    initBarChart: function () {
        var articleData = CHART_DATA.loadArticleData();
        chartData = CHART_DATA.createChartData(articleData);
        barChartObj = CHART_DATA.renderArticleBarChart(chartData);
    }
};

// DataTables
$(document).ready(function() {
    var articleTable = $('table#article-table').DataTable({
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
    var userTable = $('#user-table').DataTable({
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

    CHART_DATA.initBarChart();
});