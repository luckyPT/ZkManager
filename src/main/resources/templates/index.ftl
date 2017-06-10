<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<h1>Welcome To Zk Manager Center!</h1>
<table>
<#if nodes?exists>
    <#list nodes?keys as key>
        <#if key!="nodes">
            <tr>
                <td>节点名称:${key}</td>
                <td>节点附属信息:${nodes[key]}</td>
            </tr>
        </#if>
    </#list>
</#if>
</table>
</body>
</html>