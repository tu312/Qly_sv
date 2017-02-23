package uet.usercontroller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.usercontroller.DTO.CommentDTO;
import uet.usercontroller.model.Comment;
import uet.usercontroller.model.Partner;
import uet.usercontroller.model.Student;
import uet.usercontroller.model.User;
import uet.usercontroller.repository.CommentRepository;
import uet.usercontroller.repository.PartnerRepository;
import uet.usercontroller.repository.StudentRepository;
import uet.usercontroller.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tu on 16-Feb-17.
 */
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    PartnerRepository partnerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    StudentRepository studentRepository;

    //show all comments
    public List<HashMap<String, String>> showAllComment(){
        List<Comment> allComment = (List<Comment>) commentRepository.findAll();
        List<HashMap<String, String>> listComment = new ArrayList<HashMap<String, String>>();
        for (Comment comment : allComment){
            HashMap<String, String> lComment = new HashMap<String, String>();
            String commentId = String.valueOf(comment.getId());
            String content = comment.getContent();
            String rating = String.valueOf(comment.getRating());
            lComment.put("commentId", commentId);
            lComment.put("content", content);
            lComment.put("rating", rating);
            listComment.add(lComment);
        }
        return listComment;
    }

    //show all comment of a partner
    public List<Comment> showAllCommentOfOnePartner(int id){
        Partner partner = partnerRepository.findOne(id);
        return partner.getComments();
    }

    //write a comment
    public Comment writeComment(int partnerId, CommentDTO commentDTO, String token){
        User user = userRepository.findByToken(token);
        Student student = user.getStudent();
        if (student.getComment() == null ){
            Comment comment = new Comment();
            comment.setContent(commentDTO.getContent());
            comment.setRating(commentDTO.getRating());
            comment.setPartnerId(partnerId);
            student.setComment(comment);

            return  commentRepository.save(comment);

        } else {
            throw new NullPointerException("This user has already commented for this partner.");
        }
    }
}

