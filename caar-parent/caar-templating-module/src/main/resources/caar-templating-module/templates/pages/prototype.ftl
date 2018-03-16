[#assign theme = sitefn.theme(sitefn.site())]

[#-- Este resourcesURL esta asi para los iconos en caliente que tenemos repartidos en las paginas --]
[#assign contextPath = ctx.contextPath!""]
[#assign resourcesURL = "${ctx.contextPath}/.resources/caar-theme-module/webresources/" + theme.name]

<html>
<head>
    
    <meta charset="utf-8">
    <title>${content.windowTitle!content.title!}</title>
    
    <meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta name="description" content="${content.description!""}" />
	<meta name="keywords" content="${content.keywords!""}" />
	<meta name="author" content="Ministerio de Fomento" />
	<meta name="generator" content="Powered by Magnolia - Intuitive Opensource CMS" />
    
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    [#list theme.cssFiles as cssFile]
	    <link rel="stylesheet" href="${cssFile.link}" media="${cssFile.media}" />
	[/#list]
	
	[#list theme.jsFiles as jsFile]
	    <script src="${jsFile.link}"></script>
	[/#list]
	
  	[#-- Favicon --]
	[#assign imgFavicon = resourcesURL + "/img/favicon.ico"]
  	<link rel="shortcut icon" href="${imgFavicon!""}" type="image/x-icon" />
    
    [@cms.page /]
</head>

<body>
[#-- Con el input nos traemos el contexto que pasaremos al js para subsanar los problemas de rutas hacia los iconos --]
<input id="resources" type="hidden" value="${resourcesURL}" />

[@cms.area name="top-banner" contextAttributes={"resourcesURL":resourcesURL}/]

[@cms.area name="header" contextAttributes={"resourcesURL":resourcesURL}/]

[@cms.area name="main" contextAttributes={"resourcesURL":resourcesURL}/]

[@cms.area name="footer" contextAttributes={"resourcesURL":resourcesURL}/]

[@cms.area name="cookies-area" contextAttributes={"resourcesURL":resourcesURL}/]
</body>

</html>