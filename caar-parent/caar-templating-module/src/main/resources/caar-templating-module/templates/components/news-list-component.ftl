[#assign loadMoreElement = "<div class='col-md-12 text-center cmp-more'><span  onclick='loadMoreItems()'>${i18n['caar-templating-module.templates.components.news-list-component.loadMore.label']}</span></div>"]

[#assign news = model.getInstance()!""]
[#if content.categories?has_content]
	[#assign listNews = model.getCategorizedNewsList(content.categories, 8)]
[#else]
	[#assign listNews = model.getNewsList(8)]
[/#if]
[#if listNews?has_content]
	<section class="cmp-last-news">
        <div class="container cmp-pagination-last" last="[#if model.isLastRowOfNews() == true]true[#else]false[/#if]">
            <div class="row">
				[#list listNews as newNode]
	                <div class="col-md-3 col-sm-6 col-xs-12">
	                    <div class="noticias-container">
	                        <div class="noticias-item">
	                            <div class="container-destacado">
		                        	[#assign imgItemKey = news.getImage(newNode)]
		                        	[#if imgItemKey??]
		                        		[#if imgItemKey?has_content]
			                        		[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "414w")!]
			                        		[#if imgMediaRendition?has_content]
			                        			[#assign imageAlternativeText = "imagen de cabecera de la noticia"]
			                        			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
			                        			[#if imageAlt?has_content]
			                        				[#assign imageAlternativeText = imageAlt.alternative!""]
			                        			[/#if]
			                            		<img class="imagen-destacada" src='${imgMediaRendition.getLink()}" alt="${imageAlternativeText!""}' />
			                            	[/#if]
		                            	[/#if]
		                            [/#if]
	                        	</div>
	                        	[#assign headLine = news.getHeadline(newNode)!""]
	                        	[#assign description = news.getDescription(newNode)!""]
	                        	[#assign headLineTruncated = cmsfn.abbreviateString(headLine, 80)!""]
	                            <h4 class="title">${headLineTruncated!""}</h4>
	                            <div class="info">
	                            	[#assign descriptionTruncated = cmsfn.abbreviateString(description, 401)!""]
	                            	<p>${descriptionTruncated!""}</p>
	                            </div>
	                            <div class="noticias-links">
			                    	<a href='${cmsfn.link(newNode)!"#"}'><span class="more-link"> ${i18n['caar-templating-module.templates.components.news-list-component.information.label']}</span></a>
				                </div>
		                    </div>
		                </div>
		            </div>
            	[/#list]
	        </div>
	        [#if model.isLastRowOfNews() == false]${loadMoreElement!""}[/#if]
	    </div>
	</section>
	<script>
    var ultimo = "false";
    
    function loadMoreItems(){
    
    	var rows = $(".cmp-pagination-last .row").length;
  
        $.ajax({   
            type: "POST",
            url:window.location.href,
            data:{rows:rows},
            success: function(datos){
			
                $('.cmp-last-news').find(".container").append($(datos).find('.cmp-pagination-last').find(".row"));
                $('.cmp-more').remove();
                ultimo = $(datos).find('.cmp-pagination-last').attr("last");
                if (ultimo == "true") {
                    $('.cmp-more').remove();
                } else {
                    var cmp_more = "${loadMoreElement!""}";
                    $('.cmp-more').remove();
                    $('.cmp-last-news').find(".container").append(cmp_more);
                }
            }
        });
    }
	</script>
[/#if]