/*global Backbone */
var app = app || {};

(function () {
	'use strict';

	// Sentencia Model
	// ----------

	// Nuestro moledo basico de **Sentencia** posee los atributos: 'nombre', 'valor', 'estado', 'mensaje'
  app.Sentencia = Backbone.Model.extend({
		// Atributos por defecto de una Sentencia
		// de faltar un campo, se está asumiendo que simepre se asigna dicho atributo al crearlo
    defaults:{
        nombre:"form_X",
        valor:"",
        estado:"", //blanco - none
        mensaje:""
    }
	});
})();
