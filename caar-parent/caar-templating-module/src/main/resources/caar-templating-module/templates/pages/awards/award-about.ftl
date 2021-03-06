[#assign nodeJcrPath = ctx.getParameter('path')!?html]
[#if nodeJcrPath?has_content]
	[#assign awardsContent = cmsfn.contentByPath(nodeJcrPath, "awards")!""]
	[#assign awardsContentNode = cmsfn.asJCRNode(awardsContent)!""]
	[#assign awards = model.parent.getInstance()!""]
	[@cms.area name="breadcrumb" contextAttributes={"contentNode": awardsContentNode}/]
	[#-- [@cms.component content=content template="submenu-award" /] --]
	[#--  [#include "submenu-award.ftl"]--]
	[@cms.area name="submenu-award" contextAttributes={"currentAward":awardsContentNode} /]
	[@cms.area name="subheader" /]
	<section class="cmp-nota-legal">
		<div class="container">
		    <div class="row">
		        <div class="col-md-12">
						[#assign richTextContent = cmsfn.asContentMap(awardsContentNode)!""]
            			${cmsfn.decode(richTextContent).awardAboutText!""}
				</div>
			</div>
		</div>
	</section>
[#else]
	[@cms.area name="breadcrumb" /]
	[@cms.area name="submenu-award" /]
	[@cms.area name="subheader" /]
[/#if]