package com.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.board.beans.Board;

public class BoardDao extends CommonDao {
    public static BoardDao getInstance() {
        BoardDao _instance = new BoardDao();
        return _instance;
    }

    public ArrayList<Board> getArticleList() throws SQLException {
        ResultSet rs = null;
        String sql = "SELECT a.*, b.user_id AS writer FROM TestBOARD AS a LEFT JOIN USER AS b ON a.user_id = b.idx ORDER BY a.idx desc";
        rs = openConnection().executeQuery(sql);

        ArrayList<Board> articleList = new ArrayList<Board>();
        while (rs.next()) {
            Board article = new Board();
            article.setIdx(rs.getInt("idx"));
            article.setCategory(rs.getString("category"));
            article.setTitle(rs.getString("title"));
            article.setWriter(rs.getString("writer"));
            article.setReg_date(rs.getString("reg_date"));
            article.setMod_date(rs.getString("mod_date"));
            article.setHit_count(rs.getInt("hit_count"));
            articleList.add(article);
        }
        closeConnection();
        return articleList;
    }
    
    public ArrayList<Board> getArticleListCategoty(String category) throws SQLException {
        ResultSet rs = null;
        String sql = "SELECT a.*, b.user_id AS writer FROM TestBOARD AS a LEFT JOIN USER AS b ON a.user_id = b.idx WHERE category='"+category+"' ORDER BY a.idx desc";
        rs = openConnection().executeQuery(sql);

        ArrayList<Board> articleList = new ArrayList<Board>();
        while (rs.next()) {
            Board article = new Board();
            article.setIdx(rs.getInt("idx"));
            article.setCategory(rs.getString("category"));
            article.setTitle(rs.getString("title"));
            article.setWriter(rs.getString("writer"));
            article.setReg_date(rs.getString("reg_date"));
            article.setMod_date(rs.getString("mod_date"));
            article.setHit_count(rs.getInt("hit_count"));
            articleList.add(article);
        }
        closeConnection();
        return articleList;
    }
    
    public ArrayList<Board> getArticleList(int idx) throws SQLException {
        ResultSet rs = null;
        String sql = "SELECT a.*, b.user_name AS writer FROM TestBOARD AS a LEFT JOIN USER AS b ON a.user_id=b.idx WHERE a.idx="+idx ;
        rs = openConnection().executeQuery(sql);

        ArrayList<Board> articleList = new ArrayList<Board>();
        while (rs.next()) {
            Board article = new Board();

            article.setIdx(rs.getInt("idx"));
            article.setCategory(rs.getString("category"));
            article.setTitle(rs.getString("title"));
            article.setWriter(rs.getString("writer"));
            article.setReg_date(rs.getString("reg_date"));
            article.setMod_date(rs.getString("mod_date"));
            article.setContent(rs.getString("content"));
            article.setHit_count(rs.getInt("hit_count"));

            articleList.add(article);
        }
        closeConnection();
        return articleList;
    }
    
    public void deleteArticle(int idx) throws SQLException {
        String sql = "DELETE FROM TestBOARD WHERE idx="+idx;
        openConnection().executeQuery(sql);
    }

    public void insertArticle(Board article) throws SQLException {
        String sql = "INSERT INTO TestBOARD "+
            "(title, category,user_id, content, hit_count) "+
            "VALUES ('"+article.getTitle()+"', '"+article.getCategory()+"', '"+article.getWriter()+"', '"+article.getContent()+"',0)";
        openConnection().executeQuery(sql);
    }

    public void modifyArticle(Board article) throws SQLException {
        String sql = "UPDATE TestBOARD SET "+
            "title = '"+article.getTitle()+
            "', category = '"+article.getCategory()+
            "', content = '"+article.getContent()+
            "' "+ "WHERE idx = "+article.getIdx();
        openConnection().executeQuery(sql);
    }
}
