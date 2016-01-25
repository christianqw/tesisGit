/*global Backbone, jQuery, _, ENTER_KEY, ESC_KEY */
var app = app || {};

(function ($) {
	'use strict';

	// Sentencia Item View
	// --------------
    app.SentenciaView = Backbone.View.extend({
				tagName:"li",
				className:"item_sentencia has-feedback",
				template:$("#Item_Sentencia_Template").html(),
				var_char_pos:0,

				events:{
					'click input.input_sentencia' : 'edit',
					'click .btn-destroy-trash' : 'clear',
					'blur .input_sentencia' : 'updateOnFocusOut',
					'keypress .edit': 'updateOnEnter'
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
				//	alert("se toma el focus de la sentencia");
					this.event_aggregator.trigger("event_formulario:edit_Focus", this);
				},

				clear : function(){
					this.model.destroy();
				},

				updateOnClikBtnChar : function(c){
					console.log("estoy llamando a mimi");
					console.log("dentro de la sentencian- pos: " + this.var_char_pos);
					var string = this.model.get('valor');
					string = string.substring(0, this.var_char_pos) + c + string.substring(this.var_char_pos);
					console.log(string);
					this.model.save({valor : string});
					this.var_char_pos = this.var_char_pos + 3;
				},

				updateOnFocusOut: function(){
						this.var_char_pos = this.$('input').prop('selectionStart');
						var value = this.$('input').val();
						if (value){
							//Eliminado, genera conflicto con la inserciond ecaracteres
							//var trimmedValue = value.trim();//string sin espacios
							if (this.model.get("valor") !== value){
								this.model.save({ valor: value });
								//this.model.trigger('change', this.model);
							}
						} else {
							if (this.model.get("valor")){
								this.model.save({valor : ""});
								//this.model.trigger('change', this.model);
								}
						};
				},

				remove_editing : function(){

					this.$el.removeClass('editing');
					this.$el.find(".my-icon-resultado").removeClass('my-icon-editing').addClass('my-icon-none');
					//this.model.save({estado : "my-icon-none"});
				},

				add_editing : function(){
					this.model.save({estado : "my-icon-editing"});
					this.$el.find(".my-icon-resultado").removeClass('my-icon-none').addClass('my-icon-editing');
					//this.$el.addClass('editing');

				},

				updateOnEnter : function(){

				}

    });
  })(jQuery);
