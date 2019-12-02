package com.board.beans;

public class Board {
    private int idx;
    private String title;
    private String writer;
    private String reg_date;
    private String mod_date;
	private int hit_count;
    private String content;
    private String category;
    

    public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getIdx() {
        return idx;
    }
    public void setIdx(int idx) {
        this.idx = idx;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public int getCount() {
        return hit_count;
    }
    public void setCount(int hit_count) {
        this.hit_count = hit_count;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getHit_count() {
		return hit_count;
	}
	public void setHit_count(int hit_count) {
		this.hit_count = hit_count;
	}
	public String getMod_date() {
		return mod_date;
	}
	public void setMod_date(String mod_date) {
		this.mod_date = mod_date;
	}
}
