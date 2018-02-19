[#assign countFirstLevel = ctx.countFirstLevel]
<div class="panel panel-default panel-principal jurado">
    <div class="panel-heading close-acordeon">
        <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion-convocatoria" href="#collapse${countFirstLevel}"><div class="text">${content.title_accordion!""}</div> <div class="icon"><i class="fa fa-chevron-down" aria-hidden="true"></i></div></a>
        </h4>
    </div>
    <div id="collapse${countFirstLevel}" class="panel-collapse collapse">
        <div class="panel-body">
        	[#list cmsfn.children(content.judgeList) as judge]
            <div class="col-jurado"> <!-- multivalue composite -->
                <div class="img-jurado">
                [#assign imgItemKey = judge.judge_image!]
            	[#if imgItemKey??]
            		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "320w")!]
            		[#if imgMediaRendition?has_content]
            			[#assign imageAlternativeText = "imagen del arquitecto jurado"]
            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
            			[#if imageAlt?has_content]
            				[#assign imageAlternativeText = imageAlt.alternative!""]
            			[/#if]
                		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
                	[/#if]
                [/#if]
                </div>
                <div class="info-jurado">
                    <h4>${judge.judge_name!""}</h4>
                    ${cmsfn.decode(judge).basic_text!""}
                </div>
                [#assign hrefLink = "#"]
                [#if judge.architect_file_link??]
                	[#assign hrefLink = cmsfn.link(cmsfn.contentByPath(judge.architect_file_link))]
                [/#if]
                <a href="${hrefLink}" class="ficha-jurado">
                    <div><i class="fa fa-plus" aria-hidden="true"></i></div>
                </a>
                <a href="#" class="pdf">${i18n['caar-templating-module.templates.components.accordion-structure-judge-component.PDF.label']} <i class="fa fa-file-o" aria-hidden="true"></i></a>
            </div>
            [/#list]
        </div>
    </div>
</div>