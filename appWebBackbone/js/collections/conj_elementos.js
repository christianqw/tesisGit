/*global Backbone */
var app = app || {};

(function () {
	'use strict';

	// Elementos Collection
	// ---------------

  var Conj_Elementos = Backbone.Collection.extend({
    model: app.Elemento,
		localStorage: new Backbone.LocalStorage("Conjunto-Elementos"),

    // Save all of the todo items under the `"todos"` namespace.
		//localStorage: new Backbone.LocalStorage('sentencias-backbone')
  });

  // Create our global collection of **Elementos**.
	app.elemento_collention = new Conj_Elementos();
  })();
