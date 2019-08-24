<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${info.title}</title>
</head>

<body>
  正文是:${info.content}
  <hr/>
  姓名列表:
  <ul>
  <#list names as name>
    <li>${name}</li>
  </#list>
  </ul>
</body>
</html>
