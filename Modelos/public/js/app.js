(function ($) {

  // -------- Conector -------
  Backbone.View.prototype.event_aggregator = _.extend({}, Backbone.Events);

    //defino menu de elementos como tabs
    $( "#marco_elementos" ).tabs();

    //defino receptor donde se pueden soltar los elementos
    $(".contenedor_modelo").droppable();
    $("#menu_ctx_elem").menu();

    var appView = new app.AppView();


})(jQuery);
