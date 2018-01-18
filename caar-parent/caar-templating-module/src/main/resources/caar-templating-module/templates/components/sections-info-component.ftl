
[#if content.listElements?has_content]
[#assign rowCount = 1]
<section class="cmp-distribuidor-convocatoria">
    <div class="container-fluid">
[#list cmsfn.children(content.listElements) as element]
		[#if rowCount%4 == 1]
        <div class="row">
        [/#if]
            <a href="#${element.idAnchor!""}" class="col-md-3 anchor-distribuidor">
                <div class="title">
                    <p>${element.title!""}</p>
                </div>
                <div class="img-arquia">
                	[#assign imgItemKey = element.anchorImage!]
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
                        <h2>${element.title!""}</h2></div>
                </div>
                <div class="new-links">
                    <span class="more-link" alt="leer más">Leer</span>
                </div>
            </a>
        [#if rowCount%4 == 0]
        </div>
        [/#if]
        [#assign rowCount = rowCount + 1]
[/#list]
	</div>
	<div class="cmp-volver"><i class="fa fa-chevron-circle-up" aria-hidden="true"></i></div>
</section>

[#list cmsfn.children(content.listElements) as element]
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
                	${cmsfn.decode(element).richText!""}
                </div>
            </div>
        </div>
    </div>
</section>
[/#list]
[/#if]
