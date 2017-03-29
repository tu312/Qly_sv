package uet.usercontroller.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by fgv on 7/11/2016.
 */
@Entity
@Table(name="Internship")
public class Internship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name="id")
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="partner")
    @JsonIgnore
    private Partner  partner;
    private String company;
    private Date startDate;
    private Date  endDate;
    private String supervisor;
    private int studentId;

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
