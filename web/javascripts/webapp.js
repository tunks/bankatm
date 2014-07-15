
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


  $("#addCustomer").bind("click", function(event) {
     event.preventDefault();
     var url = $(this).attr("href");
      $.get( url, function( data ) {
        $( "#bankAccountsBank" ).html( data );
        });
    });
    
  //post customer account
   $("form#createCustomer" ).submit(function( event ) {
      /*if ( $( "input:first" ).val() === "correct" ) {
        $( "span" ).text( "Validated..." ).show();
        return;
        }
        $( "span" ).text( "Not valid!" ).show().fadeOut( 1000 );
        */
           event.preventDefault();
           var $form = $( this ),
            url = $form.attr( "action" );
            // Send the data using post
            console.log($form);
             $.ajax({
                    type: "POST",
                    //the url where you want to sent the userName and password to
                    url: url,
                    //dataType: 'json',
                    async: false,
                    //json object to sent to the authentication url
                    data: $form.serialize(),
                    success: function (response) {
                    alert("Thanks!"); 
                    },
                    error:function(error){
                        console.log(error);
                    }
                    
                });
    });
    
  //close customer form
   $("button#closeCustomerForm").bind("click", function(event) {
      event.preventDefault();
      var url = "bank";
      $.get( url, function( data ) {
        $( "#bankAccountsBank" ).html( data );
        });
    });
//captacha
//$("#realPerson").realperson();
//$("#realPerson").realperson({chars: $.realperson.alphanumeric,length: 6});


});