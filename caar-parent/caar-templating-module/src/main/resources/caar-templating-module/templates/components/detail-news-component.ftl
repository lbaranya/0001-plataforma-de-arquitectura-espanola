
[#assign nodeJcrPath = ctx.getParameter('newsPath')!?html]
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
	            		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "1024")!]
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
                    <h3>${news.getLongTitle(newsContentNode)!""}</h3>
                    <p>${news.getDate(newsContentNode)!""} <span>/ AE</span></p>
                </div>
                <div class="info-noticia">
                    ${news.getLongDescription(newsContentNode)!""}
                </div>
            </div>
        </div>
    </div>
</section>
[/#if]