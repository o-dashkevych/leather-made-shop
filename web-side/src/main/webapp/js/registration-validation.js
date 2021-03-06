/* General functions for validation and elements processing */

var warningsFunctionsSet;

function isExist(id) {
    var result = document.getElementById(id) !== null;
    return result;
}


function createWarning(fieldDiv, id) {
    var warning = document.createElement('span');
    warning.setAttribute('id', id);
    document.getElementById(fieldDiv).appendChild(warning);
    return warning;
}

function createElementWarningIfNotExistAndGet(fieldDiv, id) {
    if (isExist(id)) {
        return document.getElementById(id);
    } else {
        return createWarning(fieldDiv, id);
    }
}

function setWarningTextIfInvalid(divId, warningId, warning, isValid) {
    var warningElement = createElementWarningIfNotExistAndGet(divId, warningId);
    if (!isValid) {
        warningElement.textContent = warning;
    } else if (isExist(warningId)) {
        document.getElementById(warningId).textContent = '';
    }
}


function addOrRemoveWarningFunction(warningFunction, isToRemove) {
    if (isToRemove) {
        warningsFunctionsSet.delete(warningFunction);
    } else {
        warningsFunctionsSet.add(warningFunction);
    }
}

function attachEventToElement(elementId, eventName, functionName) {
    var element = document.getElementById(elementId);
    if (element.addEventListener) { // For all major browsers, except IE 8 and earlier
        element.addEventListener(eventName, functionName);
    } else if (element.attachEvent) { // For IE 8 and earlier versions
        element.attachEvent("on" + eventName, functionName);
    }
}


function validateRepeatValue(firstPasswordField, secondPasswordField) {
    var firstValue = document.getElementsByName(firstPasswordField)[0].value;
    var secondValue = document.getElementsByName(secondPasswordField)[0].value;
    if(firstValue.length === 0 || secondValue.length === 0){
        return false;
    }
    return firstValue === secondValue;
}

/*On submit warning check */

function showWarningsIfSubmit(eventObject) {
    if (warningsFunctionsSet.size !== 0) {
        if (eventObject.preventDefault) {
            eventObject.preventDefault();
        } else if (window.event) { /* for ie */
            window.event.returnValue = false;
        }
        warningsFunctionsSet.forEach(function (item) {
            item();
        });
        return false;
    }
    return true;
}

/* Name input validation*/

function validateName(firstEmailField) {
    var login = document.getElementsByName(firstEmailField)[0].value
        , loginPattern = /^([a-zA-Z]+[0-9]*){3,30}$/i;
    return loginPattern.test(login);
}

function setWarningIfInvalidName() {
    var isValidName = validateName("name");
    addOrRemoveWarningFunction(setWarningIfInvalidName, isValidName);
    setWarningTextIfInvalid("nameDiv", "warningName", "Invalid name", isValidName);
}

/* Surname input validation*/

function setWarningIfInvalidSurname() {
    var isValidSurname = validateName("surname");
    addOrRemoveWarningFunction(setWarningIfInvalidSurname, isValidSurname);
    setWarningTextIfInvalid("surnameDiv", "warningSurname", "Invalid surname", isValidSurname);
}


/* Email validation */

function validateEmail(name) {
    var emailPattern = /^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i;
    var email = document.getElementsByName(name)[0].value;
    return emailPattern.test(email);
}

function setWarningIfInvalidEmail() {
    var isValidEmail = validateEmail('email');
    addOrRemoveWarningFunction(setWarningIfInvalidEmail, isValidEmail);
    setWarningTextIfInvalid("emailDiv", "warningEmail", "Invalid email", isValidEmail);
}

/* Repeat email input validation*/

function setWarningIfInvalidRepeatEmail() {
    var isValidRepeatEmail = validateRepeatValue("email", "emailRepeat");
    addOrRemoveWarningFunction(setWarningIfInvalidRepeatEmail, isValidRepeatEmail);
    setWarningTextIfInvalid("emailRepeatDiv", "warningRepeatEmail", "Emails doesn't match", isValidRepeatEmail);
}

/* Password input validation*/

function validatePassword(passwordField) {
    var password = document.getElementsByName(passwordField)[0].value;
    var passwordPattern = /^[\w+\s]{4,10}$/i;
    return passwordPattern.test(password);
}

function setWarningIfInvalidPassword() {
    var isValidPassword = validatePassword("password");
    addOrRemoveWarningFunction(setWarningIfInvalidPassword, isValidPassword);
    setWarningTextIfInvalid("passwordDiv", "warningPassword", "Invalid password", isValidPassword);
}

/* Repeat password input validation*/

function setWarningIfInvalidRepeatPassword() {
    var isValidRepeatPassword = validateRepeatValue("password", "passwordRepeat");
    addOrRemoveWarningFunction(setWarningIfInvalidRepeatPassword, isValidRepeatPassword);
    setWarningTextIfInvalid("passwordRepeatDiv", "warningRepeatPassword", "Passwords doesn't match", isValidRepeatPassword);
}

function setListenersAndWarnings() {
    warningsFunctionsSet = new Set();
    warningsFunctionsSet.add(setWarningIfInvalidName);
    attachEventToElement("name", "input", setWarningIfInvalidName);
    attachEventToElement("name", "blur", setWarningIfInvalidName);

    warningsFunctionsSet.add(setWarningIfInvalidSurname);
    attachEventToElement("surname", "input", setWarningIfInvalidSurname);
    attachEventToElement("surname", "blur", setWarningIfInvalidSurname);

    warningsFunctionsSet.add(setWarningIfInvalidEmail);
    attachEventToElement("email", "input", setWarningIfInvalidEmail);
    attachEventToElement("email", "blur", setWarningIfInvalidEmail);

    warningsFunctionsSet.add(setWarningIfInvalidRepeatEmail);
    attachEventToElement("email", "blur", setWarningIfInvalidRepeatEmail);
    attachEventToElement("emailRepeat", "input", setWarningIfInvalidRepeatEmail);

    warningsFunctionsSet.add(setWarningIfInvalidPassword);
    attachEventToElement("password", "blur", setWarningIfInvalidPassword);
    attachEventToElement("password", "input", setWarningIfInvalidPassword);

    warningsFunctionsSet.add(setWarningIfInvalidRepeatPassword);
    attachEventToElement("password", "input", setWarningIfInvalidRepeatPassword);
    attachEventToElement("password", "blur", setWarningIfInvalidRepeatPassword);
    attachEventToElement("passwordRepeat", "input", setWarningIfInvalidRepeatPassword);

    attachEventToElement("registerSubmit", "click", showWarningsIfSubmit);
}
setListenersAndWarnings();