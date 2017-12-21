<section class="cmp-banner-bienales">
				[#assign imageBackground = "#"]
				[#assign imgItemKey = content.backgroundImage!]
	            	[#if imgItemKey??]
                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "1440")]
	            		[#if imgMediaRendition??]
                    		[#assign imageBackground = imgMediaRendition.getLink()!]
                    	[/#if]
                    [/#if]
        <div class="header container-fluid" style="background-image:url('${imageBackground!""}')">
            <div class="row">
                <div class="contendor-logo">
                    [#assign imgItemKey = content.image!]
	            	[#if imgItemKey??]
                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "181x181")]
	            		[#if imgMediaRendition??]
	            			[#assign imageAlternativeText = "logo de bienal"]
	            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
	            			[#if imageAlt?has_content]
	            				[#assign imageAlternativeText = imageAlt.alternative!""]
	            			[/#if]
                    		<img class="logo-premio" src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText}" />
                    	[/#if]
                    [/#if]
                </div>
            </div>
            <div class="row">
                <div class="title-big">
                    <h2>${content.title!""}</h2>
                </div>
            </div>
            <div class="row">
                <div class="contendor-btn">
                    <div class="botonera">
                        <button class="btn">${content.button1!""}</button>
                        <button class="btn">${content.button2!""}</button>
                        <a href="${content.linkHref!""}">${content.linkText!""}</a>
                    </div>
                </div>
            </div>

        </div>

</section>