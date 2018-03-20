[#assign nodeJcrPath = ctx.getParameter('path')!?html]
[#if nodeJcrPath?has_content]
	[#assign eventsContent = cmsfn.contentByPath(nodeJcrPath, "awards")]
	[#assign eventsContentNode = cmsfn.asJCRNode(eventsContent)]
	[#assign events = model.parent.getInstance()!""]
	[#-- [@cms.component content=content template="submenu-award" /] --]
	[#--  [#include "submenu-award.ftl"]--]
	[#assign awardContentNode = cmsfn.asJCRNode(cmsfn.parent(eventsContent, "mgnl:award"))!""]
	[@cms.area name="breadcrumb" contextAttributes={"contentNode", eventsContentNode}/]
	[@cms.area name="submenu-award" contextAttributes={"currentAward":awardContentNode} /]
	[@cms.area name="subheader" contextAttributes={"nodeName": events.getTitle(eventsContentNode)}/]
	<section class="cmp-programa-directo">
        <div class="container">
            <div class="row">
                <div>
                    <iframe src="${events.getStreamingLink(eventsContentNode)!"#"}" frameborder="0" allowfullscreen></iframe>
                </div>
            </div>
        </div>
    </section>
    <section class="cmp-programa-directo-rrss">
        <div class="container">
            <div class="row">
                <div class="col-md-12 title">
                    <h3>${i18n['caar-templating-module.templates.cpages-award-live-event.followUs.label']}</h3>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-rrss">
                    <div class="container-rrss" align="center">
                        <iframe src="https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2F${events.getFacebookUser(eventsContentNode)!""}%2F&tabs=timeline&width=340&height=500&small_header=true&adapt_container_width=true&hide_cover=true&show_facepile=false&appId" width="340" height="500" style="border:none;overflow:hidden" scrolling="no" frameborder="0" allowTransparency="true"></iframe>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="container-rrss" align="center">
                        <a class="twitter-timeline" data-width="400" data-height="500" href="https://twitter.com/${events.getTwitterUser(eventsContentNode)!""}?ref_src=twsrc%5Etfw">Tweets by ${events.getTwitterUser(eventsContentNode)!""}</a> <script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
                    </div>
                </div>
            </div>
        </div>
    </section>
[#else]
	[@cms.area name="breadcrumb" /]
	[@cms.area name="submenu-award" /]
	[@cms.area name="subheader" /]
[/#if]

