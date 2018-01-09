[#assign currentLanguage = cmsfn.language()!""]
[#assign listNews = model.getNewsList()]
[#if listNews?has_content]
[#list listNews as newNode]
<section class="cmp-noticias">
	<div class="noticia-destacada">
        <div class="row-new">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 imagen-destacada-new">
                        <div>
                        	[#assign imgItemKey = model.getImage(newNode)]
                        	[#if imgItemKey??]
                        		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "414")]
                        		[#if imgMediaRendition??]
                        			[#assign imageAlternativeText = "imagen de cabecera de la noticia"]
                        			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
                        			[#if imageAlt?has_content]
                        				[#assign imageAlternativeText = imageAlt.alternative!""]
                        			[/#if]
                            		<img src='${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}' />
                            	[/#if]
                            [/#if]
                        </div>
                        <div class="noticia">
                        [#assign headLine = model.getHeadline(newNode, currentLanguage)!""]
                        [#assign date = model.getDate(newNode)!""]
                        [#assign description = model.getDescription(newNode, currentLanguage)!""]
                            <h4>${headLine!""}</h4>
                            <span>${date!""}</span>
                            <p>${description!""}</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-12 row-info">
                    <a href='${cmsfn.link(newNode)!"algo"}'><div><i class="fa fa-file" aria-hidden="true"></i> ${i18n['caar-templating-module.templates.components.news-list-component.information.label']}</div></a>
                </div>
            </div>
        </div>
    </div>
</section>
[/#list]
[/#if]