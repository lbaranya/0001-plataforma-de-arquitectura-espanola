<html>
<head>
	[#-- automatizar --]
	[#-- [#assign site = sitefn.site()!]

	[#assign theme = sitefn.theme(site)!] --]
    <meta charset="utf-8">
    <title>Sabana</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    ${resfn.css("/caar-theme-module/webresources.*css")}
</head>

<body>

[@cms.area name="header" /]

[@cms.area name="main" /]

[@cms.area name="footer" /]
	
	[#-- automatizar --]
    ${resfn.js("/caar-theme-module/webresources.*js")}
    
</body>

</html>