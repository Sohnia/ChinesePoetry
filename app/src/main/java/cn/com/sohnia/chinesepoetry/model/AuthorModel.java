package cn.com.sohnia.chinesepoetry.model;

import java.io.Serializable;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.NameInDb;

@Entity
public class AuthorModel implements Serializable {
    @Id(assignable = true)
    private long authorId;

    @NameInDb("NAME")
    private String name;

    @NameInDb("INTRODUCE")
    private String introduce;

    @NameInDb("LIKE")
    private String like;

    @NameInDb("HEADIMAGE")
    private String headimage;

    @NameInDb("DATE")
    private long data;

    public AuthorModel() {
    }

    public AuthorModel(long authorId, String name, String introduce, String like, String headimage, long data) {
        this.authorId = authorId;
        this.name = name;
        this.introduce = introduce;
        this.like = like;
        this.headimage = headimage;
        this.data = data;
    }


    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AuthorModel{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", like='" + like + '\'' +
                ", headimage='" + headimage + '\'' +
                ", data=" + data +
                '}';
    }
}
