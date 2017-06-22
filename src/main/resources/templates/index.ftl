<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style type="text/css">
        html, body {
            margin: 0px;
            padding: 0px;
        }

        .zero-margin {
            margin: 0px;
            padding: 0px;
        }
    </style>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script src="/js/vue/vue.min.js"></script>
    <title>猿媛客栈</title>
</head>
<body>
<div id="head-nav" style="width: 100%;height: 70px;overflow: visible;position:absolute;top:0px;z-index: 10">
</div>
<div class="container-fluid" style="margin-top:80px">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-heading center">优质文章推荐</div>
                    <div class="panel-body">
                        <iframe id="slice" class="zero-margin" style="width: 100%;overflow: visible;"
                                src="/slice-box/slice.html" allowTransparency="true" frameBorder=0
                                scrolling=no></iframe>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading center">最新文章列表</div>
                    <div class="panel-body" id="article-list">
                        <my-article v-for="article in articles" v-bind:article="article">

                        </my-article>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>
<script type="text/x-template" id="single-article">
    <div class="row"
         style="margin:10px;padding:12px;box-shadow: 5px 5px 2px #3366CC;background-color:#F0F0F0; border:#00CC66 1px solid;">
        <div class="col-md-4">
            <img src="http://dynamic-image.yesky.com/1080x-/uploadImages/2013/316/61WG87B3DOU9.jpg"
                 style="height: 100%;width: 100%">
        </div>
        <div class="col-md-8">
            <a target="_blank" v-bind:href="'/article/id/' + article.id">
                <h4 style="color: #BC2A4D">{{article.title}}</h4>
            </a>

            <p style="color: dimgrey; font:18px;text-indent:2em;margin-top: 5px">{{article.summary}}</p>

            <div class="form-inline" style="margin-top: 10px">
                <span class="glyphicon glyphicon-bookmark" style="margin-top: 4px"></span>&nbsp;&nbsp;
                <span style="color: #555555; padding-left: 4px;padding-right:4px;background:#E0E0E0;border:1px solid #A0A0A0"
                      v-for="keyWord in article.keyWords">{{keyWord}}</span>
                <a target="_blank" v-bind:href="'/article/id/' + article.id">
                    <button style="float: right" type="button" class="btn btn-danger">阅读全文</button>
                </a>
            </div>
        </div>
    </div>
</script>
<script type="text/javascript">
    $.ajax({
        url: '/head.html',
        type: 'GET', //GET
        data: '',
        async: true,    //或false,是否异步
        timeout: 15000,    //超时时间
        dataType: 'html', //返回的数据格式：json/xml/html/script/jsonp/text
        success: function (resp) {
            $('#head-nav').html(resp);
        }
    });
    $("#slice").load(function () {
        document.getElementById("slice").height = document.getElementById("slice").offsetWidth * 0.55;
    });
    var article = {title: "阴晴雨雪小天气", summary: "小米天气为您播报天气，今天白天，晴，最高温度23摄氏度，最低温度19摄氏度，适宜出去游玩！"};
    Vue.component('my-article', {
        template: '#single-article',
        props: ['article'],
        props: {
            article: {
                default: {title: "无标题", summary: "无摘要"}
            }
        }
    })
    // 创建根实例
    var articleList = new Vue({
        el: '#article-list',
        data: {
            articles: []
        }
    });

    var currentNum = 0;
    //请求文章
    function getArticle() {
        $.ajax({
            url: '/article?pageNum=' + currentNum,
            type: 'GET', //GET
            data: '',
            async: true,    //或false,是否异步
            timeout: 15000,    //超时时间
            dataType: 'json', //返回的数据格式：json/xml/html/script/jsonp/text
            success: function (resp) {
                console.log(resp);
                articleList.articles = articleList.articles.concat(resp);
                currentNum++;
            }
        });
    }
    getArticle();

    /**
     * 判断滚动条是否到最底端的方法
     * @param Element obj
     */
    function isScrollBottom(obj) {
        if ($(window).scrollTop() + $(window).height() >= $(document).height()) {
            return true;
        } else {
            return false;
        }
    }
    /*添加滚动监听事件*/
    $(window).bind('scroll', function () {
        if (isScrollBottom(window)) {
            getArticle();
        }
    });

</script>
</body>
</html>