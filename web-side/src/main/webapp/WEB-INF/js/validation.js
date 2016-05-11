var emailValidation = function validateEmail(){
    var emailPattern = /^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i;
    var email = document.getElementsByName('email')[0].value
    var result = email.match(emailPattern);
    if(!result){
        var message = 'Invalid email';
        var warning = document.createElement('p');
        warning.innerHTML = message;
        document.getElementById('emailDiv').appendChild(warning);
    }
}