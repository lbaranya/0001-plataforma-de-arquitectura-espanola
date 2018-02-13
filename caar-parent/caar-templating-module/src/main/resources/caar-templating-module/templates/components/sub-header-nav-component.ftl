[#assign nodeJcrPath = ctx.getParameter('path')!?html]
[#if nodeJcrPath?has_content]
[#assign newsContent = cmsfn.contentByPath(nodeJcrPath, "news")]
[#assign newsContentNode = cmsfn.asJCRNode(newsContent)]
<section class="cmp-detalle-noticia">
    <div class="header-comun">
        <div class="container-margin">
            <div class="row">
                <h3>${content.subHeaderTitle!"Empty header"}</h3>
                [#assign isEmpty = model.paramsEmpty()!""]
                [#if isEmpty?has_content && isEmpty == false]
                <div class="botonera">
                	[#assign path = model.getParentListNewsPath()!""]
                    <a href="${path!"#"}"><i class="fa fa-caret-square-o-left" aria-hidden="true"></i> ${i18n['caar-templating-module.templates.components.sub-header-nav-component.goBack.label']}</a>
                    [#assign listEmpty = model.listEmpty()]
                    [#if listEmpty == false]
	                    [#assign previousNode = model.getPreviousNews(newsContentNode)!""]
	                    <a href="${cmsfn.link("news", previousNode.getIdentifier())!"#"}">${i18n['caar-templating-module.templates.components.sub-header-nav-component.previous.label']}</a>
	                    [#assign nextNode = model.getNextNews(newsContentNode)!""]
	                    <a href="${cmsfn.link("news", nextNode.getIdentifier())!"#"}">${i18n['caar-templating-module.templates.components.sub-header-nav-component.next.label']}</a>
                    [/#if]
                </div>
                [/#if]
            </div>
        </div>
    </div>
</section>
[/#if]