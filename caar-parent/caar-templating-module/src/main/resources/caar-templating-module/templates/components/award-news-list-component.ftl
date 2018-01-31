[#assign nodeJcrPath = ctx.getParameter('path')!?html]
[#if nodeJcrPath?has_content]
	[#assign currentLanguage = cmsfn.language()!""]
	[#assign awardContent = cmsfn.contentByPath(nodeJcrPath, "awards")!""]
	[#assign awardContentNode = cmsfn.asJCRNode(awardContent)!""]
	[#assign awards = model.getAwardsInstance()!""]
	[#assign categoriesList = awards.getCategoriesList(awardContentNode)!""]
	[#assign listNews = model.getCategorizedNewsList(categoriesList)!""]
	[#assign news = model.getNewsInstance()!""]
	<section class="cmp-last-news">
        <div class="container">
            <div class="row">
				[#list listNews as newsNode]
	                <div class="col-md-3 col-sm-6 col-xs-12">
	                    <div class="noticias-container">
	                        <div class="noticias-item">
	                            <div class="container-destacado">
		                        	[#assign imgItemKey = news.getImage(newsNode)]
		                        	[#if imgItemKey??]
		                        		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "414")]
		                        		[#if imgMediaRendition??]
		                        			[#assign imageAlternativeText = "imagen de cabecera de la noticia"]
		                        			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
		                        			[#if imageAlt?has_content]
		                        				[#assign imageAlternativeText = imageAlt.alternative!""]
		                        			[/#if]
		                            		<img class="imagen-destacada" src='${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}' />
		                            	[/#if]
		                            [/#if]
	                        	</div>
	                            <h4 class="title">${news.getHeadline(newsNode, currentLanguage)!""}</h4>
	                            <p>${news.getDescription(newsNode, currentLanguage)!""}</p>
	                            <div class="noticias-links">
			                    	<a href='${cmsfn.link(newsNode)!"#"}'><span class="more-link" alt="leer más"> ${i18n['caar-templating-module.templates.components.news-list-component.information.label']}</span></a>
				                </div>
				                <div class="evento-footer-rrss">
				                    <a href="#" class="rrss-link">
				                        <i class="fa fa-facebook rrss-icon" aria-hidden="true"></i>
				                    </a>
				                    <a href="#" class="rrss-link">
				                        <i class="fa fa-twitter rrss-icon" aria-hidden="true"></i>
				                    </a>
				                    <a href="#" class="rrss-link">
				                        <i class="fa fa-pinterest rrss-icon" aria-hidden="true"></i>
				                    </a>
				                    <a href="#" class="rrss-link">
				                        <i class="fa fa-google-plus rrss-icon" aria-hidden="true"></i>
				                    </a>
				                </div>
		                    </div>
		                </div>
		            </div>
	            [/#list]
	        </div>
	    </div>
	</section>
[/#if]