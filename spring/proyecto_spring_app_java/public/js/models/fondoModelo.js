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
		var_map : {"R63G72B204" : "aire", //Azul
							 "R34G177B76" : "bosque",
							 "R255G242B0" : "granero",
							 "R255G174B201" : "pasto",
							 "R237G28B36": "corral"
		},
		var_imageCtx :"",
		var_hReal : "",
		var_wReal : "",

    defaults:{
        img: 'images/granja.png',
        img_mascara:'images/mascara.png',
        alt: 'granja',
    },

		getStringZona:function(data, size){
			console.log("calculamos las pos reales de la mascara")
			var img_fondo = document.getElementById('imagen_fondo');
			var leftReal = this.calcularRealLeft(data["left"], size["w"],img_fondo.clientWidth);
			var topReal = this.calcularRealTop(data["top"], size["h"], img_fondo.clientHeight);
			console.log("pos real en la mascara: " + leftReal + " "+ topReal );

			var claveColor = this.getPixelColor(leftReal, topReal); //get color de canvas real:real
			console.log("clave Color : " + claveColor);//get value mapa en color
			return this.var_map[claveColor];
		},

		initialize:function(){

			this.generateImgData();
		},

		generateImgData: function (image) {
			var img = document.getElementById('myMascara');
			//var canvas = document.getElementById('my-canvas');
			var canvas = document.createElement('canvas');
			this.var_wReal = img.width;
			this.var_hReal = img.height;
			canvas.width = 	this.var_wReal;
			canvas.height = 	this.var_hReal;
			this.var_imageCtx = canvas.getContext("2d");
			this.var_imageCtx.drawImage(img, 0, 0, this.var_wReal, this.var_hReal);
			alert("tamaños reales: "+this.var_wReal + "  " +img.height);
		},

		getPixelColor: function ( l, t ) {
			var pixelData = this.var_imageCtx.getImageData(l, t, 1, 1).data;
			alert('R: ' + pixelData[0] + '<br>G: ' + pixelData[1] + '<br>B: ' + pixelData[2] + '<br>A: ' + pixelData[3])	//, a: data[ position + 3 ]
			return('R'+ pixelData[0] + 'G' + pixelData[1] + 'B' + pixelData[2]);
		},

		calcularRealTop:function(pos, h, tvisual) {
			var centro = pos+(~~(h/2));
			console.log("pos = " + pos + "centro : " + centro);
			return (~~(centro*this.var_hReal/tvisual));
		//	return 0;
		},

		calcularRealLeft:function(pos, w, tvisual){
			var centro = pos+(~~(w/2));
			console.log("pos = " + pos + "centro : " + centro);
			return (~~(centro*this.var_wReal/tvisual));
		}

	}
);
})();
