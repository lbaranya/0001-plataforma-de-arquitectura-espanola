[#assign nodeJcrPath = ctx.getParameter('path')!?html]
[#if nodeJcrPath?has_content]
	[#if model.isArchitectNodeType(nodeJcrPath)??]
		[#assign architectContent = cmsfn.contentByPath(nodeJcrPath, "architecture-files")!""]
		[#assign architectContentNode = cmsfn.asJCRNode(architectContent)!""]
		[#assign architect = model.getArchitect()!"No se puede obtener la instancia"]
		<section class="cmp-ficha-detalle-arquitecto">
	        <div class="container-margin">
	            <div class="row">
	                <div class="header-img">
	                	[#assign imgItemKey = architect.getPhoto(architectContentNode)!""]
		            	[#if imgItemKey??]
		            		[#if imgItemKey?has_content]
		                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "928x627")!]
			            		[#if imgMediaRendition?has_content]
			            			[#assign imageAlternativeText = "arquitecto"]
			            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
			            			[#if imageAlt?has_content && imageAlt.alternative?has_content]
			            				[#assign imageAlternativeText = imageAlt.alternative!""]
			            			[/#if]
		                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText}" />
		                    	[/#if]
	                    	[/#if]
	                    [/#if]
	                </div>
	                <div class="descrip-header">
	                    <h2>
	                    	${architect.getName(architectContentNode)!""}
	                    	${architect.getFirstSurname(architectContentNode)!""}
	                    	${architect.getSecondSurname(architectContentNode)!""}
	                    </h2>
	                    <span>
	                    	${architect.getBirthCity(architectContentNode)!""}
	                    	[#assign birthYear = architect.getBirthDate(architectContentNode)!""]
	                    	${birthYear?keep_after_last(" ")!""}
	                    </span>
	                    <p>${architect.getAditionalInfo(architectContentNode)!""}</p>
	                </div>
	            </div>
	        </div>
    	</section>
    [/#if]
[/#if]
    