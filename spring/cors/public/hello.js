$(document).ready(function() {
  $("#send").on('click', function(e) {
      $.ajax({
          type: 'post',
          data: $("#name_imputs").serializeArray(),
          url: "http://localhost:8080/greeting"
      }).then(function(data, status, jqxhr) {
         $('.greeting-id').append(data.id);
         $('.greeting-content').append(data.content);
         console.log(jqxhr);
          });
  });

  $("#send2").on('click', function(e) {
      $.ajax({
          type: 'post',
          data:
          {
            "nombre" : "luis",
            "instrumento" : "asdasd"
            //,"listaCD" : [],
            /*"banda" : {
                        "nombre_banda" : "musica",
                        "integrantes" : 5
                      }*/
          },

          url: "http://localhost:8080/musicando"
      }).then(function(data, status, jqxhr) {
         //$('.greeting-id').append(data.id);
         //$('.greeting-content').append(data.content);
         console.log(jqxhr);
          });
  });
});

/*
{ "musico" :
    {
      "nombre" : "luis",
      "instrumento" : "asdasd"
    },
  //,"listaCD" : [],
  "banda" : {
              "nombre_banda" : "musica",
              "integrantes" : 5
            }
},
*/
