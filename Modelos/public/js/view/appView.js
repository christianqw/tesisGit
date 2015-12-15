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
					"click #id_btn_remove" : "funcion_popup",
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
						var _id_atributos = $("#marco_elementos .ui-tabs-active a").attr("href");
						console.log("form: ");
						console.log(_id_atributos);
						var _Json_atributos = $(_id_atributos).serializeArray();
						console.log("serializado: ");
						console.log(_Json_atributos);
						var tipo = $("#marco_elementos .ui-tabs-active img").attr("id");
						var data = { "tipo" : tipo };
						console.log("   tipo: "+ tipo + "    data: " + data);
						 $.each(_Json_atributos, function (i, obj) {
							 data[obj.name] = obj.value;
						 });
						console.log(data);
						//var aux = $_tab.tabs( "select",  $_tab.tabs( "option", "active" ) );
						//console.log( aux.serializeArray() );
						this.event_aggregator.trigger("event_mundo:add_Element", data);
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
				},

				funcion_popup : function(){
					alert("ALERT: apretaste borrar...");
					var mascara = new Image();
					mascara.src = "images/mascara.png";
					alert(mascara);
					var data = mascara.data;
					alert(data);
					var width = mascara.width;
					var height = mascara.height;
					alert("width: " + width + "height: "+ height);
				}
    });

  })(jQuery);
