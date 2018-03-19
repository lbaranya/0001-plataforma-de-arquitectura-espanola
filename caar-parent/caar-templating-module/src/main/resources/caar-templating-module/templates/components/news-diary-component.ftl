<section class="cmp-noticias-eventos">
    <div class="container-margin">
        <div class="row row-noticias">
            <div class="col-md-3 cmp-noticias">
                <!-- Aqui va el componente de NOTICIAS estilo footer-->
                <span class="categoria">${i18n['caar-templating-module.templates.components.news-diary-component.categoryNews.label']}</span>
                <section class="cmp-noticias-footer">
                	[#assign newsInstance = model.getNewsInstance()!""]
					[#assign newsList = model.getImportantNewsList()!""]
					
              		[#list newsList as newsNode]
                    	<div class="row">
                            <div class="col-md-12">
                				<div class="noticias-container">
                                    <div class="noticias-item">
                                        <h4 class="title">${cmsfn.abbreviateString(newsInstance.getHeadline(newsNode),100)}</h4>
                                        <div class="noticias-links">
                                            <a class="more-link" href="${cmsfn.link(newsNode)}">${i18n['caar-templating-module.templates.components.news-diary-component.read.label']}</a>
                                        </div>
                                    </div>
								</div>
                            </div>
	                    </div>
                    [/#list]
                    
                    <div class="ver-todo">
                        <a href="${cmsfn.link(cmsfn.nodeByPath(content.allNewsLink))}" class="ver-todo-link">${i18n['caar-templating-module.templates.components.news-diary-component.allNews.label']}
                            <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
                        </a>
                    </div>
                </section>
            </div>
            <div class="col-md-9 cmp-agenda">
                <!-- Aqui va el componente de EVENTOS estilo footer-->
                <section class="cmp-agenda-footer">
                    <div class="row">
                        <div class="col-md-12">
                            <span class="categoria title">${i18n['caar-templating-module.templates.components.news-diary-component.categoryEvents.label']}</span>
                        </div>
                    </div>
                    <div class="row eventos-row">
                    
                        [#assign eventsInstance = model.getArchitectureFilesSupportEventInstance()!""]
						[#assign eventsList = model.getNewsDiaryArchitectureFilesSupportEventList()!""]
						[#assign counter = 0][#assign eventsToShow = 4]
                    	[#list eventsList as eventsNode]
                    		[#if counter < eventsToShow]
                    			[#assign counter = counter + 1]
	                            <div class="col-md-3 evento-contenedor">
	                                <div class="evento-item">
	                                    <a href="${model.getEventLink(cmsfn.link(eventsNode)!"")!""}" class="evento-link">
	                                        <div class="evento-header">
	                                            <span class="categoria">${eventsInstance.getEventType(eventsNode)!""}</span>
	                                            <span class="evento-fecha">${eventsInstance.getStartDayOfWeek(eventsNode)!""}</span>
	                                            <span class="evento-fecha">${eventsInstance.getPresentationStartDate(eventsNode)!""}</span>
	                                        </div>
	                                        <div class="evento-contenido">
		                                       	[#assign imgItemKey = eventsInstance.getPreviewPhoto(eventsNode)!""]
									            	[#if imgItemKey??]
									            		[#if imgItemKey?has_content]
									                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "206x182")!]
										            		[#if imgMediaRendition?has_content]
										            			[#assign imageAlternativeText = "logo de evento"]
										            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
										            			[#if imageAlt?has_content && imageAlt.alternative?has_content]
										            				[#assign imageAlternativeText = imageAlt.alternative!""]
										            				<img class="img-evento" src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText}" />
										            			[/#if]
									                    	[/#if]
								                    	[/#if]
								                    [/#if]
	                                            <h4 class="title">${cmsfn.abbreviateString(eventsInstance.getOuvreTitle(eventsNode)!"", 45)!""}</h4>
	                                            <p>${cmsfn.abbreviateString(eventsInstance.getOuvreAbstract(eventsNode)!"", 183)!""}</p>
	                                            <span class="more-link">${i18n['caar-templating-module.templates.components.news-diary-component.read.label']}</span>
	                                        </div>
	                                    </a>
	                                </div>
	                            </div>
                            [/#if]
                        
                        [/#list]
                    </div>
                    <div class="ver-todo ver-eventos">
                        <a href="${cmsfn.link(cmsfn.nodeByPath(content.allEventsLink))}" class="ver-todo-link eventos">${i18n['caar-templating-module.templates.components.news-diary-component.allEvents.label']}
                            <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
                        </a>
                    </div>
            	</div>
            </section>
        </div>
    </div>
</section>