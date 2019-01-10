package cn.com.sohnia.chinesepoetry.model;

import java.io.Serializable;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.NameInDb;

@Entity
public class SentencesModel implements Serializable {
    @Id(assignable = true)
    private long id;

    @NameInDb("CONTENT")
    private String content;

    @NameInDb("LABEL")
    private String label;

    @NameInDb("DATE")
    private long data;

    public SentencesModel() {
    }

    public SentencesModel(long id, String content, String label, long data) {
        this.id = id;
        this.content = content;
        this.label = label;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SentencesModel{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", label='" + label + '\'' +
                ", data=" + data +
                '}';
    }
}
