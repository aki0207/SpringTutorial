<!DOCTYPE html>
<html>
<head>
<title>Echo Application</title>
</head>
<body>

  <form:form modelAttribute="echoForm" action="${pageContext.request.contextPath}/echo/hello">
    <form:label path="name">Input Your Name:</form:label>
    <form:input path="name" />
    <%-- 入力画面には、エラーがあった場合に、エラーメッセージを表示するため、 form:errors タグを追加する。 --%>
     <form:errors path="name" cssStyle="color:red" />
    <input type="submit" />
  </form:form>
</body>
</html>