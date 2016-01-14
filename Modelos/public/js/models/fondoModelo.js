/*global Backbone */
var app = app || {};

(function () {
	'use strict';

	// Fondo del Model (atributo zona)
	// ----------

	/*Dentro del modelo, los elementos poseen el atributo **Zona**
  el mismo está determinado por el lugar en el que es dropeado el elemnto,
  para ello es que se incorpora una logica que trabaja con una mascara.
  */
  app.FondoModelo = Backbone.Model.extend({
		var_map : {"bosque":"Rojo",
							"corral":"Azul",
							"aire":"Amarillo",
							"pasto":"Verde"
		},
		var_imagedata :"",
		var_hReal : "",
		var_wReal : "",

    defaults:{
        img: 'images/granja.png',
        img_mascara:'images/mascara.png',
        alt: 'granja',
    },

		getStringZona:function(data, size){
			console.log("calculamos las pos reales de la mascara")
			var leftReal = this.calcularRealLeft(data["left"], size["h"]);
			var topReal = this.calcularRealTop(data["top"], size["w"]);
			//get color de canvas real:real
			//get value mapa en color.
			return "corral";
		},


	initialize:function(){

		var img = document.getElementById('myMascara');
		//var canvas = document.getElementById('my-canvas');
		var canvas = document.createElement('canvas');
		this.var_wReal = img.width;
		this.var_hReal = img.height;
		canvas.width = 	this.var_wReal;
		canvas.height = 	this.var_hReal;
		this.var_imagedata = canvas.getContext("2d");
		this.var_imagedata.drawImage(img, 0, 0, this.var_wReal, this.var_hReal);
		alert(this.var_wReal + "  " +img.height);

		//alert($(#imagen_fondo).width);

		//var pixelData = canvas.getContext('2d').getImageData(100, 100, 1, 1).data;
		//alert('R: ' + pixelData[0] + '<br>G: ' + pixelData[1] + '<br>B: ' + pixelData[2] + '<br>A: ' + pixelData[3])

/*		var img = new Image();
		img.src = "images/mascara.png";
		alert(img.width + "  sss  " + img.height);

		alert("dentro del Modelo Fondo");
		alert("img var  " + img);
		this.var_imagedata = this.getImgData( img );
		var color = this.getPixel( this.var_imagedata, 10, 10);

		alert(var_imagedata);
		alert(color);

	var canvas = document.getElementById('panel');
	var ctx = canvas.getContext('2d');
	ctx.drawImage(image, 0, 0);

  var imageData = ctx.getImageData(100, 100, 1, 1);
	var pixel = imageData.data;
	var pixelColor = "rgba("+pixel[0]+", "+pixel[1]+", "+pixel[2]+", "+pixel[3]+")";
	alert(pixelColor)
	*/
	},

		getImgData: function (image) {
		    var canvas = document.createElement( 'canvas' );
		    canvas.width = image.width;
		    canvas.height = image.height;
		    var context = canvas.getContext( '2d' );
				console.log("context var " + context);
		    context.drawImage( image, 0, 0 );
		    return context.getImageData( 0, 0, image.width, image.height );


		},

		getPixel: function ( imagedata, x, y ) {
		    var position = ( x + imagedata.width * y ) * 4, data = imagedata.data;
		    return { r: data[ position ], g: data[ position + 1 ], b: data[ position + 2 ]};																																					//, a: data[ position + 3 ]
		},

		calcularRealTop:function(pos, h) {
			var centro = pos+(h/2);
			console.log("pos = " + pos + "centro : " + centro);


			return 0;
		},

		calcularRealLeft:function(pos){
			return 0;
		}

	}
);
})();
