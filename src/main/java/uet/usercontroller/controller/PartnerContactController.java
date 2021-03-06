package uet.usercontroller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uet.usercontroller.DTO.PartnerContactDTO;
import uet.usercontroller.model.PartnerContact;
import uet.usercontroller.model.Role;
import uet.usercontroller.service.PartnerContactService;
import uet.usercontroller.stereotype.RequiredRoles;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by fgv on 9/2/2016.
 */
@RestController
public class PartnerContactController {
    @Autowired
    private PartnerContactService partnerContactService;

    //show all partner contact
    @RequiredRoles({Role.STUDENT,Role.ADMIN,Role.VIP_PARTNER})
    @RequestMapping(value="/partnerContact",method = RequestMethod.GET)
    public List<PartnerContact> getallPartnerContact(){
        return partnerContactService.getpartnerContacts();
    }

    //Show list contact of a partner
    @RequiredRoles({Role.ADMIN,Role.VIP_PARTNER,Role.STUDENT, Role.NORMAL_PARTNER})
    @RequestMapping(value="/partner/{partnerId}/partnerContact",method = RequestMethod.GET)
    public List<PartnerContact> showAllContact(@PathVariable("partnerId") int partnerId){
        return partnerContactService.showAllContact(partnerId);
    }
    //show a partner contact
    @RequiredRoles({Role.ADMIN, Role.VIP_PARTNER, Role.STUDENT, Role.NORMAL_PARTNER})
    @RequestMapping(value="/partnerContact/{partnerContactId}", method = RequestMethod.GET)
    public PartnerContact showCont(@PathVariable("partnerContactId") int partnerCtId){
        return partnerContactService.showContact(partnerCtId);
    }
    //create a partner contact
    @RequiredRoles({Role.VIP_PARTNER, Role.NORMAL_PARTNER})
    @RequestMapping(value="/partner/{partnerId}/partnerContact", method = RequestMethod.POST)
    public PartnerContact createcontact(@PathVariable("partnerId") int partnerId, @RequestBody PartnerContactDTO partnerContactDTO, HttpServletRequest request){
        String token = request.getHeader("auth-token");
        return partnerContactService.createContact(partnerId, partnerContactDTO, token);
    }

    //edit contact of a partner
    @RequiredRoles({Role.VIP_PARTNER, Role.NORMAL_PARTNER})
    @RequestMapping(value="/partnerContact/{partnerContactId}", method = RequestMethod.PUT)
    public PartnerContact editcontact(@PathVariable("partnerContactId") int partnerContactId, @RequestBody PartnerContactDTO partnerContactDTO, HttpServletRequest request){
        String token = request.getHeader("auth-token");
        return partnerContactService.editContact(partnerContactId, partnerContactDTO, token);
    }

    //delete contact of a partner
    @RequiredRoles({Role.VIP_PARTNER, Role.NORMAL_PARTNER})
    @RequestMapping(value="/partnerContact/{partnerContactId}", method = RequestMethod.DELETE)
    public void deleteCont(@PathVariable("partnerContactId") int partnerCtId, HttpServletRequest request){
        String token = request.getHeader("auth-token");
        partnerContactService.deleteContact(partnerCtId, token);
    }
}
