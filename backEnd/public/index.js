$(document).ready(function() {
  $("#send").on('click', function(e) {
      $.ajax({
          type: 'post',
          headers: { 'content-type': 'application/json' },
          data:JSON.stringify({
                  "listaElementos":[
                    {"tipo":"tipo1","dominio":"animal","att1":"chico","att2":"despierto","nombre":"e1","zona":"bosque","img":"images/icon_chancho.png","left":62,"top":146,"id":"1327578c-34d4-8c0c-95b5-2fea3670c64d"},
                    {"tipo":"tipo3","dominio":"animal","att1":"chico","att2":"despierto","nombre":"e2","zona":"bosque","img":"images/icon_pato.png","left":205,"top":140,"id":"d22f5b75-eff1-ff50-0f4c-8497aa3f8870"}
                  ],
                  "listaSentencias": [
                    {"nombre":"form_X","valor":"@ x (Asd(x)  | Despierto (x))","estado":"","mensaje":"","id":"2a2beaa5-8513-bd27-ea29-b150247a4f1f"},
                    {"nombre":"form_02","valor":"13223123123","estado":"","mensaje":"","id":"afc8524b-51d9-3ef9-2d9b-e8b265b2a1c0"}
                  ]
                }),
          url: "http://localhost:8080/action"
      })
      .then(function(data, status, jqxhr) {
        $('#respuesta').html('');
        console.log(jqxhr);
        console.log(app);
        var s = data["listaSentencias"];
        for (var i in  s) {
          $('#respuesta').append('Elemenento ' + i +' : ' + s[i] + '<br/>');
        }


      });
  });
});
