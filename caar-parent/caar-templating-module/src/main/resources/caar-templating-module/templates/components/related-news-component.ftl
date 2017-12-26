	<section class="cmp-last-news">
        <div class="container">
            <div class="row">
                <div class="col-md-12 title">
                    <span class="categoria">${content.title!""}</span>
                </div>
                
                [#if content.news??]
                	[#assign mapList = cmsfn.children(content.news)]
                	[#if mapList??]
						[#list mapList as noticia]
							[#assign newsNode = cmsfn.contentByPath(noticia.picker, "news")]
			                <div class="col-md-3">
			                    <div class="noticias-container">
			                        <div class="noticias-item">
			                            <h4 class="title">${model.getHeadline(cmsfn.asJCRNode(newsNode))}</h4>
			                            <p>${model.getDescription(cmsfn.asJCRNode(newsNode))}</p>
			                            <div class="noticias-links">
			                                <a href="${cmsfn.link(newsNode)}"><span class="more-link">${i18n['caar-templating-module.templates.components.related-news-component.read.label']}</span></a>
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
	                [/#if]
                [/#if]
            </div>
        </div>
    </section>