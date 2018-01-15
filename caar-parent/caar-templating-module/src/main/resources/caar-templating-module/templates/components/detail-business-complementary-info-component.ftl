[#assign nodeJcrPath = ctx.getParameter('path')!?html]
[#if nodeJcrPath?has_content]
	[#if model.isBusinessNodeType(nodeJcrPath)]
		[#assign businessContent = cmsfn.contentByPath(nodeJcrPath, "architecture-files")]
		[#assign businessContentNode = cmsfn.asJCRNode(businessContent)]
        <section class="cmp-info-complementaria">
	        <div class="container">
	            <div class="row">
	                <div class="col-md-12">
	                    <h3>${i18n['caar-templating-module.templates.components.detail-business-complementary-info-component.title.label']}</h3>
	                    <p class="descript">${model.getAditionalInfo(businessContentNode)!""}</p>
	                </div>
	            </div>
	        </div>
	    </section>
    [/#if]
[/#if]