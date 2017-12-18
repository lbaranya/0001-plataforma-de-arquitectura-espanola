<html>
    <head>
        ${i18n['caar-utils-module.templates.email.header']!"Solicitud de traduccion"}
    </head>
    <body>
        <dl>
        
        	[#if emailData['pathToTranslatableNode']?? && emailData['pathToTranslatableNode']?has_content]
	        	<dt>${i18n['caar-utils-module.templates.email.body']!"Se ha solicitado la traduccion de la noticia: "}${emailData['pathToTranslatableNode']}</dt>
	        [/#if]
        </dl>
    </body>
</html>