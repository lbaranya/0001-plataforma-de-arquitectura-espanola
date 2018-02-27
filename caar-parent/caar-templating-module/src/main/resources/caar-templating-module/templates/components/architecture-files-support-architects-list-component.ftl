[#--[#assign architectsInstance = model.getInstance()!""]
<section class="cmp-arquitecto">
    <div class="container-fluid cmp-header-arqui" style="background-image: url('${cmsfn.link(content.headerImage)!""}')">
        <div class="container">
            <div class="row">
                <div class="header">
                    <div class="sub-title">${content.title!""}</div>
                    <div class="title-big">
                        ${content.headerText!""}
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="cmp-arquitecto">
    <div class="container cmp-arquitecto-header">
        <div class="row">
            <h2>${content.title!""}</h2>
        </div>
    </div>
</section>

<section class="cmp-arquitecto">
    <div class="container cmp-arquitecto-ultimos">
        <div class="row">
            <div class="col-md-12">
                <div class="sub-title-arqui">${i18n['caar-templating-module.templates.components.architecture-files-support-architects-list-component.last-profiles.label']}</div>
            </div>
            [#assign lastModifiedList = model.getArchitectsList()!""]
            [#list lastModifiedList as architect]
            
	            <div class="col-md-6 ult-arqui">
	                <div class="nom-arqui">${architectsInstance.getFullName(architect)!""}</div>
	                <div class="arqui-img-text">
	                    [#assign imgItemKey = architectsInstance.getPhoto(architect)!""]
		            	[#if imgItemKey??]
	                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "261x350")!]
		            		[#if imgMediaRendition??]
		            			[#assign imageAlternativeText = "arquitecto"]
		            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
		            			[#if imageAlt?has_content]
		            				[#assign imageAlternativeText = imageAlt.alternative!""]
		            			[/#if]
	                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText}" />
	                    	[/#if]
	                    [/#if]
	                    <div class="texto-hover"><h2>“La arquitectura es el arte de gastar el espacio”.</h2></div>
	                </div>
	            </div>
            
            [/#list]
        </div>
    </div>
</section>

<section class="cmp-arquitecto">
    <div class="container cmp-todos-arqui">
        <div class="row">
            <div class="col-md-12">
                <div class="sub-title-arqui">${i18n['caar-templating-module.templates.components.architecture-files-support-architects-list-component.all-profiles.label']}</div>
            </div>
            
            [#assign architectsList = model.getArchitectsList()!""]
            [#list architectsList as architect]
            
	            <div class="col-md-3 container-arqui">
	                <div class="nom-arqui">${architectsInstance.getFullName(architect)!""}</div>
	                <div class="arqui-img-text">
	                    [#assign imgItemKey = architectsInstance.getPhoto(architect)!""]
		            	[#if imgItemKey??]
	                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "261x350")!]
		            		[#if imgMediaRendition??]
		            			[#assign imageAlternativeText = "arquitecto"]
		            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
		            			[#if imageAlt?has_content]
		            				[#assign imageAlternativeText = imageAlt.alternative!""]
		            			[/#if]
	                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText}" />
	                    	[/#if]
	                    [/#if]
                    <div class="texto-hover"><h2>“La arquitectura es el arte de gastar el espacio”.</h2></div>
	                </div>
	            </div>
	            
            [/#list]
        </div>
    </div>
</section>--]
Pepito