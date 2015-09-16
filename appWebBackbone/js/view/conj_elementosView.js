/*global Backbone, jQuery, _, ENTER_KEY, ESC_KEY */
var app = app || {};

(function ($) {
	'use strict';

	// Elemento Collection View
	// --------------
    app.Conj_ElementosView = Backbone.View.extend({
        el:$("#panel_mundo1"),  //insertamos los elementos en este componente

				var_num_name: 1,

        events:{
          "click #asd" :"mensaje2"
        },

        initialize:function(){                    //var_sentencias
            _.bindAll(this, "addNewElemento");

            //this.collection = new List_Sentencias();  eliminado
            //this.collection.add(new Sentencia({nombre:"form_01"})); utilizado en una funcíon aparte.
            //this.cargar();
            this.render(); //luego de crear elemento llamamos al render (buena practica)

            app.elemento_collention.on("add", this.renderElemento, this); //actualiza la vista cada agregado.
                                                                            //actualiza la vista cada eliminado y otro para edit.
            this.event_aggregator.bind("event_element:add_Element", this.addNewElemento);
        },

        render: function(){
            var that = this;
            //iteramos sobre toda la coleccion, undercode function
            _.each(app.elemento_collention.models,
                   function(item){ //funcion que se le aplica a cada elemento
                      that.renderElemento(item);
                  }, this);
        },

        renderElemento:function(item){
            var elementoView = new app.ElementoView({ //genera la vista del  modelo
                model: item
            });
            this.$el.append(elementoView.render().el); //agrega al final
        },
				/* Alternativa del codigo, realiza lo mismo.
				renderElemento : function (item){
				var el = new app.ElementoView({model:item}).render.el;
				this.$el.append(el);
				},
				*/

				num_nameNext: function(){
					this.var_num_name = this.var_num_name + 1;
				},

        addNewElemento: function(){
          alert("agregar elemento  - conj ");
            /*
            var privada con contador - id del name
            cargar animal y atributos del formulario seleccionados.
            */
						var name = "e" + this.var_num_name;
						this.num_nameNext();
            app.elemento_collention.add(new app.Elemento({nombre: name}));
        },

        mensaje2 : function(){
          alert("apretaste asd dentro");
        }
    });

  })(jQuery);
