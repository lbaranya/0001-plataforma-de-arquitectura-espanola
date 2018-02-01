[#assign nodeJcrPath = ctx.getParameter('awardsPath')!?html]
[#if nodeJcrPath?has_content]
	[#assign currentLanguage = cmsfn.language()!""]
	[#assign awardsContent = cmsfn.contentByPath(nodeJcrPath, "awards")]
	[#assign awardsContentNode = cmsfn.asJCRNode(awardsContent)]
	[#assign awards = model.parent.getInstance()!""]
	[@cms.area name="breadcrum" /]
	[#include "submenu-award.ftl"]
	[@cms.area name="subheader" /]
	<section class="cmp-nota-legal">
		<div class="container">
		    <div class="row">
		        <div class="col-md-12">
						${awards.getAwardAboutText(awardsContentNode)!}
				</div>
			</div>
		</div>
	</section>
[#else]
	[@cms.area name="breadcrum" /]
	[@cms.area name="subheader" /]
[/#if]