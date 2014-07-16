/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function numberOnly(evt) {
  var theEvent = evt || window.event;
  var key = theEvent.keyCode || theEvent.which;
  key = String.fromCharCode( key );
  var regex = /[0-9]/;
  if( !regex.test(key) ) {
    theEvent.returnValue = false;
    if(theEvent.preventDefault) theEvent.preventDefault();
  }
}

function saveAmount(){
    var WithdrawAmount = document.getElementById('WithdrawAmount').value;
    document.getElementById('WAmount').value = document.getElementById('WithdrawAmount').value;
    //alert(document.getElementById('WAmount').value);
    submitSaveAmount();
}

function saveAmount10(){
    document.getElementById('WAmount').value = 10;
    //alert(document.getElementById('WAmount').value);
    submitSaveAmount();
}
            
function saveAmount20(){
    document.getElementById('WAmount').value = 20;
    //alert(document.getElementById('WAmount').value);
    submitSaveAmount();
}
            
function saveAmount50(){
    document.getElementById('WAmount').value = 50;
    //alert(document.getElementById('WAmount').value);
    submitSaveAmount();
}

function submitSaveAmount(){
    document.getElementById("Withdraw").submit();
}

function ConfirmWithdraw(){
    document.getElementById("Withdraw").submit();
}
