[#assign nodeJcrPath = ctx.getParameter('path')!?html]
[#if nodeJcrPath?has_content]
	[#assign eventsContent = cmsfn.contentByPath(nodeJcrPath, "awards")]
	[#assign eventsContentNode = cmsfn.asJCRNode(eventsContent)]
	[#assign events = model.parent.getInstance()!""]
	[@cms.area name="breadcrumb" /]
	[#-- [@cms.component content=content template="submenu-award" /] --]
	[#--  [#include "submenu-award.ftl"]--]
	[#assign awardContentNode = cmsfn.asJCRNode(cmsfn.parent(eventsContent, "mgnl:award"))!""]
	[@cms.area name="submenu-award" contextAttributes={"currentAward":awardContentNode} /]
	[@cms.area name="subheader" /]
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
		                                <a href="${cmsfn.link(navfn.rootPage(content))}" class="evento-link"> 
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
				                    <h4>${relatedElement.getTitle()!""}</h4>
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
				                            <a style="color:#fff" href="${cmsfn.link(cmsfn.nodeByPath(relatedElement.getPath(), relatedElement.getWorkspace()))!"#"}"><h2>${relatedElement.getTitle()!""}</h2></a>
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
			                        <h3 class="title">${relatedElement.getTitle()!""}</h3>
			                        <p class="descript">${relatedElement.getDescription()!""}</p>
			                        <div class="more"><span>Ver Más</span><img src="${ctx.resourcesURL}/icons/interface-1.svg" alt="icon"/></div>
			                    </div>
			                </div>
			                [#if countRows%4 == 0 || countRows == listSupport?size]
							</div>
							[/#if]
			                [#assign countRows = countRows + 1]
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
			                        <div class="more"><span>Ver Más</span><img src="${ctx.resourcesURL}/icons/interface-1.svg" alt="icon"/></div>
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