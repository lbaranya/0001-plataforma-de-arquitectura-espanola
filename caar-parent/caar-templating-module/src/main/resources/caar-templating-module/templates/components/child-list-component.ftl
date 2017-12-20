[#-- <a href="${cmsfn.link(cmsfn.page(cmsfn.root(content, "mgnl:page")))}">${cmsfn.page(cmsfn.root(content, "mgnl:page")).title!""}</a>  --]
<section class="cmp-distribuidor">
    <div class="container">
    	[#assign countRow = 1]
        [#list cmsfn.children(cmsfn.page(content), "mgnl:page") as child]
        	[#if countRow%2==1]
        <div class="row">
        	[/#if]
			<a href="${cmsfn.link(child)}" class="col-md-6">
				<div class="title">
					<p>${child.title!""}</p>
				</div>
				<div class="img-arquia">
					[#assign imgItemKey = content.image!]
	            	[#if imgItemKey??]
	            		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "555x400")]
	            		[#if imgMediaRendition??]
	            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(content.image!"").getPath(),"dam")!]
                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlt.alternative!""}" />
                    	[/#if]
                    [/#if]
                    <div class="texto"><h2>${child.title!""}</h2></div>
                </div>
                <div class="descrip-arquia">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatem, necessitatibus, soluta. Maxime corrupti, nihil repellat odio nulla doloribus quasi non optio recusandae nemo voluptate ipsa, qui, deserunt, veritatis! Laboriosam, magnam.</p>
                </div>
			</a>
			[#if countRow%2==0]
		</div>
			[/#if]
			[#assign countRow = countRow + 1]
		[/#list]
	</div>
</section>