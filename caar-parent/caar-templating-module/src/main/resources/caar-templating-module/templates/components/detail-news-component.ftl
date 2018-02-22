[#assign nodeJcrPath = ctx.getParameter('path')!?html]
[#if nodeJcrPath?has_content]
[#assign newsContent = cmsfn.contentByPath(nodeJcrPath, "news")]
[#assign newsContentNode = cmsfn.asJCRNode(newsContent)]
[#assign news = model.getInstance()!""]
<section class="cmp-detalle-noticia">
    <div class="row-imagen-video">
        <div class="container">
            <div class="imagen-video">
                [#assign imgItemKey = news.getImage(newsContentNode)]
            	[#if imgItemKey??]
            		[#if imgItemKey?has_content]
	            		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "1024w")!]
	            		[#if imgMediaRendition?has_content]
	            			[#assign imageAlternativeText = "imagen de cabecera de la noticia"]
	            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
	            			[#if imageAlt?has_content]
	            				[#assign imageAlternativeText = imageAlt.alternative!""]
	            			[/#if]
	                		<img src='${imgMediaRendition.getLink()}' alt='${imageAlternativeText!""}' />
	                	[/#if]
                	[/#if]
                [/#if]
            </div>
        </div>
    </div>
    <div class="row-noticia">
        <div class="container">
            <div class="noticia">
                <div class="header">
                    <h3>${news.getHeadline(newsContentNode)!""}</h3>
                    <p>${news.getDate(newsContentNode)!""} <span>/ ${news.getMedium(newsContentNode)!""}</span></p>
                </div>
                <div class="info-noticia">
                    ${news.getDescription(newsContentNode)!""}
                </div>
            </div>
        </div>
    </div>
</section>
[/#if]