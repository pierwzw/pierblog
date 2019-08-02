<%--
    博客顶部部分
    包括：顶部菜单，主要菜单(包括搜索按钮)，面包屑
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%--导航 start--%>
<header id="masthead" class="site-header">
    <%--顶部菜单 start--%>
    <%--<nav id="top-header">
        <div class="top-nav">
            <div class="user-login">
                &lt;%&ndash;<c:choose>
                    <c:when test="${sessionScope.user==null}">
                        <a href="/admin">登录</a>
                    </c:when>
                    <c:otherwise>
                        <a href="/admin">退出</a>
                    </c:otherwise>
                </c:choose>&ndash;%&gt;
                &lt;%&ndash;<a href="#" target="_blank" style="color:red;">&ndash;%&gt;欢迎光临凌汐博客&lt;%&ndash;</a>&ndash;%&gt;
            </div>
            <div class="menu-topmenu-container">
                <ul id="menu-topmenu" class="top-menu">
                    <c:forEach items="${menuList}" var="m">
                        <li class="menu-item">
                        <c:if test="${m.menuLevel==1}">
                                <a href="${m.menuUrl}" >
                                    <i class="${m.menuIcon}"></i>
                                    <span class="font-text">${m.menuName}&nbsp;</span>&nbsp;
                                </a>
                            </c:if>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </nav><!-- #top-header -->--%>
    <%--顶部菜单 end--%>

    <%--主要菜单 satrt--%>
    <div id="menu-box">
        <div class="menu-left" style="width: 7%">
            <p>
                愿光阴不付勤奋
            </p>
            <p>
                芳华不付卿
            </p>
        </div>
        <div id="top-menu">
            <div class="menu-left">

            </div>
            <div class="logo-site">
                <h1 class="site-title">
                    <a href="/" title="${options.optionSiteTitle}">
                        <%--${options.optionSiteTitle}--%>
                        <img src="/img/lingxi_logo.jpg">
                    </a>
                </h1>
                <%--<p class="site-description">${options.optionSiteDescrption}</p>--%>
            </div><!-- .logo-site -->
            <div id="site-nav-wrap">
                <div id="sidr-close">
                    <a href="#sidr-close" class="toggle-sidr-close">×</a>
                </div>
                <nav id="site-nav" class="main-nav">
                    <a href="#sidr-main" id="navigation-toggle" class="bars">
                        <i class="fa fa-bars"></i>
                    </a>
                    <div class="menu-pcmenu-container">
                        <ul id="menu-pcmenu" class="down-menu nav-menu sf-js-enabled sf-arrows">

                            <%--<li>
                                <a href="/">
                                    <i class="fa-home fa"></i>
                                    <span class="font-text">首页</span>
                                </a>
                            </li>--%>

                            <c:forEach items="${allCategoryList}" var="category">
                                <c:if test="${category.categoryPid==0}">
                                    <li>
                                        <a href="/category/${category.categoryId}">
                                            <i class="${category.categoryIcon}"></i>
                                            <span class="font-text">${category.categoryName}&nbsp;</span>
                                        </a>
                                        <ul class="sub-menu">
                                            <c:forEach items="${allCategoryList}" var="cate">
                                                <c:if test="${cate.categoryPid==category.categoryId}">
                                                    <li>
                                                        <a href="/category/${cate.categoryId}" target="_blank">${cate.categoryName}</a>
                                                    </li>
                                                </c:if>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                </c:if>
                            </c:forEach>
                            <%--主要菜单其余部分--%>
                            <%--<c:forEach items="${menuList}" var="m">
                                <c:if test="${m.menuLevel == 2}">
                                    <li>
                                        <a href="${m.menuUrl}">
                                            <i class="${m.menuIcon}"></i>
                                            <span class="font-text">${m.menuName}&nbsp;</span>
                                        </a>
                                    </li>
                                </c:if>
                            </c:forEach>--%>
                        </ul>
                    </div>
                </nav>
            </div>
                <div class="searchbar nav-search">
                    <form method="get" id="searchform1" action="/search">
                        <span> <input type="text" value="" name="keywords" id="s1" placeholder="输入搜索内容" required="">
                            <button type="submit" id="searchsubmit1"><i class="fa fa-search"></i></button>
                        </span>
                    </form>
                </div>
            <%--<div class="clear"></div>--%>
        </div><!-- #top-menu -->
        <div class="menu-right" style="width: 8%;">
            <div class="user-login">
                <c:choose>
                    <c:when test="${sessionScope.user==null}">
                        <a class="login" href="">登录</a>
                    </c:when>
                    <c:otherwise>
                        <a class="logout" href="">退出</a>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="user-name">
                <c:if test="${sessionScope.user!=null}">
                    ${sessionScope.user.userName}
                </c:if>
            </div>
        </div>
    </div><!-- #menu-box -->
    <%--主要菜单 satrt--%>

</header><!-- #masthead -->
<%--导航 end start--%>

<%--搜索框 start--%>
<%--<div id="search-main">
    <div class="searchbar">
        <form method="get" id="searchform" action="/search" accept-charset="UTF-8">
            <span>
                <input type="text" value="" name="keywords" id="s" placeholder="输入搜索内容"required="">
                <button type="submit" id="searchsubmit">搜索</button>
            </span>
        </form>
    </div>
    <div class="clear"></div>
</div>--%>
<%--搜索框 end--%>
<script>
    $(function () {
        var loginPath = "/login/login.html?path=" + window.location.pathname;
        var logoutPath = "/logout?path=" + window.location.pathname;
        $(".user-login .login").attr("href", loginPath)
        $(".user-login .logout").attr("href", logoutPath)
    })
</script>

<rapid:block name="breadcrumb"></rapid:block>
