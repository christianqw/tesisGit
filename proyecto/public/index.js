$(document).ready(function() {
  $("#send").on('click', function(e) {
      $.ajax({
          type: 'post',
          headers: { 'content-type': 'application/json' },
          data:JSON.stringify({
                  "cars":[
                    {
                      "color":"Blue",
                      "miles":100,
                      "vin":"1234"
                    },
                    {
                      "color":"Red",
                      "miles":400,
                      "vin":"1235"
                    }
                  ],
                  "truck":{
                    "color":"Red",
                    "miles":400,
                    "vin":"1235"
                  }
                }),
          url: "http://localhost:8080/carsandtrucks"
      }).then(function(data, status, jqxhr) {
        console.log(jqxhr);
          });
  });

});
