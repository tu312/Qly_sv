package uet.usercontroller.DTO;

/**
 * Created by nhkha on 19/02/2017.
 */
public class AdminNotificationDTO {
    private int id;
    private String issue;
    private  int studentId;
    private int partnetId;
    private String userName;

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
        return partnetId;
    }

    public void setPartnetId(int partnetId) {
        this.partnetId = partnetId;
    }

    public String getName() {
        return userName;
    }

    public void setName(String userName) {
        this.userName = userName;
    }
}
