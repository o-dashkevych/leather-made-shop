<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<img src="/register/captcha?id=${captchaId}"/>
<c:if test="${not empty captchaId}">
    <input type="hidden" value="${captchaId}">
</c:if>