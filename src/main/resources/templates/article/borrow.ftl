<#if article??>
    <div class="container">
        <div class="row">
            <h3 class="text-center">${article.getName()}</h3>
        </div>
        <div class="row">
            <div class="col-xs-6 col-xs-offset-3 fixed-image">
                <img class='img-circle' src="${article.getImage()!"not_found"}"/>
            </div>
        </div>
        <div class="row">
            <br>
            <div class="col-xs-12">
                <p>${article.getDescription()}</p>
            </div>
        </div>
        <hr>
        <div class="row text-center">
            <h3><@spring.message "article_borrow_title"/></h3>
            <h4><@spring.message "article_form_cost_msg"/>: $<b>${article.getCost()}</b></h4>
        </div>
        <#if article.getRemainingQuantity() == 0>
            <div class="row">
                <h3><@spring.message "article_borrow_not_available"></@spring.message></h3>
            </div>
        <#else>
            <div class="row">
                <form method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label for="quantity"><@spring.message "article_form_quantity_msg"/></label>
                            <select class="form-control" name="quantity" required>
                                <#list 1..article.getRemainingQuantity() as num>
                                    <option value="${num}" <#if num == 1>selected</#if>>${num}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label for="date"><@spring.message "article_borrow_date"/></label>
                            <div class="input-group date" data-provide="datepicker">
                                <input type="text" id="date" required name="toDate" class="form-control">
                                <div class="input-group-addon">
                                    <span class="glyphicon glyphicon-th"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12">
                        <button class="btn btn-block btn-success form-control"><@spring.message "article_borrow_button_title"/></button>
                    </div>
                </form>
            </div>
        </#if>


    </div>
</#if>