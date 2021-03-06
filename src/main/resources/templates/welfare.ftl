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
<h1 align="center">源码福利</h1>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-offset-2 col-md-8" style="text-align: center">
            <p style="color: red">
                付款前请仔细阅读<a href="#" onclick="$('#important_statement').css('display','block')">《重要声明》</a><br>

            <p id="important_statement" style="display: none;background-color: #e4ebe9">
                付款前请阅读代码介绍，钱款一经付出，任何情况下，作者都有绝对权利不退还钱款！<br>
                付款之后，加收款人好友，一般情况下，24小时之内都能交付代码，如果超出72小时未收到交付代码，则退还钱款！定制代码交付时间，需另行商议！
            </p>
            <hr>
            <strong style="color: red">扫码付款(记得填写留言)，付款之后加微信好友获取源码！</strong>
            </p>
        </div>
    </div>
    <div class="row" style="margin: 6px" id="productsList">
        <products v-for="product in codeProducts" v-bind:product="product">

        </products>
        <div>
            <button type="button" class="btn btn-info" onclick="$('#addProduct').css('display','block')">增加商品</button>
            <form action="/code/add" id="addProduct" style="display: none">
                <input name="productName" type="text" placeholder="productName"/>
                <input name="productDesc" type="text" placeholder="productDesc"/>
                <input name="price" type="text" placeholder="price"/>
                <input name="reserveCount" type="text" placeholder="reserveCount"/>
                <input type="text" name="verifyCode" placeholder="verifyCode">
                <input type="submit"></input
            </form>
        </div>
    </div>
</div>
<script type="text/x-template" id="single-product">
    <div class="col-md-2" style="text-align: center;border: 2px solid #80FFFF">
        <h4>付款留言：{{product.productName}}</h4>
        <img v-bind:src="'/image/moneyQR/'+product.price+'.jpg'" style="height: 100%;width: 100%">
        <a v-on:click="show(product.productName)" style="cursor: pointer">代码介绍</a>

        <p v-bind:id="product.productName" style="display: none">{{product.productDesc}}</p>
    </div>
</script>
<script type="text/javascript">
    Vue.component('products', {
        template: '#single-product',
        props: ['product'],
        props: {
            product: {
                default: {productName: "无标题", price: "1", productDesc: "无"}
            }
        }
    });
    // 创建根实例
    var productList = new Vue({
        el: '#productsList',
        data: {
            codeProducts: []
        }
    });

    //加载商品
    $.ajax({
        url: '/code/all',
        type: 'GET', //GET
        data: '',
        async: true,    //或false,是否异步
        timeout: 15000,    //超时时间
        dataType: '*', //返回的数据格式：json/xml/html/script/jsonp/text
        success: function (resp) {
            productList.codeProducts = resp;
        }
    });
    function show(id) {
        $('#' + id).css("display", "block");
    }
</script>
</body>