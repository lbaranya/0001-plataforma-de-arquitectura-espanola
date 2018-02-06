[#assign awardHomeName = ""]
[#if ctx.awardHomeName?has_content]
	[#assign awardHomeName = ctx.awardHomeName!""]
[/#if]
<section class="cmp-acerca-de-ae cmp-breadcrumb-info-video">
	<ul class="breadcrumb">
		[#list cmsfn.ancestors(content, "mgnl:page") as ancestor]
		[#if cmsfn.page(content).title?lower_case == ancestor.title?lower_case]
			[#if awardHomeName?has_content]
				<li class="active">${awardHomeName!""}</li>
			[#else]
				<li class="active">${ancestor.title!""}</li>
			[/#if]
		[#else]
			<li><a href="${cmsfn.link(ancestor)!"#"}">${ancestor.title!""}</a></li>
		[/#if]
		[/#list]
	</ul>
</section>