[#assign nodeJcrPath = ctx.getParameter('awardsPath')!?html]
[#if nodeJcrPath?has_content]
[#assign currentLanguage = cmsfn.language()!""]
[#assign awardsContent = cmsfn.contentByPath(nodeJcrPath, "awards")]
[#assign awardsContentNode = cmsfn.asJCRNode(awardsContent)]
[#assign awards = model.parent.getInstance()!""]
[@cms.area name="content" contextAttributes={"awardHomeName":awards.getAwardName(awardsContentNode, currentLanguage)}/]
[@cms.area name="submenu-award" contextAttributes={"currentAward":awardsContentNode} /]
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
	                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "181x181")!]
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
                    <h2>${awards.getAwardName(awardsContentNode, currentLanguage)!""}</h2>
                </div>
            </div>
            <div class="row">
                <div class="contendor-btn">
                    <div class="botonera">
                    	[#assign hrefLink = "#"]
                    	[#assign openEditionNode = model.parent.getEditionStateOpen(awardsContentNode)!""]
                    	[#if openEditionNode?has_content]
                    		[#assign openEditionContentMap = cmsfn.asContentMap(openEditionNode)!""]
	                    	[#if openEditionContentMap.announcementButtonLinkexternalLink?has_content]
								[#assign hrefLink = cmsfn.externalLink(openEditionContentMap, "announcementButtonLinkexternalLink")]                        		
	                    	[/#if]
	                    	[#if openEditionContentMap.announcementButtonLinkinternalLink?has_content]
	                    		[#assign hrefLink = cmsfn.link(cmsfn.contentById(openEditionContentMap.announcementButtonLinkinternalLink, "dam"))]
	                    	[/#if]
                    	<a class="btn" href="${hrefLink}">${awards.getEditionAnnouncementButtonText(openEditionNode, currentLanguage)}</a>
                        <a class="btn" href="${cmsfn.externalLink(openEditionContentMap, "enrollmentButtonLink")}">${awards.getEditionEnrollmentButtonText(openEditionNode, currentLanguage)}</a>
                        <a href="${cmsfn.externalLink(awardsContentNode,"awardExternalURL")!""}">${awards.getAwardExternalURL(awardsContentNode)!""}</a>
                        [/#if]
                    </div>
                </div>
            </div>

        </div>
</section>
<section class="cmp-texto-premio">
    <div class="container">
        <div class="row">
            <div class="col-md-12 descripcion">
                ${awards.getAwardDescription(awardsContentNode, currentLanguage)!""}
            </div>
        </div>
    </div>
</section>
[@cms.area name="relatedNews" /]
[#else]
	[@cms.area name="content" /]
	[@cms.area name="submenu-award" /]
	[@cms.area name="relatedNews" /]
[/#if]