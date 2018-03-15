[#assign nodeJcrPath = ctx.getParameter('path')!?html]

[@cms.area name="breadcrumb" /]

[#if nodeJcrPath?has_content]
	[#assign eventInstance = model.parent.getInstance()]
	[#assign eventContent = cmsfn.contentByPath(nodeJcrPath, "architecture-files")] falla aqui
	[#assign eventContentNode = cmsfn.asJCRNode(eventContent)]
	[#if eventInstance.isEventNodeType(eventContentNode)]
	
		<section class="cmp-detalle-agenda">
	        <div class="container-fluid">
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
	                                    <p class="info-texto">
	                                    	${eventInstance.getOuvreAbstract(eventContentNode)!""}
	                                    </p>
	                                    <div class="info-conferenciantes">
	                                        <span class="title">Conferenciantes</span>
	                                        <p class="info-texto">Bertemus, poreciberce cre iam inum confecum Forunius Mae commoverta, quonsultilic
	                                            veres horbissedo, consigilina, quitatiae essestrei pulaFur. Cato ni publin nostrio
	                                            hinatuidii tanum ines pari conlocciis.
	                                        </p>
	                                    </div>
	                                    <div class="info-link">
	                                        <div class="info-link-more">
	                                            <a href="#" class="moreinfo" alt="más información">+ info</a>
	                                        </div>
	                                        <div class="rrss-container">
	                                            <div class="evento-footer-rrss">
	                                                <a href="#" class="rrss-link" alt="">
	                                                    <i class="fa fa-facebook rrss-icon" aria-hidden="true"></i>
	                                                </a>
	                                                <a href="#" class="rrss-link" alt="">
	                                                    <i class="fa fa-twitter rrss-icon" aria-hidden="true"></i>
	                                                </a>
	                                                <a href="#" class="rrss-link" alt="">
	                                                    <i class="fa fa-pinterest rrss-icon" aria-hidden="true"></i>
	                                                </a>
	                                                <a href="#" class="rrss-link" alt="">
	                                                    <i class="fa fa-google-plus rrss-icon" aria-hidden="true"></i>
	                                                </a>
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	
	
	                    </div>
	                    <div class="col-md-3 evento-informacion">
	                        <div class="cuando">
	                            <span class="title">Cuando?</span>
	                            <h4 class="cuando-fecha">MIERCOLES
	                                <br>13.02.2016</h4>
	                        </div>
	                        <div class="horario">
	                            <span class="title">Horario</span>
	                            <h4 class="horario-hora">17h - 21.15h</h4>
	                        </div>
	                        <div class="precio">
	                            <span class="title">Precio</span>
	                            <h3 class="precio-cantidad">20€</h3>
	                        </div>
	                        <div class="donde">
	                            <span class="title">Donde?</span>
	                            <div class="google-map">
	                                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3037.684713166875!2d-3.6978028847044513!3d40.415834879365256!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd422883ac7f058b%3A0xa9e74fa3ce52d316!2sUOC+Sede+de+Madrid!5e0!3m2!1ses!2ses!4v1511527443617"
	                                    class="map" width="" height="167" frameborder="0" style="border:0" allowfullscreen></iframe>
	                            </div>
	                            <span class="donde-direccion">
	                                Camino de Vera s/n</span>
	                            <span class="donde-direccion"> 46p22 Madrid</span>
	                            <a href="#" class="donde-link" alt="">www.uoc.es</a>
	
	                        </div>
	                    </div>
	
	                </div>
	                
	            </div>
	        </div>
	    </section>
	[/#if]
[/#if]