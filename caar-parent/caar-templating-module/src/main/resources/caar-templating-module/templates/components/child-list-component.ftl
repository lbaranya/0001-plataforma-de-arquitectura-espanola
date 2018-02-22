[#-- <a href="${cmsfn.link(cmsfn.page(cmsfn.root(content, "mgnl:page")))}">${cmsfn.page(cmsfn.root(content, "mgnl:page")).title!""}</a>  --]
<section class="cmp-distribuidor">
    <div class="container-fluid">
    	[#assign countRow = 1]
        [#list cmsfn.children(cmsfn.page(content), "mgnl:page") as child]
        	[#if countRow%2==1]
        <div class="row">
        	[/#if]
        	[#if !navfn.isHiddenInNav(child)]
			<a href="${cmsfn.link(child)}" class="col-md-6">
				<div class="title">
					<p>${child.title!""}</p>
				</div>
				<div class="img-arquia">
					[#assign imgItemKey = content.image!]
	            	[#if imgItemKey??]
	            		[#if imgItemKey?has_content]
		            		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "555x400")!]
		            		[#if imgMediaRendition?has_content]
		            			[#assign imageAlternativeText = "imagen de fondo para enlace de noticias"]
	                			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
	                			[#if imageAlt?has_content]
	                				[#assign imageAlternativeText = imageAlt.alternative!""]
	                			[/#if]
	                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
	                    	[/#if]
                    	[/#if]
                    [/#if]
                    <div class="texto"><h2>${child.title!""}</h2></div>
                </div>
			</a>
			[#if countRow%2==0]
		</div>
			[/#if]
			[#assign countRow = countRow + 1]
			[/#if]
		[/#list]
	</div>
</section>