[#assign contentChildren = cmsfn.children(content)]

[#list contentChildren as child]
	[#assign tmp = model.addToList(cmsfn.asJCRNode(child))]
[/#list]

[#assign sortedList = model.sortWeightArray()!""]

[#assign rowCount = 1]

<section class="cmp-distribuidor-convocatoria">
    <div class="container-fluid">
[#list sortedList as item]
	[#if rowCount%4 == 1]
    	<div class="row">
    [/#if]
    
	[#assign contentItem = cmsfn.asContentMap(item)]
	
	[#if contentItem.type?has_content]
	
		[#if contentItem.type == "richText"]
			<a href="#${contentItem.richTextOptionIdAnchor!""}" class="col-md-3 anchor-distribuidor">
                <div class="title">
                    <p>${contentItem.richTextOptionTitle!""}</p>
                </div>
                <div class="img-arquia">
                	[#assign imgItemKey = contentItem.richTextOptionImageAnchor!]
                	[#if imgItemKey??]
                		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "320")]
                		[#if imgMediaRendition??]
                			[#assign imageAlternativeText = "imagen del ancla"]
                			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
                			[#if imageAlt?has_content]
                				[#assign imageAlternativeText = imageAlt.alternative!""]
                			[/#if]
                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
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
			<a href="#${contentItem.juryOptionIdAnchor!""}" class="col-md-3 anchor-distribuidor">
                <div class="title">
                    <p>${contentItem.juryOptionTitle!""}</p>
                </div>
                <div class="img-arquia">
                	[#assign imgItemKey = contentItem.juryOptionImageAnchor!]
                	[#if imgItemKey??]
                		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "320")]
                		[#if imgMediaRendition??]
                			[#assign imageAlternativeText = "imagen del ancla"]
                			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
                			[#if imageAlt?has_content]
                				[#assign imageAlternativeText = imageAlt.alternative!""]
                			[/#if]
                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
                    	[/#if]
                    [/#if]
                    <div class="text">
                        <h2>${contentItem.juryOptionTitle!""}</h2></div>
                </div>
                <div class="new-links">
                    <span class="more-link" alt="leer más">${i18n['caar-templating-module.templates.components.distributor-sections-rich-text.read.label']!""}</span>
                </div>
            </a>
		[/#if]
		
		[#if contentItem.type == "lemma"]
			<a href="#${contentItem.lemmaOptionIdAnchor!""}" class="col-md-3 anchor-distribuidor">
                <div class="title">
                    <p>${contentItem.lemmaOptionTitle!""}</p>
                </div>
                <div class="img-arquia">
                	[#assign imgItemKey = contentItem.lemmaOptionImageAnchor!]
                	[#if imgItemKey??]
                		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "320")]
                		[#if imgMediaRendition??]
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
                    <span class="more-link" alt="leer más">${i18n['caar-templating-module.templates.components.distributor-sections-rich-text.read.label']!""}</span>
                </div>
            </a>
		[/#if]
		
		[#if contentItem.type == "enrollment"]
			<a href="#${contentItem.enrollmentOptionIdAnchor!""}" class="col-md-3 anchor-distribuidor">
                <div class="title">
                    <p>${contentItem.enrollmentOptionTitle!""}</p>
                </div>
                <div class="img-arquia">
                	[#assign imgItemKey = contentItem.enrollmentOptionImageAnchor!]
                	[#if imgItemKey??]
                		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "320")]
                		[#if imgMediaRendition??]
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
                    <span class="more-link" alt="leer más">${i18n['caar-templating-module.templates.components.distributor-sections-rich-text.read.label']!""}</span>
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
			[#if contentItem.richTextOptionIdAnchor??]
				[#assign idAnchor = contentItem.richTextOptionIdAnchor]
			[/#if]
			[#assign title = ""]
			[#if contentItem.richTextOptionTitle??]
				[#assign title = contentItem.richTextOptionTitle]
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
		        <div class="container-fluid">
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
			[#if contentItem.juryOptionIdAnchor??]
				[#assign idAnchor = contentItem.juryOptionIdAnchor]
			[/#if]
			[#assign title = ""]
			[#if contentItem.juryOptionTitle??]
				[#assign title = contentItem.juryOptionTitle]
			[/#if]
			[#assign abstract = ""]
			[#if contentItem.juryOptionAbstract??]
				[#assign abstract = contentItem.juryOptionAbstract]
			[/#if]
		<section class="cmp-distribuidor-general-content" id="${idAnchor!""}">
		    <div class="cmp-distruidor-content-title">
		        <div class="container-fluid">
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
				                	[#assign judgeListTmp = model.getJuryList(cmsfn.asJCRNode(content))]
				                	[#assign judgeList = cmsfn.asContentMapList(judgeListTmp)]
			                		[#if judgeList?has_content]
			                			[#list judgeList as judge]
			                				[#if contentItem.juryOptionCategory == judge.judgeCategory]
			                				<div class="col-jurado">
            									<div class="img-jurado">
            										[#assign imgItemKey = judge.judgePhoto!]
									            	[#if imgItemKey??]
									            		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "320")]
									            		[#if imgMediaRendition??]
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
            								[/#if]
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
			[#if contentItem.lemmaOptionIdAnchor??]
				[#assign idAnchor = contentItem.lemmaOptionIdAnchor]
			[/#if]
			[#assign title = ""]
			[#if contentItem.lemmaOptionTitle??]
				[#assign title = contentItem.lemmaOptionTitle]
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
		        <div class="container-fluid">
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
				                        		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "320")]
				                        		[#if imgMediaRendition??]
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
			[#if contentItem.enrollmentOptionIdAnchor??]
				[#assign idAnchor = contentItem.enrollmentOptionIdAnchor]
			[/#if]
			[#assign title = ""]
			[#if contentItem.enrollmentOptionTitle??]
				[#assign title = contentItem.enrollmentOptionTitle]
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
		        <div class="container-fluid">
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

[#-- 
[#list cmsfn.children(content.listElements) as element]
[#assign type = element.switchType!""]
<section class="cmp-distribuidor-general-content" id="${element.idAnchor!""}">
    <div class="cmp-distruidor-content-title">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 content-title">
                    <h3>${element.title!""}</h3>
                </div>
                <div class="col-md-12 text-contenido">
                    <p>${element.text!""}</p>
                </div>
            </div>
        </div>
    </div>
        <div class="cmp-distruidor-contenido">
        <div class="container-sub-info">
            <div class="row">
                <div class="col-md-12 contenido">
                	[#if type.switchType == "lemmaOption"]
                		[#assign lemma = type.lemmaOption]
                		${cmsfn.decode(lemma).lemmaRichText!""}
                	[/#if]
                	[#if type.switchType == "enrollmentOption"]
                		<div class="inscripcion">
	                		[#assign enrollment = type.enrollmentOption!""]
	                		${cmsfn.decode(enrollment).enrollmentRichText!""}
				            [#assign hrefLink="#"]
				            [#if enrollment.buttonLink??]
				            	[#assign hrefLink = cmsfn.link(cmsfn.contentByPath(enrollment.buttonLink))]
				            [/#if]
				            <a href="${hrefLink}" class="btn">${enrollment.buttonText!""}</a>
			            </div>
                	[/#if]
                	[#if type.switchType == "judgeOption"]
                		[#assign judge = cmsfn.children(content.judgeList)]
                		[#list judge as judgee]
                			${judgee.judgeName!""}
                		[/#list]
                	[/#if]
                	[#if type.switchType == "richTextOption"]
                		[#assign rich = type.richTextOption]
                		${cmsfn.decode(rich).richText!""}
                	[/#if]
                </div>
            </div>
        </div>
    </div>
</section>
[/#list]
[/#if]

 --]
