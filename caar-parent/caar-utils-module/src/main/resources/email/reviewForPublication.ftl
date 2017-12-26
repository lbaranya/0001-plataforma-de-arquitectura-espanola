<html>
    <body>
        <p>${i18n['caar-utils-module.templates.email.reviewForPublication.header']!"Solicitud de publicaci&oacute;n"}</p>
        <dl>
	        [#if mgnlData['requestor']?? && mgnlData['requestor']?has_content]
	        	<dt>${i18n['caar-utils-module.templates.email.reviewForPublication.user']!"Usuario: "}${mgnlData['requestor']}</dt>
	        [/#if]
	        [#if mgnlData['comment']?? && mgnlData['comment']?has_content]
	        	<dt>${i18n['caar-utils-module.templates.email.reviewForPublication.comment']!"Comentario: "}${mgnlData['comment']}</dt>
	        [/#if]
	        [#if mgnlData['repository']?? && mgnlData['repository']?has_content]
	        	<dt>${i18n['caar-utils-module.templates.email.reviewForPublication.application']!"Aplicaci&oacute;n: "}${mgnlData['repository']}</dt>
	        [/#if]
	        [#if mgnlData['path']?? && mgnlData['path']?has_content]
	        	<dt>${i18n['caar-utils-module.templates.email.reviewForPublication.node']!"Nodo: "}${mgnlData['path']}</dt>
        	[/#if]
        </dl>
    </body>
</html>