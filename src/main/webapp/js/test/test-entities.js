/**
 * User: Oleg
 * Date: 10.09.12
 * Time: 1:01
 */

$(document).ready(function () {
    $("table button").click(function () {
        var mongoObj = $(this).parents("tr");
        var mongoId = mongoObj.attr("data-mongoId");
        $.ajax({
            url:"../../test/entities?mongoId=" + mongoId,
            type:"DELETE"
        }).done(function () {
                console.log("delete ok");
                mongoObj.remove();
            });
    })
});

