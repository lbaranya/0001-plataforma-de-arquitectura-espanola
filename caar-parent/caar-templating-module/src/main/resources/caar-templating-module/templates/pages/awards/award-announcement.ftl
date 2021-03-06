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
	[@cms.area name="breadcrumb" contextAttributes={"contentNode", announcementContentNode}/]
	[#-- [@cms.component content=content template="submenu-award" /] --]
	[#--  [#include "submenu-award.ftl"]--]
	[@cms.area name="submenu-award" contextAttributes={"currentAward":awardsContentNode} /]
	[@cms.area name="subheader" contextAttributes={"nodeName": announcement.getAnnouncementTitle(announcementContentNode)}/]
	<div class="container-margin">
		<div class="row">
		<section class="cmp-acerca-de-ae cmp-breadcrumb-info-video">
			[#assign mediaType = announcement.getAnnouncementMediaType(announcementContentNode)!"image"]
			[#assign mediaPosition = announcement.getAnnouncementMediaPosition(announcementContentNode)!"right"]
			[#if mediaType == "image"]
				[#assign imgItemKey = announcement.getAnnouncementMediaImage(announcementContentNode)!""]
			 	[#if imgItemKey?has_content]
			 		[#if imgItemKey?has_content]
				 		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "414w")!]
				 		[#if imgMediaRendition?has_content]
				 			[#assign imageAlternativeText = "imagen de cabecera de la noticia"]
				 			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
				 			[#if imageAlt?has_content && imageAlt.alternative?has_content]
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
		    <div class="col-md-12 info-acerca">
		    [#if imgMediaRendition?has_content || announcement.getAnnouncementMediaVideo(announcementContentNode)?has_content]
				<div class="col-md-7 video-img-acerca" style="float:${mediaPosition}; padding-${mediaPosition}:0;">
			    [#if mediaType == "image"]
			    	[#if imgMediaRendition?has_content]
			    		<img class="imagen-destacada" src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
			    	[/#if]
			   	[#else]
						<iframe src="${announcement.getAnnouncementMediaVideo(announcementContentNode)!"#"}" frameborder="0" allowfullscreen></iframe>
			    [/#if]
			    </div>
			[/#if]
				<p>${announcement.getAnnouncementText(announcementContentNode)!""}</p>
			</div>
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
					[#if richTextOptionIdAnchor?has_content]
					<a href="#${richTextOptionIdAnchor?lower_case!""}" class="col-md-3 anchor-distribuidor">
		                <div class="title">
		                    <p>${contentItem.richTextOptionTitle!""}</p>
		                </div>
		                <div class="img-arquia">
		                	[#assign imgItemKey = contentItem.richTextOptionImageAnchor!]
		                	[#if imgItemKey?has_content]
		                		[#if imgItemKey?has_content]
			                		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "556x445")!]
			                		[#if imgMediaRendition?has_content]
			                			[#assign imageAlternativeText = "imagen del ancla"]
			                			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
			                			[#if imageAlt?has_content && imageAlt.alternative?has_content]
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
				[/#if]
				
				[#if contentItem.type == "jury"]
					[#assign juryOptionIdAnchor = model.parent.getAnchorFromString(contentItem.juryOptionTitle)!""]
					[#if juryOptionIdAnchor?has_content]
					<a href="#${juryOptionIdAnchor?lower_case!""}" class="col-md-3 anchor-distribuidor">
		                <div class="title">
		                    <p>${contentItem.juryOptionTitle!""}</p>
		                </div>
		                <div class="img-arquia">
		                	[#assign imgItemKey = contentItem.juryOptionImageAnchor!]
		                	[#if imgItemKey?has_content]
		                		[#if imgItemKey?has_content]
			                		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "556x445")!]
			                		[#if imgMediaRendition?has_content]
			                			[#assign imageAlternativeText = "imagen del ancla"]
			                			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
			                			[#if imageAlt?has_content && imageAlt.alternative?has_content]
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
				[/#if]
				
				[#if contentItem.type == "lemma"]
					[#assign lemmaOptionIdAnchor = model.parent.getAnchorFromString(contentItem.lemmaOptionTitle)!""]
					[#if lemmaOptionIdAnchor?has_content]
					<a href="#${lemmaOptionIdAnchor?lower_case!""}" class="col-md-3 anchor-distribuidor">
		                <div class="title">
		                    <p>${contentItem.lemmaOptionTitle!""}</p>
		                </div>
		                <div class="img-arquia">
		                	[#assign imgItemKey = contentItem.lemmaOptionImageAnchor!]
		                	[#if imgItemKey?has_content]
		                		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "556x445")!]
		                		[#if imgMediaRendition?has_content]
		                			[#assign imageAlternativeText = "imagen del ancla"]
		                			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
		                			[#if imageAlt?has_content && imageAlt.alternative?has_content]
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
				[/#if]
				
				[#if contentItem.type == "enrollment"]
					[#assign enrollmentOptionIdAnchor = model.parent.getAnchorFromString(contentItem.enrollmentOptionTitle)!""]
					[#if enrollmentOptionIdAnchor?has_content]
					<a href="#${enrollmentOptionIdAnchor?lower_case!""}" class="col-md-3 anchor-distribuidor">
		                <div class="title">
		                    <p>${contentItem.enrollmentOptionTitle!""}</p>
		                </div>
		                <div class="img-arquia">
		                	[#assign imgItemKey = contentItem.enrollmentOptionImageAnchor!]
		                	[#if imgItemKey?has_content]
		                		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "556x445")!]
		                		[#if imgMediaRendition?has_content]
		                			[#assign imageAlternativeText = "imagen del ancla"]
		                			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
		                			[#if imageAlt?has_content && imageAlt.alternative?has_content]
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
					[#if contentItem.richTextOptionTitle?has_content]
						[#assign title = contentItem.richTextOptionTitle]
						[#assign idAnchor = model.parent.getAnchorFromString(contentItem.richTextOptionTitle)?lower_case!""]
					[/#if]
					[#assign richText = ""]
					[#if contentItem.richTextOptionRichText?has_content]
						[#assign richText = cmsfn.decode(contentItem).richTextOptionRichText]
					[/#if]
				<section class="cmp-distribuidor-general-content" id="${idAnchor!""}">
				    <div class="cmp-distruidor-content-title">
				        <div>
				            <div class="row">
				                <div class="col-md-12 content-title">
				                    <h4>${title!""}</h4>
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
					[#if contentItem.juryOptionTitle?has_content]
						[#assign title = contentItem.juryOptionTitle]
						[#assign idAnchor = model.parent.getAnchorFromString(contentItem.juryOptionTitle)?lower_case!""]
					[/#if]
					[#assign abstract = ""]
					[#if contentItem.juryOptionAbstract?has_content]
						[#assign abstract = contentItem.juryOptionAbstract]
					[/#if]
				<section class="cmp-distribuidor-general-content" id="${idAnchor!""}">
				    <div class="cmp-distruidor-content-title">
				        <div>
				            <div class="row">
				                <div class="col-md-12 content-title">
				                    <h4>${title!""}</h4>
				                </div>
				                <div class="col-md-12 text-contenido">
				                    <p class="ckeditor text-contenido">${abstract!""}</p>
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
											            	[#if imgItemKey?has_content]
											            		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "320x320")!]
											            		[#if imgMediaRendition?has_content]
											            			[#assign imageAlternativeText = "imagen del arquitecto jurado"]
											            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
											            			[#if imageAlt?has_content && imageAlt.alternative?has_content]
											            				[#assign imageAlternativeText = imageAlt.alternative!""]
											            			[/#if]
											                		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
											                	[/#if]
											                [/#if]
		            									</div>
		            									<div class="info-jurado">
		            										<h4>${judge.judgeName!""}</h4>
		            										${cmsfn.abbreviateString(cmsfn.decode(judge).judgeText,450)!""}
		            									</div>
		            									[#assign hrefLink = "#"]
		            									[#assign judgeFileNode = ""]
										                [#if judge.judgeFileLink?has_content]
										                	[#assign checkContent = cmsfn.contentByPath(judge.judgeFileLink, "architecture-files")!""]
	        												[#if checkContent?has_content]
	        													[#assign judgeFileNode = cmsfn.nodeByPath(judge.judgeFileLink, "architecture-files")!""]
	        													[#if judgeFileNode?has_content]
											               			[#assign hrefLink = cmsfn.link(judgeFileNode)!"#"]
											               		[/#if]
											               	[/#if]
											               	<a href="${model.parent.getLink(judgeFileNode,hrefLink)!"#"}" class="ficha-jurado">
											                   <div style="margin-right:45px;"><i class="fa fa-plus" aria-hidden="true"></i></div>
											                </a>
										                [/#if]
										                [#assign hrefLink = "#"]
										                [#if judge.judgeCV?has_content]
										                	[#assign checkContent = damfn.getAsset(judge.judgeCV)!""]
	        												[#if checkContent?has_content]
											               		[#assign hrefLink = damfn.getAssetLink(judge.judgeCV)!"#"]
											               	[/#if]
											               	<a href="${hrefLink}" class="ficha-jurado">
											               	    <div><i class="fa fa-file-o" aria-hidden="true"></i></div>
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
					[#if contentItem.lemmaOptionTitle?has_content]
						[#assign title = contentItem.lemmaOptionTitle]
						[#assign idAnchor = model.parent.getAnchorFromString(contentItem.lemmaOptionTitle)?lower_case!""]
					[/#if]
					[#assign lemmaFileLink = "#"]
					[#assign lemmaFileNode = ""]
					[#if contentItem.lemmaOptionLink?has_content]
						[#assign lemmaFileLink = contentItem.lemmaOptionLink]
						[#if lemmaFileLink?has_content]
							[#assign lemmaFileNode = cmsfn.nodeByPath(lemmaFileLink, "architecture-files")!""]
						[/#if]
					[/#if]
					[#assign lemmaPhotoPreview = "#"]
					[#if contentItem.lemmaOptionPhotoPreview?has_content]
						[#assign lemmaPhotoPreview = contentItem.lemmaOptionPhotoPreview]
					[/#if]
					[#assign richText = ""]
					[#if contentItem.lemmaOptionRichText?has_content]
						[#assign richText = cmsfn.decode(contentItem).lemmaOptionRichText]
					[/#if]
					[#assign lemmaFileDownloadLink = "#"]
					[#if contentItem.lemmaOptionFileLink?has_content]
						[#assign lemmaFileDownloadLink = contentItem.lemmaOptionFileLink]
					[/#if]
				<section class="cmp-distribuidor-general-content" id="${idAnchor!""}">
				    <div class="cmp-distruidor-content-title">
				        <div>
				            <div class="row">
				                <div class="col-md-12 content-title">
				                    <h4>${title!""}</h4>
				                </div>
				                <div class="cmp-distruidor-contenido">
						        <div class="container-sub-info">
						            <div class="row">
						                <div class="col-md-12 contenido">
						                <div class="preview">
						                	<div class="descript">
						                	<div class="col-info-preview">
						                		[#assign hrefLemma = cmsfn.link(lemmaFileNode)!"#"]
						                    	<a href="${model.parent.getLink(lemmaFileNode,hrefLemma)!"#"}">
						                    		[#assign imgItemKey = lemmaPhotoPreview!]
						                        	[#if imgItemKey?has_content]
						                        		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "320w")!]
						                        		[#if imgMediaRendition?has_content]
						                        			[#assign imageAlternativeText = "imagen del arquitecto del lema"]
						                        			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
						                        			[#if imageAlt?has_content && imageAlt.alternative?has_content]
						                        				[#assign imageAlternativeText = imageAlt.alternative!""]
						                        			[/#if]
						                            		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
						                            	[/#if]
						                            [/#if]
						                    	</a>
						                    </div>
						                    [#if contentItem.lemmaOptionFileLink?has_content]
						                    	<a class=" " href="${damfn.getAssetLink(lemmaFileDownloadLink)!"#"}">${contentItem.lemmaOptionFileLinkName!i18n['caar-templating-module.templates.pages.award-announcement.downloadPDF.text']} <i class="fa fa-file" aria-hidden="true"></i></a>
						                    [/#if]
						                    <div class="info-basica">
						                    	${richText}
						                    </div>
						                  </div>
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
					[#if contentItem.enrollmentOptionTitle?has_content]
						[#assign title = contentItem.enrollmentOptionTitle]
						[#assign idAnchor = model.parent.getAnchorFromString(contentItem.enrollmentOptionTitle)?lower_case!""]
					[/#if]
					[#assign richText = ""]
					[#if contentItem.enrollmentOptionRichText?has_content]
						[#assign richText = cmsfn.decode(contentItem).enrollmentOptionRichText]
					[/#if]
					[#assign buttonLink = "#"]
					[#if contentItem.enrollmentOptionButtonLink?has_content]
						[#if contentItem.enrollmentOptionButtonLink == "internalLink"]
                        	[#if contentItem.enrollmentOptionButtonLinkinternalLink?has_content]
                        		[#assign checkContent = cmsfn.contentByPath(contentItem.enrollmentOptionButtonLinkinternalLink)!""]
	        					[#if checkContent?has_content]
                        			[#assign buttonLink = cmsfn.link(cmsfn.contentByPath(contentItem.enrollmentOptionButtonLinkinternalLink))]
                        		[/#if]
                        	[/#if]
                      	[#else]
                      		[#if contentItem.enrollmentOptionButtonLinkexternalLink?has_content]
                        		[#assign buttonLink = cmsfn.externalLink(contentItem, "enrollmentOptionButtonLinkexternalLink")]
                        	[/#if]
                    	[/#if]
					[/#if]
					[#assign buttonText = ""]
					[#if contentItem.enrollmentOptionButtonText?has_content]
						[#assign buttonText = contentItem.enrollmentOptionButtonText]
					[/#if]
				<section class="cmp-distribuidor-general-content" id="${idAnchor!""}">
				    <div class="cmp-distruidor-content-title">
				        <div>
				            <div class="row">
				                <div class="col-md-12 content-title">
				                    <h4>${title!""}</h4>
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