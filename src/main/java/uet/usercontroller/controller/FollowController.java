package uet.usercontroller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uet.usercontroller.DTO.FollowDTO;
import uet.usercontroller.model.Follow;
import uet.usercontroller.model.Post;
import uet.usercontroller.model.Role;
import uet.usercontroller.model.Student;
import uet.usercontroller.service.FollowService;
import uet.usercontroller.stereotype.RequiredRoles;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by nhkha on 16/02/2017.
 */
@RestController
public class FollowController {

    @Autowired
    FollowService followService;

    // show all follows of student
    @RequiredRoles({Role.STUDENT, Role.ADMIN})
    @RequestMapping(value="student/{studentId}/follow",method = RequestMethod.GET)
    public List<Follow> showAllFollowsOfStudent(@PathVariable("studentId") int studentId, HttpServletRequest request){
        String token =request.getHeader("auth-token");
        return followService.showAllFollowsOfStudent(studentId, token);
    }

    // show all follows of post
    @RequiredRoles({Role.STUDENT, Role.VIP_PARTNER,Role.ADMIN})
    @RequestMapping(value="post/{postId}/follow",method = RequestMethod.GET)
    public List<Follow> showAllFollowsOfPost(@PathVariable("postId") int postId, HttpServletRequest request){
        String token =request.getHeader("auth-token");
        return followService.showAllFollowsOfPost(postId, token);
    }

    //check follow
    @RequiredRoles({Role.STUDENT})
    @RequestMapping(value="/post/{postId}/student/{studentId}/checkFollow",method = RequestMethod.PUT)
    public Follow checkFollow(@PathVariable("postId") int postId, @PathVariable("studentId") int studentId, HttpServletRequest request){
        String token =request.getHeader("auth-token");
        return followService.checkFollow(postId, studentId ,token);
    }

    //follow a post
    @RequiredRoles({Role.STUDENT})
    @RequestMapping(value="/post/{postId}/student/{studentId}/follow",method = RequestMethod.PUT)
    public void createFollow(@PathVariable("postId") int postId, @PathVariable("studentId") int studentId, HttpServletRequest request){
        String token =request.getHeader("auth-token");
        followService.createFollow(postId, studentId ,token);
    }

    //unfollow
    @RequestMapping(value="/post/{postId}/student/{studentId}/unfollow", method = RequestMethod.DELETE)
    @RequiredRoles({Role.STUDENT,Role.ADMIN})
    public void deleteJs(@PathVariable("postId") int postId, @PathVariable("studentId") int studentId, HttpServletRequest request){
        String token = request.getHeader("auth-token");
        followService.unfollow(postId,studentId,token);
    }
}
