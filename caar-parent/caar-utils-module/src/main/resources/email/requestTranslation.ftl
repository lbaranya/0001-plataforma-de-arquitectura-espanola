<html>
    <body>
        <p>${i18n['caar-utils-module.templates.email.requestTranslation.header']!"Solicitud de traducci&oacute;n"}</p>
        <dl>
        	[#if emailData['pathToTranslatableNode']?? && emailData['pathToTranslatableNode']?has_content]
	        	<dt>${i18n['caar-utils-module.templates.email.requestTranslation.body']!"Se ha solicitado la traducci&oacute;n de la noticia: "}${emailData['pathToTranslatableNode']}</dt>
	        [/#if]
        </dl>
    </body>
</html>