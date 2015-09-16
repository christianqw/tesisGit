/*global Backbone */
var app = app || {};

(function () {
	'use strict';

	// Sentencias Collection
	// ---------------

  var List_Sentencias = Backbone.Collection.extend({
    model: app.Sentencia,
		localStorage: new Backbone.LocalStorage("Lista-Sentencias"),

    // Save all of the todo items under the `"todos"` namespace.
		//localStorage: new Backbone.LocalStorage('sentencias-backbone')
  });

  // Create our global collection of **Todos**.
	app.sentencia_collention = new List_Sentencias();

  })();
