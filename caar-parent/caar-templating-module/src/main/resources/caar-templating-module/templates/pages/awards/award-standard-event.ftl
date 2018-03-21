[#assign nodeJcrPath = ctx.getParameter('path')!?html]
[#if nodeJcrPath?has_content]
	[#assign eventsContent = cmsfn.contentByPath(nodeJcrPath, "awards")]
	[#assign eventsContentNode = cmsfn.asJCRNode(eventsContent)]
	[#assign events = model.parent.getInstance()!""]
	[#-- [@cms.component content=content template="submenu-award" /] --]
	[#--  [#include "submenu-award.ftl"]--]
	[#assign awardContentNode = cmsfn.asJCRNode(cmsfn.parent(eventsContent, "mgnl:award"))!""]
	[@cms.area name="breadcrumb" contextAttributes={"contentNode", eventsContentNode}/]
	[@cms.area name="submenu-award" contextAttributes={"currentAward":awardContentNode} /]
	[@cms.area name="subheader" contextAttributes={"nodeName": events.getTitle(eventsContentNode)}/]
	[#list cmsfn.children(eventsContent) as eventItem]
		[#assign eventNode = cmsfn.asJCRNode(eventItem)!""]
		<section class="cmp-programas-marco">
	        <div class="container-margin">
	            <div class="row">
	                <div class="col-md-12 descript">
	                    <h3>${events.getTitle(eventNode)!"error"}</h3>
	                    ${events.getStandardText(eventNode)!"error text"}
	                </div>
	            </div>
	            <div class="row listado-fichas">
		            <section class="cmp-arquitectos-realacionados cmp-last-news">
		            [#assign countRows = 1]
		            [#if events.getFilesList(eventNode)?has_content]
		            [#assign listPaths = events.getFilesList(eventNode)]
		            [#assign listSupport = model.parent.getSupportFiles(listPaths)!""]
		            [#if listSupport?has_content]
					[#list listSupport as item]
						[#if countRows%4 == 1]
						<div class="row">
						[/#if]
							[#assign nodeItem = cmsfn.nodeByPath(item, "architecture-files")!""]
							[#assign relatedElement = model.parent.transform(nodeItem)!""]
							[#assign relatedElementTitle = relatedElement.getTitle()!"hola"]
							
							[#if relatedElement.getNodeType() = "mgnl:support-event"]
							<div class="col-md-3">
								<div class="evento-contenedor">
		                            <div class="evento-item">
		                                [#-- <a href="${cmsfn.link(eventsNode)}" class="evento-link">  --]
		                                <a href="${model.parent.getLink(nodeItem, cmsfn.link(nodeItem))!"#"}" class="evento-link"> 
		                                    <div class="evento-header">
		                                        <span class="categoria">${relatedElement.getEventType()!""}</span>
		                                        <span class="evento-fecha">${relatedElement.getDayOfWeek()!""}</span>
		                                        <span class="evento-fecha">${relatedElement.getDate()!""}</span>
		                                    </div>
		                                    <div class="evento-contenido">
		                                       	[#assign imgItemKey = relatedElement.getPhoto()!""]
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
		                                        <h4 class="title">${cmsfn.abbreviateString(relatedElement.getTitle()!"", 45)!""}</h4>
		                                        <p>${cmsfn.abbreviateString(relatedElement.getDescription()!"", 183)!""}</p>
		                                        <span class="more-link">${i18n['caar-templating-module.templates.components.news-diary-component.read.label']}</span>
		                                    </div>
		                                </a>
		                            </div>
	                            </div>
	                        </div>
	                        	[#if countRows%4 == 0 && events.getFilesList]
								</div>
								[/#if]
	            				[#assign countRows = countRows + 1]
	            			[#elseif relatedElement.getNodeType() == "mgnl:support-architect" || relatedElement.getNodeType() == "mgnl:support-project" || relatedElement.getNodeType() == "mgnl:support-review-i" || relatedElement.getNodeType() == "mgnl:support-review-ii" || relatedElement.getNodeType() == "mgnl:support-review-iii" || relatedElement.getNodeType() == "mgnl:support-review-iv"]
			                <div class="col-md-3">
			                	<div class="arquitecto">
				                    <h4 class="header-div-text">${relatedElement.getTitle()!""}</h4>
				                    <div class="container-img">
					                    [#assign imgItemKey = relatedElement.getPhoto()!""]
						            	[#if imgItemKey??]
						            		[#if imgItemKey?has_content]
						                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "338x502")!]
							            		[#if imgMediaRendition?has_content]
							            			[#assign imageAlternativeText = "ficha de arquitectura"]
							            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
							            			[#if imageAlt?has_content && imageAlt.alternative?has_content]
							            				[#assign imageAlternativeText = imageAlt.alternative!""]
							            			[/#if]
						                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
						                    	[/#if]
					                    	[/#if]
					                    [/#if]
				                        <div class="texto">
				                            <a style="color:#fff" href="${model.parent.getLink(nodeItem, cmsfn.link(nodeItem))!"#"}"><h2>${relatedElement.getTitle()!""}</h2></a>
				                        </div>
				                    </div>
			                    </div>
			                </div>
			                [#if countRows%4 == 0 || countRows == listSupport?size]
							</div>
							[/#if]
			                [#assign countRows = countRows + 1]
			            [#elseif relatedElement.getNodeType() == "mgnl:support-business"]
			            	<div class="col-md-3">
			            		<h4 class="header-div-text">${i18n['caar-templating-module.templates.pages.award-standard-event.business.text']}</h4>
			                    <div class="div-instituciones">
			                        [#assign imgItemKey = relatedElement.getPhoto()!""]
					            	[#if imgItemKey??]
					            		[#if imgItemKey?has_content]
					                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "137x173")!]
						            		[#if imgMediaRendition?has_content]
						            			[#assign imageAlternativeText = "ficha de arquitectura"]
						            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
						            			[#if imageAlt?has_content && imageAlt.alternative?has_content]
						            				[#assign imageAlternativeText = imageAlt.alternative!""]
						            			[/#if]
					                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
					                    	[/#if]
				                    	[/#if]
				                    [/#if]
				                    <div class="info-block">
				                        <h3 class="title">${relatedElement.getTitle()!""}</h3>
				                        <p class="business-type">${cmsfn.contentById(relatedElement.getBusinessType(),"category").displayName!""}</p>
				                        <p class="descript">${relatedElement.getCity()!""}, ${model.parent.getCountryName(catfn.getCategoryNodeByName(relatedElement.getCountry()))!""}</p>
			                        </div>
			                        <div class="more"><span><a href="${model.parent.getLink(nodeItem, cmsfn.link(nodeItem))!"#"}">Ver más</a></span><img src="${ctx.resourcesURL}/icons/interface-1.svg" alt="icon"/></div>
			                    </div>
			                </div>
			                [#if countRows%4 == 0 || countRows == listSupport?size]
							</div>
							[/#if]
			                [#assign countRows = countRows + 1]
			            [#elseif relatedElement.getNodeType() == "mgnl:portfolio"]
			            	<div class="col-md-3">
			            		<h4 class="header-div-text">${i18n['caar-templating-module.templates.pages.award-standard-event.portfolio.text']}</h4>
			                    <div class="div-portafolio">
			                        [#assign imgItemKey = relatedElement.getPhoto()!""]
					            	[#if imgItemKey??]
					            		[#if imgItemKey?has_content]
					                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "338x502")!]
						            		[#if imgMediaRendition?has_content]
						            			[#assign imageAlternativeText = "ficha de arquitectura"]
						            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
						            			[#if imageAlt?has_content && imageAlt.alternative?has_content]
						            				[#assign imageAlternativeText = imageAlt.alternative!""]
						            			[/#if]
					                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
					                    	[/#if]
				                    	[/#if]
				                    [/#if]
			                        <h3 class="title">${relatedElement.getTitle()!""}</h3>
			                        <p class="descript">${relatedElement.getDescription()!""}</p>
			                        <div class="more"><span><a href="${model.parent.getLink(nodeItem, cmsfn.link(nodeItem))!"#"}">Ver más</a></span><img src="${ctx.resourcesURL}/icons/interface.svg" alt="icon"/></div>
			                    </div>
			                </div>
			                [#if countRowsFormat%4 == 0 || countRowsFormat == listSupport?size]
							</div>
							[/#if]
			                [#assign countRowsFormat = countRowsFormat + 1]
		                [/#if]
					[/#list]
					[/#if]
					[/#if]
					<div class="row seperador-black">
		                <hr>
		            </div>
					[#assign countRowsFormat = 1]
					[#if events.getFilesList(eventNode)?has_content]
		            [#assign listPaths = events.getFilesList(eventNode)]
		            [#assign listSupport = model.parent.getFormatFiles(listPaths)!""]
		            [#if listSupport?has_content]
					[#list listSupport as item]
						[#if countRowsFormat%4 == 1]
						<div class="row">
						[/#if]
							[#assign nodeItem = cmsfn.nodeByPath(item, "architecture-files")!""]
							[#assign relatedElement = model.parent.transform(nodeItem)!""]
							[#assign relatedElementTitle = relatedElement.getTitle()!"hola"]
							
			            	[#if relatedElement.getNodeType() == "mgnl:format-audio" || relatedElement.getNodeType() == "mgnl:format-book" || relatedElement.getNodeType() == "mgnl:format-cartographic" || relatedElement.getNodeType() == "mgnl:format-continuous" || relatedElement.getNodeType() == "mgnl:format-electronic" || relatedElement.getNodeType() == "mgnl:format-graphic" || relatedElement.getNodeType() == "mgnl:format-manuscript" || relatedElement.getNodeType() == "mgnl:format-three-dimensional" || relatedElement.getNodeType() == "mgnl:format-video"]
			                <div class="col-md-3">
			                	[#assign header_item_text = ""]
			                	[#if relatedElement.getNodeType() == "mgnl:format-audio"]
			                		[#assign header_item_text = i18n['caar-templating-module.templates.pages.award-standard-event.audio.text']]
			                	[#elseif relatedElement.getNodeType() == "mgnl:format-book"]
			                		[#assign header_item_text = i18n['caar-templating-module.templates.pages.award-standard-event.book.text']]
			                	[#elseif relatedElement.getNodeType() == "mgnl:format-cartographic"]
			                		[#assign header_item_text = i18n['caar-templating-module.templates.pages.award-standard-event.cartographic.text']]
			                	[#elseif relatedElement.getNodeType() == "mgnl:format-continuous"]
			                		[#assign header_item_text = i18n['caar-templating-module.templates.pages.award-standard-event.continuous.text']]
			                	[#elseif relatedElement.getNodeType() == "mgnl:format-electronic"]
			                		[#assign header_item_text = i18n['caar-templating-module.templates.pages.award-standard-event.electronic.text']]
			                	[#elseif relatedElement.getNodeType() == "mgnl:format-graphic"]
			                		[#assign header_item_text = i18n['caar-templating-module.templates.pages.award-standard-event.graphic.text']]
			                	[#elseif relatedElement.getNodeType() == "mgnl:format-manuscript"]
			                		[#assign header_item_text = i18n['caar-templating-module.templates.pages.award-standard-event.manuscript.text']]
			                	[#elseif relatedElement.getNodeType() == "mgnl:format-three-dimensional"]
			                		[#assign header_item_text = i18n['caar-templating-module.templates.pages.award-standard-event.three-dimensional.text']]
			                	[#elseif relatedElement.getNodeType() == "mgnl:format-video"]
			                		[#assign header_item_text = i18n['caar-templating-module.templates.pages.award-standard-event.video.text']]
			                	[/#if]
			                	<h4 class="header-div-text">${header_item_text!""}</h4>
			                    <div class="div-portafolio">
			                        [#assign imgItemKey = relatedElement.getPhoto()!""]
					            	[#if imgItemKey??]
					            		[#if imgItemKey?has_content]
					                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "338x502")!]
						            		[#if imgMediaRendition?has_content]
						            			[#assign imageAlternativeText = "ficha de arquitectura"]
						            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
						            			[#if imageAlt?has_content && imageAlt.alternative?has_content]
						            				[#assign imageAlternativeText = imageAlt.alternative!""]
						            			[/#if]
					                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
					                    	[/#if]
				                    	[/#if]
				                    [/#if]
			                        <h3 class="title">${relatedElement.getTitle()!""}</h3>
			                        <p class="descript">${relatedElement.getSubtitle()!""}</p>
			                        <div class="more"><span><a href="${model.parent.getLink(nodeItem, cmsfn.link(nodeItem))!"#"}">Ver más</a></span><img src="${ctx.resourcesURL}/icons/interface.svg" alt="icon"/></div>
			                    </div>
			                </div>
			                [#if countRowsFormat%4 == 0 || countRowsFormat == listSupport?size]
							</div>
							[/#if]
			                [#assign countRowsFormat = countRowsFormat + 1]
		                [/#if]
					[/#list]
					[/#if]
					[/#if]
					<div class="row seperador-black">
		                <hr>
		            </div>
		            [#assign countRowsNews = 1]
					[#if events.getNewsList(eventNode)?has_content]
		            [#assign listSupport = events.getNewsList(eventNode)]
		            [#if listSupport?has_content]
					[#list listSupport as item]
						[#if countRowsNews%4 == 1]
						<div class="row">
						[/#if]
							[#assign nodeItem = cmsfn.nodeByPath(item, "news")!""]
							[#assign relatedElement = model.parent.transform(nodeItem)!""]
							[#assign relatedElementTitle = relatedElement.getTitle()!"hola"]
							
			            	[#if relatedElement.getNodeType() == "mgnl:news"]
			                <div class="col-md-3 col-sm-6 col-xs-12">
			                <h4 class="header-div-text">${i18n['caar-templating-module.templates.pages.award-standard-event.news.text']}</h4>
		                    <div class="noticias-container">
		                        <div class="noticias-item">
		                            <div class="container-destacado">
			                        	[#assign imgItemKey = relatedElement.getPhoto()]
			                        	[#if imgItemKey??]
			                        		[#if imgItemKey?has_content]
				                        		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "414w")!]
				                        		[#if imgMediaRendition?has_content]
				                        			[#assign imageAlternativeText = "imagen de cabecera de la noticia"]
				                        			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
				                        			[#if imageAlt?has_content && imageAlt.alternative?has_content]
				                        				[#assign imageAlternativeText = imageAlt.alternative!""]
				                        			[/#if]
				                            		<img class="imagen-destacada" src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
				                            	[/#if]
			                            	[/#if]
			                            [/#if]
		                        	</div>
		                        	[#assign headLine = relatedElement.getTitle()!""]
		                        	[#assign description = relatedElement.getDescription()!""]
		                        	[#assign headLineTruncated = cmsfn.abbreviateString(headLine, 80)!""]
		                            <h4 class="title">${headLineTruncated!""}</h4>
		                            <div class="info">
		                            	[#assign descriptionTruncated = cmsfn.abbreviateString(description, 401)!""]
		                            	<p>${descriptionTruncated?replace("<img(.)*>","","r")!""}</p>
		                            </div>
		                            <div class="noticias-links">
				                    	<a href="${cmsfn.link(cmsfn.nodeByPath(relatedElement.getPath(), relatedElement.getWorkspace()))!"#"}"><span class="more-link"> ${i18n['caar-templating-module.templates.components.news-list-component.information.label']}</span></a>
					                </div>
			                    </div>
			                </div>
			            </div>
			                [#if countRowsNews%4 == 0 || countRowsNews == listSupport?size]
							</div>
							[/#if]
			                [#assign countRowsNews = countRowsNews + 1]
		                [/#if]
					[/#list]
					[/#if]
					[/#if]
					</section>
				</div>
		    </div>
    	</section>
	[/#list]
[#else]
	[@cms.area name="breadcrumb" /]
	[@cms.area name="submenu-award" /]
	[@cms.area name="subheader" /]
[/#if]