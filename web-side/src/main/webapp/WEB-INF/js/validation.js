var emailInput = document.getElementById('email');
if (emailInput.addEventListener) { // For all major browsers, except IE 8 and earlier
    emailInput.addEventListener("oninput", emailValidation);
} else if (emailInput.attachEvent) { // For IE 8 and earlier versions
    emailInput.attachEvent("oninput", emailValidation);
}

var emailValidation = function validateEmail() {
    var emailPattern = /^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i;
    var email = document.getElementsByName('email')[0].value
    var result = emailPattern.test(email);
    console.log('matches = ' + result);
    var warningEmailId = 'warningEmail';
    var warning = createEmailWarningIfNotExistAndGet(warningEmailId);
    if (!result) {
        warning.textContent = 'Invalid email';
    } else if (isExist(warningEmailId)) {
        document.getElementById(warningEmailId).textContent = '';
    }
}

function createEmailWarning(id) {
    var warning = document.createElement('p');
    var emailDiv = document.getElementById('emailDiv');
    warning.setAttribute('id', id);
    emailDiv.appendChild(warning);
    return warning;
}

function isExist(id) {
    var result = document.getElementById(id) !== null;
    console.log(id + ' exist = ' + result);
    return result;
}

function createEmailWarningIfNotExistAndGet(id) {
    if (isExist(id)) {
        var resultItem = document.getElementById(id);
    } else {
        resultItem = createEmailWarning(id);
    }
    return resultItem;
}