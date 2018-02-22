<section class="cmp-footer">
        <div class="container footer">
            <div class="row footer-row">
                <div class="col-sm-2 col-xs-12">
                    <h4 class="footer-title">${content.columnNameTab1!i18n['caar-templating-module.templates.components.footer-component.webMap.label']}</h4>
                    <ul>
                    	[#if content.linkElements1?has_content]
                    	[#list cmsfn.children(content.linkElements1) as element]
                        <li class="footer-global-link">
                        	[#assign hrefTmp = "#"]
                        	[#if element.link == "internalLink"]
	                        	[#if element.linkinternalLink?has_content]
	                        		[#assign hrefTmp = cmsfn.link(cmsfn.contentById(element.linkinternalLink))]
	                        	[/#if]
	                      	[#else]
	                      		[#if element.linkexternalLink?has_content]
	                        		[#assign hrefTmp = cmsfn.externalLink(element, "linkexternalLink")]
	                        	[/#if]
                        	[/#if]
                            <a href="${hrefTmp}" class="global-link" title="${element.linkText!""}">${element.linkText!""}</a>
                        </li>
                        [/#list]
                        [/#if]
                    </ul>
                </div>
                <div class="col-sm-2 col-xs-12">
                    <h4 class="footer-title">${content.columnNameTab2!i18n['caar-templating-module.templates.components.footer-component.about.label']}</h4>
                    <ul>
                        [#if content.linkElements2?has_content]
                    	[#list cmsfn.children(content.linkElements2) as element]
                        <li class="footer-global-link">
                        	[#assign hrefTmp = "#"]
                        	[#if element.link == "internalLink"]
	                        	[#if element.linkinternalLink?has_content]
	                        		[#assign hrefTmp = cmsfn.link(cmsfn.contentById(element.linkinternalLink))]
	                        	[/#if]
	                      	[#else]
	                      		[#if element.linkexternalLink?has_content]
	                        		[#assign hrefTmp = cmsfn.externalLink(element, "linkexternalLink")]
	                        	[/#if]
                        	[/#if]
                            <a href="${hrefTmp}" class="global-link" title="${element.linkText!""}">${element.linkText!""}</a>
                        </li>
                        [/#list]
                        [/#if]
                    </ul>
                </div>
                <div class="col-sm-2 col-xs-12">
                    <h4 class="footer-title">${content.columnNameTab3!i18n['caar-templating-module.templates.components.footer-component.legalNote.label']}</h4>
                    <li class="footer-global-link">
                    	[#assign hrefLegalLink = "#"]
                		[#if content.legalLink?has_content]
                        	[#assign hrefLegalLink = cmsfn.link(cmsfn.contentById(content.legalLink!"/"))!"#"]
                		[/#if]
                    	<a href="${hrefLegalLink}" class="global-link" title="nota legal">${i18n['caar-templating-module.templates.components.footer-component.legalNote.label']!"nota legal"}</a>
                    </li>
                    <li class="footer-global-link">
                		[#assign hrefCookiesLink = "#"]
                		[#if content.cookiesLink?has_content]
                        	[#assign hrefCookiesLink = cmsfn.link(cmsfn.contentById(content.cookiesLink!"/"))!"#"]
                		[/#if]
                        <a href="${hrefCookiesLink}" class="global-link" title="cookies">${i18n['caar-templating-module.templates.components.footer-component.cookies.label']!"cookies"}</a>
                     </li>
                </div>
                <div class="col-sm-2 col-xs-12">
                    <h4 class="footer-title">${content.columnNameTab4!"siguenos en"}</h4>
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
				<h4 class="footer-title">${content.columnNameTab!i18n['caar-templating-module.templates.components.footer-component.collaborators.label']}</h4>
				<ul class="footer-logos-list">
				[#if content.logoElements?has_content]
				[#list cmsfn.children(content.logoElements) as logoElement]
					[#assign imgItemKey = logoElement.image!]
	            	[#if imgItemKey??]
	            		[#if imgItemKey?has_content]
		            		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "175w")!]
		            		[#if imgMediaRendition?has_content]
		            			[#assign imageAlternativeText = "imagen de banner en la cabecera"]
		            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
		            			[#if imageAlt?has_content]
		            				[#assign imageAlternativeText = imageAlt.alternative!""]
		            			[/#if]
		            			
	                        	[#assign hrefTmp = "#"]
	                        	[#if logoElement.link == "internalLink"]
		                        	[#if logoElement.linkinternalLink?has_content]
		                        		[#assign hrefTmp = cmsfn.link(cmsfn.contentById(logoElement.linkinternalLink))]
		                        	[/#if]
		                      	[#else]
		                      		[#if logoElement.linkexternalLink?has_content]
		                        		[#assign hrefTmp = cmsfn.externalLink(logoElement, "linkexternalLink")]
		                        	[/#if]
	                        	[/#if]
							<li class="logo-item"><a href="${hrefTmp}" class="footer-logo"><img src="${imgMediaRendition.getLink()}" width="175w" height="40" alt="${imageAlternativeText!""}"></a></li>
							[/#if]
						[/#if]
					[/#if]
				[/#list]
				[/#if]
				</ul>
			</div>
		</div>
	</div>
</section>