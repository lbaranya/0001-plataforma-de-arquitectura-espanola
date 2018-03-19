[#assign awardHomeName = ""]
[#if ctx.awardHomeName?has_content]
	[#assign awardHomeName = ctx.awardHomeName!""]
[/#if]
<section class="cmp-acerca-de-ae cmp-breadcrumb-info-video">
	<ul class="breadcrumb">
		[#list cmsfn.ancestors(content, "mgnl:page") as ancestor]
		[#assign navTitle = cmsfn.page(content).navigationTitle!cmsfn.page(content).title]
		[#assign ancestorNavTitle = ancestor.navigationTitle!ancestor.title]
		[#if navTitle?lower_case == ancestorNavTitle?lower_case]
			[#if awardHomeName?has_content]
				<li class="active">${awardHomeName!""}</li>
			[#else]
				<li class="active">${ancestorNavTitle!""}</li>
			[/#if]
		[#else]
			<li><a href="${cmsfn.link(ancestor)!"#"}">${ancestorNavTitle!""}</a></li>
		[/#if]
		[/#list]
	</ul>
</section>