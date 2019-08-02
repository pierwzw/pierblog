<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<ul id="scroll">
    <li class="log log-no">
        <a class="log-button" title="文章目录">
            <i class="fa fa-bars"></i>
        </a>
        <div class="log-prompt">

            <%--<div class="log-arrow">我是目录
            </div>--%>
        </div>
    </li>

    <li class="layui-icon layui-fixbar-top" lay-type="top" style="display: list-item;">
        <a class="scroll-h" title="返回顶部"><i class="fa fa-angle-up"></i></a>
    </li>
    <li class="layui-icon layui-fixbar-bottom" lay-type="bottom" style="display: list-item;">
        <a class="scroll-b" title="转到底部"><i class="fa fa-angle-down"></i></a>
    </li>
    <%--<li class="gb2-site"><a id="gb2big5"><span>繁</span></a></li>--%>
    <li class="qqonline">
        <div class="online">
            <a class="scroll-qq" href="http://wpa.qq.com/msgrd?v=3&uin=501311328&site=qq&menu=yes" target="_blank" title="QQ"><i class="fa fa-qq"></i></a>
        </div>
        <%--<div class="qqonline-box">
            <div class="qqonline-main">
                <div class="nline-wiexin">
                    <h4>QQ</h4>
                    <img title="QQ" alt="QQ" src="/img/wx.jpg"/>
                </div>
                <div class="nline-qq">
                    <a target="_blank" rel="external nofollow"
                       href=""><i class="fa fa-qq"></i>
                    </a>
                </div>
            </div>
            <span class="qq-arrow"></span>
        </div>--%>
    </li>
    <%--这个效果较好：https://cloud.tencent.com/developer/article/1368280--%>
    <li class="wxonline">
        <a title="微信" rel="external nofollow">
            <i class="fa fa-weixin"> </i>
        </a>
        <div class="wx-prompt">
            <img class="wx-img" alt="wx" src="/img/wx.jpg"/>
            <div class="wx-arrow">
            </div>
        </div>
    </li>
    <%--反馈建议：https://www.duanliang920.com/--%>
    <li id="layerDemo">
        <a class="scroll-fd layui-btn layui-btn-normal" data-method="offset" data-type="auto" title="建议反馈" rel="external nofollow">
            <i class="fa fa-file-text-o"> </i>
        </a>
        <%--<div class="fd-prompt">
            <img class="wx-img" alt="wx" src="/img/wx.jpg"/>
            <div class="wx-arrow">
            </div>
        </div>--%>
    </li>
</ul>