[#assign nodeJcrPath = ctx.getParameter('path')!?html]
[#assign nodeWorkspace = ctx.getParameter('workspace')!?html]
[#if nodeJcrPath?has_content]
	[#assign fileContent = cmsfn.contentByPath(nodeJcrPath, nodeWorkspace)!""]
	[#assign fileContentNode = cmsfn.asJCRNode(fileContent)!""]
	[#assign nodes = model.getRelatedElements(fileContentNode)!""]
	[#if nodes?has_content]
	<section class="cmp-arquitectos-realacionados cmp-last-news">
    	<div class="container-margin">
            <div class="row">
                <div class="col-md-12">
                    <h3 class="title">${content.title!""}</h3>
                </div>
            </div>
            <div class="row">
            	[#list nodes as node]
            		[#if node.getNodeType() = "mgnl:news"]
            		
		                <div class="col-md-3 col-sm-6 col-xs-12">
		                    <div class="noticias-container">
		                        <div class="noticias-item">
		                            <div class="container-destacado">
			                        	[#assign imgItemKey = node.getPhoto()]
			                        	[#if imgItemKey??]
			                        		[#if imgItemKey?has_content]
				                        		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "414w")!]
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
		                        	[#assign headLine = node.getTitle()!""]
		                        	[#assign description = node.getDescription()!""]
		                        	[#assign headLineTruncated = cmsfn.abbreviateString(headLine, 80)!""]
		                            <h4 class="title">${headLineTruncated!""}</h4>
		                            <div class="info">
		                            	[#assign descriptionTruncated = cmsfn.abbreviateString(description, 401)!""]
		                            	<p>${descriptionTruncated!""}</p>
		                            </div>
		                            <div class="noticias-links">
				                    	<a href='${node.getPath()!"#"}'><span class="more-link"> ${i18n['caar-templating-module.templates.components.news-list-component.information.label']}</span></a>
					                </div>
			                    </div>
			                </div>
			            </div>
			            
            		[#elseif node.getNodeType() = "mgnl:support-event"]
            		
						<div class="col-md-3 evento-contenedor">
                            <div class="evento-item">
                                [#-- <a href="${cmsfn.link(eventsNode)}" class="evento-link">  --]
                                <a href="${cmsfn.link(navfn.rootPage(content))}" class="evento-link"> 
                                    <div class="evento-header">
                                        <span class="categoria">${node.getEventType()!""}</span>
                                        <span class="evento-fecha">${node.getDayOfWeek()!""}</span>
                                        <span class="evento-fecha">${node.getDate()!""}</span>
                                    </div>
                                    <div class="evento-contenido">
                                       	[#assign imgItemKey = node.getPhoto()!""]
							            	[#if imgItemKey??]
							            		[#if imgItemKey?has_content]
							                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "206x182")!]
								            		[#if imgMediaRendition?has_content]
								            			[#assign imageAlternativeText = "logo de evento"]
								            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
								            			[#if imageAlt?has_content]
								            				[#assign imageAlternativeText = imageAlt.alternative!""]
								            				<img class="img-evento" src="${imgMediaRendition.getLink()}" width="130" height="115" alt="${imageAlternativeText}" />
								            			[/#if]
							                    	[/#if]
						                    	[/#if]
						                    [/#if]
                                        <h4 class="title">${cmsfn.abbreviateString(node.getTitle()!"", 45)!""}</h4>
                                        <p>${cmsfn.abbreviateString(node.getDescription()!"", 183)!""}</p>
                                        <span class="more-link">${i18n['caar-templating-module.templates.components.news-diary-component.read.label']}</span>
                                    </div>
                                </a>
                            </div>
                        </div>
            		
            		[#else]
            		
		                <div class="col-md-3 arquitecto">
		                    <h4>${node.getTitle()!""}</h4>
		                    <div class="container-img">
			                    [#assign imgItemKey = node.getPhoto()!""]
				            	[#if imgItemKey??]
				            		[#if imgItemKey?has_content]
				                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "445h")!]
					            		[#if imgMediaRendition?has_content]
					            			[#assign imageAlternativeText = "ficha de arquitectura"]
					            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
					            			[#if imageAlt?has_content]
					            				[#assign imageAlternativeText = imageAlt.alternative!""]
					            			[/#if]
				                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
				                    	[/#if]
			                    	[/#if]
			                    [/#if]
		                        <div class="texto">
		                            <a style="color:#fff" href="${cmsfn.link(cmsfn.nodeByPath(node.getPath(), node.getWorkspace()))!"#"}"><h2>${node.getTitle()!""}</h2></a>
		                        </div>
		                    </div>
		                </div>
		                
	                [/#if]
                [/#list]
            </div>
        </div>
    </section>
    [/#if]
[/#if]