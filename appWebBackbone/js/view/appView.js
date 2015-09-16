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
					"click #add_element" :"addNewElemento"
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
            this.event_aggregator.trigger("event_sentencia:add_Before");
        },

				addNewElemento: function(){
						this.event_aggregator.trigger("event_element:add_Element");
				},

        mensaje : function(){
          alert("apretaste afuera")
        }
    });

  })(jQuery);
