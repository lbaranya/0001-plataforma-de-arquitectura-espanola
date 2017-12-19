[#assign listNews = model.getNewsList()]
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
                            		<img src="${imgMediaRendition.getLink()}" alt="Noticia" />
                            	[/#if]
                            [/#if]
                        </div>
                        <div class="noticia">
                            <h4>${model.getHeadline(newNode)!""}</h4>
                            <span>${model.getDate(newNode)!""}</span>
                            <p>${model.getDescription(newNode)!""}</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-12 row-info">
                	[#assign parent = cmsfn.parent(content, "mgnl:page")]
                	[#assign path = cmsfn.link(parent)]
                	[#assign path = path?replace(".html", "")]
                	[#assign hrefLink = "#"]
                	[#assign parameter = "/"]
                	[#assign hrefLink = path+parameter+newNode.UUID]
                    <a href="${hrefLink}"><div><i class="fa fa-file" aria-hidden="true"></i> ${i18n['caar-templating-module.templates.components.news-list-component.information.label']}</div></a>
                </div>
            </div>
        </div>
    </div>
</section>
[/#list]