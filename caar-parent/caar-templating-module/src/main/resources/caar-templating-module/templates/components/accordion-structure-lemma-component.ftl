[#assign countFirstLevel = ctx.countFirstLevel]
<div class="panel panel-default panel-principal">
    <div class="panel-heading close-acordeon">
        <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion" href="#collapse${countFirstLevel}"><div class="text">${content.title_accordion!""}</div> <div class="icon"><i class="fa fa-chevron-down" aria-hidden="true"></i></div></a>
        </h4>
    </div>
    <div id="collapse${countFirstLevel}" class="panel-collapse collapse">
        <div class="panel-body lema">
            <div class="preview">
                <h4>${content.sub_title_accordion!""}</h4>
                <div class="descript">
                    <div class="col-info-preview">
                    [#assign hrefLink = "#"]
                    [#if content.architect_file_link??]
                    	[#assign hrefLink = cmsfn.link(cmsfn.contentByPath(content.architect_file_link))]
                    [/#if]
                        <a href="${hrefLink}">
                        	[#assign imgItemKey = content.preview_file!]
                        	[#if imgItemKey??]
                        		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "320")!]
                        		[#if imgMediaRendition?has_content]
                        			[#assign imageAlternativeText = "imagen del arquitecto del lema"]
                        			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
                        			[#if imageAlt?has_content]
                        				[#assign imageAlternativeText = imageAlt.alternative!""]
                        			[/#if]
                            		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" />
                            	[/#if]
                            [/#if]
                        </a>
                        <div class="info-preview">
                            <span>${content.info_preview_text!""}</span>
                            [#assign yearText = ""]
                            [#if content.info_preview_year?has_content]
                            	[#assign yearText = "Año"]
                            [/#if]
                            <span class="year">${yearText!""} ${content.info_preview_year!""}</span>
                        </div>
                    </div>
                    <div class="info-basica">
                        ${cmsfn.decode(content).basic_information!""}
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>