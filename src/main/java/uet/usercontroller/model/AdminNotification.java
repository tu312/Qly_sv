package uet.usercontroller.model;


import javax.persistence.*;

/**
 * Created by nhkha on 19/02/2017.
 */
@Entity
@Table(name = "AdminNotification")
public class AdminNotification {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String issue;
    private int studentId;
    private int partnerId;
    private String status;
    private String userName;

    public AdminNotification() {
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getPartnetId() {
        return partnerId;
    }

    public void setPartnetId(int partnetId) {
        this.partnerId = partnetId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
