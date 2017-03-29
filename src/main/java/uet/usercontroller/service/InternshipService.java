package uet.usercontroller.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.usercontroller.DTO.InternshipDTO;
import uet.usercontroller.model.*;
import uet.usercontroller.repository.*;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fgv on 7/11/2016.
 */
@Service
public class InternshipService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private InternshipRepository internshipRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PartnerRepository partnerRepository;
    @Autowired
    private AdminNotificationRepository adminNotificationRepository;

    private Internship createInternship(Partner partner,InternshipDTO internshipDTO){
        Internship internship = new Internship();
        internship.setCompany(internshipDTO.getCompany());
        internship.setPartner(partner);
        internship.setEndDate(internshipDTO.getEndDate());
        internship.setStartDate(internshipDTO.getStartDate());
        internship.setSupervisor(internshipDTO.getSupervisor());
        internship.setStudentId(internshipDTO.getStudentId());
        return internship;
    }

    //show all Internships
    public List<Internship> getAllIntern(String token){
        return (List<Internship>) internshipRepository.findAll();
    }

    //show all internships of a partner
    public List<Internship> getAllInPartner(int partnerId, String token){
        User user=userRepository.findByToken(token);
        Partner partner=partnerRepository.findById(partnerId);
        if(user.getRole().equals(Role.ADMIN) || user.getRole().equals(Role.VIP_PARTNER))
        {
            return partner.getInternships();
        }
        else {
            throw new NullPointerException("You don's have permission");
        }

    }
    //find a internship
    public Internship findInternById(int id,String token) {
        User user = userRepository.findByToken(token);
        Internship internship = internshipRepository.findById(id);
        if(user.getRole()==Role.STUDENT){
            return user.getStudent().getInternship();
        } else {
            return internship;
        }
    }


    //Create a internship
    public Internship createIntern(int studentId,int partnerId,InternshipDTO internshipDTO,String token) {
        User user = userRepository.findByToken(token);
        Student student = studentRepository.findOne(studentId);
        Partner partner = partnerRepository.findById(partnerId);
        if(user.getRole().equals(Role.ADMIN)){
            if(student.getInternship()==null) {
                Internship internship = this.createInternship(partner,internshipDTO);
                student.setInternship(internship);
                partner.getInternships().add(internship);
                return internshipRepository.save(internship);
            }
            else {
                throw new NullPointerException("This student had internship ");
            }
        }
        else{
            throw new NullPointerException("You don't have permission");
        }
    }

    //Edit a internship
    public Internship changeById( int internId, InternshipDTO internshipDTO,String token){
        User user = userRepository.findByToken(token);
        if(user.getRole().equals(Role.ADMIN)) {
            Internship internship = internshipRepository.findOne(internId);
            internship.setCompany(internshipDTO.getCompany());
            internship.setStartDate(internshipDTO.getStartDate());
            internship.setEndDate(internshipDTO.getEndDate());
            internship.setSupervisor(internshipDTO.getSupervisor());
            return internshipRepository.save(internship);
        }
        else{
            throw new NullPointerException("You don't have permission");
        }
    }

    //Delete by Id
    public void deleteById(int id,String token){
        User user = userRepository.findByToken(token);
        Student student = studentRepository.findByInternshipId(id);
        if (user.getRole().equals(Role.ADMIN)) {
            student.setInternship(null);
            internshipRepository.delete(id);
        }
        else {
            throw new NullPointerException("You don't have permission");
        }
    }

    //create internship from excel
    public void createMultiInternship(List<InternshipDTO> list, String token) {
        User user = userRepository.findByToken(token);
        Partner partner = user.getPartner();
        for(InternshipDTO internshipDTO : list){
            User user_ = userRepository.findByUserName(String.valueOf(internshipDTO.getStudentCode()));
            if(user_ == null){
                AdminNotification adminNotification = new AdminNotification();
                adminNotification.setIssue("Kiem tra lai sinh vien: " + internshipDTO.getStudentName() + "-"
                    + internshipDTO.getBirthday() + "-" + internshipDTO.getGrade() + internshipDTO.getStudentClass()
                    + " khong tim thay sinh vien co MSSV: " + internshipDTO.getStudentCode());
                adminNotification.setPartnetId(partner.getId());
                adminNotification.setStatus("NEW");
                adminNotificationRepository.save(adminNotification);
            } else{
                Student student = user_.getStudent();
                if( student.getInternship() == null){
                    internshipDTO.setStudentId(student.getId());
                    Internship internship = this.createInternship(partner,internshipDTO);
                    student.setInternship(internship);
                    partner.getInternships().add(internship);
                    internshipRepository.save(internship);
                } else{
                    AdminNotification adminNotification = new AdminNotification();
                    adminNotification.setIssue("Kiem tra lai sinh vien: " + internshipDTO.getStudentName() + "-"
                        + internshipDTO.getBirthday() + "-" + internshipDTO.getGrade() + internshipDTO.getStudentClass()
                        + ", internship da ton tai");
                    adminNotification.setPartnetId(partner.getId());
                    adminNotification.setUserName(user.getUserName());
                    adminNotification.setStatus("NEW");
                    adminNotificationRepository.save(adminNotification);
                }
            }
        }

    }
}
