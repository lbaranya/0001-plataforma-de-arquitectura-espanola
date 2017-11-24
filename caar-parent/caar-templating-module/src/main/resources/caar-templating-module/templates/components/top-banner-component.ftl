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
					<h2 class="title">${element.title!""}</h2>
						<div class="contenido">
							<p class="frase">${element.phrase!""}</p>
							<p class="autor">${element.author!""}</p>
						</div>
				</div>
			</div>
			[#assign cont = cont + 1]
			[/#list]
			[/#if]
		</div>
</section>