[#assign nodeJcrPath = ctx.getParameter('path')!?html]
[#if nodeJcrPath?has_content]
	[#assign fileContent = cmsfn.contentByPath(nodeJcrPath, "architecture-files")!""]
	[#assign fileContentNode = cmsfn.asJCRNode(fileContent)!""]
	[#assign nodes = model.getNodes(fileContentNode)]
	<section class="cmp-arquitectos-realacionados">
    	<div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h3 class="title">${content.title!""}</h3>
                </div>
            </div>
            <div class="row">
            	[#list nodes as node]
	                <div class="col-md-3 arquitecto">
	                    <h4>${node.getTitle()!""}</h4>
	                    <div class="container-img">
		                    [#assign imgItemKey = node.getPhoto()!""]
			            	[#if imgItemKey??]
		                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "1440")]
			            		[#if imgMediaRendition??]
			            			[#assign imageAlternativeText = "ficha de arquitectura"]
			            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
			            			[#if imageAlt?has_content]
			            				[#assign imageAlternativeText = imageAlt.alternative!""]
			            			[/#if]
		                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
		                    	[/#if]
		                    [/#if]
	                        <div class="texto">
	                            <h2>${node.getTitle()!""}</h2>
	                        </div>
	                    </div>
	                </div>
                [/#list]
            </div>
        </div>
    </section>
[/#if]