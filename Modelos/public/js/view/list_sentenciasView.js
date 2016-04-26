/*global Backbone, jQuery, _, ENTER_KEY, ESC_KEY */
var app = app || {};

(function ($) {
	'use strict';

	// Sentencia Collection View
	// --------------
    app.List_SentenciasView = Backbone.View.extend({
				el:$("#lista_sentencias"),  //insertamos los elementos en este componente

				var_num_name: 3,
				var_focus:'',

        initialize:function(){                    //var_sentencias
            _.bindAll(this, "addNew");
						_.bindAll(this, "changeFocusSentencia");  //<---
						_.bindAll(this, "addCharInSentencia");
						_.bindAll(this, "clearAllInputs");

            //this.collection = new List_Sentencias();  eliminado
            //this.collection.add(new Sentencia({nombre:"form_01"})); utilizado en una funcíon aparte.
            this.cargar();
            this.render(); //luego de crear elemento llamamos al render (buena practica)

            app.sentencia_collention.on("add", this.renderSentencia, this); //actualiza la vista cada agregado.
						/*
						this.listenTo(this.model, 'change', this.render);
						this.listenTo(this.model, 'destroy', this.remove);
						*/

						this.event_aggregator.bind("event_formulario:add_Before", this.addNew);
						this.event_aggregator.bind("event_formulario:edit_Focus", this.changeFocusSentencia); //<---
						this.event_aggregator.bind("event_formulario:insert_Char", this.addCharInSentencia);
						this.event_aggregator.bind("event_formulario:clearAll", this.clearAllInputs);

				},

        cargar : function(){
          var formData1 = {};
            app.sentencia_collention.add(new app.Sentencia(formData1));
          var formData2 = { nombre:"form_02" };
            app.sentencia_collention.add(new app.Sentencia(formData2));
        },

        render : function(){
            var that = this;
            //iteramos sobre toda la coleccion, undercode function
            _.each(app.sentencia_collention.models,
                   function(item){ //funcion que se le aplica a cada elemento
                      that.renderSentencia(item);
                  }, this);
        },

        renderSentencia : function(item){
            var sentenciaView = new app.SentenciaView({ //genera la vista del  modelo
                model: item
            });
            this.$el.append(sentenciaView.render().el); //agrega al final
        },

				clearAllInputs : function(){
					var that = this;
					//iteramos sobre toda la coleccion, undercode function
					_.each(app.sentencia_collention.models,
								 function(item){ //funcion que se le aplica a cada elemento
									item.save({valor : ''});
								}, this);
				},

				num_nameNext : function(){
					this.var_num_name = this.var_num_name + 1;
				},

        addNew : function(){
					var name = "form_" + this.var_num_name;
					alert("dentro del new sentencia")
					this.num_nameNext();
          app.sentencia_collention.add(new app.Sentencia({nombre: name}));
        },

				changeFocusSentencia : function( that ){
					if( !(this.var_focus === that)){
						if (this.var_focus){
							this.var_focus.remove_editing();
						}
						//alert(" changeFocusSentencia dentro de la lista");
						that.add_editing();
						this.var_focus = that;
						//alert(this.var_focus.model.get('nombre'));
					}
				},

				addCharInSentencia : function( char ){
					if (this.var_focus){
						this.var_focus.updateOnClikBtnChar(char);
					}
				}

    });

  })(jQuery);
