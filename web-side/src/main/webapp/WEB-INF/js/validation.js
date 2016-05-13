attachEventToElement("email", "input", setWarningIfInvalidEmail);
attachEventToElement("emailRepeat", "input", setWarningIfInvalidRepeatEmail);

function attachEventToElement(elementId, eventName, functionName) {
    var element = document.getElementById(elementId);
    if (element.addEventListener) { // For all major browsers, except IE 8 and earlier
        element.addEventListener(eventName, functionName);
    } else if (element.attachEvent) { // For IE 8 and earlier versions
        element.attachEvent("on" + eventName, functionName);
    }
}

function setWarningIfInvalidRepeatEmail() {
    var isValidRepeatEmail = validateRepeatEmail("email", "emailRepeat");
    console.log('are same emails = ' + isValidRepeatEmail);
    setWarningTextIfInvalid("emailRepeatDiv", "warningRepeatEmail", "Emails doesn't match", isValidRepeatEmail)
}

function validateRepeatEmail(firstEmailField, secondEmailField) {
    var firstEmail = document.getElementsByName(firstEmailField)[0].value;
    var secondEmail = document.getElementsByName(secondEmailField)[0].value;
    return firstEmail === secondEmail;
}

function setWarningIfInvalidEmail() {
    var isValidEmail = validateEmail('email');
    console.log('is valid email = ' + isValidEmail);
    setWarningTextIfInvalid("emailDiv", "warningEmail", "Invalid email", isValidEmail)
}

function setWarningTextIfInvalid(divId, warningId, warning, isValid) {
    var warningElement = createElementWarningIfNotExistAndGet(divId, warningId);
    if (!isValid) {
        warningElement.textContent = warning;
    } else if (isExist(warningId)) {
        document.getElementById(warningId).textContent = '';
    }
}

function validateEmail(name) {
    var emailPattern = /^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i;
    var email = document.getElementsByName(name)[0].value;
    return emailPattern.test(email);
}

function createWarning(fieldDiv, id) {
    var warning = document.createElement('p');
    var emailDiv = document.getElementById(fieldDiv);
    warning.setAttribute('id', id);
    emailDiv.appendChild(warning);
    return warning;
}

function isExist(id) {
    var result = document.getElementById(id) !== null;
    console.log(id + ' exist = ' + result);
    return result;
}

function createElementWarningIfNotExistAndGet(fieldDiv, id) {
    if (isExist(id)) {
        var resultItem = document.getElementById(id);
    } else {
        resultItem = createWarning(fieldDiv, id);
    }
    return resultItem;
}