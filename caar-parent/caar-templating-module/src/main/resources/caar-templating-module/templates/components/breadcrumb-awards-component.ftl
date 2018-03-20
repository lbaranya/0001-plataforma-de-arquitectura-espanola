[#assign nodeJcrPath = ctx.contentNode!""]
[#if nodeJcrPath?has_content]
	
	[#assign awardsContentNode = nodeJcrPath!""]
	[#assign awards = model.getInstance()!""]
	[#assign ancestorsList = cmsfn.ancestors(awardsContentNode)]
<section class="cmp-acerca-de-ae cmp-breadcrumb-info-video">
	[#assign ancestor = navfn.ancestorPageAtLevel(content, 2)!]
	<ul class="breadcrumb">
		<li><a href="${cmsfn.link(navfn.rootPage(content))!"#"}">${i18n['caar-templating-module.templates.components.breadcrumb-awards-component.label']}</a></li>
		<li><a href="${cmsfn.link(ancestor)!"#"}">${ancestor.navTitle!ancestor.title}</a></li>
	[#if !awardsContentNode.isNodeType("mgnl:award")]
	[#if ancestorsList?has_content]
		[#list ancestorsList as ancestor]
				[#if ancestor.isNodeType("mgnl:award")]
					<li><a href="${cmsfn.link(ancestor)!"#"}">${awards.getAwardName(ancestor)?lower_case!""}</a></li>
				[#else]
					<li>${cmsfn.asContentMap(ancestor).title?lower_case!""}</li>
				[/#if]
		[/#list]
	[/#if]
		<li class="active">${cmsfn.asContentMap(awardsContentNode).title?lower_case!""?lower_case}</li>
	[#else]
		<li class="active"><a href="${cmsfn.link(awardsContentNode)!"#"}">${awards.getAwardName(awardsContentNode)?lower_case}</a></li>
	[/#if]
	</ul>
</section>
[/#if]