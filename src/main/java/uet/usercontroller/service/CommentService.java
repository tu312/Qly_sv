package uet.usercontroller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.usercontroller.DTO.CommentDTO;
import uet.usercontroller.model.*;
import uet.usercontroller.repository.*;

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
    @Autowired
    PartnerInfoRepository partnerInfoRepository;

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
            if (commentDTO.getRating() != null && commentDTO.getContent()!=null) {
                if (commentDTO.getRating() > 0 && commentDTO.getRating() <= 5) {
                    Comment comment = new Comment();
                    comment.setContent(commentDTO.getContent());
                    comment.setRating(commentDTO.getRating());
                    comment.setPartnerId(partnerId);
                    student.setComment(comment);
                    Partner partner = partnerRepository.findOne(partnerId);
                    PartnerInfo partnerInfo = partner.getPartnerInfo();
                    if (partnerInfo.getTotalRating() == null) {
                        partnerInfo.setTotalRating(1);
                    } else {
                        int totalRating;
                        totalRating = partnerInfo.getTotalRating();
                        totalRating++;
                        partnerInfo.setTotalRating(totalRating);
                    }
                    partnerInfoRepository.save(partnerInfo);
                    return commentRepository.save(comment);
                } else {
                    throw new NullPointerException("Rating value must be between 1 and 5.");
                }
            } else {
                throw new NullPointerException("Missing Information. Please write a review and rate this partner.")
            }
        } else {
            throw new NullPointerException("This user has already commented for this partner.");
        }
    }

    //show 5 top comment to homepage
    public List<Comment> showTopComment(){
        List<Comment> topComment = (List<Comment>) commentRepository.findByFilterNotLike(0);
        return topComment;
    }

    //admin change filter value
    public Comment changeFilterValue(int commentId, CommentDTO commentDTO){
        Comment comment = commentRepository.findOne(commentId);
        comment.setFilter(commentDTO.getFilter());
        return commentRepository.save(comment);
    }
}

