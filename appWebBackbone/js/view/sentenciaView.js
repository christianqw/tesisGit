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
					'blur .input_sentencia' : 'close',
					//'blur .edit' : 'close', //implica sacar el tag editar de la sentencia?
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
					$(".editing").removeClass('editing');
					//alert("editando...");
					this.$el.addClass('editing');
					//this.$input.focus();
				},

				clear : function(){
					//alert("eliminado...");
					this.model.destroy();
				},

				close: function(){ //esto esta medio bastante choto
 					var value = $(".editing > input").val();
					console.log( "VALOR DE LA VARIABLE: " +  value + "<-");
					if (value){
						var trimmedValue = value.trim();//string sin espacios
						if (this.model.get("valor") !== trimmedValue){
							console.log( "VALOR DEL MODELO " +  this.model.get("valor") + "   VALOR ACORTADO: " + trimmedValue);
							this.model.save({ valor: trimmedValue });console.log("GUARDADOOOO EN MODELO");
							this.model.trigger('change', this.model);
						}
					} else {
						if (this.model.get("valor")){
							this.model.save({valor : ""});
							this.model.trigger('change', this.model);
							}
						console.log("no tiene nada el Imput");
					};
				},

				updateOnFocusOut: function(){
					function ejecutar(that, $input){
						if ($input.val()){
							value = $input.val();
							alert( "alert interno   " +  value);
							var trimmedValue = value.trim();//string sin espacios
							if (that.model.get("valor") !== trimmedValue){
								alert( "VALOR DEL MODELO " +  that.model.get("valor") + "   VALOR ACORTADO: " + trimmedValue);
								that.model.save({ valor: trimmedValue });
								that.model.trigger('change');
							}
						} else {
							alert("input val undefined .. ");
						}
					};

					var that = this;
					var $input = $(".editing > input");
					if (!this.$el.hasClass('editing')) {
						return;
					};

					ejecutar (that, $input);
					alert("THE END");
					return;

				},

				_update_OnFocusOut: function(){
					if (typeof this.$input.val() !== "undefined" ){
						var value = this.$input.val();
						var trimmedValue = value.trim();

						if (!this.$el.hasClass('editing')) {
							return;
						}

						if (trimmedValue) {
							this.model.save({ valor: trimmedValue });
							if (value !== trimmedValue) {
								// Model values changes consisting of whitespaces only are
								// not causing change to be triggered Therefore we've to
								// compare untrimmed version with a trimmed one to check
								// whether anything changed
								// And if yes, we've to trigger change event ourselves
								this.model.trigger('change');
							}
						}
					};
					alert("fin de close");
				},

				updateOnEnter: function(){

				},
				revertOnEscape: function(){

				}
    });
  })(jQuery);
