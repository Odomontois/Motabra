window.onload = function () {
    var stage = new Kinetic.Stage({
        container:"container",
        width:600,
        height:300
    });
    var layer = new Kinetic.Layer();
    var quadrilateral = new Kinetic.Shape({
        drawFunc:function (ctx) {
            ctx.beginPath();
            ctx.moveTo(0, 110);
            ctx.lineTo(-200, 30);
            ctx.quadraticCurveTo(-100, 10, 0, -70);
            ctx.lineTo(200, -30);
            ctx.quadraticCurveTo(100, -10, 0, 110);
            ctx.closePath();
            this.fill(ctx);
            this.stroke(ctx);
        },
//        offset:{
//            x:300,
//            y:170
//        },
        x:300,
        y:170,
        offset:{y:50},
        fill:"LightGreen",
        stroke:"DarkGreen",
        strokeWidth:5
    });
    quadrilateral.on("mouseover touchstart", function () {
        this.transitionTo({

            scale:{
                x:1.3,
                y:1.3
            },
            duration:0.2,
            easing:"linear"
        })
    });
    quadrilateral.on("mouseout touchend", function () {
        this.transitionTo({
            scale:{
                x:1,
                y:1
            },
            duration:0.1,
            easing:"linear"
        })
    });
    layer.add(quadrilateral);
    stage.add(layer);
}