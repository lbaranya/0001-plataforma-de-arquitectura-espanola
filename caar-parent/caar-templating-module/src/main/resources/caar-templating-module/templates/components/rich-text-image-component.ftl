<section class="cmp-acerca-de-ae cmp-breadcrumb-info-video">
	[#assign imgItemKey = content.imageLink!""]
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
	[#if content.title?has_content]
	<div class="col-md-12 title">
        <h3>${content.title!""}</h3>
    </div>
    [/#if]
    [#if imgMediaRendition?has_content && content.imagePosition == "left"]
		<div class="col-md-7 video-img-acerca">
    		<img class="imagen-destacada" src='${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}' />
    	</div>
    [/#if]
	<div class="col-md-5 info-acerca">
		<p>${cmsfn.decode(content).text!""}</p>
	</div>
	[#if imgMediaRendition?has_content && content.imagePosition == "right"]
	<div class="col-md-7 video-img-acerca">
		<img class="imagen-destacada" src='${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}' />
	</div>
	[/#if]
</div>
</section>