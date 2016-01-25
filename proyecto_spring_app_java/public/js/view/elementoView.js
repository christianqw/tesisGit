/*global Backbone, jQuery, _, ENTER_KEY, ESC_KEY */
var app = app || {};

(function ($) {
  'use strict';

  // Sentencia Item View
  // --------------
    app.ElementoView = Backbone.View.extend({

        tagName:"div",
        className:"draggable elementoInsertado",
        template:$("#Elemento_Template").html(),

        events:{
          'click img.elemento_insertado': 'element_focus',
          'click .destroy' : 'delete'
          //'contextmenu img.elemento_insertado': 'mm'
          //no andan!!
          //"dragstop .draggable": "edit_position_model"
          //'stop .elemento_insertado': 'edit_position_model'
        },

        initialize:function(){
          this.listenTo(this.model, 'destroy', this.remove); //cuando se elimina actualiza
					//this.listenTo(this.model, 'change', this.render);  //Por los espacion adelante... cuando se edita el modelo actualiza.
				},

        element_focus: function(){
          alert("focus en " + this.model.get("nombre"));
          this.event_aggregator.trigger("event_mundo:edit_Focus_Element", this);
        },

        render:function () {
          //tmpl is a function that takes a JSON object and returns html
          var tmpl = _.template(this.template);
          //this.el is what we defined in tagName. use $el to get access to jQuery html() function
          this.$el.html(tmpl(this.model.toJSON()));
          var that = this;
          var data = {"left": 0, "top": 0 };
          var size = {"h": 41 , "w": 41};
          this.$el.draggable({
                  stop: function( event, ui ) {
                  //alert("Dentro del Drop ccccccc");
                  var data = {"left": ui.position.left, "top": ui.position.top };
                  var size = {"h": 41 , "w": 41};
                  //alert("left: " + 	data["left"]+ " top: " + data["top"] );
                  //alert("ddddddd");
                  that.event_aggregator.trigger("event_board:setPos", that, data, size);
                  //that.stop_drop(ui.position.left, ui.position.top);
                }
          }).css({position:"absolute", top:0, left:0})
          //alert("Por fuera del Drop - left: " + 	data["left"]+ " top: " + data["top"] );
          this.event_aggregator.trigger("event_board:setPos", that, data, size);
          return this;
        },

        individualRender: function(){
          //tmpl is a function that takes a JSON object and returns html
          var tmpl = _.template(this.template);
          //this.el is what we defined in tagName. use $el to get access to jQuery html() function
          this.$el.html(tmpl(this.model.toJSON()));
          return this;
        },

        remove_editingFocus : function(){
					this.$el.removeClass('editing-focus');
				},

				add_editingFocus : function(){
					this.$el.addClass('editing-focus');
				},

        editData : function(d){
          this.model.save(d);
          this.model.updateImg();
          this.individualRender();
        },

        delete : function(){
          this.model.destroy();
        },

        mm : function (event) {
          // body...
          //alert("evento capturado. menu contextual");
         var $menu_ctx = $("#contextMenu");
         $menu_ctx.position({
                  my: "left top",
                  of: event
              });
          console.log("antes del show");
          $menu_ctx.show().on('click', 'a',
                      function (e) {
                        $menu_ctx.hide();
                        alert("mira las cosas de la memoria")
                        alert(e.target);
                      });
          console.log("show");
          return false;
        }
/*
        render:function () {
          //tmpl is a function that takes a JSON object and returns html
          var tmpl = _.template(this.template);
          //this.el is what we defined in tagName. use $el to get access to jQuery html() function
          this.$el.html(tmpl(this.model.toJSON()));
          var that = this.model;
          var data = {"left": 0, "top": 0 };
          this.$el.draggable({
                  stop: function( event, ui ) {
                  data = {"left": ui.position.left, "top": ui.position.top }
                  alert("left: " + 	data["left"]+ " top: " + data["top"] );
                  //var z = app.boardView.model.getStringZona(ui.position.left,  ui.position.top );
                  that.stop_drop(ui.position.left, ui.position.top);
                }
          }).css({position:"absolute", top:0, left:0})
          //this.event_aggregator.trigger("event_board:setPos", that, data);
          return this;
        }*/
    });
  })(jQuery);
