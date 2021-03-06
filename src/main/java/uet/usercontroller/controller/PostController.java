package uet.usercontroller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uet.usercontroller.DTO.PostDTO;
import uet.usercontroller.model.Post;
import uet.usercontroller.model.Role;
import uet.usercontroller.service.PostService;
import uet.usercontroller.stereotype.RequiredRoles;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Trung on 8/29/2016.
 */
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    //show all post with pagination
    @RequiredRoles({Role.ADMIN,Role.STUDENT})
    @RequestMapping(value="/post",method= RequestMethod.GET)
    public Page<Post> getAllPosts(HttpServletRequest request, Pageable pageable) {
        String token = request.getHeader("auth-token");
        return postService.getAllPosts(token, pageable);
    }

    //Show list post of a partner
    @RequiredRoles({Role.ADMIN,Role.STUDENT,Role.VIP_PARTNER})
    @RequestMapping(value="/partner/{partnerId}/post",method = RequestMethod.GET)
    public List<Post> showAllPost(@PathVariable("partnerId") int partnerId, HttpServletRequest request){
        String token = request.getHeader("auth-token");
        return postService.showAllPost(partnerId, token);
    }

    //Show a post
    @RequiredRoles({Role.ADMIN,Role.VIP_PARTNER,Role.STUDENT})
    @RequestMapping(value="/post/{postId}",method = RequestMethod.GET)
    public Post showPost(@PathVariable("postId") int postId){
        return postService.showPost(postId);
    }

    //Create post
    @RequiredRoles({Role.VIP_PARTNER, Role.NORMAL_PARTNER})
    @RequestMapping(value="/partner/{partnerId}/post",method = RequestMethod.POST)
    public Post createPost(@PathVariable("partnerId") int partnerId, @RequestBody PostDTO postDTO, HttpServletRequest request) throws IOException {
        String token = request.getHeader("auth-token");
        return postService.createPost(partnerId, postDTO, token);
    }

    //upload image for post
    @RequiredRoles({Role.VIP_PARTNER})
    @RequestMapping(value="/partner/{partnerId}/post/image",method = RequestMethod.POST)
    public Post uploadImage(@PathVariable("partnerId") int partnerId , @RequestBody PostDTO postDTO, HttpServletRequest request) throws IOException {
        String token = request.getHeader("auth-token");
        return postService.uploadImage(partnerId, postDTO, token);
    }

    //Edit post
    @RequiredRoles({Role.VIP_PARTNER, Role.NORMAL_PARTNER})
    @RequestMapping(value="/post/{postId}",method = RequestMethod.PUT)
    public Post editPost(@PathVariable("postId") int postId, @RequestBody PostDTO postDTO, HttpServletRequest request){
        String token = request.getHeader("auth-token");
        return postService.editPost(postId, postDTO, token);
    }

    //Delete post
    @RequiredRoles({Role.VIP_PARTNER, Role.NORMAL_PARTNER})
    @RequestMapping(value="/post/{postId}",method = RequestMethod.DELETE)
    public void deletePost(@PathVariable("postId") int postId, HttpServletRequest request){
        String token = request.getHeader("auth-token");
        postService.deletePost(postId, token);
    }

    //change post status
    @RequiredRoles(Role.ADMIN)
    @RequestMapping(value="post/{postId}/status", method = RequestMethod.PUT)
    public Post changeStatus(@PathVariable("postId") int postId){
        return postService.changeStatus(postId);
    }

}
