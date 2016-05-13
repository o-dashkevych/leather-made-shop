'use strict';

var warningsFuncsSet = new Set();


/*On submit warning check */

function showWarningsIfSubmit(event) {
    if (warningsFuncsSet.size == 0) {
        event.preventDefault();
        warningsFuncsSet.forEach(func => window[func]());
    }
}

/* Login input validation*/

function setWarningIfInvalidLogin() {
    var isValidLogin = validateLogin("login");
    addOrRemoveWarningFunction(setWarningIfInvalidLogin, isValidLogin);
    console.log('is valid login = ' + isValidLogin);
    setWarningTextIfInvalid("loginDiv", "warningLogin", "Invalid login", isValidLogin);
}

function validateLogin(firstEmailField) {
    var login = document.getElementsByName(firstEmailField)[0].value;
    var loginPattern = /^([a-zA-Z]+[0-9]*){4,10}$/i;
    return loginPattern.test(login);
}

/* Email validation */

function setWarningIfInvalidEmail() {
    var isValidEmail = validateEmail('email');
    addOrRemoveWarningFunction(setWarningIfInvalidEmail, isValidEmail);
    console.log('is valid email = ' + isValidEmail);
    setWarningTextIfInvalid("emailDiv", "warningEmail", "Invalid email", isValidEmail);
}

function validateEmail(name) {
    var emailPattern = /^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i;
    var email = document.getElementsByName(name)[0].value;
    return emailPattern.test(email);
}

/* Repeat email input validation*/

function setWarningIfInvalidRepeatEmail() {
    var isValidRepeatEmail = validateRepeatEmail("email", "emailRepeat");
    addOrRemoveWarningFunction(setWarningIfInvalidRepeatEmail, isValidRepeatEmail);
    console.log('are same emails = ' + isValidRepeatEmail);
    setWarningTextIfInvalid("emailRepeatDiv", "warningRepeatEmail", "Emails doesn't match", isValidRepeatEmail)
}

function validateRepeatEmail(firstEmailField, secondEmailField) {
    var firstEmail = document.getElementsByName(firstEmailField)[0].value;
    var secondEmail = document.getElementsByName(secondEmailField)[0].value;
    return firstEmail === secondEmail;
}

/* Password input validation*/

function setWarningIfInvalidPassword() {
    var isValidPassword = validatePassword("password");
    addOrRemoveWarningFunction(setWarningIfInvalidPassword, isValidPassword);
    console.log('is valid password = ' + isValidPassword);
    setWarningTextIfInvalid("passwordDiv", "warningPassword", "Invalid password", isValidPassword);
}

function validatePassword(passwordField) {
    var password = document.getElementsByName(passwordField)[0].value;
    var passwordPattern = /^[\w+\s]{4,10}$/i;
    return passwordPattern.test(password);
}

/* Repeat password input validation*/

function setWarningIfInvalidRepeatPassword() {
    var isValidRepeatPassword = validateRepeatPassword("password", "passwordRepeat");
    addOrRemoveWarningFunction(setWarningIfInvalidRepeatPassword, isValidRepeatPassword);
    console.log('are same passwords = ' + isValidRepeatPassword);
    setWarningTextIfInvalid("passwordRepeatDiv", "warningRepeatPassword", "Passwords doesn't match", isValidRepeatPassword);
}

function validateRepeatPassword(firstPasswordField, secondPasswordField) {
    var firstPassword = document.getElementsByName(firstPasswordField)[0].value;
    var secondPassword = document.getElementsByName(secondPasswordField)[0].value;
    return firstPassword === secondPassword;
}

/* General functions for validation and elements processing */

function setWarningTextIfInvalid(divId, warningId, warning, isValid) {
    var warningElement = createElementWarningIfNotExistAndGet(divId, warningId);
    if (!isValid) {
        warningElement.textContent = warning;
    } else if (isExist(warningId)) {
        document.getElementById(warningId).textContent = '';
    }
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

function addOrRemoveWarningFunction(warningFunction, isToRemove) {
    if (isToRemove) {
        warningsFuncsSet.delete(warningFunction);
    } else {
        warningsFuncsSet.add(warningFunction);
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

function setListenersAndWarnings() {
    warningsFuncsSet.add(setWarningIfInvalidLogin);
    attachEventToElement("login", "input", setWarningIfInvalidLogin);
    attachEventToElement("login", "blur", setWarningIfInvalidLogin);

    warningsFuncsSet.add(setWarningIfInvalidEmail);
    attachEventToElement("email", "input", setWarningIfInvalidEmail);
    attachEventToElement("email", "blur", setWarningIfInvalidEmail);

    warningsFuncsSet.add(setWarningIfInvalidRepeatEmail);
    attachEventToElement("email", "blur", setWarningIfInvalidRepeatEmail);
    attachEventToElement("emailRepeat", "input", setWarningIfInvalidRepeatEmail);

    warningsFuncsSet.add(setWarningIfInvalidPassword);
    attachEventToElement("password", "blur", setWarningIfInvalidPassword);
    attachEventToElement("password", "input", setWarningIfInvalidPassword);

    warningsFuncsSet.add(setWarningIfInvalidRepeatPassword);
    attachEventToElement("password", "input", setWarningIfInvalidRepeatPassword);
    attachEventToElement("password", "blur", setWarningIfInvalidRepeatPassword);
    attachEventToElement("passwordRepeat", "input", setWarningIfInvalidRepeatPassword);
    
    attachEventToElement("registerSubmit", "submit", showWarningsIfSubmit(Event))
}

setListeners();