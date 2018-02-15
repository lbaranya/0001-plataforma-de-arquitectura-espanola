var booleanmouse = true;
var scroll;

$(document).ready(function () {

	adaptCurrentURLToNewLanguage();

	// Resources URL
	var resourcesURL = $("#resources").val();
	// Icons URL
	var iconsURL = resourcesURL + "/icons/";
	/**Banner-header**/

	$('.cmp-banner-header').mouseover(function () {
		if (booleanmouse) {
			banneraletario();
			booleanmouse = false;
		}
	});

	$('.cmp-banner-header').mouseleave(function () {
		booleanmouse = true;
	});

	/**Termina Banner-header**/

	/**Posición del scroll para hacerlo fijo**/
	$(window).scroll(function () {

		scroll = document.documentElement.scrollTop || document.body.scrollTop;

		var limit = 100;
		var heightpage = $(window).height();

		if(heightpage >1100){
			if ($(".cmp-exist-home").length) {
				limit = 400;
			}
			if (scroll > limit) {
				//Si hacemos un cambio de estructura respectarlo

				$(".cmp-menu").addClass("fixed-menu");

			} else {

				$(".cmp-menu").removeClass("fixed-menu");

			}
		}

	});
	/**Termina posición del scroll**/

	/**Enventos del menu**/

	$('.menu-link').on('click', function (e) {
		e.preventDefault();

		var comprobacion = $(this).hasClass("active-item");

		if (comprobacion != true) {

			var datamenu = $(this).attr('data-submenu');
			//Compruebo si cmp-exist-home existe
			if ($(".cmp-exist-home").length) {
				$('.submenu-container').removeClass('clicked');
				$('.submenu-container').addClass('clicked');
			} else {
				$('.submenu-container').removeClass("clicked-nh");
				$('.submenu-container').addClass("clicked-nh");
			}

			$('.submenu').css('display', 'none');
			$('.menu-link').removeClass('active-item');
			$('.menu-item-icon').removeClass('active-item');
			$('.logo').removeClass('active-item');
			$('.search-icon').attr('src', iconsURL + 'search-icon.svg');
			$('.user-icon').attr('src', iconsURL + 'usuario-icon.svg');

			if ($(this).hasClass('menu-item-icon')) {
				datamenu = $(this)
				.find('.icon-link')
				.attr('data-submenu');
			}

			if (datamenu != 'search') {
				$('.' + datamenu).css('display', 'flex');

				if (datamenu == 'signin') {
					$(this)
					.find('.user-icon')
					.attr('src', iconsURL + 'usuario-icon-blanco.svg');
					$('.search-icon').attr('src', iconsURL + 'search-icon.svg');
					$('.menu-item-icon').removeClass('active-item');
					$(this).addClass('active-item');
				} else {
					$('.menu-link').removeClass('active-item');
					$(this).addClass('active-item');
				}
			} else {
				$('.' + datamenu).css('display', 'block');
				$(this)
				.find('.search-icon')
				.attr('src', iconsURL + 'search-icon-blanco.svg');
				$('.user-icon').attr('src', iconsURL + 'usuario-icon.svg');
				$('.menu-item-icon').removeClass('active-item');
				$(this).addClass('active-item');
			}
			$('html, body').animate({
				scrollTop: 0
			},
			600
			);

			$('.cmp-menu').removeClass('fixed-menu');
		} else {
			$('.submenu').css('display', 'none');
			$('.menu-link').removeClass('active-item');
			$('.menu-item-icon').removeClass('active-item');
			$('.logo').removeClass('active-item');
			$('.submenu-container').removeClass('clicked');
			$('.submenu-container').removeClass('clicked-nh');
			$('.search-icon').attr('src', iconsURL + 'search-icon.svg');
			$('.user-icon').attr('src', iconsURL + 'usuario-icon.svg');
		}
	});

	$('.logo').on('click', function (e) {
		var comprobacion = $(this).hasClass("active-item");
		if (comprobacion != true) {
			var datamenu = $(this).attr('data-submenu');
			//Compruebo si cmp-exist-home existe
			if ($(".cmp-exist-home").length) {
				$('.submenu-container').removeClass('clicked');
				$('.submenu-container').addClass('clicked');
			} else {
				$('.submenu-container').removeClass("clicked-nh");
				$('.submenu-container').addClass("clicked-nh");
			}
			$('.submenu').css('display', 'none');
			$('.' + datamenu).css('display', 'flex');
			$('.menu-link').removeClass('active-item');
			$(this).addClass('active-item');
		} else {
			$('.submenu').css('display', 'none');
			$('.menu-link').removeClass('active-item');
			$('.menu-item-icon').removeClass('active-item');
			$('.logo').removeClass('active-item');
			$('.submenu-container').removeClass('clicked');
			$('.submenu-container').removeClass('clicked-nh');
			$('.search-icon').attr('src', iconsURL + 'search-icon.svg');
			$('.user-icon').attr('src', iconsURL + 'usuario-icon.svg');
		}
	});

	$('.close-btn').on('click', function (e) {
		e.preventDefault();
		$('.submenu-container').removeClass("clicked");
		$('.submenu-container').removeClass('clicked-nh');
		$(".menu-link").removeClass("active-item");
		$('.logo').removeClass("active-item");
		$('.search-icon').attr('src', iconsURL + 'search-icon.svg');
		$(".menu-item-icon").removeClass('active-item');

		$('.user-icon').attr('src', iconsURL + 'usuario-icon.svg');
		$(".menu-item-icon").removeClass('active-item');
	});

	/**Termina eventos del menu**/

	/**Función para cambiar icono de acordeon**/
	$('.panel-heading.close-acordeon .panel-title').on('click', function(e) {
		e.preventDefault();


		if (
				$(this)
				.find('.icon i')
				.hasClass('fa-chevron-up')
		) {
			$('.panel-heading')
			.find('.panel-title')
			.find('.icon i')
			.removeClass('fa-chevron-up');
			$('.panel-heading')
			.find('.panel-title')
			.find('.icon i')
			.addClass('fa-chevron-down');
			$(this)
			.find('.icon i')
			.addClass('fa-chevron-down');
			$(this)
			.find('.icon i')
			.removeClass('fa-chevron-up');

		} else {
			$('.panel-heading')
			.find('.panel-title')
			.find('.icon i')
			.removeClass('fa-chevron-up');
			$('.panel-heading')
			.find('.panel-title')
			.find('.icon i')
			.addClass('fa-chevron-down');
			$(this)
			.find('.icon i')
			.removeClass('fa-chevron-down');
			$(this)
			.find('.icon i')
			.addClass('fa-chevron-up');

		}
	});
	/**Termina icono de acordeon**/

	/**Funcion para cerrar politica de cookies**/
	$(function() {
		var visit=GetCookie("cookies_surestao");
		if (visit==1){ 
			popboxCookies(false);
		}else {
			popboxCookies(true);
		}
	});

	$('.aceptar-btn').click(function() {
		accept_cookies();
	});
	/**Termina funcion politica de cookies**/

	/* COMPONENTE DE SECCIONES / SUSTITUTO DE ACORDEON -> COMPORTAMIENTO */

	$('.anchor-distribuidor').click(function(event) {
		event.preventDefault();
		$(".cmp-distribuidor-general-content").hide();
		var strAncla = $(this).attr('href');
		$(strAncla).show();
		$('html, body').stop(true, true).animate({
			scrollTop: $(strAncla).offset().top
		}, 500);
	});

	$(".cmp-distribuidor-convocatoria .cmp-volver").click(function(e) {
		$(".cmp-distribuidor-general-content").fadeOut();
		var parentPosition = $(".cmp-distribuidor-convocatoria").position();
		$('html,body').animate({
			scrollTop: parentPosition.top - 50
		}, 500);

		$('html,body').animate({
			scrollTop: parentPosition.top - 50
		}, {
			duration: 500
		});


	});

	$.fn.scrollBottom = function() {
		return -(window.innerHeight + this.scrollTop()); 
	};

	$(window).scroll(function () {

		var scrollbottom = $(window).scrollBottom();

		var heightfooter = $(".cmp-footer").height();
		if(scrollbottom < -($(document).height()-heightfooter)+53){
			$(".cmp-volver").css("color","#fff");
		}else{
			$(".cmp-volver").css("color","#D0021B");
		}

	});


	/**Menú de Convocatoria**/
	//Activar Menu
	$(".col-header h3").on("click", function (e) {
		$(this).find("i").toggleClass("fa-chevron-down , fa-chevron-right");
		var data_menu = $(this).attr("data-ref");
		$(".menu-second").removeClass("active-menu-item");
		$(".menu-third").removeClass("active-menu-item");
		$(".menu-first").removeClass("active");
		$(".menu-first").attr("data-active", "false");
		$(".menu-second-item").removeClass("active");
		$(".menu-second-item").attr("data-active", "false");
		$(".submenu-convocatoria").toggleClass("active-menu");
	});
	//Activar submenu *Menu-First*
	$(".menu-first").on("click", function (e) {

		var activo = $(this).attr("data-active");
		if (activo != "true") {
			/**Reseteo de menu**/
			$(".menu-second").removeClass("active-menu-item");
			$(".menu-third").removeClass("active-menu-item");
			$(".menu-second-item").removeClass("active");
			$(".menu-second-item").attr("data-active", "false");
			/**Termina el reseteo del menu**/

			/**Desactiva los anteriores items activos**/
			$(".menu-first").attr("data-active", "false");
			$(".menu-first").removeClass("active");
			$(".menu-first").find(".menu-second").removeClass("active-menu-item");
			/**Termina**/

			/**Activa menu**/
			$(this).toggleClass("active");
			$(this).find(".menu-second").toggleClass("active-menu-item");
			$(this).attr("data-active", "true");
			/**Termina el activo del menu**/

			/**Cuenta el numero de hermano que tiene el item para posicionar el menu-second**/
			var contadorsiblings = 0;
			$(".menu-first").each(function (e) {
				if ($(this).hasClass("active")) {
					return false;
				} else {
					contadorsiblings++;
				}
			});

			/**Obtiene la altura del menu first**/
			var menu_height = $(".menu-first").height();

			/**Comprueba si el menu solo tiene un hermano por arriba**/
			if (contadorsiblings == 1) {
				alturaelement = -menu_height;
			}
			/**Sino tiene un hermano por arriba solo, multiplica la altura por el número de item que tiene por arriba para obtener la posición**/
			else {
				var alturaelement = -menu_height * contadorsiblings;
			}

			/**Altura mínima del contendor reduccir o ampliar según diseño**/
			$(".submenu-convocatoria ul").css("min-height", "391px");

			/**Altura del menu-second**/
			var alturamax = $(".menu-second.active-menu-item").height();
			$(".submenu-convocatoria ul").css("min-height", alturamax);

			/**Aumento de margen según diseño**/
			alturamax += 35;
			$(".submenu-convocatoria").css("height", alturamax);
			$(this).find(".menu-second").css("top", alturaelement);
		}else{
			/**Reseteo de menu**/
			$(".menu-second").removeClass("active-menu-item");
			$(".menu-third").removeClass("active-menu-item");
			$(".menu-second-item").removeClass("active");
			$(".menu-second-item").attr("data-active", "false");
			/**Termina el reseteo del menu**/

			/**Desactiva los anteriores items activos**/
			$(".menu-first").attr("data-active", "false");
			$(".menu-first").removeClass("active");
			$(".menu-first").find(".menu-second").removeClass("active-menu-item");
			/**Termina**/
		}

	});

	//Activar submen *Menu-thrid*
	$(".menu-second-item").on("click", function (e) {

		var activo = $(this).attr("data-active");
		if (activo != "true") {
			$(".menu-second-item").attr("data-active", "false");
			$(".menu-second-item").removeClass("active");
			$(".menu-second-item").find(".menu-third").removeClass("active-menu-item");
			$(this).toggleClass("active");
			$(this).find(".menu-third").toggleClass("active-menu-item");
			$(this).attr("data-active", "true");

			var alturafather = $(".submenu-convocatoria").height();
			/**Altura del menu-third**/
			var alturamax = $(".menu-third.active-menu-item").height();
			if (alturafather <= alturamax) {
				/**Altura mínima del contendor reduccir o ampliar según diseño**/
				$(".submenu-convocatoria ul").css("min-height", "391px");
				$(".submenu-convocatoria ul").css("min-height", alturamax);
				/**Aumento de margen**/
				alturamax += 35;
				$(".submenu-convocatoria").css("height", alturamax);
			}

		}else{
			$(".menu-second-item").attr("data-active", "false");
			$(".menu-second-item").removeClass("active");
			$(".menu-second-item").find(".menu-third").removeClass("active-menu-item");
			
			var alturafather = $(".submenu-convocatoria").height();
			/**Altura del menu-third**/
			var alturamax = $(".menu-third.active-menu-item").height();
			if (alturafather <= alturamax) {
				/**Altura mínima del contendor reduccir o ampliar según diseño**/
				$(".submenu-convocatoria ul").css("min-height", "391px");
				$(".submenu-convocatoria ul").css("min-height", alturamax);
				/**Aumento de margen**/
				alturamax += 35;
				$(".submenu-convocatoria").css("height", alturamax);
			}
		}
	});


	/**Termina menú de convocatoria**/

}); /* TERMINA DOCUMENT READY */

/* We adapt the url of the header component so that it always gets the url of the page in which we are, with the language injected */
function adaptCurrentURLToNewLanguage(){
	var currentURL = window.location.href;
	var replacement = $("#currentLanguageInput").val();

	var contextPath = $("#contextPathInput").val();

	if(replacement){
		replacement = "/"+replacement;
	}
	var newString = contextPath+replacement;
	var regexp = new RegExp(contextPath +"(\/en|\/es)*","i");
	var newURL = currentURL.replace(regexp, newString);
	$("#currentLanguage").attr('href', newURL);
}

/**Funcion para Banner-header**/

function banneraletario() {
	var numfrase = $('.block-frase').length;

	var alefrases = Math.round(Math.random() * (numfrase - 1) + 1);

	alefrases--;

	$('.contenedor-frases')
	.find('.block-frase')
	.each(function (e) {
		//Habilitado para que siempre cambie de imagen. Si no quitarlo.

		var clactive = $(this).hasClass('active');

		if (alefrases == e && clactive == true) {
			if (alefrases < numfrase) {
				alefrases++;
			}
		}

		//Función nueva frase aleatoria

		if (alefrases == e) {
			$('.contenedor-frases .block-frase').removeClass('active');
			$(this).addClass('active');
		}
	});
}

/* Auxiliary functions cookies */

function GetCookie(name) {
	var arg=name+"=";
	var alen=arg.length;
	var clen=document.cookie.length;
	var i=0;

	while (i<clen) {
		var j=i+alen;

		if (document.cookie.substring(i,j)==arg)
			return "1";
		i=document.cookie.indexOf(" ",i)+1;
		if (i==0)
			break;
	}

	return null;
}

function accept_cookies(){
	var expire=new Date();
	expire=new Date(expire.getTime()+7776000000);
	document.cookie="cookies_surestao=aceptada; expires="+expire;

	var visit=GetCookie("cookies_surestao");

	if (visit==1){ 
		popboxCookies(false);
	}else {
		popboxCookies(true);
	}
}

function popboxCookies(showBox) {
	var e = $('#cookiesBox');
	if(showBox)
		e.css('display', 'block');
	else
		e.css('display', 'none');
}

