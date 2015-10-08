/*global Backbone, jQuery, _, ENTER_KEY, ESC_KEY */
var app = app || {};

(function ($) {
	'use strict';

  // The Application
	// ---------------

    app.AppView = Backbone.View.extend({
        el:$("#app_container"),  //Panel de Trabajo

        events:{
          "click #id_btn_add_before" :"addNewBefore",
					"click #add_element" :"addNewElemento",
					"click .btn-character" :"addCharToInput",
					"click #id_btn_action" : "verificar"
        },

        initialize:function(){
          var list_sentenciasView = new app.List_SentenciasView();
					var conj_elementosView = new app.Conj_ElementosView();

        },

        render: function(){
          this.$el.append(app.list_sentenciasView.render().el);
					this.$el.append(app.conj_elementosView.render().el);
          return this;
        },

        addNewBefore: function(){
            this.event_aggregator.trigger("event_formulario:add_Before");
        },

				addNewElemento: function(){
						this.event_aggregator.trigger("event_mundo:add_Element");
				},

				addCharToInput: function(e){
+					this.event_aggregator.trigger("event_formulario:insert_Char", $(e.target).text());
 				},

        mensaje : function(){
          alert("apretaste afuera")
        },

				verificar : function(){
					console.log('collection-Elementos.toJSON(): ', app.elemento_collention.toJSON());
    			console.log('JSON.stringify(collection.toJSON()): ', JSON.stringify(app.elemento_collention.toJSON()));
				  console.log('-------------------');
					console.log('collection-Sentencias.toJSON(): ', app.sentencia_collention.toJSON());
    			console.log('JSON.stringify(collection.toJSON()): ', JSON.stringify(app.sentencia_collention.toJSON()));
				}
    });

  })(jQuery);
