package uet.usercontroller.DTO;

/**
 * Created by nhkha on 16/02/2017.
 */
public class FollowDTO {
    private int id;
    private int postId;
    private int studentId;
    private String postTitle;
    private String studentName;

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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
