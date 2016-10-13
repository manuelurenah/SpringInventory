<#if toReturn?? && toReturn?size != 0>
<div class="container">
    <div class="row">
        <h3><@spring.message "invoice_title"></@spring.message></h3>
        <form action="/invoice/return" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <table class="table table-responsive table-hover table-middle">
                <thead>
                <th><@spring.message "articles_msg"></@spring.message></th>
                <th><@spring.message "cost_per_day"></@spring.message></th>
                <th><@spring.message "borrowed_quantity_to_return"></@spring.message></th>
                <th>Total</th>
                </thead>
                <tbody>
                    <#list toReturn as tr>
                        <#assign article = tr.getArticle()/>
                    <input type="hidden" value="${tr.getId()}" name="borrows[]">
                    <tr class="calculated-total">
                        <td>
                            <h4>${article.getName()} <br>
                            <small><@spring.message "borrowed_at"></@spring.message>: ${tr.getTakenOn()}</small></h4>
                        </td>
                        <td class="cost-here">${article.getCost()}</td>
                        <td class="quantity-here"><select name="quantities[]" class="form-control" required>

                            <#list 0..tr.getQuantity() as num>
                                <option value="${num}" <#if num == 0>selected</#if>>${num}</option>
                            </#list>
                        </select></td>
                        <td class="total-here">TODO</td>
                    </tr>
                    </#list>
                </tbody>
            </table>

            <br>

            <div class="col-xs-12">
                <button class="btn btn-block btn-success"><@spring.message "generate_invoice"></@spring.message></button>
            </div>

        </form>
    </div>
</div>
<#else>
<div class="container">
    <div class="row">
        <div class="col-xs-12">
            <p><@spring.message "nothing_to_return"></@spring.message></p>
            <p><a href="/articles/list" class="btn btn-primary"><@spring.message "articles_msg"></@spring.message></a></p>
        </div>
    </div>
</div>
</#if>