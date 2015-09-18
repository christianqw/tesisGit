/*global Backbone, jQuery, _, ENTER_KEY, ESC_KEY */
var app = app || {};

(function ($) {
	'use strict';

	// Sentencia Item View
	// --------------
    app.SentenciaView = Backbone.View.extend({
				tagName:"div",
				className:"item_sentencia has-feedback",
				template:$("#Item_Sentencia_Template").html(),

				events:{
					'click input.input_sentencia' : 'edit',
					'click .destroy' : 'clear',
					'blur .input_sentencia' : 'updateOnFocusOut',
					'keypress .edit': 'updateOnEnter',
					'keydown .edit' : 'revertOnEscape'
				},

				initialize: function () {
					this.listenTo(this.model, 'destroy', this.remove); //cuando se elimina actualiza
					this.listenTo(this.model, 'change', this.render);  //Por los espacion adelante... cuando se edita el modelo actualiza.
				},

				mensaje:function(){
					//alert("mensaje mensaje mensaje");
				},

        render:function () {
					if (this.model.changed.id !== undefined) {
						return;
					}
					//tmpl is a function that takes a JSON object and returns html
            var tmpl = _.template(this.template);
          //this.el is what we defined in tagName. use $el to get access to jQuery html() function
            this.$el.html(tmpl(this.model.toJSON()));
            return this;
        },

				edit: function(){
					alert("se toma el focus de la sentencia");
																													//, this
					this.event_aggregator.trigger("event_formulario:edit_Focus");
					//var aux = this;
					//$(".editing").removeClass('editing');
					//this.$el.addClass('editing');

				},

				clear : function(){
					this.model.destroy();
				},

				updateOnFocusOut: function(){
						var value = this.$('input').val();
						if (value){
							var trimmedValue = value.trim();//string sin espacios
							if (this.model.get("valor") !== trimmedValue){
								this.model.save({ valor: trimmedValue });
								this.model.trigger('change', this.model);
							}
						} else {
							if (this.model.get("valor")){
								this.model.save({valor : ""});
								this.model.trigger('change', this.model);
								}
						};
					},

				updateOnEnter: function(){

				},
				revertOnEscape: function(){

				}
    });
  })(jQuery);
