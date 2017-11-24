var booleanmouse = true;
var scroll;

$(document).ready(function () {
    /**Banner-header**/
	// Resources URL
	var resourcesURL = document.location.origin + "/caar-webapp/.resources/caar-theme-module/webresources/caar-theme";
	// Icons URL
	var iconsURL = resourcesURL + "/icons/";

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
    window.onscroll = function()
    {
    scroll = document.documentElement.scrollTop || document.body.scrollTop;
        if(scroll >400){
            if($(".submenu-container").hasClass("clicked") != true){
                $(".cmp-menu").addClass("fixed-menu");
            }
        }else{
            $(".cmp-menu").removeClass("fixed-menu");
        }
    
    }
    /**Termina posición del scroll**/

    /**Enventos del menu**/

    $('.menu-link').on('click', function (e) {
        e.preventDefault();

        var datamenu = $(this).attr('data-submenu');
        $('.submenu-container').removeClass("clicked");
        $('.submenu-container').addClass("clicked");
        $('.submenu').css('display', 'none');
        $(".menu-link").removeClass('active-item');
        $(".menu-item-icon").removeClass('active-item');
        $(".logo").removeClass('active-item');
        $('.search-icon').attr('src', iconsURL + 'search-icon.svg');
        $('.user-icon').attr('src', iconsURL + 'usuario-icon.svg');
        
        if($(this).hasClass("menu-item-icon")){
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
        $("html, body").animate({ scrollTop: 0 }, 600);
        $(".cmp-menu").removeClass("fixed-menu");
    });

    $('.logo').on('click', function (e) {
        var datamenu = $(this).attr('data-submenu');
        $('.submenu').css('display', 'none');
        $('.' + datamenu).css('display', 'flex');
        $('.submenu-container').removeClass("clicked");
        $('.submenu-container').addClass("clicked");
        $(".menu-link").removeClass('active-item');
        $(this).addClass('active-item');

    });

    $('.close-btn').on('click', function (e) {
        e.preventDefault();
        $('.submenu-container').removeClass("clicked");
        $(".menu-link").removeClass("active-item");

        $('.search-icon').attr('src', iconsURL + 'search-icon.svg');
        $(".menu-item-icon").removeClass('active-item');

        $('.user-icon').attr('src', iconsURL + 'usuario-icon.svg');
        $(".menu-item-icon").removeClass('active-item');
    });

    /**Termina eventos del menu**/
    
    
});

/**Función para Banner-header**/

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