<section class="cmp-footer">
        <div class="container footer">
            <div class="row footer-row">
                <div class="col-sm-2 col-xs-12 col-sm-offset-1 newsletter">
                    <h4 class="footer-title">newsletter</h4>
                    <ul>
                        <li class="footer-nl-link">
                            <a href="#" class="nl-link" alt="tu_email" title="tu_email">Tu email</a>
                        </li>
                        <li class="footer-nl-link">
                            <a href="#" class="nl-link" alt="subscribe" title="subscribe">subscribe!</a>
                        </li>
                    </ul>
                </div>
                <div class="col-sm-2 col-xs-12">
                    <h4 class="footer-title">mapa web</h4>
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
                    <h4 class="footer-title">about</h4>
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
                    <h4 class="footer-title">nota legal</h4>
                    <li class="footer-global-link">
                            <a href="${content.legalLink!""}" class="global-link" alt="legal_link" title="nota legal">nota legal</a>
                    </li>
                    <li class="footer-global-link">
                            <a href="${content.cookiesLink!""}" class="global-link" alt="cookies_link" title="cookies">cookies</a>
                    </li>
                </div>
                <div class="col-sm-2 col-xs-12">
                    <h4 class="footer-title">siguenos en</h4>
                    <ul class="rrss-list">
                        <li class="rrss-link">
                            <a href="" class="rrss-icon">
                                <i class="fa fa-facebook" aria-hidden="true"></i>
                            </a>
                        </li>
                        <li class="rrss-link">
                            <a href="" class="rrss-icon">
                                <i class="fa fa-twitter" aria-hidden="true"></i>
                            </a>
                        </li>
                        <li class="rrss-link">
                            <a href="" class="rrss-icon">
                                <i class="fa fa-youtube" aria-hidden="true"></i>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
		<div class="row">
			<div class="col-sm-8 colaboradores">
				<h4 class="footer-title">colaboradores</h4>
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