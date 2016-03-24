/*global Backbone, jQuery, _, ENTER_KEY, ESC_KEY */
var app = app || {};

(function ($) {
	'use strict';

  // The Application
	// ---------------

    app.AppView = Backbone.View.extend({
        el:$("#app_container"),  //Panel de Trabajo

        events:{
          "click #id_btn_add_sentencia" :"addNewSentencia",
					"click #add_element" :"addNewElemento",
					"click .btn-character" :"addCharToInput",
					"click #id_btn_action" : "verificar",
					"click #id_btn_clear" : "clearAllInputs",
					//-------------
					"click #id_btn_remove" : "funcion_popup",
					"click #edit_element" : "editFocusElement"
        },

        initialize:function(){

					var list_sentenciasView = new app.List_SentenciasView();
					var conj_elementosView = new app.Conj_ElementosView();
					var boardView = new app.BoardView({model: new app.FondoModelo});
					//var boardView = new app.BoardView({model: new app.FondoModelo}); sin realizar el new en el inic
        },

        render: function(){
          this.$el.append(app.list_sentenciasView.render().el);
					this.$el.append(app.conj_elementosView.render().el);
					this.$el.append(app.boardView.render().el);
          return this;
        },

        addNewSentencia: function(){
            this.event_aggregator.trigger("event_formulario:add_Before");
        },

				clearAllInputs: function(){
					this.event_aggregator.trigger("event_formulario:clearAll");
				},

				capturarAtributos: function(){
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

					return data;
				},

				addNewElemento: function(){
						var d = this.capturarAtributos();
						//var aux = $_tab.tabs( "select",  $_tab.tabs( "option", "active" ) );
						//console.log( aux.serializeArray() );
						this.event_aggregator.trigger("event_mundo:add_Element", d);
				},

				editFocusElement: function(){
					var d = this.capturarAtributos();
					this.event_aggregator.trigger("event_mundo:edit_Element", d);
				},

				addCharToInput: function(e){
+					this.event_aggregator.trigger("event_formulario:insert_Char", $(e.target).text());
 				},

        mensaje : function(){
          alert("apretaste afuera")
        },

				verificar : function(){
					//console.log('collection-Elementos.toJSON(): ', app.elemento_collention.toJSON());
    			//console.log('JSON.stringify(collection.toJSON()): ', JSON.stringify(app.elemento_collention.toJSON()));
				  //console.log('-------------------');
					//console.log('collection-Sentencias.toJSON(): ', app.sentencia_collention.toJSON());
    			console.log('JSON.stringify(collection.toJSON()): ', JSON.stringify(app.sentencia_collention.toJSON()));

					var listaElementos = app.elemento_collention.toJSON();
					var listaSentencias = app.sentencia_collention.toJSON();
					var that =this.event_aggregator;
					//beggin AJAX
					$.ajax({
		          type: 'post',
		          headers: { 'content-type': 'application/json' },
		          data:JSON.stringify({
		                  "listaElementos":listaElementos,
		                  "listaSentencias": listaSentencias
		                }),
		          url: "http://localhost:8080/action",
							//success: function(data){
							//		that.trigger("event_formulario:insert_Char", "dentro del Ajax");
							//}
		      }).then(function(data, status, jqxhr) {
						//	var lsentenciasR = data["listaSentencias"];
						that.trigger("event_formulario:respuestaResivida",  data["listaSentencias"]);
	    			//for (var i in  s) {
		        //  $('#respuesta').append('Elemenento ' + i +' : ' + s[i] + '<br/>');
		        //}
		      });
					//end AJA

				},

				funcion_popup : function(){
					alert("ALERT: apretaste borrar...");

				}
    });

  })(jQuery);
