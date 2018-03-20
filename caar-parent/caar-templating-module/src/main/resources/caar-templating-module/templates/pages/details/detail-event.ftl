[#assign nodeJcrPath = ctx.getParameter('path')!?html]

[@cms.area name="breadcrumb" /]

[#if nodeJcrPath?has_content]
	[#assign eventContent = cmsfn.contentByPath(nodeJcrPath, "architecture-files")!""]
	[#if eventContent?has_content]
		[#assign eventContentNode = cmsfn.asJCRNode(eventContent)!""]
		[#if eventContentNode?has_content]
			[#assign eventInstance = model.parent.getInstance()!""]
			[#if eventInstance?has_content]
				[#if eventInstance.isEventNodeType(eventContentNode)]
				
					<section class="cmp-detalle-agenda">
				        <div class="container-margin">
				            <div class="row">
				                <div class="col-md-12">
				                    <h1 class="main-title">${i18n['caar-templating-module.templates.components.detail-event-component.title']!""}</h1>
				                </div>
				            </div>
				            <div class="row general-container detalle-container">
				                <div class="agenda-container">
				                    <div class="col-md-9 agenda-evento">
				                        <div class="row">
				                            <div class="col-md-6 agenda-img">
				                                [#assign imgItemKey = eventInstance.getPreviewPhoto(eventContentNode)!""]
								            	[#if imgItemKey??]
								            		[#if imgItemKey?has_content]
								                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "524x661")!]
									            		[#if imgMediaRendition?has_content]
									            			[#assign imageAlternativeText = "imagen de evento"]
									            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
									            			[#if imageAlt?has_content && imageAlt.alternative?has_content]
									            				[#assign imageAlternativeText = imageAlt.alternative!""]
									            			[/#if]
								                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText}" />
								                    	[/#if]
							                    	[/#if]
							                    [/#if]
				                            </div>
				                            <div class="col-md-6 agenda-detalles">
				                                <div class="detalle-info">
				                                    <h2 class="subtitle">${eventInstance.getOuvreTitle(eventContentNode)!""}</h2>
				                                    <div class="info-texto">
				                                    	${eventInstance.getOuvreAbstract(eventContentNode)!""}
				                                    </div>
				                                    <div class="info-conferenciantes">
				                                        <span class="title">${i18n['caar-templating-module.templates.components.detail-event-component.lecturers']!""}</span>
				                                        <div class="info-texto">
				                                        	[#assign lecturerList = eventInstance.getAuthorshipList(eventContentNode)!""]
				                                        	[#list lecturerList as lecturer]
				                                        		<span>${eventInstance.getAuthorshipName(lecturer)!""} (${eventInstance.getAuthorshipType(lecturer)!""}):</span>
				                                        		${eventInstance.getAuthorshipDetail(lecturer)!""}
				                                        	[/#list]
				                                        </div>
				                                    </div>
				                                </div>
				                            </div>
				                        </div>
				
				
				                    </div>
				                    <div class="col-md-3 evento-informacion">
				                        <div class="cuando">
				                            <span class="title">${i18n['caar-templating-module.templates.components.detail-event-component.when']!""}</span>
				                            <h4 class="cuando-fecha">${eventInstance.getStartCompleteDayOfWeek(eventContentNode)!""}
				                                <br>${eventInstance.getPresentationStartDate(eventContentNode)!""}</h4>
				                        </div>
				                        <div class="horario">
				                            <span class="title">${i18n['caar-templating-module.templates.components.detail-event-component.schedule']!""}</span>
				                            <h4 class="horario-hora">${eventInstance.getSchedule(eventContentNode)!""}</h4>
				                        </div>
				                        [#assign precio = eventInstance.getPrice(eventContentNode)!""]
				                        [#if precio?has_content]
					                        <div class="precio">
					                            <span class="title">${i18n['caar-templating-module.templates.components.detail-event-component.price']!""}</span>
					                            <h3 class="precio-cantidad">${eventInstance.getPrice(eventContentNode)!""}</h3>
					                        </div>
				                        [/#if]
				                        <div class="donde">
				                            <span class="title">${i18n['caar-templating-module.templates.components.detail-event-component.where']!""}</span>
				                            <div class="google-map">
				                                [#-- <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3037.684713166875!2d-3.6978028847044513!3d40.415834879365256!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd422883ac7f058b%3A0xa9e74fa3ce52d316!2sUOC+Sede+de+Madrid!5e0!3m2!1ses!2ses!4v1511527443617"
				                                    class="map" width="" height="167" frameborder="0" style="border:0" allowfullscreen></iframe> --]
				                                    <iframe src="https://www.google.com/maps/embed/v1/place?key=AIzaSyC9ERBqe9wg36Be4VbUD0S0ZKrKHJzpKhc
				                                    &q=${eventInstance.getPresentationLocationForMap(eventContentNode)!""}"
				                                    class="map" width="" height="167" frameborder="0" style="border:0" allowfullscreen></iframe>
				                            </div>
				                            <span class="donde-direccion">${eventInstance.getPresentationLocation(eventContentNode)!""}</span>
				                            <a href="${cmsfn.externalLink(eventContentNode,eventInstance.getWebsiteFieldName()!"")!""}" class="donde-link">${eventInstance.getWebsite(eventContentNode)!""}</a>
				
				                        </div>
				                    </div>
				
				                </div>
				                
				            </div>
				        </div>
				    </section>
	    	    [/#if]
			[/#if]
	    [/#if]
	[/#if]
[/#if]