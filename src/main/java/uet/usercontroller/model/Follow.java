package uet.usercontroller.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by nhkha on 16/02/2017.
 */
@Entity
@Table(name="Follow")
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student")
    @JsonIgnore
    private Student student;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="post")
    @JsonIgnore
    private Post post;
    private String postTitle;
    private String studentName;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
