<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>猿媛客栈</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-md-offset-3" style="background-color: #F6F6F6">
            <h3 align="center">${title}</h3>

            <div class="row">
                <div class="col-xs-3" style="color: #999">${author}</div>
                <div class="col-xs-3" style="color: #999">${publishTime}</div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-heading center">
                            <span style="color: #3c3c3c">内容提要</span>
                        </div>
                        <div class="panel-body" id="panelBody" style="background-color: #EEEEF0">
                        ${summary}
                        </div>
                    </div>
                </div>

                <div class="col-xs-12">
                    <div class="col-xs-12">
                    ${content}
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>