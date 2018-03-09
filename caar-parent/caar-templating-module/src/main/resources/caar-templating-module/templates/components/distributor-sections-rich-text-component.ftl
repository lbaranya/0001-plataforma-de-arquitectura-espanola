[#assign contentChildren = cmsfn.children(content)]

[#list contentChildren as child]
	[#assign tmp = model.addToList(cmsfn.asJCRNode(child))]
[/#list]

[#assign sortedList = model.sortWeightArray()!""]

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
			[#assign richTextOptionIdAnchor = model.getAnchorFromString(contentItem.richTextOptionTitle)?lower_case!""]
			<a href="#${richTextOptionIdAnchor!""}" class="col-md-3 anchor-distribuidor">
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
				[#assign idAnchor = model.getAnchorFromString(contentItem.richTextOptionTitle)?lower_case!""]
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
	[/#if]
[/#list]
