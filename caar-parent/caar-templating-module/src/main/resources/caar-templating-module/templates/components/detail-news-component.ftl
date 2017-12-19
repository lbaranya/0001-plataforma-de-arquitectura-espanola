[#assign nodeJcrId = ctx.getParameter('newsId')!?html]
[#if nodeJcrId?has_content]
[#assign newsContent = cmsfn.contentById(nodeJcrId, "news")]
[#assign newsContentNode = cmsfn.asJCRNode(newsContent)]
<section class="cmp-detalle-noticia">
    <div class="row-imagen-video">
        <div class="container">
            <div class="imagen-video">
                [#assign imgItemKey = model.getImage(newsContentNode)]
            	[#if imgItemKey??]
            		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "1024")]
            		[#if imgMediaRendition??]
                		<img src="${imgMediaRendition.getLink()}" alt="${imgMediaRendition.getAsset().getFileName()}" />
                	[/#if]
                [/#if]
            </div>
        </div>
    </div>
    <div class="row-noticia">
        <div class="container">
            <div class="noticia">
                <div class="header">
                    <h3>${model.getLongTitle(newsContentNode)!""}</h3>
                    <p>${model.getDate(newsContentNode)!""} <span>/ AE</span></p>
                </div>
                <div class="info-noticia">
                    ${model.getLongDescription(newsContentNode)!""}
                </div>
            </div>
        </div>
    </div>
</section>
[/#if]