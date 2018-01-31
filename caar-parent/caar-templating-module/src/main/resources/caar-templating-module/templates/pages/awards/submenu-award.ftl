<section class="cmp-convocatoria">
    <div class="header-comun">
        <div class="container-fluid">
            <div class="row col-row">
                <div class="col-header">
                    <h3 data-ref="menu">${awards.getAwardName(awardsContentNode)!""}<i class="fa fa-chevron-up" aria-hidden="true"></i></h3>
                    <p>Fase: Descriptivo</p>
                </div>
            </div>
        </div>
    </div>
    <nav class="submenu-convocatoria" data-menu="menu">
        <div class="contenedor-menu">
            <ul class="">
            	[#assign openEdition = model.parent.getEditionStateOpen(awardsContentNode)!""]
                [#if openEdition?has_content]
                <li class="menu-first">
                    <a href="javascript:void(0)">
                        <span>${i18n['caar-templating-module.award.home.actualEdition.label']}</span>
                        <div class="icon"><i class="fa fa-chevron-right" aria-hidden="true"></i></div>
                    </a>
                    <!--
                    <ul class="menu-second">
                        <li class="menu-second-item">
                            <a href="#"><span>convocatoria</span></a>
                        </li>
                    </ul>
                    -->
                </li>
                [/#if]
                [#assign inProgressEdition = model.parent.getEditionStateInProgress(awardsContentNode)!""]
                [#if inProgressEdition?has_content]
                <li class="menu-first">
                    <a href="javascript:void(0)">
                        <span>${i18n['caar-templating-module.award.home.inProgressEdition.label']}</span>
                        <div class="icon"><i class="fa fa-chevron-right" aria-hidden="true"></i></div>
                    </a>
                </li>
                [/#if]
                <li class="menu-first">
                	[#assign hrefLink = cmsfn.link(awardsContentNode)]
                	[#assign hrefLink = hrefLink?replace("/awards/","/awards/about/")]
                    <a href="${hrefLink}">
                        <span>${i18n['caar-templating-module.award.home.awardAbout.label']}</span>
                        <div class="icon hidden"><i class="fa fa-chevron-right" aria-hidden="true"></i></div>
                    </a>
                </li>
                <li class="menu-first">
                    <a href="#">
                        <span>${i18n['caar-templating-module.award.home.awardNews.label']}</span>
                        <div class="icon hidden"><i class="fa fa-chevron-right" aria-hidden="true"></i></div>
                    </a>
                </li>
            </ul>
            <div class="logo-convacotoria">
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
    </nav>
</section>