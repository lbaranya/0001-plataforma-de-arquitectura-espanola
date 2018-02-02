[#assign nodeJcrPath = ctx.getParameter('awardsPath')!?html]
[#if nodeJcrPath?has_content]
	[#assign currentLanguage = cmsfn.language()!""]
	[#assign awardContent = cmsfn.contentByPath(nodeJcrPath, "awards")!""]
	[#assign awardsContentNode = cmsfn.asJCRNode(awardContent)!""]
	[#assign awards = model.parent.getAwardInstance()!""]
	[#assign categoriesList = awards.getAwardCategoriesList(awardsContentNode)!""]
	[#assign listNews = model.parent.getCategorizedNewsList(categoriesList)!""]
	[#assign news = model.parent.getNewsInstance()!""]
	[@cms.area name="content" contextAttributes={"awardHomeName" : awards.getAwardName(awardsContentNode, currentLanguage)}/]
	[@cms.area name="submenu-award" contextAttributes={"currentAward":awardsContentNode} /]
	[@cms.area name="subheader" /]
	<section class="cmp-last-news">
        <div class="container">
	        <div class="row">
				[#list listNews as newsNode]
	                <div class="col-md-3 col-sm-6 col-xs-12">
	                    <div class="noticias-container">
	                        <div class="noticias-item">
	                            <div class="container-destacado">
		                         [#assign imgItemKey = news.getImage(newsNode)!]
		                         	[#if imgItemKey??]
			                        	[#if imgItemKey?has_content]
			                        		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "414")!]
			                        		[#if imgMediaRendition?has_content]
			                        			[#assign imageAlternativeText = "imagen de cabecera de la noticia"]
			                        			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
			                        			[#if imageAlt?has_content]
			                        				[#assign imageAlternativeText = imageAlt.alternative!""]
			                        			[/#if]
			                            		<img class="imagen-destacada" src='${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}' />
			                            	[/#if]
			                            [/#if]
		                            [/#if]
	                        	</div>
	                            <h4 class="title">${news.getHeadline(newsNode, currentLanguage)!""}</h4>
	                            <p>${news.getDescription(newsNode, currentLanguage)!""}</p>
	                            <div class="noticias-links">
			                    	<a href='${cmsfn.link(newsNode)!"#"}'><span class="more-link"> ${i18n['caar-templating-module.templates.components.news-list-component.information.label']}</span></a>
				                </div>
		                    </div>
		                </div>
			        </div>
		        [/#list]
            </div>
	    </div>
	</section>
[#else]
	[@cms.area name="content" /]
	[@cms.area name="submenu-award" /]
	[@cms.area name="subheader" /]
[/#if]