[#list components as component]
    [@cms.component content=component /]
[/#list]
[@cms.area name="content" contextAttributes={"resourcesURL":ctx.resourcesURL}/]
[@cms.area name="accordion" contextAttributes={"resourcesURL":ctx.resourcesURL}/]