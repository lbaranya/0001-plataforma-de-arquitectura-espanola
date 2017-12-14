[#assign countFirstLevel = ctx.countFirstLevel]
<div class="panel panel-default panel-principal">
    <div class="panel-heading close-acordeon">
        <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion" href="#collapse${countFirstLevel}"><div class="text">INSCRIPCIÓN</div> <div class="icon"><i class="fa fa-chevron-down" aria-hidden="true"></i></div></a>
        </h4>
    </div>
    <div id="collapse${countFirstLevel}" class="panel-collapse collapse">
        <div class="panel-body inscripcion">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
            <button class="btn">Inscripción</button>
        </div>
    </div>
</div>