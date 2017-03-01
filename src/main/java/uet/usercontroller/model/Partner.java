package uet.usercontroller.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tu on 03-May-16.
 */
@Entity
@Table(name="Partner")
public class Partner {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private PartnerInfo partnerInfo;

    @OneToMany(mappedBy = "partnerId", cascade = CascadeType.ALL)
    private List<Post> post;

    @OneToMany(mappedBy = "partnerId", cascade = CascadeType.ALL)
    private List<Internship> internships;

    @OneToMany(mappedBy = "partnerId", cascade = CascadeType.ALL)
    private List<PartnerContact> partnerContacts;

    @OneToMany(mappedBy = "partnerId", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<Comment>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PartnerInfo getPartnerInfo() {
        return partnerInfo;
    }

    public void setPartnerInfo(PartnerInfo partnerInfo) {
        this.partnerInfo = partnerInfo;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    public List<Internship> getInternships() {
        return internships;
    }

    public void setInternships(List<Internship> internships) {
        this.internships = internships;
    }

    public List<PartnerContact> getPartnerContacts() {
        return partnerContacts;
    }

    public void setPartnerContacts(List<PartnerContact> partnerContacts) {
        this.partnerContacts = partnerContacts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }
}



