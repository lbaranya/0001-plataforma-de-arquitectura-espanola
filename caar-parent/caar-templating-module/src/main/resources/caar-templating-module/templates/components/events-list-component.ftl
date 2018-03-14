[#assign loadMoreElement = "<div class='col-md-12 text-center cmp-more'><span  onclick='loadMoreItems()'>${i18n['caar-templating-module.templates.components.news-list-component.loadMore.label']}</span></div>"]

[#assign news = model.getInstance()!""]
[#if news?has_content]
[#assign listEvents = model.getEventsList()]

[#if listEvents?has_content]

[#list listEvents as event]

[/#list]

[/#if]

[/#if]