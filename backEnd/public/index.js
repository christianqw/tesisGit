$(document).ready(function() {
  $("#send").on('click', function(e) {
      $.ajax({
          type: 'post',
          headers: { 'content-type': 'application/json' },
          data:JSON.stringify({
                  "sentens": [
                    {"nombre":"form_X","valor":"sasdasdasd","estado":"","mensaje":"","id":"2a2beaa5-8513-bd27-ea29-b150247a4f1f"},
                    {"nombre":"form_02","valor":"13223123123","estado":"","mensaje":"","id":"afc8524b-51d9-3ef9-2d9b-e8b265b2a1c0"}
                  ]
                }),
          url: "http://localhost:8080/act"
      }).then(function(data, status, jqxhr) {
        console.log(jqxhr);
          });
  });

});
