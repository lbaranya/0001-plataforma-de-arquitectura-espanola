[#assign nodeJcrPath = ctx.getParameter('path')!?html]
[#if nodeJcrPath?has_content]
	[#assign eventsContent = cmsfn.contentByPath(nodeJcrPath, "awards")]
	[#assign eventsContentNode = cmsfn.asJCRNode(eventsContent)]
	[#assign events = model.parent.getInstance()!""]
	[@cms.area name="breadcrumb" /]
	[#-- [@cms.component content=content template="submenu-award" /] --]
	[#--  [#include "submenu-award.ftl"]--]
	[#assign awardContentNode = cmsfn.asJCRNode(cmsfn.parent(eventsContent, "mgnl:award"))!""]
	[@cms.area name="submenu-award" contextAttributes={"currentAward":awardContentNode} /]
	[@cms.area name="subheader" /]
	[#list cmsfn.children(eventsContent) as eventItem]
		[#assign eventNode = cmsfn.asJCRNode(eventItem)!""]
		${events.getTitle(eventNode)!"error"}
		${events.getStandardText(eventNode)!"error text"}
		[#list events.getFilesList(eventNode) as item]
			${item}
		[/#list]
	[/#list]
	
	
[#else]
	[@cms.area name="breadcrumb" /]
	[@cms.area name="submenu-award" /]
	[@cms.area name="subheader" /]
[/#if]