[#assign nodeJcrContext = ctx.currentAward!""]
[#if nodeJcrContext?has_content]
	
	[#assign awardsContentNode = nodeJcrContext!""]
	[#assign awards = model.getInstance()!""]
	[#assign event = model.getEventInstance()!""]
<section class="cmp-convocatoria">
    <div class="header-comun">
        <div class="container-fluid">
            <div class="row col-row">
                <div class="col-header">
                    <h3 data-ref="menu">${awards.getAwardName(awardsContentNode)!""}<i class="fa fa-chevron-down" aria-hidden="true"></i></h3>
                    [#assign phase = model.getAnnouncementState(awardsContentNode)!""]
                    [#if phase?has_content]
                    	<p>${i18n['caar-templating-module.templates.components.submenu-award.phase.label']}: ${phase}</p>
                    [/#if]
                </div>
            </div>
        </div>
    </div>
    <nav class="submenu-convocatoria" data-menu="menu">
        <div class="contenedor-menu">
            <ul class="">
            	[#assign openEdition = model.getEditionStateOpen(awardsContentNode)!""]
                [#if openEdition?has_content]
                [#if cmsfn.children(openEdition)?has_content]
                <li class="menu-first">
                    <a href="javascript:void(0)">
                        <span>${i18n['caar-templating-module.award.home.actualEdition.label']}</span>
                        <div class="icon"><i class="fa fa-chevron-right" aria-hidden="true"></i></div>
                    </a>
                    <ul class="menu-second">
                    	[#list cmsfn.children(openEdition) as childItem]
                        <li class="menu-second-item">
                        	[#if childItem.isNodeType("mgnl:announcement")]
                        	[#assign currentUrl = cmsfn.link(childItem)]
                        	[#assign href = model.getSecondLevelMenuLink(currentUrl, childItem)!"#"]
                            <a href="${href}"><span>${i18n['caar-templating-module.templates.components.submenu-award.announcement.label']}</span></a>
                            [/#if]
                            [#if childItem.isNodeType("mgnl:program")]
                            <a href="javascript:void(0)">
                            	<span>${i18n['caar-templating-module.templates.components.submenu-award.program.label']}</span>
                            	<div class="icon"><i class="fa fa-chevron-right" aria-hidden="true"></i></div>
                            </a>
                            	[#if cmsfn.children(childItem)?has_content]
                            		<ul class="menu-third">
                            		[#list cmsfn.children(childItem) as thirdLevelItem]
                            			<li class="menu-third-item">
                            				[#assign currentUrlThirdLevel = cmsfn.link(thirdLevelItem)]
                        					[#assign href = model.getSecondLevelMenuLink(currentUrlThirdLevel, thirdLevelItem)!"#"]
                        					[#if thirdLevelItem.isNodeType("mgnl:event-wrapper")]
                        						[#assign hrefModified = model.getAwardStandardEventMenuLink(href, thirdLevelElement)!"#"]
                        					[#else]
                        						[#assign hrefModified = model.getAwardLiveEventMenuLink(href, thirdLevelElement)!"#"]
                        					[/#if]
                            				<a href="${hrefModified!"#"}">
                            					<span>${event.getTitle(thirdLevelItem)}</span>
                            				</a>
                            			</li>
                            		[/#list]
                            		</ul>
                            	[/#if]
                            [/#if]
                            [#if childItem.isNodeType("mgnl:diffusion")]
                            <a href="javascript:void(0)">
                            	<span>${i18n['caar-templating-module.templates.components.submenu-award.diffusion.label']}</span>
                            	<div class="icon"><i class="fa fa-chevron-right" aria-hidden="true"></i></div>
                            </a>
                            [#if cmsfn.children(childItem)?has_content]
                            		<ul class="menu-third">
                            		[#list cmsfn.children(childItem) as thirdLevelItem]
                            			<li class="menu-third-item">
                            				[#assign currentUrlThirdLevel = cmsfn.link(thirdLevelItem)]
                        					[#assign href = model.getSecondLevelMenuLink(currentUrlThirdLevel, thirdLevelItem)!"#"]
                        					[#if thirdLevelItem.isNodeType("mgnl:event-wrapper")]
                        						[#assign hrefModified = model.getAwardStandardEventMenuLink(href, thirdLevelElement)!"#"]
                        					[#else]
                        						[#assign hrefModified = model.getAwardLiveEventMenuLink(href, thirdLevelElement)!"#"]
                        					[/#if]
                            				<a href="${hrefModified!"#"}">
                            					<span>${event.getTitle(thirdLevelItem)}</span>
                            				</a>
                            			</li>
                            		[/#list]
                            		</ul>
                            	[/#if]
                            [/#if]
                        </li>
                        [/#list]
                    </ul>
                </li>
                [/#if]
                [/#if]
                [#assign inProgressEdition = model.getEditionStateInProgress(awardsContentNode)!""]
                [#if inProgressEdition?has_content]
                <li class="menu-first">
                    <a href="javascript:void(0)">
                        <span>${i18n['caar-templating-module.award.home.inProgressEdition.label']}</span>
                        <div class="icon"><i class="fa fa-chevron-right" aria-hidden="true"></i></div>
                    </a>
                </li>
                [/#if]
                [#assign aboutText = awards.getAwardAboutText(awardsContentNode)]
                [#if aboutText?has_content]
                <li class="menu-first">
                	[#assign currentUrl = cmsfn.link(awardsContentNode)]
                	[#assign hrefLinkAbout = model.getAboutLink(currentUrl)]
                    <a href="${hrefLinkAbout}">
                        <span>${i18n['caar-templating-module.award.home.awardAbout.label']}</span>
                        <div class="icon hidden"><i class="fa fa-chevron-right" aria-hidden="true"></i></div>
                    </a>
                </li>
                [/#if]
                [#if awards.getAwardCategoriesList(awardsContentNode)?has_content]
                [#assign currentUrl = cmsfn.link(awardsContentNode)]
                [#assign hrefLinkNewsList = model.getNewsListLink(currentUrl)]
                <li class="menu-first">
                    <a href="${hrefLinkNewsList}">
                        <span>${i18n['caar-templating-module.award.home.awardNews.label']}</span>
                        <div class="icon hidden"><i class="fa fa-chevron-right" aria-hidden="true"></i></div>
                    </a>
                </li>
                [/#if]
            </ul>
            <div class="logo-convacotoria">
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
    </nav>
</section>
[/#if]