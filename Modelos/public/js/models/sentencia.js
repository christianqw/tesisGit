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
        estado:"glyphicon glyphicon-warning-sign ", //blanco - none
        mensaje:""
    }

		//unchequed - glyphicon glyphicon-unchecked
		// alert  - glyphicon glyphicon-warning-sign
		// editing - glyphicon glyphicon-edit
	});
})();
