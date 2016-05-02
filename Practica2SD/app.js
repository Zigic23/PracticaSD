$(function () {

    function mostrar_fotos(info) {
        var i;
        for (i = 0; i < info.photos.photo.length; i++) {
            var item = info.photos.photo[i];
            var url = 'https://farm' + item.farm + ".staticflickr.com/" + item.server + '/' + item.id + '_' + item.secret + '.jpg';
            console.debug(url);
            $("#imagenes").append($("<img/>").attr("src", url).addClass("newImage img-rounded").attr("height","150px"));
        }
    }
    
    $('#imagenes').on('click','.newImage',function(e){
        var target = $(e.target);
        console.log("click");
        var img = $('.window').find("img");
        if (img.attr("src") === ""){
            img.attr("src", $(target).attr("src"));
            $('.window').fadeIn();
        } else {
            img.attr("src", "");
            $('.window').fadeOut();
        }
    })
    
    $('.window').on('click','.window',function(e){
        var target = $(e.target);
        console.log("click");
        var img = $('.window').find("img");
        if (img.attr("src") === ""){
            img.attr("src", $(target).attr("src"));
            $('.window').fadeIn();
        } else {
            img.attr("src", "");
            $('.window').fadeOut();
        }
    })

    $('#type').change(function () {
        if ($('#type').val() === 'username') {
            $('.aBuscar').hide();
        } else if ($('#type').val() === 'tags') {
            $('.aBuscar').show();
            $('#aBuscar').attr("placeholder", "Separa por espacios");
        } else {
            $('.aBuscar').show();
            $('#aBuscar').attr("placeholder", "Formato fecha: mm-dd-aaaa");
        }
    })

    $('#form').on('submit', function (e) {
        e.preventDefault();
        $('#imagenes').empty();
        var user = $("#name").val();
        if ($("#type").val() === "min_taken_date") {
            $.getJSON('https://api.flickr.com/services/rest/?&method=flickr.people.findByUsername&api_key=' + api_key + '&username=' + user + '&format=json&nojsoncallback=1', minTakenDate);
        } else if ($("#type").val() === "max_taken_date") {
            $.getJSON('https://api.flickr.com/services/rest/?&method=flickr.people.findByUsername&api_key=' + api_key + '&username=' + user + '&format=json&nojsoncallback=1', maxTakenDate);
        } else if ($("#type").val() === 'username') {
            $.getJSON('https://api.flickr.com/services/rest/?&method=flickr.people.findByUsername&api_key=' + api_key + '&username=' + user + '&format=json&nojsoncallback=1', username);
        } else if ($("#type").val() === 'min_upload_date') {
            $.getJSON('https://api.flickr.com/services/rest/?&method=flickr.people.findByUsername&api_key=' + api_key + '&username=' + user + '&format=json&nojsoncallback=1', minUploadDate);
        } else if ($("#type").val() === 'max_upload_date') {
            $.getJSON('https://api.flickr.com/services/rest/?&method=flickr.people.findByUsername&api_key=' + api_key + '&username=' + user + '&format=json&nojsoncallback=1', maxUploadDate);
        } else {
            $.getJSON('https://api.flickr.com/services/rest/?&method=flickr.people.findByUsername&api_key=' + api_key + '&username=' + user + '&format=json&nojsoncallback=1', forTags);
        }
    })

    function minTakenDate(info) {
        var minTakenDate1 = $('#aBuscar').val();
        minTakenDate1 = minTakenDate1.split("-");
        var newDate = minTakenDate1[2] + "-" + minTakenDate1[1] + "-" + minTakenDate1[0] + "00:00:00";
        console.log("pene2");
        $.getJSON('https://api.flickr.com/services/rest/?&method=flickr.people.getPhotos&api_key=' + api_key + '&user_id=' + info.user.nsid + '&min_taken_date=' + newDate + '&format=json&nojsoncallback=1', mostrar_fotos);
    }

    function maxTakenDate(info) {
        var maxTakenDate1 = $('#aBuscar').val();
        maxTakenDate1 = maxTakenDate1.split("-");
        var newDate = maxTakenDate1[2] + "-" + maxTakenDate1[1] + "-" + maxTakenDate1[0] + "00:00:00";
        console.log("pene2");
        $.getJSON('https://api.flickr.com/services/rest/?&method=flickr.people.getPhotos&api_key=' + api_key + '&user_id=' + info.user.nsid + '&max_taken_date=' + newDate + '&format=json&nojsoncallback=1', mostrar_fotos);
    }

    function username(info) {
        $.getJSON('https://api.flickr.com/services/rest/?&method=flickr.people.getPhotos&api_key=' + api_key + '&user_id=' + info.user.nsid + '&format=json&nojsoncallback=1', mostrar_fotos);
    }

    function minUploadDate(info) {
        var minUploadDate = $('#aBuscar').val();
        minUploadDate = minUploadDate.split("-");
        var newDate = minUploadDate[0] + "," + minUploadDate[1] + "," + minUploadDate[2];
        newDate = new Date(newDate).getTime;
        $.getJSON('https://api.flickr.com/services/rest/?&method=flickr.people.getPhotos&api_key=' + api_key + '&user_id=' + info.user.nsid + '&min_upload_date=' + newDate + '&format=json&nojsoncallback=1', mostrar_fotos);
    }

    function maxUploadDate(info) {
        var maxUploadDate = $('#aBuscar').val();
        maxUploadDate = maxUploadDate.split("-");
        var newDate = maxUploadDate[0] + "," + maxUploadDate[1] + "," + maxUploadDate[2];
        newDate = new Date(newDate).getTime;
        $.getJSON('https://api.flickr.com/services/rest/?&method=flickr.people.getPhotos&api_key=' + api_key + '&user_id=' + info.user.nsid + '&max_upload_date=' + newDate + '&format=json&nojsoncallback=1', mostrar_fotos);
    }

    function forTags(info) {
        var tags = $('#aBuscar').val();
        tags = tags.split(" ");
        var i;
        var tagsAAnadir = "";
        for (i = 0; i < tags.length; i++) {
            tagsAAnadir = tagsAAnadir + "&tags=" + tags[i];
        }
        $.getJSON('https://api.flickr.com/services/rest/?&method=flickr.people.getPhotos&api_key=' + api_key + '&user_id=' + info.user.nsid + tagsAAnadir + '&format=json&nojsoncallback=1', mostrar_fotos);
    }

})