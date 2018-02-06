[#assign nodeJcrPath = ctx.getParameter('newsPath')!?html]
[#if nodeJcrPath?has_content]
[#assign newsContent = cmsfn.contentByPath(nodeJcrPath, "news")]
[#assign newsContentNode = cmsfn.asJCRNode(newsContent)]
<section class="cmp-detalle-noticia">
    <div class="header-comun">
        <div class="container">
            <div class="row">
                <h3>${content.subHeaderTitle!"Empty header"}</h3>
                <div class="botonera">
                	[#assign path = model.getParentListNewsPath()!""]
                    <a href="${path!"#"}"><i class="fa fa-caret-square-o-left" aria-hidden="true"></i> ${i18n['caar-templating-module.templates.components.sub-header-nav-component.goBack.label']}</a>
                    [#assign nextNode = model.getNextNews(newsContentNode)!""]
                    <a href="${cmsfn.link(nextNode)!"#"}">${i18n['caar-templating-module.templates.components.sub-header-nav-component.previous.label']}</a>
                    [#assign previousNode = model.getPreviousNews(newsContentNode)!""]
                    <a href="${cmsfn.link(previousNode)!"#"}">${i18n['caar-templating-module.templates.components.sub-header-nav-component.next.label']}</a>
                </div>
            </div>
        </div>
    </div>
</section>
[/#if]