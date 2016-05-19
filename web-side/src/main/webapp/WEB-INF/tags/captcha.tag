<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<img src="<c:url value="/register/captcha?captchaId=${captchaId}"/>"/>
<c:if test="${not empty captchaId}">
    <input type="hidden" name="captchaId" value="${captchaId}">
</c:if>