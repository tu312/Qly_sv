package uet.usercontroller.model;

import javax.persistence.*;
import java.util.Date;
import java.sql.Blob;
import javax.persistence.Lob;

/**
 * Created by Trung on 8/27/2016.
 */
@Entity
@Table(name="Post")
public class Post {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int partnerId;
    @Column(name="content", length = 2800000)
    private String content;
    private String describePost;
    private String image;
    private String status;
    private Integer requiredNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPartnerId() { return partnerId; }

    public void setPartnerId(int partnerId) { this.partnerId = partnerId; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    private Date datePost;

    public Date getDatePost() {
        return datePost;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }

    public String getDescribePost() {
        return describePost;
    }

    public void setDescribePost(String describePost) { this.describePost = describePost; }

    public String getImage() {
        return image;
    }

    public void setImage(String image) { this.image = image; }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRequiredNumber() {
        return requiredNumber;
    }

    public void setRequiredNumber(Integer requiredNumber) {
        this.requiredNumber = requiredNumber;
    }
}
