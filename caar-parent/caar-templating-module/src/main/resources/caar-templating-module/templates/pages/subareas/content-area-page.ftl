<div class="container-fluid">
	<div class="row">
		[#list components as component]
		    [@cms.component content=component /]
		[/#list]
	</div>
</div>