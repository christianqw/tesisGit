/*global Backbone, jQuery, _, ENTER_KEY, ESC_KEY */
var app = app || {};

(function ($) {
	'use strict';

	// Elemento Collection View
	// --------------
    app.Conj_ElementosView = Backbone.View.extend({
        el:$("#panel_mundo1"),  //insertamos los elementos en este componente

				var_num_name: 1,
				var_elem_focus: '',

        events:{
          "click #asd" :"mensaje2",
					//'keydown .editing-focus': 'revertOnEscape',
        },

        initialize:function(){                    //var_sentencias
            _.bindAll(this, "addNewElemento");
						_.bindAll(this, "editElemento");
						_.bindAll(this, "changeFocusElement");

            //this.collection = new List_Sentencias();  eliminado
            //this.collection.add(new Sentencia({nombre:"form_01"})); utilizado en una funcíon aparte.
            //this.cargar();
            this.render(); //luego de crear elemento llamamos al render (buena practica)

            app.elemento_collention.on("add", this.renderElemento, this); //actualiza la vista cada agregado.
                                                                            //actualiza la vista cada eliminado y otro para edit.
            this.event_aggregator.bind("event_mundo:add_Element", this.addNewElemento);
						this.event_aggregator.bind("event_mundo:edit_Element", this.editElemento);
						this.event_aggregator.bind("event_mundo:edit_Focus_Element", this.changeFocusElement);

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

				editElemento(data){
					if (this.var_elem_focus){
						this.var_elem_focus.editData(data);
					}
				},

        addNewElemento: function( elem ){
          //alert("agregar elemento  - conj ");
            /*
            var privada con contador - id del name
            cargar animal y atributos del formulario seleccionados.
            */
						var name = "e" + this.var_num_name;
						elem["nombre"] = name;
						//console.log("nombre: " + name);
						//console.log(elem);
						this.num_nameNext();
						var e = new app.Elemento(elem);
				//		e.asd(e.getRuta(e.getClave()));
				//		console.log("usando asd");
						console.log(e);
/*
						var e = new app.Elemento(elem);
						e.save_ruta(e.getClave);
						console.log( "Elemento generado dentro del conjunto : ");
						console.log(e);
*/
            app.elemento_collention.add(e);
						//alert("se agrego a la coleccion");
        },

				changeFocusElement : function( that ){
					if (this.var_elem_focus){
						this.var_elem_focus.remove_editingFocus();
					}
					that.add_editingFocus();
					this.var_elem_focus = that;
				},
/*
				revertOnEscape: function (e) {
					if (e.which === ESC_KEY) {
						if (this.var_elem_focus){
							this.var_elem_focus.remove_editingFocus();
						}
						this.var_elem_focus = '';
					}
				},*/

        mensaje2 : function(){
          alert("Dentro de Colection");
					_.each(app.elemento_collention.models,
								 function(item){ //funcion que se le aplica a cada elemento
										console.log(item);
								}, this);
        }
    });

  })(jQuery);
