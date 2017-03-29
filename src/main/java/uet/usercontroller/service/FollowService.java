package uet.usercontroller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.usercontroller.DTO.FollowDTO;
import uet.usercontroller.DTO.PostDTO;
import uet.usercontroller.model.*;
import uet.usercontroller.repository.*;

import java.util.List;

/**
 * Created by nhkha on 16/02/2017.
 */
@Service
public class FollowService {
    @Autowired
    FollowRepository followRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PartnerRepository partnerRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PostRepository postRepository;

    public List<Follow> showAllFollowsOfStudent(int studentId, String token) {
        User user = userRepository.findByToken(token);
        if(user.getStudent().getId() == studentId){
            return user.getStudent().getFollows();
        } else{
            throw new NullPointerException("User doesn't match with Student");
        }
    }

    public List<Follow> showAllFollowsOfPost(int postId, String token) {
        User user = userRepository.findByToken(token);
        if(user.getRole() == Role.ADMIN){
            return (List<Follow>) followRepository.findByPostId(postId);
        } else {
            if (user.getPartner().equals(partnerRepository.findByPostId(postId))) {
                return (List<Follow>) followRepository.findByPostId(postId);
            } else {
                throw new NullPointerException("User doesn't match with Partner");
            }
        }
    }

    public void createFollow(int postId, int studentId, String token, FollowDTO followDTO) {
        User user = userRepository.findByToken(token);
        Student student = user.getStudent();
        Post post = postRepository.findById(postId);
        if(student.getId() == studentId){
            if (followRepository.findByStudentIdAndPostId(studentId, postId) == null){
                Follow follow = new Follow();
                follow.setPost(post);
                follow.setStudent(student);
                follow.setPostTitle(followDTO.getPostTitle());
                follow.setStudentName(followDTO.getStudentName());
                student.getFollows().add(follow);
                post.getFollows().add(follow);
                followRepository.save(follow);
            } else {
                throw new NullPointerException("Post followed");
            }
        } else {
            throw new NullPointerException("User doesn't match with Student");
        }
//        studentRepository.findById(studentId).setFollows(postRepository.findById(postId));
    }

    public void unfollow(int postId, int studentId, String token) {
        if(userRepository.findByToken(token).getStudent().getId() == studentId){
            Follow follow = followRepository.findByStudentIdAndPostId(studentId, postId);
            followRepository.delete(follow);
        } else {
            throw new NullPointerException("User doesn't match with Student");
        }
    }

    public Follow checkFollow(int postId, int studentId, String token) {
        User user = userRepository.findByToken(token);
        Student student = user.getStudent();
        if(student.getId() == studentId){
            Follow follow = new Follow();
            if(followRepository.findByStudentIdAndPostId(studentId, postId) == null){
                follow.setId(0);
                return follow;
            } else {
                follow.setId(1);
                return follow;
            }
        } else {
            throw new NullPointerException("User doesn't match with Student");
        }
    }
}
