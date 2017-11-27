<html>
<head>
    <meta charset="utf-8">
    <title>${content.title!""}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    ${resfn.css("/caar-theme-module/webresources.*bootstrap.min.css")}
    ${resfn.css("/caar-theme-module/webresources.*/css/style.css")}
    [@cms.page /]
</head>

<body>
[#assign resourcesURL = "${ctx.contextPath}/.resources/caar-theme-module/webresources/caar-theme"]

[@cms.area name="top-banner" contextAttributes={"resourcesURL":resourcesURL}/]

[@cms.area name="header" contextAttributes={"resourcesURL":resourcesURL}/]

[@cms.area name="main" contextAttributes={"resourcesURL":resourcesURL}/]

[@cms.area name="footer" contextAttributes={"resourcesURL":resourcesURL}/]
	
	[#-- automatizar --]
	${resfn.js("/caar-theme-module/webresources.*jquery.min.js")}
	${resfn.js("/caar-theme-module/webresources.*bootstrap.min.js")}
	${resfn.js("/caar-theme-module/webresources.*site.js")}
    
</body>

</html>