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
				[#list events.getFilesList(eventNode) as item]
					[#if countRows%4 == 1]
					<div class="row">
					[/#if]
						[#assign nodeItem = cmsfn.nodeByPath(item, "architecture-files")!""]
						[#assign relatedElement = model.parent.transform(nodeItem)!""]
						[#assign relatedElementTitle = relatedElement.getTitle()!"hola"]
						
						[#if relatedElement.getNodeType() = "mgnl:support-event"]
            		
						<div class="col-md-3 evento-contenedor">
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
								            				<img class="img-evento" src="${imgMediaRendition.getLink()}" width="130" height="115" alt="${imageAlternativeText}" />
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
            		
            			[#elseif relatedElement.getNodeType() == "mgnl:support-architect" || relatedElement.getNodeType() == "mgnl:support-project"]
            		
		                <div class="col-md-3 arquitecto">
		                    <h4>${relatedElement.getTitle()!""}</h4>
		                    <div class="container-img">
			                    [#assign imgItemKey = relatedElement.getPhoto()!""]
				            	[#if imgItemKey??]
				            		[#if imgItemKey?has_content]
				                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "445h")!]
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
		                
	                [/#if]
					[#if countRows%4 == 0]
					</div>
					[/#if]
				[/#list]
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