[#assign nodeJcrPath = ctx.getParameter('path')!?html]
[#assign editionPath = ctx.getParameter('edition')!?html]
[#assign announcementPath = ctx.getParameter('announcement')!?html]
[#if nodeJcrPath?has_content && editionPath?has_content && announcementPath?has_content]
	
	[#assign awardsContent = cmsfn.contentByPath(nodeJcrPath, "awards")]
	[#assign awardsContentNode = cmsfn.asJCRNode(awardsContent)]
	[#assign awards = model.parent.getInstance()!""]
	[#assign announcementContent = cmsfn.contentByPath(nodeJcrPath+editionPath+announcementPath, "awards")]
	[#assign announcementContentNode = cmsfn.asJCRNode(announcementContent)!""]
	[#assign announcement = model.parent.getAnnouncementInstance()!""]
	[@cms.area name="breadcrumb" /]
	[#-- [@cms.component content=content template="submenu-award" /] --]
	[#--  [#include "submenu-award.ftl"]--]
	[@cms.area name="submenu-award" contextAttributes={"currentAward":awardsContentNode} /]
	[@cms.area name="subheader" /]
	<div class="container-margin">
		<div class="row">
		<section class="cmp-acerca-de-ae cmp-breadcrumb-info-video">
			[#assign mediaType = announcement.getAnnouncementMediaType(announcementContentNode)!"image"]
			[#assign mediaPosition = announcement.getAnnouncementMediaPosition(announcementContentNode)!"right"]
			[#if mediaType == "image"]
				[#assign imgItemKey = announcement.getAnnouncementMediaImage(announcementContentNode)!""]
			 	[#if imgItemKey??]
			 		[#if imgItemKey?has_content]
				 		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "414w")!]
				 		[#if imgMediaRendition?has_content]
				 			[#assign imageAlternativeText = "imagen de cabecera de la noticia"]
				 			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
				 			[#if imageAlt?has_content]
				 				[#assign imageAlternativeText = imageAlt.alternative!""]
				 			[/#if]
				    	[/#if]
			    	[/#if]
			    [/#if]
		    [/#if]
			[#if content.title?has_content]
			<div class="col-md-12 title">
		        <h3>${announcement.getAnnouncementTitle(announcementContentNode)!""}</h3>
		    </div>
		    [/#if]
		    [#if mediaPosition == "left"]
		    	<div class="col-md-7 video-img-acerca">
			    [#if mediaType == "image"]
			    	[#if imgMediaRendition?has_content]
			    		<img class="imagen-destacada" src='${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}' />
			    	[/#if]
			   	[#else]
						<iframe src="${announcement.getAnnouncementMediaVideo(announcementContentNode)!"#"}" frameborder="0" allowfullscreen></iframe>
			    [/#if]
			    </div>
		    [/#if]
			<div class="col-md-5 info-acerca">
				<p>${announcement.getAnnouncementText(announcementContentNode)!""}</p>
			</div>
			[#if mediaPosition == "right"]
				<div class="col-md-7 video-img-acerca">
			    [#if mediaType == "image"]
			    	[#if imgMediaRendition?has_content]
			    		<img class="imagen-destacada" src='${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}' />
			    	[/#if]
			   	[#else]
						<iframe src="${announcement.getAnnouncementMediaVideo(announcementContentNode)!"#"}" frameborder="0" allowfullscreen></iframe>
			    [/#if]
			    </div>
			[/#if]
		</section>
		</div>
		
		[#-- SECTIONS DISTRIBUTOR --]
		
		[#assign createNode = announcement.createJuryNode(announcementContentNode)!""]
		[#assign contentChildren = cmsfn.children(announcementContentNode)]
		
		[#list contentChildren as child]
			[#assign tmp = model.parent.addToList(child)]
		[/#list]
		
		[#assign sortedList = model.parent.sortWeightArray()!""]
		
		[#assign rowCount = 1]
		
		<section class="cmp-distribuidor-convocatoria">
		    <div>
		[#list sortedList as item]
			[#if rowCount%4 == 1]
		    	<div class="row">
		    [/#if]
		    
			[#assign contentItem = cmsfn.asContentMap(item)]
			
			[#if contentItem.type?has_content]
			
				[#if contentItem.type == "richText"]
					[#assign richTextOptionIdAnchor = model.parent.getAnchorFromString(contentItem.richTextOptionTitle)!""]
					<a href="#${richTextOptionIdAnchor?lower_case!""}" class="col-md-3 anchor-distribuidor">
		                <div class="title">
		                    <p>${contentItem.richTextOptionTitle!""}</p>
		                </div>
		                <div class="img-arquia">
		                	[#assign imgItemKey = contentItem.richTextOptionImageAnchor!]
		                	[#if imgItemKey??]
		                		[#if imgItemKey?has_content]
			                		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "445h")!]
			                		[#if imgMediaRendition?has_content]
			                			[#assign imageAlternativeText = "imagen del ancla"]
			                			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
			                			[#if imageAlt?has_content]
			                				[#assign imageAlternativeText = imageAlt.alternative!""]
			                			[/#if]
			                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
			                    	[/#if]
		                    	[/#if]
		                    [/#if]
		                    <div class="text">
		                        <h2>${contentItem.richTextOptionTitle!""}</h2></div>
		                </div>
		                <div class="new-links">
		                    <span class="more-link" alt="leer más">${i18n['caar-templating-module.templates.components.distributor-sections-rich-text.read.label']!""}</span>
		                </div>
		            </a>
				[/#if]
				
				[#if contentItem.type == "jury"]
					[#assign juryOptionIdAnchor = model.parent.getAnchorFromString(contentItem.juryOptionTitle)!""]
					<a href="#${juryOptionIdAnchor?lower_case!""}" class="col-md-3 anchor-distribuidor">
		                <div class="title">
		                    <p>${contentItem.juryOptionTitle!""}</p>
		                </div>
		                <div class="img-arquia">
		                	[#assign imgItemKey = contentItem.juryOptionImageAnchor!]
		                	[#if imgItemKey??]
		                		[#if imgItemKey?has_content]
			                		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "445h")!]
			                		[#if imgMediaRendition?has_content]
			                			[#assign imageAlternativeText = "imagen del ancla"]
			                			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
			                			[#if imageAlt?has_content]
			                				[#assign imageAlternativeText = imageAlt.alternative!""]
			                			[/#if]
			                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
			                    	[/#if]
		                    	[/#if]
		                    [/#if]
		                    <div class="text">
		                        <h2>${contentItem.juryOptionTitle!""}</h2></div>
		                </div>
		                <div class="new-links">
		                    <span class="more-link">${i18n['caar-templating-module.templates.components.distributor-sections-rich-text.read.label']!""}</span>
		                </div>
		            </a>
				[/#if]
				
				[#if contentItem.type == "lemma"]
					[#assign lemmaOptionIdAnchor = model.parent.getAnchorFromString(contentItem.lemmaOptionTitle)!""]
					<a href="#${lemmaOptionIdAnchor?lower_case!""}" class="col-md-3 anchor-distribuidor">
		                <div class="title">
		                    <p>${contentItem.lemmaOptionTitle!""}</p>
		                </div>
		                <div class="img-arquia">
		                	[#assign imgItemKey = contentItem.lemmaOptionImageAnchor!]
		                	[#if imgItemKey??]
		                		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "445h")!]
		                		[#if imgMediaRendition?has_content]
		                			[#assign imageAlternativeText = "imagen del ancla"]
		                			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
		                			[#if imageAlt?has_content]
		                				[#assign imageAlternativeText = imageAlt.alternative!""]
		                			[/#if]
		                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
		                    	[/#if]
		                    [/#if]
		                    <div class="text">
		                        <h2>${contentItem.lemmaOptionTitle!""}</h2></div>
		                </div>
		                <div class="new-links">
		                    <span class="more-link">${i18n['caar-templating-module.templates.components.distributor-sections-rich-text.read.label']!""}</span>
		                </div>
		            </a>
				[/#if]
				
				[#if contentItem.type == "enrollment"]
					[#assign enrollmentOptionIdAnchor = model.parent.getAnchorFromString(contentItem.enrollmentOptionTitle)!""]
					<a href="#${enrollmentOptionIdAnchor?lower_case!""}" class="col-md-3 anchor-distribuidor">
		                <div class="title">
		                    <p>${contentItem.enrollmentOptionTitle!""}</p>
		                </div>
		                <div class="img-arquia">
		                	[#assign imgItemKey = contentItem.enrollmentOptionImageAnchor!]
		                	[#if imgItemKey??]
		                		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "445h")!]
		                		[#if imgMediaRendition?has_content]
		                			[#assign imageAlternativeText = "imagen del ancla"]
		                			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
		                			[#if imageAlt?has_content]
		                				[#assign imageAlternativeText = imageAlt.alternative!""]
		                			[/#if]
		                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
		                    	[/#if]
		                    [/#if]
		                    <div class="text">
		                        <h2>${contentItem.enrollmentOptionTitle!""}</h2></div>
		                </div>
		                <div class="new-links">
		                    <span class="more-link">${i18n['caar-templating-module.templates.components.distributor-sections-rich-text.read.label']!""}</span>
		                </div>
		            </a>
				[/#if]
				
			[/#if]
			
			[#if rowCount%4 == 0]
		    	</div>
		    [/#if]
		    [#assign rowCount = rowCount + 1]
		[/#list]
			</div>
			<div class="cmp-volver"><i class="fa fa-chevron-circle-up" aria-hidden="true"></i></div>
		</section>
		
		[#list sortedList as item]
		
			[#assign contentItem = cmsfn.asContentMap(item)]
			
			[#if contentItem.type?has_content]
			
				[#if contentItem.type == "richText"]
					[#assign idAnchor = ""]
					[#assign title = ""]
					[#if contentItem.richTextOptionTitle??]
						[#assign title = contentItem.richTextOptionTitle]
						[#assign idAnchor = model.parent.getAnchorFromString(contentItem.richTextOptionTitle)?lower_case!""]
					[/#if]
					[#assign abstract = ""]
					[#if contentItem.richTextOptionAbstract??]
						[#assign abstract = contentItem.richTextOptionAbstract]
					[/#if]
					[#assign richText = ""]
					[#if contentItem.richTextOptionRichText??]
						[#assign richText = cmsfn.decode(contentItem).richTextOptionRichText]
					[/#if]
				<section class="cmp-distribuidor-general-content" id="${idAnchor!""}">
				    <div class="cmp-distruidor-content-title">
				        <div>
				            <div class="row">
				                <div class="col-md-12 content-title">
				                    <h3>${title!""}</h3>
				                </div>
				                <div class="col-md-12 text-contenido">
				                    <p>${abstract!""}</p>
				                </div>
				                <div class="cmp-distruidor-contenido">
						        <div class="container-sub-info">
						            <div class="row">
						                <div class="col-md-12 contenido">
						                	${richText!""}
						                </div>
						           	</div>
						        </div>
				            </div>
				        </div>
				    </div>
				</section>
				[/#if]
				
				[#if contentItem.type == "jury"]
					[#assign idAnchor = ""]
					[#assign title = ""]
					[#if contentItem.juryOptionTitle??]
						[#assign title = contentItem.juryOptionTitle]
						[#assign idAnchor = model.parent.getAnchorFromString(contentItem.juryOptionTitle)?lower_case!""]
					[/#if]
					[#assign abstract = ""]
					[#if contentItem.juryOptionAbstract??]
						[#assign abstract = contentItem.juryOptionAbstract]
					[/#if]
				<section class="cmp-distribuidor-general-content" id="${idAnchor!""}">
				    <div class="cmp-distruidor-content-title">
				        <div>
				            <div class="row">
				                <div class="col-md-12 content-title">
				                    <h3>${title!""}</h3>
				                </div>
				                <div class="col-md-12 text-contenido">
				                    <p>${abstract!""}</p>
				                </div>
				                <div class="cmp-distruidor-contenido">
						        <div class="container-sub-info">
						            <div class="row">
						                <div class="col-md-12 contenido">
						                	[#assign judgeListTmp = model.parent.getJuryList(announcementContentNode)]
						                	[#assign judgeList = cmsfn.asContentMapList(judgeListTmp)]
					                		[#if judgeList?has_content]
					                			[#list judgeList as judge]
					                				<div class="col-jurado">
		            									<div class="img-jurado">
		            										[#assign imgItemKey = judge.judgePhoto!]
											            	[#if imgItemKey??]
											            		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "320w")!]
											            		[#if imgMediaRendition?has_content]
											            			[#assign imageAlternativeText = "imagen del arquitecto jurado"]
											            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
											            			[#if imageAlt?has_content]
											            				[#assign imageAlternativeText = imageAlt.alternative!""]
											            			[/#if]
											                		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
											                	[/#if]
											                [/#if]
		            									</div>
		            									<div class="info-jurado">
		            										<h4>${judge.judgeName!""}</h4>
		            										${cmsfn.decode(judge).judgeText!""}
		            									</div>
		            									[#assign hrefLink = "#"]
										                [#if judge.judgeFileLink??]
											               	[#assign hrefLink = cmsfn.link(cmsfn.contentByPath(judge.judgeFileLink))]
		                									<a href="${hrefLink}" class="ficha-jurado">
											                    <div><i class="fa fa-plus" aria-hidden="true"></i></div>
											                </a>
										                [/#if]
		            								</div>
					                			[/#list]
					                		[/#if]
						                </div>
						           	</div>
						        </div>
				            </div>
				        </div>
				    </div>
				</section>
				[/#if]
				
				[#if contentItem.type == "lemma"]
					[#assign idAnchor = ""]
					[#assign title = ""]
					[#if contentItem.lemmaOptionTitle??]
						[#assign title = contentItem.lemmaOptionTitle]
						[#assign idAnchor = model.parent.getAnchorFromString(contentItem.lemmaOptionTitle)?lower_case!""]
					[/#if]
					[#assign abstract = ""]
					[#if contentItem.lemmaOptionAbstract??]
						[#assign abstract = contentItem.lemmaOptionAbstract]
					[/#if]
					[#assign lemmaFileLink = "#"]
					[#if contentItem.lemmaOptionLink??]
						[#assign lemmaFileLink = contentItem.lemmaOptionLink]
					[/#if]
					[#assign lemmaPhotoPreview = "#"]
					[#if contentItem.lemmaOptionPhotoPreview??]
						[#assign lemmaPhotoPreview = contentItem.lemmaOptionPhotoPreview]
					[/#if]
					[#assign richText = ""]
					[#if contentItem.lemmaOptionRichText??]
						[#assign richText = cmsfn.decode(contentItem).lemmaOptionRichText]
					[/#if]
				<section class="cmp-distribuidor-general-content" id="${idAnchor!""}">
				    <div class="cmp-distruidor-content-title">
				        <div>
				            <div class="row">
				                <div class="col-md-12 content-title">
				                    <h3>${title!""}</h3>
				                </div>
				                <div class="col-md-12 text-contenido">
				                    <p>${abstract!""}</p>
				                </div>
				                <div class="cmp-distruidor-contenido">
						        <div class="container-sub-info">
						            <div class="row">
						                <div class="col-md-12 contenido">
						                	<div class="descript">
						                	<div class="preview">
						                	<div class="col-info-preview">
						                    	<a href="${lemmaFileLink}">
						                    		[#assign imgItemKey = lemmaPhotoPreview!]
						                        	[#if imgItemKey??]
						                        		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "320w")!]
						                        		[#if imgMediaRendition?has_content]
						                        			[#assign imageAlternativeText = "imagen del arquitecto del lema"]
						                        			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
						                        			[#if imageAlt?has_content]
						                        				[#assign imageAlternativeText = imageAlt.alternative!""]
						                        			[/#if]
						                            		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
						                            	[/#if]
						                            [/#if]
						                    	</a>
						                    </div>
						                    </div>
						                    </div>
						                    <div class="info-basica">
						                    	${richText}
						                    </div>
						                </div>
						           	</div>
						        </div>
				            </div>
				        </div>
				    </div>
				</section>
				[/#if]
				
				[#if contentItem.type == "enrollment"]
					[#assign idAnchor = ""]
					[#assign title = ""]
					[#if contentItem.enrollmentOptionTitle??]
						[#assign title = contentItem.enrollmentOptionTitle]
						[#assign idAnchor = model.parent.getAnchorFromString(contentItem.enrollmentOptionTitle)?lower_case!""]
					[/#if]
					[#assign abstract = ""]
					[#if contentItem.enrollmentOptionAbstract??]
						[#assign abstract = contentItem.enrollmentOptionAbstract]
					[/#if]
					[#assign richText = ""]
					[#if contentItem.enrollmentOptionRichText??]
						[#assign richText = cmsfn.decode(contentItem).enrollmentOptionRichText]
					[/#if]
					[#assign buttonLink = "#"]
					[#if contentItem.enrollmentOptionButtonLink??]
						[#assign buttonLink = cmsfn.link(cmsfn.contentByPath(contentItem.enrollmentOptionButtonLink))]
					[/#if]
					[#assign buttonText = ""]
					[#if contentItem.enrollmentOptionButtonText??]
						[#assign buttonText = contentItem.enrollmentOptionButtonText]
					[/#if]
				<section class="cmp-distribuidor-general-content" id="${idAnchor!""}">
				    <div class="cmp-distruidor-content-title">
				        <div>
				            <div class="row">
				                <div class="col-md-12 content-title">
				                    <h3>${title!""}</h3>
				                </div>
				                <div class="col-md-12 text-contenido">
				                    <p>${abstract!""}</p>
				                </div>
				                <div class="cmp-distruidor-contenido">
						        <div class="container-sub-info">
						            <div class="row">
						                <div class="col-md-12 contenido">
						                	<div class="inscripcion">
						                		${richText!""}
									            <a href="${buttonLink}" class="btn">${buttonText!""}</a>
								            </div>
						                </div>
						           	</div>
						        </div>
				            </div>
				        </div>
				    </div>
				</section>
				[/#if]
				
			[/#if]
			
		[/#list]
		
		</div>
	</div>
[#else]
	[@cms.area name="breadcrumb" /]
	[@cms.area name="submenu-award" /]
	[@cms.area name="subheader" /]
[/#if]