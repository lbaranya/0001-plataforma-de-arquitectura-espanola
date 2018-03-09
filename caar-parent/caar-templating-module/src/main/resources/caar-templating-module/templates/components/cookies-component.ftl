<section id="cookiesBox" class="cmp-politica-cookies">
    <div class="container-fluid">
        <div class="row">
            <div class="container">
                <div class="row">
                    <div class="cookies-container">
                        <div class="cookies-info">
                           <div class="cookies-text">${cmsfn.decode(content).cookiesText!""}
                           	[#assign checkContent = cmsfn.contentByPath(content.cookiesLink!)!""]
	            			[#if checkContent?has_content]
                             <a href="${cmsfn.link(cmsfn.contentByPath(content.cookiesLink!))!"#"}" class="cookies-link">${i18n['caar-templating-module.templates.components.cookies-component.cookiesLink.label']!"Política de cookies"}</a>
                           	[/#if]
                           </div>
                           </p>
                           <a href="#" class="aceptar-btn">${i18n['caar-templating-module.templates.components.cookies-component.cookiesButton.label']!"Aceptar"}</a>
                   		</div>
                   </div>
                </div>
            </div>
        </div>
    </div>
</section>