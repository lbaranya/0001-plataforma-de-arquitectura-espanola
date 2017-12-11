<section class="cmp-acerca-de-ae cmp-breadcrumb-info-video">
	[#if content.title?has_content]
	<div class="col-md-12 title">
        <h3>${content.title!""}</h3>
    </div>
    [/#if]
	<div class="col-md-5 info-acerca">
		<p>${cmsfn.decode(content).text!""}</p>
	</div>
	<div class="col-md-7 video-img-acerca">
		<iframe src="${content.videoLink!"#"}" frameborder="0" allowfullscreen></iframe>
	</div>
</div>
</section>