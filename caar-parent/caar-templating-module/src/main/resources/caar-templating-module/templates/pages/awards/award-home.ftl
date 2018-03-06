[#assign nodeJcrPath = ctx.getParameter('path')!?html]
[#if nodeJcrPath?has_content]

[#assign awardsContent = cmsfn.contentByPath(nodeJcrPath, "awards")]
[#assign awardsContentNode = cmsfn.asJCRNode(awardsContent)]
[#assign awards = model.parent.getInstance()!""]
[@cms.area name="content" contextAttributes={"awardHomeName":awards.getAwardName(awardsContentNode)}/]
[@cms.area name="submenu-award" contextAttributes={"currentAward":awardsContentNode} /]
<section class="cmp-banner-bienales">
	[#assign imageBackground = "#"]
	[#assign imgItemKey = awards.getAwardHeaderBackground(awardsContentNode)!]
    	[#if imgItemKey??]
        	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "1440w")!]
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
                    <h2>${awards.getAwardName(awardsContentNode)!""}</h2>
                </div>
            </div>
            <div class="row">
                <div class="contendor-btn">
                    <div class="botonera">
                    	[#assign hrefLink = "#"]
                    	[#assign openEditionNode = model.parent.getEditionStateOpen(awardsContentNode)!""]
                    	[#if openEditionNode?has_content]
                    		[#assign openEditionContentMap = cmsfn.asContentMap(openEditionNode)!""]
	                    	[#if openEditionContentMap.announcementButtonLink?has_content]
	                    		[#assign hrefLink = cmsfn.link(cmsfn.contentById(openEditionContentMap.announcementButtonLink, "dam"))]
	                    	[/#if]
                    	<a class="btn" href="${hrefLink}">${awards.getEditionAnnouncementButtonText(openEditionNode)}</a>
                        <a class="btn" href="${cmsfn.externalLink(openEditionContentMap, "enrollmentButtonLink")}">${awards.getEditionEnrollmentButtonText(openEditionNode)}</a>
                        [/#if]
                        [#if awards.getAwardExternalURL(awardsContentNode)?has_content]
	                        [#if awards.getAwardExternalURLText(awardsContentNode)?has_content]
	                        	[#assign linkText = awards.getAwardExternalURLText(awardsContentNode)!""]
	                        [#else]
	                        	[#assign linkText = awards.getAwardExternalURL(awardsContentNode)!""]
	                        [/#if]
	                        <a href="${cmsfn.externalLink(awardsContentNode,"awardExternalURL")!""}">${linkText}</a>
	                    [/#if]
                    </div>
                </div>
            </div>

        </div>
</section>
<section class="cmp-texto-premio">
    <div class="container-margin">
        <div class="row">
            <div class="col-md-12 descripcion">
            	[#assign richTextContent = cmsfn.asContentMap(awardsContentNode)!""]
            	${cmsfn.decode(richTextContent).awardDescription!""}
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