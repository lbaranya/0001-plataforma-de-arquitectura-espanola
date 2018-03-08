    <section class="cmp-rejilla-home">
        <div class="container-margin">
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-3 col-info">
	                        [#assign imgItemKey = content.image1!""]
							[#if imgItemKey??]
								[#if imgItemKey?has_content]
							 		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "263x445")!]
							 		[#if imgMediaRendition?has_content]
							 			[#assign imageAlternativeText = "imagen de grid de la home"]
							 			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
							 			[#if imageAlt?has_content]
							 				[#assign imageAlternativeText = imageAlt.alternative!""]
							 			[/#if]
							    	[/#if]
								[/#if]
							[/#if]
                            <h4><span>${content.title1!""}</span>${content.subtitle1!""}</h4>
                            [#assign hrefTmp = "#"]
                        	[#if content.link1 == "architectureFileLink"]
	                        	[#if content.link1architectureFileLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link1architectureFileLink, "architecture-files")]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
                        	[#elseif content.link1 == "awardLink"]
	                      		[#if content.link1awardLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link1awardLink, "awards")!""]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
                        	[#elseif content.link1 == "newsLink"]
	                      		[#if content.link1newsLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link1newsLink, "news")!""]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
	                      	[#else]
	                      		[#if content.link1externalLink?has_content]
	                        		[#assign hrefTmp = cmsfn.externalLink(content, "link1externalLink")!""]
	                        	[/#if]
                        	[/#if]
                            <a href="${hrefTmp!"#"}"><img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" style="width: 100%;" /></a>
                        </div>
                        <div class="col-md-3 col-info">
	                        [#assign imgItemKey = content.image2!""]
							[#if imgItemKey??]
								[#if imgItemKey?has_content]
							 		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "263x445")!]
							 		[#if imgMediaRendition?has_content]
							 			[#assign imageAlternativeText = "imagen de grid de la home"]
							 			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
							 			[#if imageAlt?has_content]
							 				[#assign imageAlternativeText = imageAlt.alternative!""]
							 			[/#if]
							    	[/#if]
								[/#if]
							[/#if]
                            <h4><span>${content.title2!""}</span>${content.subtitle2!""}</h4>
                            [#assign hrefTmp = "#"]
                        	[#if content.link2 == "architectureFileLink"]
	                        	[#if content.link2architectureFileLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link2architectureFileLink, "architecture-files")]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
                        	[#elseif content.link2 == "awardLink"]
	                      		[#if content.link2awardLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link2awardLink, "awards")!""]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
                        	[#elseif content.link2 == "newsLink"]
	                      		[#if content.link2newsLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link2newsLink, "news")!""]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
	                      	[#else]
	                      		[#if content.link2externalLink?has_content]
	                        		[#assign hrefTmp = cmsfn.externalLink(content, "link2externalLink")!""]
	                        	[/#if]
                        	[/#if]
                            <a href="${hrefTmp!"#"}"><img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" style="width: 100%;" /></a>
                        </div>
                        <div class="col-md-6 col-info">
                            <h4><span>${content.title3!""}</span>${content.subtitle3!""}</h4>
                            <div class="imagen-video">
                                <iframe src="${content.videoLink!""}" frameborder="0" allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="row">
                                <div class="col-md-6 col-info col-one">
                                    <h4><span>${content.title4!""}</span>${content.subtitle4!""}</h4>
		                            [#assign hrefTmp = "#"]
		                        	[#if content.link4 == "architectureFileLink"]
			                        	[#if content.link4architectureFileLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link4architectureFileLink, "architecture-files")]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link4 == "awardLink"]
			                      		[#if content.link4awardLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link4awardLink, "awards")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link4 == "newsLink"]
			                      		[#if content.link4newsLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link4newsLink, "news")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
			                      	[#else]
			                      		[#if content.link4externalLink?has_content]
			                        		[#assign hrefTmp = cmsfn.externalLink(content, "link4externalLink")!""]
			                        	[/#if]
		                        	[/#if]
                                    <a href="${hrefTmp!"#"}">
                                        <div class="pensamiento">
                                            <h3>${content.contentTitle4!""}</h3>
                                            <p>${cmsfn.decode(content).contentText4!""}</p>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-md-6 col-info col-two">
			                        [#assign imgItemKey = content.image5!""]
									[#if imgItemKey??]
										[#if imgItemKey?has_content]
									 		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "263x445")!]
									 		[#if imgMediaRendition?has_content]
									 			[#assign imageAlternativeText = "imagen de grid de la home"]
									 			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
									 			[#if imageAlt?has_content]
									 				[#assign imageAlternativeText = imageAlt.alternative!""]
									 			[/#if]
									    	[/#if]
										[/#if]
									[/#if]
		                            <h4><span>${content.title5!""}</span>${content.subtitle5!""}</h4>
		                            [#assign hrefTmp = "#"]
		                        	[#if content.link5 == "architectureFileLink"]
			                        	[#if content.link5architectureFileLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link5architectureFileLink, "architecture-files")]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link5 == "awardLink"]
			                      		[#if content.link5awardLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link5awardLink, "awards")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link5 == "newsLink"]
			                      		[#if content.link5newsLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link5newsLink, "news")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
			                      	[#else]
			                      		[#if content.link5externalLink?has_content]
			                        		[#assign hrefTmp = cmsfn.externalLink(content, "link5externalLink")!""]
			                        	[/#if]
		                        	[/#if]
		                            <a href="${hrefTmp!"#"}"><img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" style="width: 100%;" /></a>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 col-info col-width">
			                        [#assign imgItemKey = content.image6!""]
									[#if imgItemKey??]
										[#if imgItemKey?has_content]
									 		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "691x445")!]
									 		[#if imgMediaRendition?has_content]
									 			[#assign imageAlternativeText = "imagen de grid de la home"]
									 			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
									 			[#if imageAlt?has_content]
									 				[#assign imageAlternativeText = imageAlt.alternative!""]
									 			[/#if]
									    	[/#if]
										[/#if]
									[/#if]
		                            <h4><span>${content.title6!""}</span>${content.subtitle6!""}</h4>
		                            [#assign hrefTmp = "#"]
		                        	[#if content.link6 == "architectureFileLink"]
			                        	[#if content.link6architectureFileLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link6architectureFileLink, "architecture-files")]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link6 == "awardLink"]
			                      		[#if content.link6awardLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link6awardLink, "awards")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link6 == "newsLink"]
			                      		[#if content.link6newsLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link6newsLink, "news")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
			                      	[#else]
			                      		[#if content.link6externalLink?has_content]
			                        		[#assign hrefTmp = cmsfn.externalLink(content, "link6externalLink")!""]
			                        	[/#if]
		                        	[/#if]
		                            <a href="${hrefTmp!"#"}"><img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" style="width: 100%;" /></a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-info" style="    vertical-align: middle; display: flex; justify-content: center; align-items: center;height: 100vh; font-size: 100px;">
                            <p>Twitter</p>
                        </div>
                        <div class="col-md-3 col-info col-premios">
                                <div class="col-vertical">
                                    <h4><span>${content.title7!""}</span>${content.subtitle7!""}</h4>
		                            [#assign hrefTmp = "#"]
		                        	[#if content.link7 == "architectureFileLink"]
			                        	[#if content.link7architectureFileLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link7architectureFileLink, "architecture-files")]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link7 == "awardLink"]
			                      		[#if content.link7awardLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link7awardLink, "awards")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link7 == "newsLink"]
			                      		[#if content.link7newsLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link7newsLink, "news")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
			                      	[#else]
			                      		[#if content.link7externalLink?has_content]
			                        		[#assign hrefTmp = cmsfn.externalLink(content, "link7externalLink")!""]
			                        	[/#if]
		                        	[/#if]
                                    <a href="${hrefTmp!"#"}">
                                        <div class="datos-arquitectos">
                                            <h5 class="inicial">${content.contentInitial7!""}</h5>
                                            <h5 class="arquitecto">${content.contentTitle7!""}</h5>
                                            <p>${cmsfn.decode(content).contentText7!""}</p>
                                        </div>
                                    </a>
                                </div>
                                <div class="">
			                        [#assign imgItemKey = content.image8!""]
									[#if imgItemKey??]
										[#if imgItemKey?has_content]
									 		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "263x445")!]
									 		[#if imgMediaRendition?has_content]
									 			[#assign imageAlternativeText = "imagen de grid de la home"]
									 			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
									 			[#if imageAlt?has_content]
									 				[#assign imageAlternativeText = imageAlt.alternative!""]
									 			[/#if]
									    	[/#if]
										[/#if]
									[/#if]
		                            <h4><span>${content.title8!""}</span>${content.subtitle8!""}</h4>
		                            [#assign hrefTmp = "#"]
		                        	[#if content.link8 == "architectureFileLink"]
			                        	[#if content.link8architectureFileLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link8architectureFileLink, "architecture-files")]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link8 == "awardLink"]
			                      		[#if content.link8awardLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link8awardLink, "awards")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link8 == "newsLink"]
			                      		[#if content.link8newsLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link8newsLink, "news")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
			                      	[#else]
			                      		[#if content.link8externalLink?has_content]
			                        		[#assign hrefTmp = cmsfn.externalLink(content, "link8externalLink")!""]
			                        	[/#if]
		                        	[/#if]
		                            <a href="${hrefTmp!"#"}"><img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" style="width: 100%;" /></a>
                                </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 col-info">
	                        [#assign imgItemKey = content.image9!""]
							[#if imgItemKey??]
								[#if imgItemKey?has_content]
							 		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "1412x445")!]
							 		[#if imgMediaRendition?has_content]
							 			[#assign imageAlternativeText = "imagen de grid de la home"]
							 			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
							 			[#if imageAlt?has_content]
							 				[#assign imageAlternativeText = imageAlt.alternative!""]
							 			[/#if]
							    	[/#if]
								[/#if]
							[/#if]
                            <h4><span>${content.title9!""}</span>${content.subtitle9!""}</h4>
                            [#assign hrefTmp = "#"]
                        	[#if content.link9 == "architectureFileLink"]
	                        	[#if content.link9architectureFileLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link9architectureFileLink, "architecture-files")]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
                        	[#elseif content.link9 == "awardLink"]
	                      		[#if content.link9awardLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link9awardLink, "awards")!""]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
                        	[#elseif content.link9 == "newsLink"]
	                      		[#if content.link9newsLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link9newsLink, "news")!""]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
	                      	[#else]
	                      		[#if content.link9externalLink?has_content]
	                        		[#assign hrefTmp = cmsfn.externalLink(content, "link9externalLink")!""]
	                        	[/#if]
                        	[/#if]
                            <a href="${hrefTmp!"#"}"><img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" style="width: 100%;" /></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>