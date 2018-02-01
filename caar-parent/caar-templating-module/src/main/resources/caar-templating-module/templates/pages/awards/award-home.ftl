[@cms.area name="content" /]
[#assign nodeJcrPath = ctx.getParameter('awardsPath')!?html]
[#if nodeJcrPath?has_content]
[#assign currentLanguage = cmsfn.language()!""]
[#assign awardsContent = cmsfn.contentByPath(nodeJcrPath, "awards")]
[#assign awardsContentNode = cmsfn.asJCRNode(awardsContent)]
[#assign awards = model.parent.getInstance()!""]
[#include "submenu-award.ftl"]
<section class="cmp-banner-bienales">
	[#assign imageBackground = "#"]
	[#assign imgItemKey = awards.getAwardHeaderBackground(awardsContentNode)!]
    	[#if imgItemKey??]
        	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "1440")!]
    		[#if imgMediaRendition?has_content]
        		[#assign imageBackground = imgMediaRendition.getLink()!]
        	[/#if]
        [/#if]
        <div class="header container-fluid" style="background-image:url('${imageBackground!""}')">
            <div class="row">
                <div class="contendor-logo">
                    [#assign imgItemKey = awards.getAwardLogo(awardsContentNode)!]
	            	[#if imgItemKey??]
	            		[#if imgItemKey?has_content]
	                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "181x181")]
		            		[#if imgMediaRendition?has_content]
		            			[#assign imageAlternativeText = "logo de bienal"]
		            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
		            			[#if imageAlt?has_content]
		            				[#assign imageAlternativeText = imageAlt.alternative!""]
		            			[/#if]
	                    		<img class="logo-premio" src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText}" />
	                    	[/#if]
                    	[/#if]
                    [/#if]
                </div>
            </div>
            <div class="row">
                <div class="title-big">
                    <h2>${awards.getAwardName(awardsContentNode)!""}</h2>
                </div>
            </div>
            <div class="row">
                <div class="contendor-btn">
                    <div class="botonera">
                    	[#assign hrefLink = "#"]
                    	[#if cmsfn.parent(content).announcementButtonLinkexternalLink??]
							[#assign hrefLink = cmsfn.externalLink(cmsfn.parent(content), "announcementButtonLink")]                        		
                    	[/#if]
                    	[#if cmsfn.parent(content).linkinternalLink??]
                    		[#assign hrefLink = cmsfn.link(cmsfn.contentById(cmsfn.parent(content).linkinternalLink, "website"))]
                    	[/#if]
                        <a class="btn" href="#">${cmsfn.parent(content).announcementButtonText!""}</a>
                        <a class="btn" href="#">${cmsfn.parent(content).enrollmentButtonText!""}</a>
                        <a href="${cmsfn.externalLink(awardsContentNode,"awardExternalURL")!""}">${awards.getAwardExternalURL(awardsContentNode)!""}</a>
                    </div>
                </div>
            </div>

        </div>
</section>
<section class="cmp-texto-premio">
        <div class="container">
            <div class="row">
                <div class="col-md-12 descripcion">
                    ${awards.getAwardDescription(awardsContentNode)!""}
                </div>
            </div>
        </div>
    </section>
[/#if]