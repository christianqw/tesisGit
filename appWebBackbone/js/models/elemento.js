/*global Backbone */
var app = app || {};

(function () {
	'use strict';

	// Elemento Model
	// ----------

	// Nuestro moledo basico de **Elemento** posee los atributos: 'nombre', 'valor', 'estado', 'mensaje'
  app.Elemento = Backbone.Model.extend({
		// Atributos por defecto de un Elemento
		// de faltar un campo, se está asumiendo que simepre se asigna dicho atributo al crearlo
    defaults:{
        nombre:"eX",
				tipo:"xxx",
        img: 'images/icon_chancho.png',
        left: 0,
        top: 0,
        att1:"YYY",
        att2:"WWWW"
    },

		save_ruta : function (clave) {
			var map = {
					"tipo1ChicoDespierto":"images/icon_chancho.png",
					"tipo2ChicoDespierto":"images/icon_gallina.png",
					"tipo3ChicoDespierto":"images/icon_pato.png",
					"tipo4ChicoDespierto":"images/icon_vaca.png"
			};
			 //console.log(map[clave]);
			 this.save({
 				img: map[clave],
 			});
		},

		initialize: function(){
      //concatenamos atributos y tipo para sacar la ruta del elemento.
			
			//console.log("concatenacion : " + this.get("tipo")+this.get("att1")+this.get("att2"));
			var clave = this.get("tipo")+this.get("att1")+this.get("att2");
			//console.log(clave);
			this.save_ruta(clave);
		},

		//function editing position
		stop_drop: function ( new_left, new_top ) {
			this.save({
				left: new_left,
				top: new_top
			});
		}


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
