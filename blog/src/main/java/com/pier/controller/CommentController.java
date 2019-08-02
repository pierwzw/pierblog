package com.pier.controller;

import cn.hutool.http.HtmlUtil;
import com.pier.dto.JsonResult;
import com.pier.entity.Article;
import com.pier.entity.Comment;
import com.pier.entity.User;
import com.pier.enums.ArticleStatus;
import com.pier.enums.Role;
import com.pier.service.ArticleService;
import com.pier.service.CommentService;
import com.pier.util.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author pierwzw
 * @date 2017/9/10
 */

@Controller
@RestController
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    /**
     * 添加评论
     *
     * @param request
     * @param comment
     */
    @RequestMapping(value = "/", method = {RequestMethod.POST})
    public JsonResult insertComment(HttpServletRequest request, Comment comment) {
        //添加评论
        comment.setCommentCreateTime(new Date());
        comment.setCommentIp(MyUtils.getIpAddr(request));
        User user = null;
        if ((user = (User)request.getSession().getAttribute("user")) != null && user.getUserName().equals("pierwzw")) {
            comment.setCommentRole(Role.ADMIN.getValue());
        } else {
            comment.setCommentRole(Role.VISITOR.getValue());
        }
        comment.setCommentAuthorAvatar(MyUtils.getGravatar(comment.getCommentAuthorEmail()));

        //过滤字符，防止XSS攻击
        comment.setCommentContent(HtmlUtil.escape(comment.getCommentContent()));
        comment.setCommentAuthorName(HtmlUtil.escape(comment.getCommentAuthorName()));
        comment.setCommentAuthorEmail(HtmlUtil.escape(comment.getCommentAuthorEmail()));
        comment.setCommentAuthorUrl(HtmlUtil.escape(comment.getCommentAuthorUrl()));
        try {
            commentService.insertComment(comment);
            //更新文章的评论数
            Article article = articleService.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), comment.getCommentArticleId());
            articleService.updateCommentCount(article.getArticleId());
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult().fail();
        }
        return new JsonResult().ok();
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        commentService.deleteComment(id);
    }
}
