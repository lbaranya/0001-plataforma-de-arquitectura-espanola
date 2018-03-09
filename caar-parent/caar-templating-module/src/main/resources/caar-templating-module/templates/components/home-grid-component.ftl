    <section class="cmp-rejilla-home">
        <div class="container-margin">
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-3 col-info">
	                        [#assign imgItemKey = content.image11!""]
							[#if imgItemKey??]
								[#if imgItemKey?has_content]
							 		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "331x445")!]
							 		[#if imgMediaRendition?has_content]
							 			[#assign imageAlternativeText = "imagen de grid de la home"]
							 			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
							 			[#if imageAlt?has_content]
							 				[#assign imageAlternativeText = imageAlt.alternative!""]
							 			[/#if]
							    	[/#if]
								[/#if]
							[/#if]
                            <h4><span>${content.title11!""}</span>${content.subtitle11!""}</h4>
                            [#assign hrefTmp = "#"]
                        	[#if content.link11 == "architectureFileLink"]
	                        	[#if content.link11architectureFileLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link11architectureFileLink, "architecture-files")]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
                        	[#elseif content.link11 == "awardLink"]
	                      		[#if content.link11awardLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link11awardLink, "awards")!""]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
                        	[#elseif content.link11 == "newsLink"]
	                      		[#if content.link11newsLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link11newsLink, "news")!""]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
	                      	[#else]
	                      		[#if content.link11externalLink?has_content]
	                        		[#assign hrefTmp = cmsfn.externalLink(content, "link1externalLink")!""]
	                        	[/#if]
                        	[/#if]
                            <a href="${hrefTmp!"#"}"><img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" style="width: 100%;" /></a>
                        </div>
                        <div class="col-md-3 col-info">
	                        [#assign imgItemKey = content.image12!""]
							[#if imgItemKey??]
								[#if imgItemKey?has_content]
							 		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "331x445")!]
							 		[#if imgMediaRendition?has_content]
							 			[#assign imageAlternativeText = "imagen de grid de la home"]
							 			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
							 			[#if imageAlt?has_content]
							 				[#assign imageAlternativeText = imageAlt.alternative!""]
							 			[/#if]
							    	[/#if]
								[/#if]
							[/#if]
                            <h4><span>${content.title12!""}</span>${content.subtitle12!""}</h4>
                            [#assign hrefTmp = "#"]
                        	[#if content.link12 == "architectureFileLink"]
	                        	[#if content.link12architectureFileLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link12architectureFileLink, "architecture-files")]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
                        	[#elseif content.link12 == "awardLink"]
	                      		[#if content.link12awardLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link12awardLink, "awards")!""]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
                        	[#elseif content.link12 == "newsLink"]
	                      		[#if content.link12newsLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link12newsLink, "news")!""]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
	                      	[#else]
	                      		[#if content.link12externalLink?has_content]
	                        		[#assign hrefTmp = cmsfn.externalLink(content, "link12externalLink")!""]
	                        	[/#if]
                        	[/#if]
                            <a href="${hrefTmp!"#"}"><img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" style="width: 100%;" /></a>
                        </div>
                        <div class="col-md-6 col-info">
                            <h4><span>${content.title13!""}</span>${content.subtitle13!""}</h4>
                            <div class="imagen-video">
                                <iframe src="${content.videoLink13!""}" frameborder="0" allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="row">
                                <div class="col-md-6 col-info col-one">
                                    <h4><span>${content.title21!""}</span>${content.subtitle21!""}</h4>
		                            [#assign hrefTmp = "#"]
		                        	[#if content.link21 == "architectureFileLink"]
			                        	[#if content.link21architectureFileLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link21architectureFileLink, "architecture-files")]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link21 == "awardLink"]
			                      		[#if content.link21awardLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link21awardLink, "awards")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link21 == "newsLink"]
			                      		[#if content.link21newsLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link21newsLink, "news")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
			                      	[#else]
			                      		[#if content.link21externalLink?has_content]
			                        		[#assign hrefTmp = cmsfn.externalLink(content, "link21externalLink")!""]
			                        	[/#if]
		                        	[/#if]
                                    <a href="${hrefTmp!"#"}">
                                        <div class="pensamiento">
                                            <h3>${content.contentTitle21!""}</h3>
                                            <p>${cmsfn.decode(content).contentText21!""}</p>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-md-6 col-info col-two">
			                        [#assign imgItemKey = content.image22!""]
									[#if imgItemKey??]
										[#if imgItemKey?has_content]
									 		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "331x445")!]
									 		[#if imgMediaRendition?has_content]
									 			[#assign imageAlternativeText = "imagen de grid de la home"]
									 			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
									 			[#if imageAlt?has_content]
									 				[#assign imageAlternativeText = imageAlt.alternative!""]
									 			[/#if]
									    	[/#if]
										[/#if]
									[/#if]
		                            <h4><span>${content.title22!""}</span>${content.subtitle22!""}</h4>
		                            [#assign hrefTmp = "#"]
		                        	[#if content.link22 == "architectureFileLink"]
			                        	[#if content.link22architectureFileLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link22architectureFileLink, "architecture-files")]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link22 == "awardLink"]
			                      		[#if content.link22awardLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link22awardLink, "awards")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link22 == "newsLink"]
			                      		[#if content.link22newsLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link22newsLink, "news")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
			                      	[#else]
			                      		[#if content.link22externalLink?has_content]
			                        		[#assign hrefTmp = cmsfn.externalLink(content, "link22externalLink")!""]
			                        	[/#if]
		                        	[/#if]
		                            <a href="${hrefTmp!"#"}"><img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" style="width: 100%;" /></a>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 col-info col-width">
			                        [#assign imgItemKey = content.image31!""]
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
		                            <h4><span>${content.title31!""}</span>${content.subtitle31!""}</h4>
		                            [#assign hrefTmp = "#"]
		                        	[#if content.link31 == "architectureFileLink"]
			                        	[#if content.link31architectureFileLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link31architectureFileLink, "architecture-files")]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link31 == "awardLink"]
			                      		[#if content.link31awardLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link31awardLink, "awards")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link31 == "newsLink"]
			                      		[#if content.link31newsLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link31newsLink, "news")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
			                      	[#else]
			                      		[#if content.link31externalLink?has_content]
			                        		[#assign hrefTmp = cmsfn.externalLink(content, "link24externalLink")!""]
			                        	[/#if]
		                        	[/#if]
		                            <a href="${hrefTmp!"#"}"><img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" style="width: 100%;" /></a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-info" style="    vertical-align: middle; display: flex; font-size: 100px; flex-direction: column;">
                    		[#assign imgItemKey = content.image23!""]
							[#if imgItemKey??]
								[#if imgItemKey?has_content]
							 		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "331x926")!]
							 		[#if imgMediaRendition?has_content]
							 			[#assign imageAlternativeText = "imagen de grid de la home"]
							 			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
							 			[#if imageAlt?has_content]
							 				[#assign imageAlternativeText = imageAlt.alternative!""]
							 			[/#if]
							    	[/#if]
								[/#if]
							[/#if]
                            <h4><span>${content.title23!""}</span>${content.subtitle23!""}</h4>
                            [#assign hrefTmp = "#"]
                        	[#if content.link23 == "architectureFileLink"]
	                        	[#if content.link23architectureFileLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link23architectureFileLink, "architecture-files")]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
                        	[#elseif content.link23 == "awardLink"]
	                      		[#if content.link23awardLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link23awardLink, "awards")!""]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
                        	[#elseif content.link23 == "newsLink"]
	                      		[#if content.link23newsLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link23newsLink, "news")!""]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
	                      	[#else]
	                      		[#if content.link23externalLink?has_content]
	                        		[#assign hrefTmp = cmsfn.externalLink(content, "link8externalLink")!""]
	                        	[/#if]
                        	[/#if]
                            <a href="${hrefTmp!"#"}"><img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" style="width: 100%; height: 927px;" /></a>
                        </div>
                        <div class="col-md-3 col-info col-premios">
                                <div class="col-vertical">
                                    <h4><span>${content.title24!""}</span>${content.subtitle24!""}</h4>
		                            [#assign hrefTmp = "#"]
		                        	[#if content.link24 == "architectureFileLink"]
			                        	[#if content.link24architectureFileLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link24architectureFileLink, "architecture-files")]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link24 == "awardLink"]
			                      		[#if content.link24awardLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link24awardLink, "awards")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link24 == "newsLink"]
			                      		[#if content.link24newsLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link24newsLink, "news")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
			                      	[#else]
			                      		[#if content.link24externalLink?has_content]
			                        		[#assign hrefTmp = cmsfn.externalLink(content, "link24externalLink")!""]
			                        	[/#if]
		                        	[/#if]
                                    <a href="${hrefTmp!"#"}">
                                        <div class="datos-arquitectos">
                                            <h5 class="inicial">${content.contentInitial24!""}</h5>
                                            <h5 class="arquitecto">${content.contentTitle24!""}</h5>
                                            <p>${cmsfn.decode(content).contentText24!""}</p>
                                        </div>
                                    </a>
                                </div>
                                <div class="">
			                        [#assign imgItemKey = content.image34!""]
									[#if imgItemKey??]
										[#if imgItemKey?has_content]
									 		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "331x445")!]
									 		[#if imgMediaRendition?has_content]
									 			[#assign imageAlternativeText = "imagen de grid de la home"]
									 			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
									 			[#if imageAlt?has_content]
									 				[#assign imageAlternativeText = imageAlt.alternative!""]
									 			[/#if]
									    	[/#if]
										[/#if]
									[/#if]
		                            <h4><span>${content.title34!""}</span>${content.subtitle34!""}</h4>
		                            [#assign hrefTmp = "#"]
		                        	[#if content.link34 == "architectureFileLink"]
			                        	[#if content.link34architectureFileLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link34architectureFileLink, "architecture-files")]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link34 == "awardLink"]
			                      		[#if content.link34awardLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link34awardLink, "awards")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
		                        	[#elseif content.link34 == "newsLink"]
			                      		[#if content.link34newsLink?has_content]
			                        		[#assign node = cmsfn.nodeById(content.link34newsLink, "news")!""]
			                        		[#assign hrefTmp = model.getLink(node)]
			                        	[/#if]
			                      	[#else]
			                      		[#if content.link34externalLink?has_content]
			                        		[#assign hrefTmp = cmsfn.externalLink(content, "link8externalLink")!""]
			                        	[/#if]
		                        	[/#if]
		                            <a href="${hrefTmp!"#"}"><img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" style="width: 100%;" /></a>
                                </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 col-info">
	                        [#assign imgItemKey = content.image41!""]
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
                            <h4><span>${content.title41!""}</span>${content.subtitle41!""}</h4>
                            [#assign hrefTmp = "#"]
                        	[#if content.link41 == "architectureFileLink"]
	                        	[#if content.link41architectureFileLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link41architectureFileLink, "architecture-files")]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
                        	[#elseif content.link41 == "awardLink"]
	                      		[#if content.link41awardLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link41awardLink, "awards")!""]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
                        	[#elseif content.link41 == "newsLink"]
	                      		[#if content.link41newsLink?has_content]
	                        		[#assign node = cmsfn.nodeById(content.link41newsLink, "news")!""]
	                        		[#assign hrefTmp = model.getLink(node)]
	                        	[/#if]
	                      	[#else]
	                      		[#if content.link41externalLink?has_content]
	                        		[#assign hrefTmp = cmsfn.externalLink(content, "link41externalLink")!""]
	                        	[/#if]
                        	[/#if]
                            <a href="${hrefTmp!"#"}"><img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}" style="width: 100%;" /></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>