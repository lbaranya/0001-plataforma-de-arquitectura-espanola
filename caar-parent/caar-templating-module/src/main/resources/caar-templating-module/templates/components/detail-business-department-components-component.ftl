[#assign nodeJcrPath = ctx.getParameter('path')!?html]
[#if nodeJcrPath?has_content]
	[#if model.isBusinessNodeType(nodeJcrPath)]
		[#assign businessContent = cmsfn.contentByPath(nodeJcrPath, "architecture-files")]
		[#assign businessContentNode = cmsfn.asJCRNode(businessContent)]
        <section class="cmp-despacho">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3>${i18n['caar-templating-module.templates.components.detail-business-department-components-component.title.label']}</h3>
                </div>                                
                [#if model.getDepartmentComponents(businessContentNode)??]
                	[#assign idList = model.getDepartmentComponents(businessContentNode)!""]
                	[#if idList??]
                		[#list idList as id]
                			[#assign component = cmsfn.contentById(id,"architecture-files")!""]
                			[#if component??]
                				[#assign componentNode = cmsfn.asJCRNode(component)!""]
	                			[#if componentNode??]
	                				<div class="col-md-6">
					                    <div class="col-despacho">
					                        <div class="col-md-6 img-despacho">
					                        	[#assign imgItemKey = model.getArchitect().getPhoto(componentNode)!""]
								            	[#if imgItemKey??]
							                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "181x181")]
								            		[#if imgMediaRendition??]
								            			[#assign imageAlternativeText = "arquitecto"]
								            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
								            			[#if imageAlt?has_content]
								            				[#assign imageAlternativeText = imageAlt.alternative!""]
								            			[/#if]
							                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText}" />
							                    	[/#if]
							                    [/#if]
					                        </div>
					                        <div class="col-md-6">
					                            <h4 class="title">
					                            	${model.getArchitect().getName(componentNode)!""}
					                            	${model.getArchitect().getFirstSurname(componentNode)!""}
					                            	${model.getArchitect().getSecondSurname(componentNode)!""}
					                            </h4>
					                            <span class="subtitle">${"subtitle"}</span>
					                            <p>${"description"}</p>
					                            <div class="download">
					                            	[#if component.componentLinkHref??]
					                            		[#if component.componentLinkText??]
					                            			[#assign LinkText = component.componentLinkText]
					                            		[#else]
					                            			[#assign LinkText = component.componentLinkHref]
					                            		[/#if]
					                                	<a href="${component.componentLinkHref}">${LinkText} <i class="fa fa-file" aria-hidden="true"></i></a>
					                                [/#if]
					                            </div>
					                        </div>
					                    </div>
					                </div>
	                			[/#if]
			                [/#if]
		               	[/#list]
	               	[/#if]
               	[/#if] 
            </div>
        </div>
    </section>
    [/#if]
[/#if]