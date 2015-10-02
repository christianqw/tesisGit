$(document).ready(function() {
  $("#send").on('click', function(e) {
    $.ajax({
        type: 'post',
        dataType: 'json',
        data: $("#name_imputs").serializeArray(),
        url: "http://localhost:8080/greeting"        
    }).then(function(data, status, jqxhr) {
       $('.greeting-id').append(data.id);
       $('.greeting-content').append(data.content);
       console.log(jqxhr);
    });
  });

});
