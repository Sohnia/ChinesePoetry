package cn.com.sohnia.chinesepoetry.model;

import java.io.Serializable;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.NameInDb;

@Entity
public class PoetryModel implements Serializable {

    @Id(assignable = true)
    private long poetryId;

    @NameInDb("TITLE")
    private String title;

    @NameInDb("CONTENT")
    private String content;

    @NameInDb("AUTHOR")
    private String author;

    @NameInDb("LIKE")
    private String like;

    @NameInDb("TYPE")
    private String type;

    @NameInDb("DATE")
    private long data;

    public PoetryModel(){}

    @Override
    public String toString() {
        return "PoetryModel{" +
                "poetryId=" + poetryId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", like='" + like + '\'' +
                ", type='" + type + '\'' +
                ", data=" + data +
                '}';
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public PoetryModel(long poetryId, String title, String content, String author, String like, String type, long data) {
        this.poetryId = poetryId;
        this.title = title;
        this.content = content;
        this.author = author;
        this.like = like;
        this.type = type;
        this.data = data;
    }

    public long getPoetryId() {
        return poetryId;
    }

    public void setPoetryId(long poetryId) {
        this.poetryId = poetryId;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
