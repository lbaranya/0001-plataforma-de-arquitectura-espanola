<html>
<head>
	[#assign siteResourcesURL = sitefn.theme(sitefn.site())]
    <meta charset="utf-8">
    <title>${content.title!""}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    [#list siteResourcesURL.cssFiles as cssFile]
	    <link rel="stylesheet" href="${cssFile.link}" media="${cssFile.media}" />
	[/#list]
    
    [@cms.page /]
</head>

<body>
[#-- Este resourcesURL esta asi para los iconos en caliente que tenemos repartidos en las paginas --]
[#assign resourcesURL = "${ctx.contextPath}/.resources/caar-theme-module/webresources/caar-theme"]
[#-- Con el input nos traemos el contexto que pasaremos al js para subsanar los problemas de rutas hacia los iconos --]
<input id="resources" type="hidden" value="${resourcesURL}" />

[@cms.area name="top-banner" contextAttributes={"resourcesURL":resourcesURL}/]

[@cms.area name="header" contextAttributes={"resourcesURL":resourcesURL}/]

[@cms.area name="main" contextAttributes={"resourcesURL":resourcesURL}/]

[@cms.area name="footer" contextAttributes={"resourcesURL":resourcesURL}/]

[@cms.area name="cookies" contextAttributes={"resourcesURL":resourcesURL}/]
	
	[#-- automatizar --]
	[#list siteResourcesURL.jsFiles as jsFile]
	    <script src="${jsFile.link}"></script>
	[/#list]
    
</body>

</html>