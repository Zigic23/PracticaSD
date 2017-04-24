$(function () {

    function mostrar_fotos(info) { //Metodo para mostrar las fotos
        var i;
        for (i = 0; i < info.photos.photo.length; i++) {
            var item = info.photos.photo[i]; //Delo que se recibe se van cogiendo las fotos y aplicando el src a imagenes nuevas
            var url = 'https://farm' + item.farm + ".staticflickr.com/" + item.server + '/' + item.id + '_' + item.secret + '_b.jpg';
            console.debug(url);
            $("#imagenes").append($("<img/>").attr("src", url).addClass("newImage img-rounded").attr("height", "150px"));
        }
    }

    $('#imagenes').on('click', '.newImage', function (e) { //Esta funcion implementa el controlador para que al 
        var target = $(e.target); //hacer click aparezca la imagen ampliada
        var img = $('.window').find("img");
        if (img.attr("src") === "") {
            img.attr("src", $(target).attr("src"));
            $('.window').fadeIn();
        } else {
            $('.window').fadeOut();
            img.attr("src", "");
        }
    })

    $('.window').on('click', '.window', function (e) { //Esta funcion implementa el controlador para que al 
        var target = $(e.target); //hacer click aparezca la imagen ampliada
        console.log("click");
        var img = $('.window').find("img");
        if (img.attr("src") === "") {
            img.attr("src", $(target).attr("src"));
            $('.window').fadeIn(200);
        } else {
            img.attr("src", "");
            $('.window').fadeOut(200);
        }
    })

    $('#form').on('submit', function (e) {
        var call = 'https://api.flickr.com/services/rest/?&method=flickr.photos.search&api_key=' + api_key + '&user_id=' + user_id;
        e.preventDefault();
        $('#imagenes').empty();
        if ($("#min_takenCheckbox").prop('checked')) { //Si se ha seleccionado la condicion se añade a la variable call para luego
            var minTakenDate1 = $('#datepicker1').val(); //hacer la llamada al servidor
            minTakenDate1 = minTakenDate1.split("/");
            var newDate = minTakenDate1[2] + "-" + minTakenDate1[1] + "-" + minTakenDate1[0] + "00:00:00";
            call = call + '&min_taken_date=' + newDate;
        }
        if ($('#max_takenCheckbox').prop('checked')) {
            var maxTakenDate1 = $('#datepicker2').val();
            maxTakenDate1 = maxTakenDate1.split("/");
            var newDate = maxTakenDate1[2] + "-" + maxTakenDate1[1] + "-" + maxTakenDate1[0] + "00:00:00";
            call = call + '&max_taken_date=' + newDate;
        }
        if ($('#min_uploadCheckBox').prop('checked')) {
            var minUploadDate = $('#datepicker3').val();
            minUploadDate = minUploadDate.split("/");
            var newDate = minUploadDate[2] + "," + minUploadDate[1] + "," + minUploadDate[0];
            newDate = new Date(newDate).getTime() / 1000; //Tiene que estar en formato Unix Timestamp
            call = call + '&min_upload_date=' + newDate;
        }
        if ($('#max_uploadCheckbox').prop('checked')) {
            var maxUploadDate = $('#datepicker4').val();
            maxUploadDate = maxUploadDate.split("/");
            var newDate = maxUploadDate[2] + "," + maxUploadDate[1] + "," + maxUploadDate[0];
            newDate = new Date(newDate).getTime() / 1000;
            call = call + '&max_upload_date=' + newDate;
        }
        if ($('#tagsCheckbox').prop('checked')) {
            var tags = $('#tagsinput').val();
            tags = tags.split(" ");
            var i;
            var tagsAAnadir = "&tags=";
            for (i = 0; i < tags.length; i++) {
                tagsAAnadir = tagsAAnadir + "," + tags[i]; //Para cada tag añade una coma y luego añade el tag
            }
            call = call + tagsAAnadir;
        }
        if ($('#ubicCheckbox').prop('checked')){
            var radius = $('#us2-radius').val()/1000;   
            call = call + "&lat=" + $('#us2-lat').val() + "&lon=" + $('#us2-lon').val() + "&radius=" + radius;
        }
        var selectedVal = "";
        var selected = $("#radioDiv input[type='radio']:checked"); //Selecciona de los radiobuttons el que esta marcado
        var tipo = "";
        if (selected.length > 0) {
            selectedVal = selected.val();
            if (selectedVal === "pics") {
                tipo = "&media=photos";
            } else if (selectedVal === "vids") {
                tipo = "&media=videos";
            }
        }
        call = call + tipo + '&format=json&nojsoncallback=1';
        console.debug(call);
        $.getJSON(call, mostrar_fotos);
    })



    $.datepicker.regional['es'] = { //Necesario para el datepicker
        closeText: 'Cerrar',
        prevText: '<Ant',
        nextText: 'Sig>',
        currentText: 'Hoy',
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mié', 'Juv', 'Vie', 'Sáb'],
        dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sá'],
        weekHeader: 'Sm',
        dateFormat: 'dd/mm/yy',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: ''
    };

    $.datepicker.setDefaults($.datepicker.regional["es"]);
    $("#locale").change(function () {
        $("#datepicker1").datepicker("option",
            $.datepicker.regional[$(this).val()]);
    });

    $("#datepicker1").datepicker();

    $.datepicker.setDefaults($.datepicker.regional["es"]);
    $("#locale").change(function () {
        $("#datepicker2").datepicker("option",
            $.datepicker.regional[$(this).val()]);
    });

    $("#datepicker2").datepicker();

    $.datepicker.setDefaults($.datepicker.regional["es"]);
    $("#locale").change(function () {
        $("#datepicker3").datepicker("option",
            $.datepicker.regional[$(this).val()]);
    });

    $("#datepicker3").datepicker();

    $.datepicker.setDefaults($.datepicker.regional["es"]);
    $("#locale").change(function () {
        $("#datepicker4").datepicker("option",
            $.datepicker.regional[$(this).val()]);
    });

    $("#datepicker4").datepicker();
    
    $("#lienzoMapa").locationpicker({
        location: {
            latitude: 40.334616,
            longitude: -3.882570
        },
        radius: 300,
        inputBinding: {
        latitudeInput: $('#us2-lat'),
        longitudeInput: $('#us2-lon'),
        radiusInput: $('#us2-radius'),
        locationNameInput: $('#us2-address')
    }
    });
    
    $('#ubicCheckbox').on('change', function(){
        $('#mapa').toggle();
    })
    
    $(document).ready(setTimeout(function(){
        $('#mapa').hide();
    },2300));
    
    

})