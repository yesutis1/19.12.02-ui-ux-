package com.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class ModifyAction implements CommandAction {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        int idx = Integer.parseInt(request.getParameter("idx"));
        ArrayList<Board> articleList = BoardDao.getInstance().getArticleList(idx);
        request.setAttribute("articleList", articleList);
        return "modify.jsp";
    }
}
