<div class="container">
<#if error_message?? >
    <br />
    <div class="row">
        <div class="col-xs-12">
            <div class="alert alert-danger">
            ${error_message}
            </div>
        </div>
    </div>
</#if>
    <div class="row">
        <div class="col-xs-12">
            <form method="post" role="form" enctype="multipart/form-data">
            <#--<legend><@spring.message "user_register_title" /></legend>-->
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <br>
                <div class="col-xs-12">
                    <div class="form-group">
                        <label for="name"><@spring.message "article_form_name_msg" /></label>
                        <@spring.bind 'newArticle.name'/>
                        <input required type="text" class="form-control" name="${spring.status.expression}"
                               value="${spring.status.value!''?html}" id="name" placeholder="">
                    <#list spring.status.errorMessages as error>
                        <span class="text-danger">${error}</span>
                    </#list>
                    </div>
                </div>
                <div class="col-xs-6">
                    <div class="form-group">
                        <label for="quantity"><@spring.message "article_form_quantity_msg" /></label>
                        <@spring.bind 'newArticle.quantity'/>
                        <input required type="number" class="form-control" name="${spring.status.expression}"
                               value="${spring.status.value!''?html}" id="quantity" placeholder="">
                    <#list spring.status.errorMessages as error>
                        <span class="text-danger">${error}</span>
                    </#list>
                    </div>
                </div>
                <div class="col-xs-6">
                    <div class="form-group">
                        <label for="cost"><@spring.message "article_form_cost_msg" /></label>
                        <div class="input-group">
                            <div class="input-group-addon">$</div>
                            <@spring.bind 'newArticle.cost'/>
                            <input required type="number" class="form-control" name="${spring.status.expression}"
                                   value="${spring.status.value!''?html}" id="cost" placeholder=""/>
                        </div>
                    <#list spring.status.errorMessages as error>
                        <span class="text-danger">${error}</span>
                    </#list>
                    </div>
                </div>
                <div class="col-xs-12">
                    <div class="form-group">
                        <label for="family"><@spring.message "article_form_family_msg" /></label>
                        <select class="form-control" name="fam_id" id="family" required>
                            <option id="family-placeholder" disabled selected><@spring.message "article_form_family_placeholder"></@spring.message></option>
                            <#list families as fam>
                                <option value="${fam.getId()}">${fam.getName()}</option>
                            </#list>
                        </select>
                    <#list spring.status.errorMessages as error>
                        <span class="text-danger">${error}</span>
                    </#list>
                    </div>
                </div>
                <div class="col-xs-12">
                    <div class="form-group">
                        <label for="subfamily"><@spring.message "article_form_subfam_msg" /></label>
                        <select class="form-control" name="subfam_id" id="subfamilies" required>
                            <option disabled selected><@spring.message "article_form_subfam_placeholder"></@spring.message></option>
                        </select>
                    <#list spring.status.errorMessages as error>
                        <span class="text-danger">${error}</span>
                    </#list>
                    </div>
                </div>
                <div class="col-xs-12">
                    <div class="form-group">
                        <label for="description"><@spring.message "article_form_description_msg" /></label>
                        <@spring.bind 'newArticle.description'/>
                        <textarea class="form-control" name="${spring.status.expression}"
                                  id="description" placeholder="">${spring.status.value!''?html}</textarea>
                    </div>
                </div>
                <div class="col-xs-12">
                    <div class="form-group">
                        <label for="picture"><@spring.message "article_form_image_msg" /></label>
                        <input required type="file" accept="image/png" class="form-control" name="profile_pic"
                               id="picture" placeholder="">
                    </div>
                </div>
                <button type="submit" class="btn btn-info btn-block"><@spring.message "article_form_add_msg" /></button>
            </form>
        </div>
    </div>
</div>
