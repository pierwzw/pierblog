<%--
    博客页脚部分
    包括：页脚部分
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<div id="footer-widget-box" class="site-footer wow fadeInUp" data-wow-delay="0.3s">
    <div class="footer-widget">

        <aside id="text-1" class="widget widget_text wow fadeInUp" data-wow-delay="0.3s">
            <h3 class="widget-title">
                <span class="s-icon"></span>本站信息
            </h3>
            <div class="textwidget">
                <ul class="menu">
                    <li>
                        <a title="" target="_blank" href="/articleFile">
                            <i class="fa-list-alt fa"></i>
                            <span class="font-text">文章归档</span>
                        </a>
                    </li>
                    <li>
                        <a target="_blank" href="/aboutSite">
                            <i class="fa fa-info"></i>
                            <span class="font-text">关于本站</span>
                        </a>
                    </li>
                    <li>
                        <a target="_blank" rel="nofollow" href="/message">
                            <i class="fa fa-comment"></i>
                            <span class="font-text">留言板</span>
                        </a>
                    </li>
                    <%--<li>
                        <a title="" target="_blank" href="/tags">
                            <i class="fa fa-tag"></i>
                            <span class="font-text">标签库</span>
                        </a>
                    </li>--%>
                    <%--<li>
                        <a title="" target="_blank" href="/recent-comments">
                            <i class="fa-comment fa"></i>
                            <span class="font-text">最新评论</span>
                        </a>
                    </li>--%>
                    <%--<li>
                        <a title="" target="_blank" href="/highlight">
                            <i class="fa-code fa"></i>
                            <span class="font-text">代码高亮</span>
                        </a>
                    </li>--%>
                </ul>
            </div>
            <div class="clear"></div>
        </aside>
        <aside id="text-3" class="widget widget_text wow fadeInUp" data-wow-delay="0.3s">
            <%--<h3 class="widget-title">
                <span class="s-icon"></span> 关于本站
            </h3>
            <div class="textwidget">
                本站基于 SpringBoot、MyBatis、Redis、FreeMarker、ElasticSearch 实现。
                请充分利用本站搜索功能，后期将开源，请关注。
            </div>
            <div class="clear"></div>--%>
        </aside>
        <aside id="text-4" class="widget widget_text wow fadeInUp" data-wow-delay="0.3s">
            <h3 class="widget-title">
                <span class="s-icon"></span>免责声明
            </h3>
            <div class="textwidget">
                <%--<div style="float:right;width:25%;">
                    <img src="http://www.pierwzw.top/img/wx.jpg">
                </div>--%>
                <div style="margin-right:35%;padding-right:5px;">
                    <p>本站以【原创+转载】的方式运营 若文字以及图片侵犯您的版权,请联系我删除！谢谢！QQ：501311328</p>
                </div>
            </div>
        </aside>
        <div class="clear"></div>
    </div>
    <%--页脚 start--%>
    <footer id="colophon" class="site-footer" role="contentinfo">
        <div class="site-info">
            <p style="text-align: center;">Copyright © 2017-2019
                <a style="color: #ccc;" href="/" target="_blank" rel="noopener noreferrer">${options.optionSiteTitle}</a>&nbsp;|
                <a style="color: #ccc;" href="http://www.beian.miit.gov.cn/" target="_blank">浙ICP备19026794号-1</a>&nbsp;|
                <a style="color: #ccc;" target="_blank" href="/map" >
                    <span class="font-text">站点地图</span>
                </a>
            </p>
        </div>
        <!-- .site-info -->
    </footer><!-- .site-footer -->
    <%--页脚 end--%>
</div>



