[#assign loadMoreElement = "<div class='col-md-12 text-center cmp-more'><span  onclick='loadMoreItems()'>${i18n['caar-templating-module.templates.components.news-list-component.loadMore.label']}</span></div>"]

[#assign eventsInstance = model.getInstance()!""]
[#if eventsInstance?has_content]
[#assign listEvents = model.getArchitectureFilesSupportEventList(8)!""]

[#if listEvents?has_content]
	<section class="cmp-last-news">
        <div class="container-margin cmp-pagination-last" last="[#if model.isLastRow() == true]true[#else]false[/#if]">
            <div class="row">
			[#list listEvents as eventsNode]
				<div class="col-md-3 evento-contenedor">
                    <div class="evento-item">
                        [#-- <a href="${cmsfn.link(eventsNode)}" class="evento-link">  --]
                        <a href="${cmsfn.link(navfn.rootPage(content))}" class="evento-link"> 
                            <div class="evento-header">
                                <span class="categoria">${eventsInstance.getEventType(eventsNode)!""}</span>
                                <span class="evento-fecha">${eventsInstance.getStartDayOfWeek(eventsNode)!""}</span>
                                <span class="evento-fecha">${eventsInstance.getPresentationStartDate(eventsNode)!""}</span>
                            </div>
                            <div class="evento-contenido">
                               	[#assign imgItemKey = eventsInstance.getPreviewPhoto(eventsNode)!""]
					            	[#if imgItemKey??]
					            		[#if imgItemKey?has_content]
					                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "206x182")!]
						            		[#if imgMediaRendition?has_content]
						            			[#assign imageAlternativeText = "logo de evento"]
						            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
						            			[#if imageAlt?has_content && imageAlt.alternative?has_content]
						            				[#assign imageAlternativeText = imageAlt.alternative!""]
						            				<img class="img-evento" src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText}" />
						            			[/#if]
					                    	[/#if]
				                    	[/#if]
				                    [/#if]
                                <h4 class="title">${cmsfn.abbreviateString(eventsInstance.getOuvreTitle(eventsNode)!"", 45)!""}</h4>
                                <p>${cmsfn.abbreviateString(eventsInstance.getOuvreAbstract(eventsNode)!"", 183)!""}</p>
                                <span class="more-link">${i18n['caar-templating-module.templates.components.news-diary-component.read.label']}</span>
                            </div>
                        </a>
                    </div>
                </div>
			[/#list]
			</div>
	        [#if model.isLastRow() == false]${loadMoreElement!""}[/#if]
	    </div>
	</section>
[/#if]
<script>
    var ultimo = "false";
    
    function loadMoreItems(){
    
    	var rows = $(".cmp-pagination-last .row").length;
  
        $.ajax({   
            type: "POST",
            url:window.location.href,
            data:{rows:rows},
            success: function(datos){
			
                $('.cmp-last-news').find(".container-margin").append($(datos).find('.cmp-pagination-last').find(".row"));
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

