[#assign businessModel = ctx.businessModel!""]
[#assign businessContentNode = ctx.businessContentNode!""]
<section class="cmp-info-complementaria">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h3>${i18n['caar-templating-module.templates.components.detail-business-complementary-info-component.title.label']}</h3>
                <p class="descript">${businessModel.getAditionalInfo(businessContentNode)!""}</p>
            </div>
        </div>
    </div>
</section>
