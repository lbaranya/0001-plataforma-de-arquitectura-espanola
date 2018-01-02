<html>
    <body>
        <p>${i18n['caar-utils-module.templates.email.requestTranslation.header']!"Request translation"}</p>
        <dl>
        	[#assign repository = emailData['repositoryOfTranslatableNode']!"Unknown repository"]
        	[#assign path = emailData['pathToTranslatableNode']!"Unknown path"]
        	[#if repository?? && repository?has_content && path?? && path?has_content]
        		[#assign body1 = i18n['caar-utils-module.templates.email.requestTranslation.body1']!"It is necessary to translate the following content: Repository: "]
        		[#assign body2 = i18n['caar-utils-module.templates.email.requestTranslation.body2']!" Path: "]
	        	<dt>${body1 + repository + '. ' + body2 + path}</dt>
	        [/#if]
        </dl>
    </body>
</html>