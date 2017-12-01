[#assign countFirstLevel = ctx.countFirstLevel]
<div class="panel panel-default panel-principal">
	<div class="panel-heading close-acordeon">
        <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion" href="#collapse${countFirstLevel}"><div class="text">${content.title!""}</div> <div class="icon"><i class="fa fa-chevron-down" aria-hidden="true"></i></div></a>
        </h4>
    </div>
    <div id="collapse${countFirstLevel}" class="panel-collapse collapse">
        <div class="panel-body">
        	${cmsfn.decode(content).text!""}
        	[#-- [#if cmsfn.children(firstLevelElement.listSecondLevel)?has_content] --]
        	[#assign countSecondLevel = 1]
        	<div class="panel-group sub-acordeon-acerca">
			[#list cmsfn.children(content.listSecondLevel) as secondLevelElement]
				<div class="panel panel-default">
		            <div class="panel-heading">
		                <h4 class="panel-title">
							<div data-toggle="collapse" href="#collapse${ctx.countFirstLevel}_${countSecondLevel}"><div class="text">${secondLevelElement.subtitle!""}</div></div> <button onclick="window.open('../../../Documentaci%25C3%25B3n/01_AE_WIREFRAMES_BASES.pdf')" class="icon-descargar">descargar <i class="fa fa-file-o" aria-hidden="true"></i> .pdf</button>
						</h4>
		            </div>
		            <div id="collapse${ctx.countFirstLevel}_${countSecondLevel}" class="panel-collapse collapse">
		                <div class="panel-body">
		                	${cmsfn.decode(secondLevelElement).subtext!""}
		                </div>
		            </div>
		        </div>
		        [#assign countSecondLevel = countSecondLevel + 1]
			[/#list]
			</div>
		</div>
		[#-- [/#if] --]
    </div>
</div>