package com.board.action;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class InsertAction implements CommandAction {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        
        request.setCharacterEncoding("utf-8");
        String category = request.getParameter("category");
        String title = request.getParameter("title");
        String writer = request.getParameter("writer");
        /* 내용은 상세보기에서 사용함. */
        String content = request.getParameter("content");

        if(title == null || title == "") System.out.println("제목이 null입니다.");
        if(writer == null || writer == "") {
            System.out.println("작성자가 null입니다.");
        } else if(!Pattern.matches("^[_0-9a-zA-Z-]+@[0-9a-zA-Z-]+(.[_0-9a-zA-Z-]+)*$", writer)) {
            System.out.println("이메일 형식이 아닙니다.");
        }
        if(content == null || content == "") System.out.println("내용이 null입니다.");
        
        Board article = new Board();
        article.setTitle(title);
        article.setCategory(category);
        article.setWriter(writer);
        article.setContent(content);
        
        BoardDao.getInstance().insertArticle(article);
        
        return "insert.jsp";
    }

}
