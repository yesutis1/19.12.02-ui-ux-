package com.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class UpdateAction implements CommandAction {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        
        request.setCharacterEncoding("utf-8");
        int idx = Integer.parseInt(request.getParameter("idx"));
        String title = request.getParameter("title");
        String category = request.getParameter("category");
        String content = request.getParameter("content");

        if(title == null || title == "") System.out.println("제목이 null입니다.");
        if(content == null || content == "") System.out.println("내용이 null입니다.");
        
        Board article = new Board();
        article.setCategory(category);
        article.setIdx(idx);
        article.setTitle(title);
        article.setContent(content);
        
        BoardDao.getInstance().modifyArticle(article);

        ArrayList<Board> articleList = BoardDao.getInstance().getArticleList(idx);
        request.setAttribute("articleList", articleList);
        return "content.jsp";
    }

}
