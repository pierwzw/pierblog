<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="header-style">
    <style>
        .entry-title {
            background: #f8f8f8;
        }
    </style>
    <link rel="stylesheet" href="/plugin/layui/css/layui.css">
</rapid:override>


<rapid:override name="breadcrumb">
    <%--面包屑导航 start--%>
    <nav class="breadcrumb">
        <a class="crumbs" href="/">
            <i class="fa fa-home"></i>首页
        </a>
        <i class="fa fa-angle-right"></i>
        留言板
        <i class="fa fa-angle-right"></i>
        正文
    </nav>
    <%--面包屑导航 end--%>
</rapid:override>


<rapid:override name="left">
    <%--博客主体-左侧文章正文 start--%>
    <div id="primary" class="content-area">
        <main id="main" class="site-main" role="main">
            <article class="post" style="min-height: 500px;">
                <header class="entry-header">
                    <h1 class="entry-title">
                           留言板
                    </h1>
                </header><!-- .entry-header -->
                <div class="entry-content">
                    <div class="single-content">
                        <!--PC版-->
                        <%--<div id="SOHUCS" sid="message"></div>
                        <script charset="utf-8" type="text/javascript" src="https://changyan.sohu.com/upload/changyan.js" ></script>
                        <script type="text/javascript">
                            window.changyan.api.config({
                                /*appid: 'cytcdBHan',
                                conf: 'prod_acc9eafcae7c468c116f87dfb853e677'*/
                                appid: 'cyumjYHHf',
                                conf: 'prod_00d9b4d9e4faf52d1a0157fddb3d0a28'
                            });
                        </script>--%>
                        <!--PC和WAP自适应版-->
                        <div id="SOHUCS" sid="comment" ></div>
                        <style>
                            #feedAv {
                                display: none !important;;
                                transform: scale(0) !important;
                                height: 0px !important;转载请注明
                            }
                            #pop_ad {
                                transform: scale(0) !important;
                                display: none !important;
                            }
                        </style>
                        <script type="text/javascript">
                            (function(){
                                var appid = 'cyumjYHHf';
                                var conf = 'prod_00d9b4d9e4faf52d1a0157fddb3d0a28';
                                var width = window.innerWidth || document.documentElement.clientWidth;
                                if (width < 960) {
                                    window.document.write('<script id="changyan_mobile_js" charset="utf-8" type="text/javascript" src="http://changyan.sohu.com/upload/mobile/wap-js/changyan_mobile.js?client_id=' + appid + '&conf=' + conf + '"><\/script>');
                                } else {
                                    var loadJs=function(d,a){
                                        var c=document.getElementsByTagName("head")[0]||document.head||document.documentElement;
                                        var b=document.createElement("script");
                                        b.setAttribute("type","text/javascript");
                                        b.setAttribute("charset","UTF-8");
                                        b.setAttribute("src",d);
                                        if(typeof a==="function"){
                                            if(window.attachEvent){
                                                b.onreadystatechange=function(){
                                                    var e=b.readyState;
                                                    if(e==="loaded"||e==="complete"){
                                                        b.onreadystatechange=null;a()
                                                    }
                                                }
                                            }else{
                                                b.onload=a}
                                        }
                                        c.appendChild(b)
                                    };
                                    loadJs("http://changyan.sohu.com/upload/changyan.js",function(){
                                        window.changyan.api.config({
                                            appid:appid,conf:conf
                                        })
                                    });
                                }
                            })();
                        </script>
                    </div>
                    <br><br>

                    <footer class="single-footer">
                        <ul class="single-meta">
                            <li class="r-hide">
                                <a href="javascript:pr()" title="侧边栏">
                                    <i class="fa fa-caret-left"></i>
                                    <i class="fa fa-caret-right"></i>
                                </a>
                            </li>
                        </ul>
                        <ul id="fontsize">
                            <li>A+</li>
                        </ul>
                    </footer><!-- .entry-footer -->


                    <div class="clear"></div>
                </div><!-- .entry-content -->
            </article><!-- #post -->



        </main>
        <!-- .site-main -->
    </div>
    <%--博客主体-左侧文章正文end--%>
</rapid:override>


<%--侧边栏 start--%>
<rapid:override name="right">
    <%@include file="../Public/part/sidebar-3.jsp" %>
</rapid:override>
<%--侧边栏 end--%>

<rapid:override name="footer-script">
    <script>
        //添加用户验证和编辑用户验证
        layui.use(['form', 'layedit', 'laydate'], function () {
            var form = layui.form, layer = layui.layer;
            form.verify({

                userName: function (value) {
                    if (value.length > 12 || value.length < 4) {
                        return "用户名必须4到12位";
                    }
                    if(checkUserName()==1) {
                        return "用户名已存在";
                    }
                },
                userEmail: function () {
                    if(checkUserEmail()==1) {
                        return "电子邮箱已存在";
                    }
                }

            });

            form.on('submit(demo1)', function (data) {
                return true;
            });
        });
    </script>
</rapid:override>

<%@ include file="../Public/framework.jsp" %>