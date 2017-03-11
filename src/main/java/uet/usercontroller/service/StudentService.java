package uet.usercontroller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.parser.Part;
import org.springframework.stereotype.Service;
import uet.usercontroller.DTO.PartnerDTO;
import uet.usercontroller.DTO.PartnerInfoDTO;
import uet.usercontroller.DTO.PostDTO;
import uet.usercontroller.DTO.StudentDTO;
import uet.usercontroller.model.*;
import uet.usercontroller.repository.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Trung on 7/8/2016.
 */
@Service
public class StudentService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    PartnerRepository partnerRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    PartnerInfoRepository partnerInfoRepository;
    @Autowired
    InfoBySchoolRepository infoBySchoolRepository;
    //Show all student information
    public List<HashMap<String, String>> getAllInfo(String token){
        List<InfoBySchool> allInfoBySchool = (List<InfoBySchool>) infoBySchoolRepository.findAll();
        List<HashMap<String, String>> listPartnerInfo = new ArrayList<HashMap<String, String>>();
        User checkUser = userRepository.findByToken(token);
        if (checkUser.getRole()==Role.VIP_PARTNER) {
            for (InfoBySchool infoBySchool : allInfoBySchool) {
                Student student = studentRepository.findByStudentInfoId(infoBySchool.getId());
                User user = userRepository.findByStudentIdAndStatus(student.getId(), "A");
                HashMap<String, String> lInfoBySChool = new HashMap<String, String>();
                lInfoBySChool.put("userId", String.valueOf(user.getId()));
                lInfoBySChool.put("status", user.getStatus());
                lInfoBySChool.put("studentName", infoBySchool.getStudentName());
                lInfoBySChool.put("infoBySchoolId", String.valueOf(infoBySchool.getId()));
                lInfoBySChool.put("gpa", String.valueOf(infoBySchool.getGPA()));
                lInfoBySChool.put("diploma", infoBySchool.getDiploma());
                lInfoBySChool.put("grade", infoBySchool.getGrade());
                lInfoBySChool.put("graduationYear", infoBySchool.getGraduationYear());
                lInfoBySChool.put("major", infoBySchool.getMajor());
                lInfoBySChool.put("studentClass", infoBySchool.getStudentClass());
                lInfoBySChool.put("studentCode", String.valueOf(infoBySchool.getStudentCode()));
                listPartnerInfo.add(lInfoBySChool);
            }
        }
        if (checkUser.getRole()==Role.ADMIN){
            for (InfoBySchool infoBySchool : allInfoBySchool) {
                Student student = studentRepository.findByStudentInfoId(infoBySchool.getId());
                User user = userRepository.findByStudentId(student.getId());
                HashMap<String, String> lInfoBySChool = new HashMap<String, String>();
                lInfoBySChool.put("userId", String.valueOf(user.getId()));
                lInfoBySChool.put("status", user.getStatus());
                lInfoBySChool.put("studentName", infoBySchool.getStudentName());
                lInfoBySChool.put("infoBySchoolId", String.valueOf(infoBySchool.getId()));
                lInfoBySChool.put("gpa", String.valueOf(infoBySchool.getGPA()));
                lInfoBySChool.put("diploma", infoBySchool.getDiploma());
                lInfoBySChool.put("grade", infoBySchool.getGrade());
                lInfoBySChool.put("graduationYear", infoBySchool.getGraduationYear());
                lInfoBySChool.put("major", infoBySchool.getMajor());
                lInfoBySChool.put("studentClass", infoBySchool.getStudentClass());
                lInfoBySChool.put("studentCode", String.valueOf(infoBySchool.getStudentCode()));
                listPartnerInfo.add(lInfoBySChool);
            }
        }
        return listPartnerInfo;
    }
    //Show
    public Student findStudent(int studentId, String token) {
        User user = userRepository.findByToken(token);
        if( user.getRole() == Role.STUDENT ){
            Student student1 = studentRepository.findById(studentId);
            if(user.getStudent().equals(student1)){
                return student1;
            }
            else{
                throw new NullPointerException("No result.");
            }
        }
        else {
            Student student2 = studentRepository.findById(studentId);
            if (student2 != null) {
                return student2;
            } else {
                throw new NullPointerException("No result.");
            }
        }
    }

//    //Create
//    public Student createStudent(int userId, StudentDTO studentDTO) {
//        User user = userRepository.findOne(userId);
//        Student student = new Student();
//        student.setStudentName(studentDTO.getStudentName());
//        user.setStudent(student);
//        return studentRepository.save(student);
//    }

    //Student search partner
    public List<PartnerInfo> searchPartner(PartnerInfoDTO partnerInfoDTO){
        List<PartnerInfo> allPartnerMatched = (List<PartnerInfo>) partnerInfoRepository.findByPartnerNameContaining(partnerInfoDTO.getPartnerName());
        return allPartnerMatched;
    }

    //Student search post description
    public List<Post> searchDescription(PostDTO postDTO){
        List<Post> allPostMatched = (List<Post>) postRepository.findByDescribePostContaining(postDTO.getDescribePost());
        return allPostMatched;
    }

    //Student search post by content
    public List<Post> searchContent(PostDTO postDTO){
        List<Post> allPostMatched = (List<Post>) postRepository.findByContentContaining(postDTO.getContent());
        return allPostMatched;
    }
}
