<!DOCTYPE html>
<html lang="en">
<head>
    <style type="text/css">
        #tagbox {
            position: relative;
            margin: 20px auto 0px;
            width: 300px;
            height: 250px;
            background: transparent;
        }

        #tagbox a {
            position: absolute;
            padding: 3px 6px;
            font-family: Microsoft YaHei;
            color: #fff;
            TOP: 0px;
            font-weight: bold;
            text-decoration: none;
            left: 0px
        }

        #tagbox a:hover {
            border: #eee 1px solid;
            background: #CCFFFF;
        }

        #tagbox .blue {
            color: #FF3333
        }

        #tagbox .red {
            color: red
        }

        #tagbox .yellow {
            color: #FF6600
        }

        #tagbox .color1 {
            color: #CC66CC
        }

        #tagbox .color2 {
            color: #CC0000;
        }
    </style>
</head>
<body>
<script type="text/javascript" src="/js/labelCloud/script.js"></script>
<div id="tagbox">
    <a class="color1" href="#" onclick="searchArticle('JAVA')">JAVA</a>
    <a class="red" href="#" onclick="searchArticle('PYTHON')">PYTHON</a>
    <a class="color1" href="#" onclick="searchArticle('kafka')">kafka</a>
    <a class="color1" href="#" onclick="searchArticle('MongoDb')">MongoDb</a>
    <a class="blue" href="#" onclick="searchArticle('MySql')">MySql</a>
    <a class="color2" href="#" onclick="searchArticle('Nignx')">Nignx</a>
    <a class="red" href="#" onclick="searchArticle('lvs')">lvs</a>
    <a class="yellow" href="#" onclick="searchArticle('KeepAlive')">KeepAlive</a>
    <a class="color1" href="#" onclick="searchArticle('zookeeper')">zookeeper</a>
    <a class="red" href="#" onclick="searchArticle('spring')">spring</a>
    <a class="color2" href="#" onclick="searchArticle('hibernate')">hibernate</a>
    <a class="blue" href="#" onclick="searchArticle('spring')">spring-boot</a>
    <a class="blue" href="#" onclick="searchArticle('vue')">vue.js</a>
    <a class="red" href="#" onclick="searchArticle('mybatis')">mybatis</a>
    <a class="yellow" href="#" onclick="searchArticle('thrift')">thrift</a>
    <a class="yellow" href="#" onclick="searchArticle('redis')">redis</a>
    <a class="blue" href="#" onclick="searchArticle('memcache')">memcache</a>
    <a class="yellow" href="#" onclick="searchArticle('机器学习')">机器学习</a>
    <a class="blue" href="#" onclick="searchArticle('云平台')">云平台</a>
    <a class="blue" href="#" onclick="searchArticle('Hive')">Hive</a>
    <a class="red" href="#" onclick="searchArticle('Hadoop')">Hadoop</a>
    <a class="color2" href="#" onclick="searchArticle('Hbase')">Hbase</a>
    <a class="color1" href="#" onclick="searchArticle('大数据')">大数据</a>
    <a class="yellow" href="#" onclick="searchArticle('struts')">struts</a>
    <a class="color1" href="#" onclick="searchArticle('Shell')">Shell</a>
    <a class="color2" href="#" onclick="searchArticle('Git')">Git</a>
    <a class="blue" href="#" onclick="searchArticle('Maven')">Maven</a>
    <a class="red" href="#" onclick="searchArticle('Html')">Html</a>
    <a class="red" href="#" onclick="searchArticle('H5动画')">H5动画</a>
    <a class="blue" href="#" onclick="searchArticle('dubbo')">dubbo</a>
    <a class="color1" href="#" onclick="searchArticle('NIO')">NIO</a>
    <a class="blue" href="#" onclick="searchArticle('netty')">netty</a>
    <a class="blue" href="#" onclick="searchArticle('AES')">AES</a>
    <a class="color1" href="#" onclick="searchArticle('RSA')">RSA</a>
    <a class="color2" href="#" onclick="searchArticle('TCP')">TCP</a>
    <a class="color1" href="#" onclick="searchArticle('HTTP')">HTTP</a>
    <a class="color1" ref="#" onclick="searchArticle('ORACLE')">ORACLE</a>
    <a class="color2" href="#" onclick="searchArticle('人工智能')">人工智能</a>
    <a class="color1" href="#" onclick="searchArticle('算法')">算法</a>
    <a class="red" href="#" onclick="searchArticle('生活杂感')">生活杂感</a>
</div>
</body>
</html>