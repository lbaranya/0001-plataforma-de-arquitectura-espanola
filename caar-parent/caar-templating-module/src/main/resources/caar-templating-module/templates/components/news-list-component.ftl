[#assign currentLanguage = cmsfn.language()!""]
[#assign news = model.getInstance()!""]
[#if content.categories?has_content]
	[#assign listNews = model.getCategorizedNewsList(content.categories)]
[#else]
	[#assign listNews = model.getNewsList()]
[/#if]
[#if listNews?has_content]
<section class="cmp-last-news">
        <div class="container">
            <div class="row">
                <!-- <div class="col-md-12 title">
                    <span class="categoria">noticias</span>
                </div> -->
				[#list listNews as newNode]
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="noticias-container">
                        <div class="noticias-item">
                            <div class="container-destacado">
                        	[#assign imgItemKey = news.getImage(newNode)]
                        	[#if imgItemKey??]
                        		[#if imgItemKey?has_content]
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
                            [/#if]
                        	</div>
                        	[#assign headLine = news.getHeadline(newNode, currentLanguage)!""]
                        	[#assign description = news.getDescription(newNode, currentLanguage)!""]
                            <h4 class="title">${headLine!""}</h4>
                            <p>${description!""}</p>
                            <div class="noticias-links">
		                    	<a href='${cmsfn.link(newNode)!"algo"}'><span class="more-link" alt="leer más"> ${i18n['caar-templating-module.templates.components.news-list-component.information.label']}</span></a>
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