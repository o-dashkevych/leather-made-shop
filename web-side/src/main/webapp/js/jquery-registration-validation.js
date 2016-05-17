var warningsFunctionsSet = new Set();

function removeWarningFunctionAndMessage(functionName, warningAttachedId) {
    console.log(functionName);
    warningsFunctionsSet.delete(functionName);
    $(getById(warningAttachedId + "Warning")).html("");
}

function getById(itemId) {
    return "#" + itemId;
}

function attachEventToElement(elementId, eventName, functionName) {
    $(getById(elementId)).on(eventName, functionName);
}

function exists(itemId) {
    var isExist = $(getById(itemId)).length != 0;
    if (isExist) {
        return $(getById(itemId)).text() !== '';
    }
    return isExist;
}

function showWarningAfterItem(itemId, message) {
    var warningId = itemId + "Warning";
    if (!exists(warningId)) {
        var warning = $("<p>" + message + "<p/>");
        warning.attr("id", warningId);
        $(getById(itemId)).after(warning);
    }
}

function validateRepeatValues(firstField, secondField) {
    var firstValue = $(getById(firstField)).val();
    var secondValue = $(getById(secondField)).val();
    if (firstValue.length === 0 || secondValue === 0) {
        return false;
    }
    return firstValue === secondValue;
}

/* Login input validation*/

function validateLogin(loginId) {
    var login = $(getById(loginId)).val();
    var loginPattern = /^([a-zA-Z]+[0-9]*){4,10}$/i;
    return loginPattern.test(login);
}

function setWarningIfInvalidLogin() {
    var itemId = "login";
    if (!validateLogin(itemId)) {
        warningsFunctionsSet.add(setWarningIfInvalidLogin);
        showWarningAfterItem("login", "Invalid login");
    } else removeWarningFunctionAndMessage(setWarningIfInvalidLogin, itemId);
}

/* Email input validation*/

function setWarningIfInvalidEmail(event) {
    var itemId = "email";
    if (!validateEmail(itemId)) {
        showWarningAfterItem(itemId, "Invalid Email Address");
        warningsFunctionsSet.add(setWarningIfInvalidEmail);
    } else removeWarningFunctionAndMessage(setWarningIfInvalidEmail, itemId);
};

function validateEmail(email) {
    var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    return filter.test($(getById(email)).val());
};

/* Repeat email input validation*/

function setWarningIfInvalidRepeatEmail(event) {
    var itemId = "emailRepeat";
    if (!validateRepeatValues("email", itemId)) {
        warningsFunctionsSet.add(setWarningIfInvalidRepeatEmail);
        showWarningAfterItem(itemId, "Emails doesn't match");
    } else removeWarningFunctionAndMessage(setWarningIfInvalidRepeatEmail, itemId);
}

/* Password input validation*/

function validatePassword(passwordField) {
    var password = $(getById(passwordField)).val();
    var passwordPattern = /^[\w+\s]{4,10}$/i;
    return passwordPattern.test(password);
}

function setWarningIfInvalidPassword() {
    var itemId = "password";
    if (!validatePassword(itemId)) {
        showWarningAfterItem(itemId, "Invalid password");
        warningsFunctionsSet.add(setWarningIfInvalidPassword);
    } else removeWarningFunctionAndMessage(setWarningIfInvalidPassword, itemId);
}

/* Repeat password input validation*/

function setWarningIfInvalidRepeatPassword() {
    console.log("InvalidRepeatPassword call");
    var itemId = "passwordRepeat";
    if (!validateRepeatValues("password", itemId)) {
        console.log("Invalid Repeat Password");
        showWarningAfterItem(itemId, "Passwords doesn't match");
        warningsFunctionsSet.add(setWarningIfInvalidRepeatPassword);
    } else removeWarningFunctionAndMessage(setWarningIfInvalidRepeatPassword, itemId);
}

/*On submit warning check */

function showWarningsIfSubmit(eventObject) {
    if (warningsFunctionsSet.size !== 0) {
        eventObject.preventDefault();
        warningsFunctionsSet.forEach(function (item) {
            item();
        });
        return false;
    }
    return true;
}

function setListenersAndWarnings() {
    warningsFunctionsSet.add(setWarningIfInvalidLogin);
    attachEventToElement("login", "input", setWarningIfInvalidLogin);
    attachEventToElement("login", "blur", setWarningIfInvalidLogin);

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
    attachEventToElement("passwordRepeat", "blur", setWarningIfInvalidRepeatPassword);

    attachEventToElement("registerSubmit", "click", showWarningsIfSubmit);
}
setListenersAndWarnings();