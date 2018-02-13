[#-- [#include "/mtk/templates/macros/navigation.ftl"]
 
[#assign navigationRootPage = navfn.rootPage(content)!]
 
[@navigation navParentItem=navigationRootPage depth=1 expandAll=true /] --]
[#assign awardsInstance = model.getInstance()!""]

<!--Menu: cmp-menu-->
<section class="cmp-menu">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-12 submenu-container">
                <div class="close close-btn">
                    <img src="${ctx.resourcesURL}/icons/close-icon.svg" width="30" alt="cerrar">
                </div>
                <div class="submenu ae">
                    <ul class="submenu-list">
                        <li class="submenu-link">
                            <a href="${cmsfn.link(cmsfn.contentByPath(content.aboutAE!"/")!"/")!"#"}">${i18n['caar-templating-module.templates.components.header-component.ae.aboutAE.label']!"acerca de A.E."}</a>
                        </li>
                        <li class="submenu-link">
                            <a href="${cmsfn.link(cmsfn.contentByPath(content.newsAE!"/")!"/")!"#"}">${i18n['caar-templating-module.templates.components.header-component.ae.newsAE.label']!"noticias"}</a>
                        </li>
                        <li class="submenu-link">
                            <a href="${cmsfn.link(cmsfn.contentByPath(content.diaryAE!"/")!"/")!"#"}">${i18n['caar-templating-module.templates.components.header-component.ae.diary.label']!"agenda"}</a>
                        </li>
                        <li class="submenu-link">
                            <a href="${cmsfn.link(cmsfn.contentByPath(content.institutionsAE!"/")!"/")!"#"}">${i18n['caar-templating-module.templates.components.header-component.ae.institutions.label']!"instituciones"}</a>
                        </li>
                        <li class="submenu-link">
                            <a href="${cmsfn.link(cmsfn.contentByPath(content.itinerariesAE!"/")!"/")!"#"}">${i18n['caar-templating-module.templates.components.header-component.ae.itineraries.label']!"itinerarios"}</a>
                        </li>
                    </ul>
                </div>
                <div class="submenu explorando">
                    <ul class="submenu-list">
                        <li class="submenu-link">
                            <a href="${cmsfn.link(cmsfn.contentByPath(content.aboutExAr!"/")!"/")!"#"}">${i18n['caar-templating-module.templates.components.header-component.explore.aboutExplore.label']!"acerca de \"explorando arquitectura\""}</a>
                        </li>
                        <li class="submenu-link">
                            <a href="${cmsfn.link(cmsfn.contentByPath(content.newsExAr!"/")!"/")!"#"}">${i18n['caar-templating-module.templates.components.header-component.explore.newsExplore.label']!"noticias"}</a>
                        </li>
                        <li class="submenu-link">
                            <a href="${cmsfn.link(cmsfn.contentByPath(content.highlightsExAr!"/")!"/")!"#"}">${i18n['caar-templating-module.templates.components.header-component.explore.highlightsExplore.label']!"destacados"}</a>
                        </li>
                        <li class="submenu-link">
                            <a href="${cmsfn.link(cmsfn.contentByPath(content.documentaryExAr!"/")!"/")!"#"}">${i18n['caar-templating-module.templates.components.header-component.explore.documentaryExplore.label']!"documental"}</a>
                            <ul class="menu-level3">
                                <li class="level3-item">
                                    <a href="${cmsfn.link(cmsfn.contentByPath(content.excellenceExAr!"/")!"/")!"#"}" class="level3-link">${i18n['caar-templating-module.templates.components.header-component.explore.documentaryExplore.excellence.label']!"excelencia"}</a>
                                </li>
                                <li class="level3-item">
                                    <a href="${cmsfn.link(cmsfn.contentByPath(content.architectsExAr!"/")!"/")!"#"}" class="level3-link">${i18n['caar-templating-module.templates.components.header-component.explore.documentaryExplore.architects.label']!"arquitectos"}</a>
                                </li>
                                <li class="level3-item">
                                    <a href="${cmsfn.link(cmsfn.contentByPath(content.ouvresExAr!"/")!"/")!"#"}" class="level3-link">${i18n['caar-templating-module.templates.components.header-component.explore.documentaryExplore.ouvresAwards.label']!"obras y premios"}</a>
                                </li>
                                <li class="level3-item">
                                    <a href="${cmsfn.link(cmsfn.contentByPath(content.thoughtsExAr!"/")!"/")!"#"}" class="level3-link">${i18n['caar-templating-module.templates.components.header-component.explore.documentaryExplore.reviews.label']!"pensamientos, crítica e investigación"}</a>
                                </li>
                                <li class="level3-item">
                                    <a href="${cmsfn.link(cmsfn.contentByPath(content.institutionsExAr!"/")!"/")!"#"}" class="level3-link">${i18n['caar-templating-module.templates.components.header-component.explore.documentaryExplore.institutions.label']!"instituciones y fondos"}</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div class="submenu bienales">
                    <ul class="submenu-list">
                        <li class="submenu-link">
                            <a href="${cmsfn.link(cmsfn.contentByPath(content.aboutBA!"/")!"/")!"#"}">${i18n['caar-templating-module.templates.components.header-component.biennals.abountBiennials.label']!"acerca de \"bienales y premios\""}</a>
                        </li>
                        <li class="submenu-link">
                            <a href="${cmsfn.link(cmsfn.contentByPath(content.newsBA!"/")!"/")!"#"}">${i18n['caar-templating-module.templates.components.header-component.biennals.newsBiennials.label']!"noticias"}</a>
                        </li>
                        <li class="submenu-link">
                            <a href="${cmsfn.link(cmsfn.contentByPath(content.biennialsBA!"/")!"/")!"#"}">${i18n['caar-templating-module.templates.components.header-component.biennals.biennials.label']!"bienales"}</a>
                            <ul class="menu-level3">
                            	[#assign biennialsList = model.getBiennialsList()!]
                            	[#list biennialsList as biennialNode]
	                                <li class="level3-item">
	                                    <a href="${cmsfn.link(biennialNode)!"#"}" class="level3-link">${awardsInstance.getAwardName(biennialNode)!""}</a>
	                                </li>
                                [/#list]
                            </ul>
                        </li>
                        <li class="submenu-link">
                            <a href="${cmsfn.link(cmsfn.contentByPath(content.awardsBA!"/")!"/")!"#"}">${i18n['caar-templating-module.templates.components.header-component.biennals.awards.label']!"premios"}</a>
                            <ul class="menu-level3">
                            	[#assign awardsList = model.getAwardsList()!]
                            	[#list awardsList as awardNode]
	                                <li class="level3-item">
                                    <a href="${cmsfn.link(awardNode)!"#"}" class="level3-link">${awardsInstance.getAwardName(awardNode)!""}</a>
                                	</li>
                                [/#list]
                            </ul>
                        </li>
                    </ul>
                </div>
                [#assign currentLangEn = cmsfn.isCurrentLocale('en')]
                [#if currentLangEn]
                
                	<div class="submenu search">
	                    <div class="search-container">
	                    	[#-- [#assign search_icon_blanco = cmsfn.contentByPath("/caar-theme/icons/", "resources")!""]
	                    	[#assign iconLink = imgfn.getImageVariationLinkFromBinary(search_icon_blanco, "original")!""] --]
	                        <img class="form-search-icon" src="${ctx.resourcesURL}/icons/search-icon-blanco.svg">
	                        <form class="form-search">
	                            <input class="search-input" type="search" placeholder="Write your search here">
	                        </form>
	                    </div>
	                    <div class="search-filter-container">
	                        <div class="search-for">
	                            <span class="form-title">Search for:</span>
	                            <form class="search-for-form">
	                                <ul>
	                                    <li class="form-title checkbox">
	                                        <input type="checkbox" name="checkbox" value="check" id="todo">
	                                        <label for="todo" class="radio-label">all</label>
	                                    </li>
	                                    <li class="form-title checkbox">
	                                        <input type="checkbox" name="checkbox" value="check" id="autor">
	                                        <label for="autor" class="radio-label">author</label>
	                                    </li>
	                                    <li class="form-title checkbox">
	                                        <input type="checkbox" name="checkbox" value="check" id="arquitecto">
	                                        <label for="arquitecto" class="radio-label">architect</label>
	                                    </li>
	                                    <li class="form-title checkbox">
	                                        <input type="checkbox" name="checkbox" value="check" id="obra">
	                                        <label for="obra" class="radio-label">ouvre / project</label>
	                                    </li>
	                                </ul>
	                            </form>
	                        </div>
	                        <div class="filter">
	                            <span class="form-title">Filter:</span>
	                            <form class="filter-form">
	                                <div class="form-container">
	                                    <div class="checkbox">
	                                        <input type="checkbox" name="checkbox" value="check" id="explorar_arquitectura">
	                                        <label for="explorar_arquitectura" class="radio-label form-title">exploring architecture</label>
	                                    </div>
	                                    <ul class="form-list">
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="documental">
	                                            <label for="documental" class="radio-label small-label">documental</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="arquitectos">
	                                            <label for="arquitectos" class="radio-label small-label">architects</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="obrasyproyectos">
	                                            <label for="obrasyproyectos" class="radio-label small-label">ouvres and projects</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="pensamientoycritica">
	                                            <label for="pensamientoycritica" class="radio-label small-label">thoughts and reviews</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="instituciones">
	                                            <label for="instituciones" class="radio-label small-label">institutions and founds</label>
	                                        </li>
	                                    </ul>
	                                </div>
	                                <div class="form-container">
	                                    <div class="checkbox">
	                                        <input type="checkbox" name="checkbox" value="check" id="bienales_premios">
	                                        <label for="bienales_premios" class="radio-label form-title">biennials and awards</label>
	                                    </div>
	                                    <ul class="form-list">
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="beau">
	                                            <label for="beau" class="radio-label small-label">BEAU</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="biau">
	                                            <label for="biau" class="radio-label small-label">BIAU</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="biennale">
	                                            <label for="biennale" class="radio-label small-label">Biennale</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="premio_nacional">
	                                            <label for="premio_nacional" class="radio-label small-label">National Award</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="premio_mies">
	                                            <label for="premio_mies" class="radio-label small-label">Mies van der Rohe Award</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="premio_eduardo">
	                                            <label for="premio_eduardo" class="radio-label small-label">Eduardo Torroja Award</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="premio_arquia_proxima">
	                                            <label for="premio_arquia_proxima" class="radio-label small-label">Arquia Próxima Award</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="premio_arquia-tesis">
	                                            <label for="premio_arquia-tesis" class="radio-label small-label">Arquia Tesis Award</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="premio_europan">
	                                            <label for="premio_europan" class="radio-label small-label">Europan</label>
	                                        </li>
	                                    </ul>
	                                </div>
	                            </form>
	
	                        </div>
	
	                    </div>
	                </div>
                
	                <div class="submenu signin">
	                    <div class="registro">
	                        <form class="form-registro">
	                            <input type="text" class="sign-in-input" placeholder="user" name="uname" required>
	                            <input type="text" class="sign-in-input" placeholder="password" name="uname" required>
	                            <button type="submit" class="sign-in-btn">enter</button>
	                        </form>
	                        <div class="registro-nuevo">
	                            <p class="registro-texto">
	                                Still not registered?
	                                <br> Sign up
	                                <a href="#" class="registro-link" alt="registro">here</a>
	                            </p>
	                        </div>
	                    </div>
	                </div>
	                
                [#else]
                
                	<div class="submenu search">
	                    <div class="search-container">
	                    	[#-- [#assign search_icon_blanco = cmsfn.contentByPath("/caar-theme/icons/", "resources")!""]
	                    	[#assign iconLink = imgfn.getImageVariationLinkFromBinary(search_icon_blanco, "original")!""] --]
	                        <img class="form-search-icon" src="${ctx.resourcesURL}/icons/search-icon-blanco.svg">
	                        <form class="form-search">
	                            <input class="search-input" type="search" placeholder="Escribe aquí tu búsqueda">
	                        </form>
	                    </div>
	                    <div class="search-filter-container">
	                        <div class="search-for">
	                            <span class="form-title">Buscar por:</span>
	                            <form class="search-for-form">
	                                <ul>
	                                    <li class="form-title checkbox">
	                                        <input type="checkbox" name="checkbox" value="check" id="todo">
	                                        <label for="todo" class="radio-label">todo</label>
	                                    </li>
	                                    <li class="form-title checkbox">
	                                        <input type="checkbox" name="checkbox" value="check" id="autor">
	                                        <label for="autor" class="radio-label">autor</label>
	                                    </li>
	                                    <li class="form-title checkbox">
	                                        <input type="checkbox" name="checkbox" value="check" id="arquitecto">
	                                        <label for="arquitecto" class="radio-label">arquitecto</label>
	                                    </li>
	                                    <li class="form-title checkbox">
	                                        <input type="checkbox" name="checkbox" value="check" id="obra">
	                                        <label for="obra" class="radio-label">obra / proyecto</label>
	                                    </li>
	                                </ul>
	                            </form>
	                        </div>
	                        <div class="filter">
	                            <span class="form-title">Filtro:</span>
	                            <form class="filter-form">
	                                <div class="form-container">
	                                    <div class="checkbox">
	                                        <input type="checkbox" name="checkbox" value="check" id="explorar_arquitectura">
	                                        <label for="explorar_arquitectura" class="radio-label form-title">explorar arquitectura</label>
	                                    </div>
	                                    <ul class="form-list">
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="documental">
	                                            <label for="documental" class="radio-label small-label">documental</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="arquitectos">
	                                            <label for="arquitectos" class="radio-label small-label">arquitectos</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="obrasyproyectos">
	                                            <label for="obrasyproyectos" class="radio-label small-label">obras y proyectos</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="pensamientoycritica">
	                                            <label for="pensamientoycritica" class="radio-label small-label">pensamiento y crítica</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="instituciones">
	                                            <label for="instituciones" class="radio-label small-label">instituciones y fondos</label>
	                                        </li>
	                                    </ul>
	                                </div>
	                                <div class="form-container">
	                                    <div class="checkbox">
	                                        <input type="checkbox" name="checkbox" value="check" id="bienales_premios">
	                                        <label for="bienales_premios" class="radio-label form-title">bienales y premios</label>
	                                    </div>
	                                    <ul class="form-list">
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="beau">
	                                            <label for="beau" class="radio-label small-label">BEAU</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="biau">
	                                            <label for="biau" class="radio-label small-label">BIAU</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="biennale">
	                                            <label for="biennale" class="radio-label small-label">Biennale</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="premio_nacional">
	                                            <label for="premio_nacional" class="radio-label small-label">Premio Nacional</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="premio_mies">
	                                            <label for="premio_mies" class="radio-label small-label">Premio Mies van der Rohe</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="premio_eduardo">
	                                            <label for="premio_eduardo" class="radio-label small-label">Premio Eduardo Torroja</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="premio_arquia_proxima">
	                                            <label for="premio_arquia_proxima" class="radio-label small-label">Premio Arquia Próxima</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="premio_arquia-tesis">
	                                            <label for="premio_arquia-tesis" class="radio-label small-label">Premio Arquia Tesis</label>
	                                        </li>
	                                        <li class="search-form-item checkbox">
	                                            <input type="checkbox" name="" id="premio_europan">
	                                            <label for="premio_europan" class="radio-label small-label">Europan</label>
	                                        </li>
	                                    </ul>
	                                </div>
	                            </form>
	
	                        </div>
	
	                    </div>
	                </div>
                
	                <div class="submenu signin">
	                    <div class="registro">
	                        <form class="form-registro">
	                            <input type="text" class="sign-in-input" placeholder="usuario" name="uname" required>
	                            <input type="text" class="sign-in-input" placeholder="contraseña" name="uname" required>
	                            <button type="submit" class="sign-in-btn">entrar</button>
	                        </form>
	                        <div class="registro-nuevo">
	                            <p class="registro-texto">
	                                ¿Todavía no estás registrado?
	                                <br> Regístrate
	                                <a href="#" class="registro-link" alt="registro">aquí</a>
	                            </p>
	                        </div>
	                    </div>
	                </div>	
                [/#if]
            </div>

        </div>
        <div class="row menu-row">
            <div class="main-container">
                <div class="col-sm-7 col-menu-list">
                    <ul class="menu-list">
                    	[#assign homeName = cmsfn.page(content)]
                    	[#if !state.currentURI?contains(homeName+".html")]
                    	<li class="menu-item arrow">
                                <a href="${cmsfn.link(navfn.rootPage(content))!"#"}" class="menu-home"><i class="fa fa-arrow-left"></i></a>
                            </li>
                        [/#if]
                        <li class="menu-item">
                            <a href="#" data-submenu="ae" class="logo" alt="arquitectura_española_logotipo" title="arquitectura_española_logotipo">${i18n['caar-templating-module.templates.components.header-component.ae.label']!"A.E."}</a>
                        </li>
                        <li class="menu-item">
                            <a href="#" data-submenu="explorando" class="menu-link" alt="explorando_arquitectura" title="explorando_arquitectura">${i18n['caar-templating-module.templates.components.header-component.exploreArchitecture.label']!"explorando arquitectura"}</a>
                        </li>
                        <li class="menu-item">
                            <a href="#" data-submenu="bienales" class="menu-link" alt="bienales_premios" title="bienales_premios">${i18n['caar-templating-module.templates.components.header-component.biennialsAndAwards.label']!"bienales y premios"}</a>
                        </li>
                    </ul>
                </div>
                <div class="col-sm-3 col-menu-logos">
                    <ul class="menu-logos">
                    [#if content.elements?has_content]
                    [#list cmsfn.children(content.elements) as element]
                        <li class="menu-item-logo">
                        	[#assign hrefLink = "#"]
                        	[#if element.linkexternalLink??]
								[#assign hrefLink = cmsfn.externalLink(element, "linkexternalLink")]                        		
                        	[/#if]
                        	[#if element.linkinternalLink??]
                        		[#assign hrefLink = cmsfn.link(cmsfn.contentById(element.linkinternalLink, "website"))]
                        	[/#if]
                            <a href="${hrefLink!""}" class="">
                            	[#assign image = damfn.getAssetLink(element.image)!]
                            	[#assign imageAlternativeText = ""]
                    			[#assign imageAlt = cmsfn.contentByPath(damfn.getAsset(element.image!"").getPath(),"dam")!]
                    			[#if imageAlt?has_content]
                    				[#assign imageAlternativeText = imageAlt.alternative!""]
                    			[/#if]
                                <img src="${image}" alt="${imageAlternativeText!""}">
                            </a>
                        </li>
                    [/#list]
                    [/#if]
                    </ul>
                </div>
                <div class="col-sm-2 col-menu-idioma">
                    [#-- Build language navigation. --]
					[#assign localizedLinks = cmsfn.localizedLinks()!]
					[#if localizedLinks?has_content]
					   [#assign languages = localizedLinks?keys]
					   <ul class="menu-idioma">
					      [#list languages as lang]
					      [#assign current = cmsfn.isCurrentLocale(lang)]
					      [#-- Use "compress" to put "li" and "a" on one line to prevent white spaces. --]
					      <li class="menu-item-idioma">[@compress single_line=true]
					         [#-- Current locale should not be linked. --]
					         [#assign currentLang = ""]
					         [#if !current]
					         	[#assign currentLang = lang]
					         	<a id="currentLanguage" href="${localizedLinks[lang]!'#'}">${lang!}</a>
					         [#elseif current]
					         	<a>${lang!}</a>					         
					         [/#if]
					         
					         <input type="hidden" id="contextPathInput" value="${contextPath!}" />
					         <input type="hidden" id="currentLanguageInput" value="${currentLang!}" />
					         
					      [/@compress]</li>
					      [/#list]
					   </ul>
					[/#if]
                    <ul class="menu-icons">
                        <li class="menu-item-icon menu-link">
                            <a href="#" class="icon-link" data-submenu="signin" alt="registro" title="registro">
                                <img class="user-icon" src="${ctx.resourcesURL}/icons/usuario-icon.svg">
                            </a>

                        </li>
                        <li class="menu-item-icon menu-link">
                                <a href="#" class="icon-link" data-submenu="search" alt="buscador" title="buscador">
                            <img class="search-icon" src="${ctx.resourcesURL}/icons/search-icon.svg">
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>