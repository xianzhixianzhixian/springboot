<!DOCTYPE html>
<html>
    <head lang="en">
        <meta charset="UTF-8" />
        <title>freemaker list</title>
    </head>
    <body>
        <#if sex=="0">男
        <#elseif sex=="1">女
        <#else>其它
        </#if>
        ${names?size}
        <#list names as name>${name}</#list>
    </body>
</html>