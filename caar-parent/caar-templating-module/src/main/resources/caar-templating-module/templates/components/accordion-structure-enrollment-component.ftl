[#assign countFirstLevel = ctx.countFirstLevel]
<div class="panel panel-default panel-principal">
    <div class="panel-heading close-acordeon">
        <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion" href="#collapse${countFirstLevel}"><div class="text">${content.title_accordion!""}</div> <div class="icon"><i class="fa fa-chevron-down" aria-hidden="true"></i></div></a>
        </h4>
    </div>
    <div id="collapse${countFirstLevel}" class="panel-collapse collapse">
        <div class="panel-body inscripcion">
            ${cmsfn.decode(content).basic_information!""}
            [#assign hrefLink="#"]
            [#if content.architect_file_link??]
            	[#assign checkContent = cmsfn.contentByPath(content.architect_file_link)!""]
	            [#if checkContent?has_content]
            		[#assign hrefLink = cmsfn.link(cmsfn.contentByPath(content.architect_file_link))]
            	[/#if]
            [/#if]
            <a href="${hrefLink}" class="btn">${content.architect_link_name!""}</a>
        </div>
    </div>
</div>