
jQuery( document ).ready(function( $ ) {
/*$( "#login" ).submit(function( event ) {
    // Stop form from submitting normally
    event.preventDefault();
    // Get some values from elements on the page:
    var $form = $( this ),
    term = $form.find( "input[name='s']" ).val(),
    url = $form.attr( "action" );
    // Send the data using post
    var posting = $.post( url, { s: term } );
    // Put the results in a div
    posting.done(function( data ) {
    var content = $( data ).find( "#content" );
    $( "#result" ).empty().append( content );
    });
});
*/


  $("a.bind-jquery-event-here-class").bind("click", function(event) {
    event.preventDefault();
    var url = $(this).attr("href");
        alert("loading via proxy: " + url);
    $.ajax({
      type: "POST",
      url: "proxy.php",
      data: "url="+url, 
      success: function(data){
        alert("finally got data " + data);
      }
    });
    });
    
//captacha
$("#realPerson").realperson();
$("#realPerson").realperson({chars: $.realperson.alphanumeric,length: 6});


});