<section class="cmp-exist-home" style="visibility: hidden; width:1px; height: 1px; z-index: -1; top: -8000"></section>
<!--Banner: cmp-banner-header-->
<section class="cmp-banner-header">
	<div class="contenedor-images-banner">
		<div class="contenedor-frases">
			[#assign cont = 0]
			[#if content.bannerElements?has_content]
			[#list cmsfn.children(content.bannerElements) as element]
			[#if cont == 0]
			<div class="block-frase active">
			[#else]
			<div class="block-frase">
			[/#if]
				[#assign imgItemKey = element.image!]
            	[#if imgItemKey??]
            		[#if imgItemKey?has_content]
	            		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "1200")!]
	            		[#if imgMediaRendition??]
	            			[#assign imageAlternativeText = "imagen de banner en la cabecera"]
	            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
	            			[#if imageAlt?has_content]
	            				[#assign imageAlternativeText = imageAlt.alternative!""]
	            			[/#if]
							<img class="image-banner" src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />						
						[/#if]
					[/#if]
                [/#if]
				<div class="block-contenido">
					<div class="contenido">
						${cmsfn.decode(element).text!""}
					</div>
				</div>
			</div>
			[#assign cont = cont + 1]
			[/#list]
			[/#if]
		</div>
</section>