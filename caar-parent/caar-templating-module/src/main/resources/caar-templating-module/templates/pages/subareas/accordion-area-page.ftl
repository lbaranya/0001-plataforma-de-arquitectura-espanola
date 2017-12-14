<!-- Cuerpo principal del componente -->
<section class="cmp-acerca-de-ae cmp-accordion-acercade cmp-accordion-convocatoria">
<div class="container">
	<div class="row">
		<div class="panel-group acordeon-acerca" id="accordion">
			[#assign countFirstLevel = 1]
			[#list components as component]
			    [@cms.component content=component contextAttributes= {"countFirstLevel" : countFirstLevel } /]
			    [#assign countFirstLevel = countFirstLevel + 1]
			[/#list]
		</div>
	</div>
</div>
</section>