<ul>
	<li>
		<a href="${cmsfn.link(cmsfn.page(cmsfn.root(content, "mgnl:page")))}">${cmsfn.page(cmsfn.root(content, "mgnl:page")).title!""}</a>
	</li>
	<ul>
	[#list cmsfn.children(cmsfn.page(content)) as child]
		<li>
			<a href="${cmsfn.link(child)}">${child.title!""}</a>
		</li>
	[/#list]
	</ul>
</ul>