[#assign news = model.getInstance()!""]
[#assign nodeJcrPath = ctx.getParameter('awardsPath')!?html]
[#if nodeJcrPath?has_content]
[#assign language = cmsfn.language()!""]
[#assign awardsContent = cmsfn.contentByPath(nodeJcrPath, "awards")]
[#assign awardsContentNode = cmsfn.asJCRNode(awardsContent)]
<section class="cmp-last-news">
    <div class="container">
        <div class="row">
            <div class="col-md-12 title">
                <span class="categoria">${content.title!""}</span>
            </div>
  [#assign relatedNewsNodeList = cmsfn.children(content.newsPicker)!]
  [#if relatedNewsNodeList?has_content]
		[#list relatedNewsNodeList as relatedNewsContent]
			[#assign relatedNewsContentMap = cmsfn.contentByPath(relatedNewsContent.newsPicker, "news")!]
			[#assign relatedNews = cmsfn.asJCRNode(relatedNewsContentMap)!]
               <div class="col-md-3 col-sm-6 col-xs-12">
                   <div class="noticias-container">
                       <div class="noticias-item">
                           <h4 class="title">${news.getHeadline(relatedNews, language)}</h4>
                           <div class="container-destacado">
                           	[#assign imgItemKey = news.getImage(relatedNews)!]
			            	[#if imgItemKey??]
			            		[#if imgItemKey?has_content]
			                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "414")!]
				            		[#if imgMediaRendition?has_content]
				            			[#assign imageAlternativeText = "imagen noticia premio"]
				            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
				            			[#if imageAlt?has_content]
				            				[#assign imageAlternativeText = imageAlt.alternative!""]
				            			[/#if]
			                    		<img class="imagen-destacada" src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText}" />
			                    	[/#if]
		                    	[/#if]
		                    [/#if]
		                    </div>
		                    <p>${news.getDescription(relatedNews, language)!}</p>
                           <div class="noticias-links">
                               <a href="${cmsfn.link(relatedNews)}"><span class="more-link">${i18n['caar-templating-module.templates.components.related-news-component.read.label']}</span></a>
                           </div>
                       </div>
                   </div>
               </div>
        [/#list]
   [/#if]
        </div>
    </div>
</section>
[/#if]