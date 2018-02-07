<section class="cmp-dummy">
	[#-- Falta por maquetar --]
	<img src='${ctx.resourcesURL}/img/homedummy.jpg' alt='dummy'/>
</section>
[#list components as component]
    [@cms.component content=component /]
[/#list]