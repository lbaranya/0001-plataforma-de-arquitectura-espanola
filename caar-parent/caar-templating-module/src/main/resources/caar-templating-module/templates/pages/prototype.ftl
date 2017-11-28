[#-- Assigns --]
	[#assign moduleName = "/caar-theme-module" /]
	[#assign site = sitefn.site()!""/]
	[#assign theme = sitefn.theme(site)!"" /]
[#-- /Assigns --]
<html>
<head>
    <meta charset="utf-8">
    <title>${content.title!""}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    [#list theme.cssFiles as cssFile]
    	<link rel="stylesheet" href="${cssFile.link}" media="${cssFile.media}" />
	[/#list]
    [@cms.page /]
</head>

<body>
	<input type="hidden" id="context" value="${ctx.contextPath}"/>
	<input type="hidden" id="module" value="${moduleName}"/>
	<input type="hidden" id="theme" value="${theme.name}"/>
[#assign resourcesURL = "${ctx.contextPath}/.resources${moduleName}/webresources/${theme.name}"]

[@cms.area name="top-banner" contextAttributes={"resourcesURL":resourcesURL}/]

[@cms.area name="header" contextAttributes={"resourcesURL":resourcesURL}/]

[@cms.area name="main" contextAttributes={"resourcesURL":resourcesURL}/]

[@cms.area name="footer" contextAttributes={"resourcesURL":resourcesURL}/]
	
	[#-- automatizar --]
	[#list theme.jsFiles as jsFile]
    	<script src="${jsFile.link}"></script>
	[/#list]
    
</body>

</html>