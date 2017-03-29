package uet.usercontroller.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import uet.usercontroller.DTO.HashtagDTO;

import javax.persistence.*;
import java.util.*;
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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="partner")
    @JsonIgnore
    private Partner partner;
    @Column(name="content", length = 2800000)
    private String content;
    private String describePost;
    private String image;
    private String status;
    private Integer requiredNumber;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Follow> follows = new ArrayList<Follow>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="post_hashtag",
            joinColumns = @JoinColumn(name="post_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="hashtag_id", referencedColumnName = "id"))
    private List<Hashtag> hashtags = new ArrayList<Hashtag>();

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

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

    public List<Follow> getFollows() {
        return follows;
    }

    public void setFollows(List<Follow> follows) {
        this.follows = follows;
    }
}
