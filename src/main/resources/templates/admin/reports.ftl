<div class="container">
    <div class="row">
        <div class="col-xs-6">
            <h3 class="text-center"><@spring.message "general_family_chart_header"></@spring.message></h3>
            <select class="form-control" style="visibility: hidden">
                <option selected disabled><@spring.message "article_form_family_placeholder"></@spring.message></option>
            </select>
            <br>
            <canvas id="report_chart" width="250" height="250"></canvas>
        </div>
        <div class="col-xs-6">

            <h3 class="text-center"><@spring.message "specific_family_chart_header"></@spring.message></h3>
            <select class="form-control" id="sfchart-selector">
                <option selected disabled><@spring.message "article_form_family_placeholder"></@spring.message></option>
                <#list parentFamilies as f>
                    <option value="${f.getId()}">${f.getName()}</option>
                </#list>
            </select>
            <br>
            <canvas id="specific_report_chart" width="250" height="250"></canvas>
        </div>
    </div>
</div>