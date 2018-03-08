[#assign loadMoreElement = "<div class='col-md-12 text-center cmp-more'><span  onclick='loadMoreItems()'>${i18n['caar-templating-module.templates.components.architecture-files-support-architects-list-component.loadMore.label']}</span></div>"]
[#assign architectsInstance = model.getInstance()!""]
[#assign highlightedArchitectsList = model.getHighlightedArchitectsList(2)!""]
[#assign architectsList = model.getArchitectsListAfterHighlighted(4,2)!""]
[#assign imageBackground = "#"]
[#assign imgItemKey = content.headerImage!]
[#if imgItemKey??]
	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "1440w")!]
	[#if imgMediaRendition?has_content]
		[#assign imageBackground = imgMediaRendition.getLink()!]
	[/#if]
[/#if]
<section class="cmp-arquitecto">
    <div class="container-fluid cmp-header-arqui" style="background-image: url('${imageBackground!""}')">
        <div class="container">
            <div class="row">
                <div class="header">
                    <div class="sub-title">${content.title!""}</div>
                    <div class="title-big">
                        ${content.headerText!""}
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="cmp-arquitecto">
    <div class="container cmp-arquitecto-header">
        <div class="row">
            <h2>${content.title!""}</h2>
        </div>
    </div>
</section>

[#if highlightedArchitectsList?has_content]

	<section class="cmp-arquitecto">
		<div class="container cmp-arquitecto-ultimos">
	        <div class="row">
	            <div class="col-md-12">
	                <div class="sub-title-arqui">${i18n['caar-templating-module.templates.components.architecture-files-support-architects-list-component.last-profiles.label']}</div>
	            </div>
	            
	            [#list highlightedArchitectsList as architect]
	            	[#assign fullName = architectsInstance.getFullName(architect)]
	            
		            <div class="col-md-6 ult-arqui">
		                <div class="nom-arqui">${fullName!""}</div>
		                <div class="arqui-img-text">
		                    [#assign imgItemKey = architectsInstance.getPhoto(architect)!""]
			            	[#if imgItemKey??]
		                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "556x445")!]
			            		[#if imgMediaRendition??]
			            			[#assign imageAlternativeText = "arquitecto"]
			            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
			            			[#if imageAlt?has_content]
			            				[#assign imageAlternativeText = imageAlt.alternative!""]
			            			[/#if]
		                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText}" />
		                    	[/#if]
		                    [/#if]
		                    <div class="texto-hover"><h2>${fullName!""}</h2></div>
		                </div>
		            </div>
		            
	            [/#list]
		            
	        </div>
	    </div>
	</section>
	
[/#if]
[#if architectsList?has_content]
	
	<section class="cmp-arquitecto cmp-last-arquitects">
	    <div class="container cmp-todos-arqui cmp-pagination-last" last="[#if model.isLastRowOfArchitects() == true]true[#else]false[/#if]">
	        <div class="row">
	            <div class="col-md-12">
	                <div class="sub-title-arqui">${i18n['caar-templating-module.templates.components.architecture-files-support-architects-list-component.all-profiles.label']}</div>
	            </div>
	            
	            
            	[#list architectsList as architect]
            		[#assign fullName = architectsInstance.getFullName(architect)]
            
		            <div class="col-md-3 container-arqui">
		                <div class="nom-arqui">${fullName!""}</div>
		                <div class="arqui-img-text">
		                    [#assign imgItemKey = architectsInstance.getPhoto(architect)!""]
			            	[#if imgItemKey??]
		                    	[#assign imgMediaRendition = damfn.getRendition(imgItemKey, "261x350")!]
			            		[#if imgMediaRendition??]
			            			[#assign imageAlternativeText = "arquitecto"]
			            			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(imgItemKey!"").getPath(),"dam")!]
			            			[#if imageAlt?has_content]
			            				[#assign imageAlternativeText = imageAlt.alternative!""]
			            			[/#if]
		                    		<img src="${imgMediaRendition.getLink()}" alt="${imageAlternativeText}" />
		                    	[/#if]
		                    [/#if]
	                    <div class="texto-hover"><h2>${fullName!""}</h2></div>
		                </div>
		            </div>
	            
            	[/#list]
            	
	        </div>
	        [#if model.isLastRowOfArchitects() == false]${loadMoreElement!""}[/#if]
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
				
	                $('.cmp-last-arquitects').find(".container").append($(datos).find('.cmp-pagination-last').find(".row"));
	                $('.cmp-more').remove();
	                ultimo = $(datos).find('.cmp-pagination-last').attr("last");
	                if (ultimo == "true") {
	                    $('.cmp-more').remove();
	                } else {
	                    var cmp_more = "${loadMoreElement!""}";
	                $('.cmp-more').remove();
	                $('.cmp-last-arquitects').find(".container").append(cmp_more);
	            }
	        }
	    });
	}
	</script>
[/#if]