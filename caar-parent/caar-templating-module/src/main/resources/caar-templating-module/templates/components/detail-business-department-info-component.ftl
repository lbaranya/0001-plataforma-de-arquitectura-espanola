[#assign nodeJcrPath = ctx.getParameter('path')!?html]
[#if nodeJcrPath?has_content]
	[#if model.isBusinessNodeType(nodeJcrPath)]
		[#assign businessContent = cmsfn.contentByPath(nodeJcrPath, "architecture-files")]
		[#assign businessContentNode = cmsfn.asJCRNode(businessContent)]
		<section class="cmp-empresa-detalle cmp-empresa-info-despacho">
	        <div class="container">
	            <div class="row">
	                <div class="col-md-12">
	                    <h3>${i18n['caar-templating-module.templates.components.detail-business-department-info-component.title.label']}</h3>
	                </div>
	                <div class="col-md-12">
	                    <span>${model.getLegalName(businessContentNode)!""}</span>
	                    <p>¿Dirección?</p>
	                </div>
	                <div class="col-md-5 map">
	                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d5424.248872088719!2d-3.592506377087934!3d37.1755847233593!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd71fce62d32c27d%3A0x9258f79dd3600d72!2sGranada!5e0!3m2!1ses!2ses!4v1513698690787" frameborder="0" style="border:0" allowfullscreen></iframe>
	                </div>
	                <div class="col-md-7 descript-emp">
	                    <div class="info">
	                        [#if content.email??]<div><i class="fa fa-envelope-o" aria-hidden="true"></i> <a href="${content.email!""}">${content.email!""}</a></div>[/#if]
	                        [#if content.phone??]<div><i class="fa fa-mobile" aria-hidden="true"></i> ${content.phone!""}</div>[/#if]
	                        [#if model.getDepartmentWebSite(businessContentNode)??]<div><i class="fa fa-link" aria-hidden="true"></i> <a href="${cmsfn.externalLink(businessContentNode, model.getDepartmentWebSiteFieldName())}">${model.getDepartmentWebSite(businessContentNode)!""}</a></div>[/#if]
	                    </div>
	                    <p>¿?</p>
	                </div>
	            </div>
	        </div>
	    </section>
    [/#if]
[/#if]