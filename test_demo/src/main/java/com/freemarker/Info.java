package com.freemarker;

/**
 * @author 王建兵
 * @Classname Info
 * @Description TODO
 * @Date 2019/7/30 15:54
 * @Created by Administrator
 */
public class Info {
    private String title;
    private String content;

    public Info(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Info() {
    }

    public Info(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
