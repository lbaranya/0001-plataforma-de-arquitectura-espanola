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
				[#assign image = damfn.getAssetLink(element.image)!]
				<img class="image-banner" src="${image}" alt="${element.altImage!""}" />
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