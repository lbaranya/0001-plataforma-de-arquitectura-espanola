[#assign nodeJcrPath = ctx.getParameter('awardsPath')!?html]
[#if nodeJcrPath?has_content]
	[#assign currentLanguage = cmsfn.language()!""]
	[#assign awardsContent = cmsfn.contentByPath(nodeJcrPath, "awards")]
	[#assign awardsContentNode = cmsfn.asJCRNode(awardsContent)]
	[#assign awards = model.getInstance()!""]
	[#assign ancestorsList = cmsfn.ancestors(awardsContentNode)]
	[#if ancestorsList?has_content]
<section class="cmp-acerca-de-ae cmp-breadcrumb-info-video">
	<ul class="breadcrumb">
		[#list ancestorsList as ancestor]
			<li><a href="${cmsfn.link(ancestor)!"#"}">${awards.getAwardName(ancestor)?lower_case}</a></li>
		[/#list]
	</ul>
</section>
	[/#if]
[/#if]