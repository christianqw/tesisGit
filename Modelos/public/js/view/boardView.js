/*global Backbone, jQuery, _, ENTER_KEY, ESC_KEY */
var app = app || {};

(function ($) {
	'use strict';

	// Board View (imagen de fondo)
	// --------------

    app.BoardView = Backbone.View.extend({
			/*el:$("#panel_mundo1"),

			initialize:function(){
				_.bindAll(this, 'render'); // fixes loss of context for 'this' within methods
		 		this.render();
			},

			render: function(){
		 		$(this.el).append("<img class='imagen_fondo'  src='images/granja.png' alt='granja'>");
	 		}*/

        el:$("#panel_mundo1"),  //insertamos los elementos en este componente

				className:"board",
				template:$("#Board_Template").html(),
        events:{
					"drop .imagen_fondo" : "alertamos"
        },

				initialize:function(){
					_.bindAll(this, "setPosyMascara");

					this.model.bind('change', this.render, this);
          this.render(); //luego de crear elemento llamamos al render (buena practica)

					this.event_aggregator.bind("event_board:setPos", this.setPosyMascara);
				},

				render:function () {
          //tmpl is a function that takes a JSON object and returns html
          var tmpl = _.template(this.template);
          //this.el is what we defined in tagName. use $el to get access to jQuery html() function
          this.$el.html(tmpl(this.model.toJSON()));
          return this;
        },

				setPosyMascara:function(element, data, size){
					alert("Zona: ");
					var aaa = document.getElementById('imagen_fondo');
					alert(aaa.clientWidth);
					data["zona"] = this.model.getStringZona(data, size);
					element.model.stop_drop(data);
					//alert("Agregados 3 atributos");
				},

				alertamos:function (){
					alert("funcionó el evento drop");
				}

    });

  })(jQuery);
