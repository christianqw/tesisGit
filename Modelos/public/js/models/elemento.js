/*global Backbone */
var app = app || {};

(function () {
	'use strict';

	// Elemento Model
	// ----------

	// Nuestro moledo basico de **Elemento** posee los atributos: 'nombre', 'valor', 'estado', 'mensaje'
  app.Elemento = Backbone.Model.extend({
		localStorage: new Store("Modelos"),
		var_map : {"tipo1ChicoDespierto":"images/icon_chancho.png",
							"tipo2ChicoDespierto":"images/icon_gallina.png",
							"tipo3ChicoDespierto":"images/icon_pato.png",
							"tipo4ChicoDespierto":"images/icon_vaca.png"
		},
		// Atributos por defecto de un Elemento
		// de faltar un campo, se está asumiendo que simepre se asigna dicho atributo al crearlo
    defaults:{
        nombre:"eX",
				tipo:"xxx",
				zona:"bosque",
        img: 'images/icon_chancho.png',
        left: 0,
        top: 0,
        att1:"YYY",
        att2:"WWWW"
    },

		 updateImg: function() {
			  console.log("<<<< Entramos a UPDATE IMG >>>>>");
				this. save({
					img : this.getImgRuta(this.getClave())
				});
				console.log("<<<<    IMG modificada     >>>>>");
		 },

		initialize: function(){
      //concatenamos atributos y tipo para sacar la ruta del elemento.
			console.log("Inicializamos: -cargamos la imagen ");
			this.updateImg();
		},

		getClave : function(){
			return (this.get("tipo")+this.get("att1")+this.get("att2"));
		},
/*
		asd : function (ruta){
			console.log("entra a asd : this es:");
			this.save({
				img: ruta,
			});
			console.log("cambio de ruta de imag : ");
			console.log(this);
		},
*/
		getImgRuta: function(k){
			return this.var_map[k];
		},

		//function editing position and Zona
		stop_drop: function ( data ) {
			this.save({
				left: data["left"],
				top: data["top"],
				zona: data["zona"]
			});
			console.log("cambio de lugar : ");
			console.log(this);
		// + this.get_img_ruta("key1") + " " + this.get_img_ruta("key2")
		}
/*
		//function editing position
		stop_drop: function ( new_left, new_top ) {
			this.save({
				left: new_left,
				top: new_top
			});
			console.log("cambio de lugar : ");
			console.log(this);
// + this.get_img_ruta("key1") + " " + this.get_img_ruta("key2")
		} */


	/*	validate: function(attrs, options) {
			var aux = attrs.tipo + attrs.att1 + attrs.att2;
			console.log("concatenacion de atributos : " + aux);
			console.log(this.aux);
			this.save( {
				img : app.Elemento.aux
			});
			if (!app.Elemento.aux) {
	      return "El elemento no tiene definido una ruta de imagen";
	    }
	  },

		updateAttributes: function(){
		 console.log("llamó a la funcion");
		 console.log(this.get("tipo")+this.get("att1")+this.get("att2") );
		 var aux = this.get("tipo")+this.get("att1")+this.get("att2");
		 console.log(this.aux);
		 this.save( {
			 img : this.aux
		 });

	 }
	 */
	}
);
})();
