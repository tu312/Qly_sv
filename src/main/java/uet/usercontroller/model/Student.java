package uet.usercontroller.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trung on 7-8-2016.
 */

@Entity
@Table(name="Student")
public class Student {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private InfoBySchool infoBySchool;

    @OneToOne(cascade = CascadeType.ALL)
    private Internship internship;

    @OneToOne(cascade = CascadeType.ALL)
    private StudentInfo studentInfo;

    @OneToOne(cascade = CascadeType.ALL)
    private Comment comment;

    @OneToMany(mappedBy = "studentId", cascade = CascadeType.ALL)
    private List<JobSkill> jobSkills;

    @OneToMany(mappedBy = "studentId", cascade = CascadeType.ALL)
    private List<Follow> follows;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {    return id; }

    public InfoBySchool getInfoBySchool() {
        return infoBySchool;
    }

    public void setInfoBySchool(InfoBySchool infoBySchool) {
        this.infoBySchool = infoBySchool;
    }

    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo){
        this.studentInfo = studentInfo;
    }

    public List<JobSkill> getJobSkills() { return jobSkills; }

    public void setJobSkills(List<JobSkill> jobSkills) { this.jobSkills = jobSkills; }

    public List<Follow> getFollows() { return follows; }

    public void setFollows(List<Follow> follows) { this.follows = follows; }

}
