[#assign nodeJcrPath = ctx.getParameter('path')!?html]

[@cms.area name="breadcrumb" /]

[#if nodeJcrPath?has_content]
	[#assign businessModel = model.parent]
	[#if businessModel.isBusinessNodeType(nodeJcrPath)]
		[#assign businessContent = cmsfn.contentByPath(nodeJcrPath, "architecture-files")]
		[#assign businessContentNode = cmsfn.asJCRNode(businessContent)]
	
		[@cms.area name="department-info" contextAttributes={"businessModel":businessModel, "businessContentNode":businessContentNode} /]
		[@cms.area name="department-components" contextAttributes={"businessModel":businessModel, "businessContentNode":businessContentNode} /]
		[@cms.area name="complementary-info" contextAttributes={"businessModel":businessModel, "businessContentNode":businessContentNode} /]
	[/#if]
[/#if]