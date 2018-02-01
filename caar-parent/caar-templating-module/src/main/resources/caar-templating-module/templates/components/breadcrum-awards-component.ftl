[#-- 
	It is necessary to make a modification of the component to contemplate the nodes of "edition" (current and in progress), "result", "program" and "diffusion" that do not have pages, and therefore, can not be clickable elements
  --]
[#assign nodeJcrPath = ctx.getParameter('awardsPath')!?html]
[#if nodeJcrPath?has_content]
	[#assign currentLanguage = cmsfn.language()!""]
	[#assign awardsContent = cmsfn.contentByPath(nodeJcrPath, "awards")]
	[#assign awardsContentNode = cmsfn.asJCRNode(awardsContent)]
	[#assign awards = model.getInstance()!""]
	[#assign ancestorsList = cmsfn.ancestors(awardsContentNode)]
<section class="cmp-acerca-de-ae cmp-breadcrumb-info-video">
	[#assign ancestor = navfn.ancestorPageAtLevel(content, 2)!]
	<ul class="breadcrumb">
		<li><a href="${cmsfn.link(navfn.rootPage(content))!"#"}">${i18n['caar-templating-module.templates.components.breadcrum-awards-component.label']}</a></li>
		<li><a href="${cmsfn.link(ancestor)!"#"}">${ancestor.title!""}</a></li>
	[#if ancestorsList?has_content]
		[#list ancestorsList as ancestor]
			<li><a href="${cmsfn.link(ancestor)!"#"}">${awards.getAwardName(ancestor)?lower_case}</a></li>
		[/#list]
	[/#if]
	<li class="active"><a href="${cmsfn.link(awardsContentNode)!"#"}">${awards.getAwardName(awardsContentNode)!""}</a></li>
	</ul>
</section>
[/#if]