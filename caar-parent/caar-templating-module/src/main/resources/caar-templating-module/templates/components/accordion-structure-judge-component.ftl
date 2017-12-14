[#assign countFirstLevel = ctx.countFirstLevel]
<div class="panel panel-default panel-principal jurado">
    <div class="panel-heading close-acordeon">
        <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion-convocatoria" href="#collapse${countFirstLevel}"><div class="text">JURADO</div> <div class="icon"><i class="fa fa-chevron-down" aria-hidden="true"></i></div></a>
        </h4>
    </div>
    <div id="collapse${countFirstLevel}" class="panel-collapse collapse">
        <div class="panel-body">
            <div class="col-jurado"> <!-- multivalue composite -->
                <div class="img-jurado"><img src="../../../assets/img/evento-agenda-1.jpg" alt=""></div>
                <div class="info-jurado">
                    <h4>NOMBRE APELLIDO APELLIDO</h4>
                    <span>Nunc cursus mollis odio, ac tincidunt nbh lacinia.</span>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur ipsam delectus eligendi dignissimos, consectetur aliquid laboriosam. Quia, eum eveniet, adipisci commodi illum, fugit aliquid fuga facere suscipit, reprehenderit voluptas ad!</p>
                </div>
                <a href="#" class="ficha-jurado">
                    <div><i class="fa fa-plus" aria-hidden="true"></i></div>
                </a>
                <a href="#" class="pdf">Descargar CV en .pdf <i class="fa fa-file-o" aria-hidden="true"></i></a>
            </div>
            <div class="col-jurado">
                <div class="img-jurado"><img src="../../../assets/img/evento-agenda-1.jpg" alt=""></div>
                <div class="info-jurado">
                    <h4>NOMBRE APELLIDO APELLIDO</h4>
                    <span>Nunc cursus mollis odio, ac tincidunt nbh lacinia.</span>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur ipsam delectus eligendi dignissimos, consectetur aliquid laboriosam. Quia, eum eveniet, adipisci commodi illum, fugit aliquid fuga facere suscipit, reprehenderit voluptas ad!</p>
                </div>
                <a href="#" class="ficha-jurado">
                    <div><i class="fa fa-plus" aria-hidden="true"></i></div>
                </a>
                <a href="#" class="pdf">Descargar CV en .pdf <i class="fa fa-file-o" aria-hidden="true"></i></a>
            </div>
        </div>
    </div>
</div>