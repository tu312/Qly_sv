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
    @RequestMapping(value="writeComment/partner/{partnerId}", method = RequestMethod.POST)
    public Comment writeComment(@PathVariable("partnerId") int partnerId,
                                @RequestBody CommentDTO commentDTO, HttpServletRequest request){
        String token = request.getHeader("auth-token");
        return commentService.writeComment(partnerId, commentDTO, token);
    }

    //show 5 comments to homepage which are filtered by admin ( filter field != null )
    @RequiredRoles({Role.ADMIN, Role.VIP_PARTNER, Role.STUDENT, Role.NORMAL_PARTNER, Role.OTHER_PARTNER})
    @RequestMapping(value="/showTopComment", method = RequestMethod.GET)
    public List<Comment> showTopComment(){
        return commentService.showTopComment();
    }

    //admin change filter field in order to add comment to homepage
    @RequiredRoles(Role.ADMIN)
    @RequestMapping(value="/changeFilterValue/{commentId}", method = RequestMethod.PUT)
    public Comment changeFilterValue(@PathVariable("commentId") int commentId, @RequestBody CommentDTO commentDTO){
        return commentService.changeFilterValue(commentId, commentDTO);
    }

    //check comment
    @RequiredRoles({Role.STUDENT, Role.ADMIN})
    @RequestMapping(value="/student/{studentId}/checkComment", method = RequestMethod.GET)
    public Comment checkComment(@PathVariable("studentId") int studentId){
        return commentService.checkComment(studentId);
    }

}
