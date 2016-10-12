<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0" />
    <title>Spring Inventory</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/webjars/font-awesome/4.6.3/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/webjars/datatables/1.10.12/css/dataTables.bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.min.css" type="text/css">
    <link rel="stylesheet" href="/css/landing-page.css" type="text/css">
    <link rel="stylesheet" href="/css/custom.css" type="text/css">
</head>
<body>
    <div id="wrapper">
        <#include 'nav_bar.ftl'/>
        <div id="content">
            <#if template_name??>
                <#include template_name>
            </#if>
        </div>
        <#include 'footer.ftl'/>
    </div>

    <script type="text/javascript" src="/webjars/jquery/3.1.0/jquery.min.js"></script>
    <script type="text/javascript" src="/lib/jquery.spring-friendly.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/webjars/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="/webjars/datatables/1.10.12/js/dataTables.bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript" src="/webjars/chartjs/2.1.3/Chart.min.js"></script>
    <script type="text/javascript" src="/js/custom.js"></script>
</body>
</html>
