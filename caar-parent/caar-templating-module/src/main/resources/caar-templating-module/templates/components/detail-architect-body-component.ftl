[#assign nodeJcrPath = ctx.getParameter('path')!?html]
[#if nodeJcrPath?has_content]
	[#if model.isArchitectNodeType(nodeJcrPath)??]
		[#assign architectContent = cmsfn.contentByPath(nodeJcrPath, "architecture-files")!""]
		[#assign architectContentNode = cmsfn.asJCRNode(architectContent)!""]
		[#assign architect = model.getArchitect()!""]	
		<section class="cmp-ficha-arquitecto">
	        <div class="container">
	            <div class="row">
	                <div class="col-md-6">
	                    <div class="col-md-12">
	                        <h3>${i18n['caar-templating-module.templates.components.detail-architect-body-component.training']}</h3>
	                        <ul>
	                        	[#assign educationList = architect.getEducationList(architectContentNode)!""]
	                        	[#list educationList as educationElement]
	                        		[#assign startYear = architect.getEducationStartDate(educationElement)!""]
	                        		[#assign endingYear = architect.getEducationEndingDate(educationElement)!""]
	                        		<li><span>${startYear?keep_after_last(" ")!""} - ${endingYear?keep_after_last(" ")!""}  
	                        		${architect.getEducationCenter(educationElement)!""},</span> ${architect.getEducationSubjects(educationElement)!""}</li>
	                            [/#list]
	                        </ul>
	                    </div>
	                    <div class="col-md-12">
	                        <h3>${i18n['caar-templating-module.templates.components.detail-architect-body-component.professional-data']}</h3>
	                        <p>
	                        	<span><strong>${architect.getDepartmentName(architectContentNode)!""}</strong></span></br>
	                        	<span><a href="${cmsfn.externalLink(architectContentNode, architect.getDepartmentWebSiteFieldName())!"#"}">${architect.getDepartmentWebSite(architectContentNode)!""}</a></span></br>
	                        	<span>${architect.getDepartmentCity(architectContentNode)!""}, ${architect.getDepartmentCountry(architectContentNode)!""}</span></br>
	                        	<span>${i18n['caar-templating-module.templates.components.detail-architect-body-component.components']}: ${architect.getConcatenatedDepartmentComponents(architectContentNode)!""}</span></br>
	                        	<span>${i18n['caar-templating-module.templates.components.detail-architect-body-component.biographic-news']}: ${architect.getBiographicNews(architectContentNode)!""}</span></br>
	                        	<span>${i18n['caar-templating-module.templates.components.detail-architect-body-component.curriculum']}: <a href="#">${i18n['caar-templating-module.templates.components.detail-architect-body-component.download']}</a></span></br>
	                        	<span>${i18n['caar-templating-module.templates.components.detail-architect-body-component.awards-and-distinctions']}: ${architect.getAwardsAndDistinctions(architectContentNode)!""}</span>
	                        </p>
	                	</div>
	                </div>
	                <div class="col-md-6">
	                    <div class="col-md-12">
	                        <h3>${i18n['caar-templating-module.templates.components.detail-architect-body-component.work-experience']}</h3>
	                        <p>
	                        	[#assign experienceList = architect.getWorkExperienceList(architectContentNode)!""]
	                        	[#list experienceList as experienceElement]
	                        		[#assign startYear = architect.getWorkExperienceStartDate(experienceElement)!""]
	                        		[#assign endingYear = architect.getWorkExperienceEndingDate(experienceElement)!""]
	                        		<span class="bold-text">${startYear?keep_after_last(" ")!""} - ${endingYear?keep_after_last(" ")!""} 
	                        		${architect.getWorkExperienceBusinessName(experienceElement)!""},</span> ${architect.getWorkExperienceMainFunctions(experienceElement)!""}
	                        		<br>
	                            [/#list]
	                        </p>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </section>
	[/#if]
[/#if]