/**
 * Created by MEUrena on 10/6/16.
 */

// Chart Implementation

var CHART_DATA = {
    loadGeneralFamilyData: function () {
        var formattedArticleArray = {};
        $.ajax({
            async: false,
            url: '/chart/general_family',
            dataType: 'json',
            success: function (familyInfo) {
                var labels = [];
                var datasetData = [];
                $.each(familyInfo, function (index, data) {
                    // This is for test purposes
                    labels.push(data[0]);
                    datasetData.push(data[1]);
                });

                var datasets = [
                    {
                        data: datasetData,
                        backgroundColor: [
                            "#FF6384",
                            "#36A2EB",
                            "#FFCE56"
                        ],
                        hoverBackgroundColor: [
                            "#FF6384",
                            "#36A2EB",
                            "#FFCE56"
                        ]
                    }];

                formattedArticleArray = {
                    datasets: datasets,
                    labels: labels
                }
            },
            error: function(error) {
                console.log(error);
            }
        });
        return formattedArticleArray;
    },
    renderGeneralFamilyChart: function (pieChartData) {
        var context = document.getElementById("report_chart").getContext("2d");
        console.log(pieChartData);
        var pieChart = new Chart(context, {
            type: 'pie',
            data: pieChartData,
        });

        return pieChart;
    },
    initBarChart: function () {
        var chartData = CHART_DATA.loadGeneralFamilyData();
        generalFamilyChart = CHART_DATA.renderGeneralFamilyChart(chartData);
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