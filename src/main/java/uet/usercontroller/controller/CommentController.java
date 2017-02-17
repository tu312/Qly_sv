package uet.usercontroller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uet.usercontroller.DTO.CommentDTO;
import uet.usercontroller.model.Comment;
import uet.usercontroller.model.Role;
import uet.usercontroller.service.CommentService;
import uet.usercontroller.stereotype.RequiredRoles;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tu on 16-Feb-17.
 */
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    //show all comments
    @RequiredRoles({Role.STUDENT, Role.ADMIN})
    @RequestMapping(value="/showAllComment", method = RequestMethod.GET)
    public List<HashMap<String, String>> showAllComment(){
        return (List<HashMap<String, String>>) commentService.showAllComment();
    }

    //show all comments of a partner
    @RequiredRoles({Role.STUDENT, Role.ADMIN})
    @RequestMapping(value="/showAllCommentOfOnePartner/{partnerId}", method = RequestMethod.GET)
    public List<Comment> showAllCommentOfOnePartner(@PathVariable("partnerId") int partnerId) {
        return commentService.showAllCommentOfOnePartner(partnerId);
    }

    //comment a partner
    @RequiredRoles({Role.STUDENT})
    @RequestMapping(value="student/{studentId}/writeComment/partner{partnerId}", method = RequestMethod.POST)
    public Comment writeComment(@PathVariable("studentId") int studentId, @PathVariable("partnerId") int partnerId,
                                @RequestBody CommentDTO commentDTO, HttpServletRequest request){
        String token = request.getHeader("auth-token");
        return commentService.writeComment(studentId, partnerId, commentDTO, token);
    }

}
