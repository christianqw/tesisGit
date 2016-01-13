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

    defaults:{
        img: 'images/granja.png',
        img_mascara:'images/mascara.png',
        alt: 'granja'
    },

		getStringZona:function(left, top){
			console.log("calculamos las pos reales de la mascara")
			var leftReal = this.calcularRealLeft(left);
			var topReal = this.calcularRealTop(top);
			//get color de canvas real:real
			//get value mapa en color.
			return "corral";
		},


	initialize:function(){
/*
		var img = new Image();
		img.src = "images/mascara.png";

		alert("dentro del Modelo Fondo");
		alert("img var  " + img);
		this.var_imagedata = this.getImgData( img );
		var color = this.getPixel( this.var_imagedata, 10, 10);

		alert(var_imagedata);
		alert(color);
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

		calcularRealTop:function(pos) {
			return 0;
		},

		calcularRealLeft:function(pos){
			return 0;
		}

	}
);
})();
