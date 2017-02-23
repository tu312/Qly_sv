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

    private Internship createInternship(InternshipDTO internshipDTO){
        Internship internship = new Internship();
        internship.setCompany(internshipDTO.getCompany());
        internship.setPartnerId(internshipDTO.getPartnerId());
        internship.setEndDate(internshipDTO.getEndDate());
        internship.setStartDate(internshipDTO.getStartDate());
        internship.setSupervisor(internshipDTO.getSupervisor());
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
            Student student = user.getStudent();
            if(student.getInternship().equals(internship)){
                return internship;
            }
            else{
                throw new NullPointerException("You don't have permission");
            }
        }
        else {
            return internship;
        }
    }


    //Create a internship
    public Internship createIntern(int studentId,int partnerId,InternshipDTO internshipDTO,String token) {
        User user = userRepository.findByToken(token);
        Student student = studentRepository.findOne(studentId);
        if(user.getRole().equals(Role.ADMIN)){
            if(student.getInternship()==null) {
                Internship internship = this.createInternship(internshipDTO);
                student.setInternship(internship);
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
            internship.setPartnerId(internshipDTO.getPartnerId());
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

    public void createMultiInternship(int partnerId, List<InternshipDTO> list, String token) {
        User user =userRepository.findByToken(token);
        Partner partner = partnerRepository.findById(partnerId);
        if(user.getPartner().equals(partner)){
//            partner.setInternships(list);
//            List<InternshipDTO> listInternship = new ArrayList<InternshipDTO>();
            for(InternshipDTO internshipDTO : list){
                Student student = studentRepository.findById(internshipDTO.getStudentId());
                if( student.getInternship() == null){
                    Internship internship = this.createInternship(internshipDTO);
                    student.setInternship(internship);
                    internshipRepository.save(internship);
                } else{
//                    listInternship.add(internshipDTO);
                    AdminNotification adminNotification = new AdminNotification();
                    adminNotification.setIssue("Kiem tra internship cua: " + studentRepository.findById(internshipDTO
                            .getStudentId()).getInfoBySchool().getStudentCode());
                    adminNotification.setPartnetId(partnerId);
                    adminNotification.setUserName(user.getUserName());
                    adminNotification.setStatus("NEW");
                    adminNotificationRepository.save(adminNotification);
                }
            }
//            return listInternship;
        } else {
            throw new NullPointerException("You don't have permission");
        }

    }
}
