var booleanmouse = true;
var scroll;

$(document).ready(function () {
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
    window.onscroll = function () {
            scroll = document.documentElement.scrollTop || document.body.scrollTop;
            if (scroll > 400) {
            	//Si hacemos un cambio de estructura respectarlo
            	 if ($(".cmp-exist-home").length) {
	                if ($(".submenu-container").hasClass("clicked") != true) {
	                    $(".cmp-menu").addClass("fixed-menu");
	                }
            	 }
            } else {
            	 if ($(".cmp-exist-home").length) {
            		 $(".cmp-menu").removeClass("fixed-menu");
            	 }
            }

        }
        /**Termina posición del scroll**/

    /**Enventos del menu**/

    $('.menu-link').on('click', function (e) {
        e.preventDefault();

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
        $(".menu-link").removeClass('active-item');
        $(".menu-item-icon").removeClass('active-item');
        $(".logo").removeClass('active-item');
        $('.search-icon').attr('src', iconsURL + 'search-icon.svg');
        $('.user-icon').attr('src', iconsURL + 'usuario-icon.svg');

        if ($(this).hasClass("menu-item-icon")) {
            datamenu = $(this).find(".icon-link").attr('data-submenu');
        }


        if (datamenu != 'search') {

            $('.' + datamenu).css('display', 'flex');

            if (datamenu == 'signin') {

                $(this).find('.user-icon').attr('src', iconsURL + 'usuario-icon-blanco.svg');
                $('.search-icon').attr('src', iconsURL + 'search-icon.svg');
                $(".menu-item-icon").removeClass('active-item');
                $(this).addClass('active-item');

            } else {

                $(".menu-link").removeClass('active-item');
                $(this).addClass('active-item');

            }
        } else {

            $('.' + datamenu).css('display', 'block');
            $(this).find('.search-icon').attr('src', iconsURL + 'search-icon-blanco.svg');
            $('.user-icon').attr('src', iconsURL + 'usuario-icon.svg');
            $(".menu-item-icon").removeClass('active-item');
            $(this).addClass('active-item');

        }
        $("html, body").animate({
            scrollTop: 0
        }, 600);
        $(".cmp-menu").removeClass("fixed-menu");
    });

    $('.logo').on('click', function (e) {
        var datamenu = $(this).attr('data-submenu');
        $('.submenu').css('display', 'none');
        $('.' + datamenu).css('display', 'flex');
        if ($(".cmp-exist-home").length) {
            $('.submenu-container').removeClass('clicked');
            $('.submenu-container').addClass('clicked');
        } else {
            $('.submenu-container').removeClass("clicked-nh");
            $('.submenu-container').addClass("clicked-nh");
        }
        $(".menu-link").removeClass('active-item');
        $(this).addClass('active-item');

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

});

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