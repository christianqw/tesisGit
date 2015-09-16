/*global Backbone, jQuery, _, ENTER_KEY, ESC_KEY */
var app = app || {};

(function ($) {
	'use strict';

	// Sentencia Collection View
	// --------------
    app.List_SentenciasView = Backbone.View.extend({
				el:$("#lista_sentencias"),  //insertamos los elementos en este componente

				var_num_name: 3,

        initialize:function(){                    //var_sentencias
            _.bindAll(this, "addNewSentencia");

            //this.collection = new List_Sentencias();  eliminado
            //this.collection.add(new Sentencia({nombre:"form_01"})); utilizado en una funcíon aparte.
            this.cargar();
            this.render(); //luego de crear elemento llamamos al render (buena practica)

            app.sentencia_collention.on("add", this.renderSentencia, this); //actualiza la vista cada agregado.
						/*
						this.listenTo(this.model, 'change', this.render);
						this.listenTo(this.model, 'destroy', this.remove);
						*/

						this.event_aggregator.bind("event_sentencia:add_Before", this.addNewSentencia);

				},

        cargar : function(){
          var formData1 = {};
            app.sentencia_collention.add(new app.Sentencia(formData1));
          var formData2 = { nombre:"form_02" };
            app.sentencia_collention.add(new app.Sentencia(formData2));
        },

        render: function(){
            var that = this;
            //iteramos sobre toda la coleccion, undercode function
            _.each(app.sentencia_collention.models,
                   function(item){ //funcion que se le aplica a cada elemento
                      that.renderSentencia(item);
                  }, this);
        },

        renderSentencia:function(item){
            var sentenciaView = new app.SentenciaView({ //genera la vista del  modelo
                model: item
            });
            this.$el.append(sentenciaView.render().el); //agrega al final
        },

				num_nameNext: function(){
					this.var_num_name = this.var_num_name + 1;
				},
				
        addNewSentencia: function(){
          alert("agregar sentencia  - lista ");
					var name = "form_" + this.var_num_name;
					this.num_nameNext();
          app.sentencia_collention.add(new app.Sentencia({nombre: name}));
        }

    });

  })(jQuery);
