[#assign loadMoreElement = "<div class='col-md-12 text-center cmp-more'><span  onclick='loadMoreItems()'>${i18n['caar-templating-module.templates.components.news-list-component.loadMore.label']}</span></div>"]

[#assign events = model.getInstance()!""]
[#if events?has_content]
[#assign listEvents = model.getArchitectureFilesSupportEventList()]

[#if listEvents?has_content]

[#list listEvents as event]

[/#list]

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

