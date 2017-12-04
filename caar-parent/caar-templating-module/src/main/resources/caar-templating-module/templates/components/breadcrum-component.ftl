<section class="cmp-acerca-de-ae cmp-breadcrumb-info-video">
	<ul class="breadcrumb">
		[#list cmsfn.ancestors(content, "mgnl:page") as ancestor]
		[#if cmsfn.page(content).title?lower_case == ancestor.title?lower_case]
			<li class="active">${ancestor.title!""}</li>
		[#else]
			<li><a href="${cmsfn.link(ancestor)!"#"}">${ancestor.title!""}</a></li>
		[/#if]
		[/#list]
	</ul>
</section>