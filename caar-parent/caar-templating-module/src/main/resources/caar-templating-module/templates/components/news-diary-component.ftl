[#assign news = model.getInstance()!""]
[#assign language = cmsfn.language()!""]
[#assign noticias = model.getImportantNewsList()!""]
	<section class="cmp-noticias-eventos">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3 cmp-noticias">
                    <!-- Aqui va el componente de NOTICIAS estilo footer-->
                    <section class="cmp-noticias-footer">
                    	<div class="row">
                            <div class="col-md-12">
                                <span class="categoria">noticias</span>
                                <div class="noticias-container">
                    
                    				[#list noticias as noticia]
                    			
	                                    <div class="noticias-item">
	                                        <h4 class="title">${news.getHeadline(noticia, language)}</h4>
	                                        <div class="noticias-links">
	                                            <a class="more-link">${i18n['caar-templating-module.templates.components.news-diary-component.read.label']}</a>
	                                            <div class="evento-footer-rrss">
	                                                <a href="#" class="rrss-link">
	                                                    <i class="fa fa-facebook rrss-icon" aria-hidden="true"></i>
	                                                </a>
	                                                <a href="#" class="rrss-link">
	                                                    <i class="fa fa-twitter rrss-icon" aria-hidden="true"></i>
	                                                </a>
	                                                <a href="#" class="rrss-link">
	                                                    <i class="fa fa-pinterest rrss-icon" aria-hidden="true"></i>
	                                                </a>
	                                                <a href="#" class="rrss-link">
	                                                    <i class="fa fa-google-plus rrss-icon" aria-hidden="true"></i>
	                                                </a>
	                                            </div>
	                                        </div>
	                                    </div>
                        
  
                    			    [/#list]
                        
								</div>
                            </div>
                        </div>
                        
                        <div class="ver-todo">
                            <a href="#" class="ver-todo-link">VER TODAS LAS NOTICIAS
                                <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
                            </a>
                        </div>
                    </section>
                </div>
                
                
                <div class="col-md-9 cmp-agenda">
                    <!-- Aqui va el componente de EVENTOS estilo footer-->
                    <section class="cmp-agenda-footer">
                        <div class="row">
                            <div class="col-md-12">
                                <span class="categoria">eventos</span>
                            </div>
                        </div>
                        <div class="row eventos-row">
                            <div class="col-md-3 evento-contenedor">
                                <div class="evento-item">
                                    <a href="#" class="evento-link">
                                        <div class="evento-header">
                                            <span class="categoria">Exposiciones</span>
                                            <span class="evento-fecha">MAR.</span>
                                            <span class="evento-fecha">12.02.2016</span>
                                        </div>
                                        <div class="evento-contenido">
                                            <img class="img-evento" src="../../assets/img/evento-agenda-1.jpg" width="130" height="115" alt="" />
                                            <h4 class="title">Ser lost pre quo</h4>
                                            <span class="more-link" alt="leer más">Leer</span>
                                        </div>
                                    </a>
                                    <div class="evento-footer-rrss">
                                        <a href="#" class="rrss-link" alt="">
                                            <i class="fa fa-facebook rrss-icon" aria-hidden="true"></i>
                                        </a>
                                        <a href="#" class="rrss-link" alt="">
                                            <i class="fa fa-twitter rrss-icon" aria-hidden="true"></i>
                                        </a>
                                        <a href="#" class="rrss-link" alt="">
                                            <i class="fa fa-pinterest rrss-icon" aria-hidden="true"></i>
                                        </a>
                                        <a href="#" class="rrss-link" alt="">
                                            <i class="fa fa-google-plus rrss-icon" aria-hidden="true"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 evento-contenedor">
                                <div class="evento-item">
                                    <a href="#" class="evento-link">
                                        <div class="evento-header">
                                            <span class="categoria">Evento</span>
                                            <span class="evento-fecha">MIE.</span>
                                            <span class="evento-fecha">13.02.2016</span>
                                        </div>
                                        <div class="evento-contenido">
                                            <img class="img-evento" src="../../assets/img/evento-agenda-2.jpg" width="130" height="115" alt="" />
                                            <h4 class="title">Ser lost pre quo</h4>
                                            <span class="more-link" alt="leer más">Leer</span>
                                        </div>
                                    </a>
                                    <div class="evento-footer-rrss">
                                        <a href="#" class="rrss-link" alt="">
                                            <i class="fa fa-facebook rrss-icon" aria-hidden="true"></i>
                                        </a>
                                        <a href="#" class="rrss-link" alt="">
                                            <i class="fa fa-twitter rrss-icon" aria-hidden="true"></i>
                                        </a>
                                        <a href="#" class="rrss-link" alt="">
                                            <i class="fa fa-pinterest rrss-icon" aria-hidden="true"></i>
                                        </a>
                                        <a href="#" class="rrss-link" alt="">
                                            <i class="fa fa-google-plus rrss-icon" aria-hidden="true"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 evento-contenedor">
                                <div class="evento-item">
                                    <a href="#" class="evento-link">
                                        <div class="evento-header">
                                            <span class="categoria">Conferencias</span>
                                            <span class="evento-fecha">JUE.</span>
                                            <span class="evento-fecha">14.02.2016</span>
                                        </div>
                                        <div class="evento-contenido">
                                            <img class="img-evento" src="../../assets/img/evento-agenda-3.jpg" width="130" height="115" alt="" />
                                            <h4 class="title">Ser lost pre quo</h4>
                                            <span class="more-link" alt="leer más">Leer</span>
                                        </div>
                                    </a>
                                    <div class="evento-footer-rrss">
                                        <a href="#" class="rrss-link" alt="">
                                            <i class="fa fa-facebook rrss-icon" aria-hidden="true"></i>
                                        </a>
                                        <a href="#" class="rrss-link" alt="">
                                            <i class="fa fa-twitter rrss-icon" aria-hidden="true"></i>
                                        </a>
                                        <a href="#" class="rrss-link" alt="">
                                            <i class="fa fa-pinterest rrss-icon" aria-hidden="true"></i>
                                        </a>
                                        <a href="#" class="rrss-link" alt="">
                                            <i class="fa fa-google-plus rrss-icon" aria-hidden="true"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 evento-contenedor">
                                <div class="evento-item">
                                    <a href="#" class="evento-link">
                                        <div class="evento-header">
                                            <span class="categoria">Exposición</span>
                                            <span class="evento-fecha">VIE.</span>
                                            <span class="evento-fecha">15.02.2016</span>
                                        </div>
                                        <div class="evento-contenido">
                                            <img class="img-evento" src="../../assets/img/evento-agenda-4.jpg" width="130" height="115" alt="" />
                                            <h4 class="title">Ser lost pre quo</h4>
                                            <span class="more-link" alt="leer más">Leer</span>
                                        </div>
                                    </a>
                                    <div class="evento-footer-rrss">
                                        <a href="#" class="rrss-link" alt="">
                                            <i class="fa fa-facebook rrss-icon" aria-hidden="true"></i>
                                        </a>
                                        <a href="#" class="rrss-link" alt="">
                                            <i class="fa fa-twitter rrss-icon" aria-hidden="true"></i>
                                        </a>
                                        <a href="#" class="rrss-link" alt="">
                                            <i class="fa fa-pinterest rrss-icon" aria-hidden="true"></i>
                                        </a>
                                        <a href="#" class="rrss-link" alt="">
                                            <i class="fa fa-google-plus rrss-icon" aria-hidden="true"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="ver-todo">
                            <a href="#" class="ver-todo-link eventos">VER TODOS LOS EVENTOS
                                <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
                            </a>
                        </div>
                	</div>
                </section>
            </div>
        </div>
    </section>