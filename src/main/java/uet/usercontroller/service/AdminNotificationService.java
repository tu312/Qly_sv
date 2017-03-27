package uet.usercontroller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.usercontroller.DTO.AdminNotificationDTO;
import uet.usercontroller.model.AdminNotification;
import uet.usercontroller.model.User;
import uet.usercontroller.repository.AdminNotificationRepository;
import uet.usercontroller.repository.UserRepository;

import java.util.List;

/**
 * Created by nhkha on 19/02/2017.
 */
@Service
public class AdminNotificationService {
    @Autowired
    AdminNotificationRepository adminNotificationRepository;
    @Autowired
    UserRepository userRepository;

    //get all
    public List<AdminNotification> getNotification() {
        List<AdminNotification> listNotification = (List<AdminNotification>) adminNotificationRepository.findAll();
        return listNotification;
    }

    public void removeNotification(int id) {
        AdminNotification adminNotification = adminNotificationRepository.findById(id);
        adminNotification.setStatus("SEEN");
        adminNotificationRepository.save(adminNotification);
    }

    //get new noti
    public List<AdminNotification> getNewNotification(String status) {
        List<AdminNotification> newNotification = (List<AdminNotification>) adminNotificationRepository.findAll();
        return newNotification;
    }

    public void writeReport(AdminNotificationDTO adminNotificationDTO, String token) {
        User user = userRepository.findByToken(token);
        AdminNotification adminNotification = new AdminNotification();
        adminNotification.setStatus("NEW");
        if(user.getStudent() == null){
            adminNotification.setPartnetId(user.getPartner().getId());
        } else{
            adminNotification.setStudentId(user.getStudent().getId());
        }
        adminNotification.setIssue(adminNotificationDTO.getIssue() + " from " + user.getUserName());
        adminNotificationRepository.save(adminNotification);
    }
}
