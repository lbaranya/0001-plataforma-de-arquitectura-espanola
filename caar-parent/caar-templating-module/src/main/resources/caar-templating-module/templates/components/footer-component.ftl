<section class="cmp-footer">
        <div class="container footer">
            <div class="row footer-row">
                <div class="col-sm-2 col-xs-12 col-sm-offset-1 newsletter">
                    <h4 class="footer-title">${i18n['caar-templating-module.templates.components.footer-component.newsletter.label']!"newsletter"}</h4>
                    <ul>
                        <li class="footer-nl-link">
                            <a href="#" class="nl-link" alt="tu_email" title="tu_email">${i18n['caar-templating-module.templates.components.footer-component.yourEmail.label']!"Tu email"}</a>
                        </li>
                        <li class="footer-nl-link">
                            <a href="#" class="nl-link" alt="subscribe" title="subscribe">${i18n['caar-templating-module.templates.components.footer-component.subscribe.label']!"subscribe!"}</a>
                        </li>
                    </ul>
                </div>
                <div class="col-sm-2 col-xs-12">
                    <h4 class="footer-title">${i18n['caar-templating-module.templates.components.footer-component.webMap.label']!"mapa web"}</h4>
                    <ul>
                    	[#if content.linkElements1?has_content]
                    	[#list cmsfn.children(content.linkElements1) as element]
                        <li class="footer-global-link">
                            <a href="${element.link!""}" class="global-link" alt="explorando_arquitectura" title="${element.linkText!""}">${element.linkText!""}</a>
                        </li>
                        [/#list]
                        [/#if]
                    </ul>
                </div>
                <div class="col-sm-2 col-xs-12">
                    <h4 class="footer-title">${i18n['caar-templating-module.templates.components.footer-component.about.label']!"sobre nosotros"}</h4>
                    <ul>
                        [#if content.linkElements2?has_content]
                    	[#list cmsfn.children(content.linkElements2) as element]
                        <li class="footer-global-link">
                            <a href="${element.link!""}" class="global-link" alt="explorando_arquitectura" title="${element.linkText!""}">${element.linkText!""}</a>
                        </li>
                        [/#list]
                        [/#if]
                    </ul>
                </div>
                <div class="col-sm-2 col-xs-12">
                    <h4 class="footer-title">${i18n['caar-templating-module.templates.components.footer-component.legalNote.label']!"nota legal"}</h4>
                    <li class="footer-global-link">
                            <a href="${content.legalLink!""}" class="global-link" alt="legal_link" title="nota legal">${i18n['caar-templating-module.templates.components.footer-component.legalNote.label']!"nota legal"}</a>
                    </li>
                    <li class="footer-global-link">
                            <a href="${content.cookiesLink!""}" class="global-link" alt="cookies_link" title="cookies">${i18n['caar-templating-module.templates.components.footer-component.cookies.label']!"cookies"}</a>
                    </li>
                </div>
                <div class="col-sm-2 col-xs-12">
                    <h4 class="footer-title">${i18n['caar-templating-module.templates.components.footer-component.followUs.label']!"siguenos en"}</h4>
                    <ul class="rrss-list">
                    [#if content.listElementsRRSS?has_content]
                    [#list cmsfn.children(content.listElementsRRSS) as element]
                        <li class="rrss-link">
                            <a href="${element.link!""}" class="rrss-icon">
                                <i class="fa fa-${element.listRRSS!""}" aria-hidden="true"></i>
                            </a>
                        </li>
                    [/#list]
                    [/#if]
                    </ul>
                </div>
            </div>
		<div class="row">
			<div class="col-sm-8 colaboradores">
				<h4 class="footer-title">${i18n['caar-templating-module.templates.components.footer-component.collaborators.label']!"colaboradores"}</h4>
				<ul class="footer-logos-list">
				[#if content.logoElements?has_content]
				[#list cmsfn.children(content.logoElements) as logoElement]
				[#assign image = damfn.getAssetLink(logoElement.image)!]
					<li class="logo-item"><a href="#" class="footer-logo"><img src="${image}" width="175" alt="${logoElement.altImage!""}"></a></li>
				[/#list]
				[/#if]
				</ul>
			</div>
		</div>
	</div>
</section>