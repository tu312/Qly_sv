package uet.usercontroller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uet.usercontroller.model.AdminNotification;
import uet.usercontroller.model.Role;
import uet.usercontroller.service.AdminNotificationService;
import uet.usercontroller.stereotype.RequiredRoles;

import java.util.List;

/**
 * Created by nhkha on 19/02/2017.
 */
@RestController
public class AdminNotificationController {
    @Autowired
    private AdminNotificationService notificationService;

    //get all notification
    @RequiredRoles({Role.ADMIN})
    @RequestMapping(value="/notification/all/admin", method = RequestMethod.GET)
    public List<AdminNotification> getNotification() {
        return notificationService.getNotification();
    }

    //get new notification
    @RequiredRoles({Role.ADMIN})
    @RequestMapping(value="/notification/{status}/admin", method = RequestMethod.GET)
    public List<AdminNotification> getNewNotification(@PathVariable("status") String status) {
        return notificationService.getNewNotification(status);
    }

    //remove notification
    @RequiredRoles({Role.ADMIN})
    @RequestMapping(value="/notification/{id}", method = RequestMethod.POST)
    public void removeNotification(@PathVariable("id") int id) {
        notificationService.removeNotification(id);
    }
}
