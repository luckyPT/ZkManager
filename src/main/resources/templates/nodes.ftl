<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<h1>Welcome To Zk Manager Center!</h1>
<table>
<#if data??>
    <#list data?keys as key>
        <tr>
            <td>节点名称:${key}</td>
            <td>节点附属信息:${data[key]}</td>
        </tr>
    </#list>
</#if>
</table>
</body>
</html>