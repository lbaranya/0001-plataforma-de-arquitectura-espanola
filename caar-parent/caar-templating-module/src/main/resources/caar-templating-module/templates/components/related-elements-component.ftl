[#assign nodeJcrPath = ctx.getParameter('path')!?html]
[#assign nodeWorkspace = ctx.getParameter('workspace')!?html]
[#if nodeJcrPath?has_content]
	[#assign fileContent = cmsfn.contentByPath(nodeJcrPath, nodeWorkspace)!""]
	[#assign fileContentNode = cmsfn.asJCRNode(fileContent)!""]
	[#assign nodes = model.getRelatedElements(fileContentNode)]
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
			            		[#if imgItemKey?has_content]
			                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "1440")!]
				            		[#if imgMediaRendition?has_content]
				            			[#assign imageAlternativeText = "ficha de arquitectura"]
				            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
				            			[#if imageAlt?has_content]
				            				[#assign imageAlternativeText = imageAlt.alternative!""]
				            			[/#if]
			                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
			                    	[/#if]
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