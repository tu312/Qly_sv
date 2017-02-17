package uet.usercontroller.model;

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
    private int studentId;
    private int postId;
    private String postTitle;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }
}
