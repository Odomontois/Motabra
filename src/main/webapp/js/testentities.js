$(document).ready(function () {
    $("#postForm button[name='submit']").click(function (event) {
        var params = [
            'firstName=' + $("#formFirstName").val(),
            'lastName=' + $('#formLastName').val()
        ].join('&');

        $.ajax({
            url:"../test/entities?" + params,
            type:'PUT'
        }).done(function () {
                document.getElementById("entity-list").contentDocument.location.reload(true);
                console.log("put ok " + params)
            });
    });

})