package uet.usercontroller.DTO;

import uet.usercontroller.model.Partner;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

/**
 * Created by Trung on 8/29/2016.
 */
public class PostDTO {
    private List<HashtagDTO> hashtagDTO;
    private int id;
    private String content;
    private Date datePost;
    private String describePost;
    private String image;
    private String status;
    private Integer requiredNumber;

    public List<HashtagDTO> getHashtagDTO() {
        return hashtagDTO;
    }

    public void setHashtagDTO(List<HashtagDTO> hashtagDTO) {
        this.hashtagDTO = hashtagDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public Date getDatePost() { return datePost; }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }

    public String getDescribePost() { return describePost; }

    public void setDescribePost(String describePost) { this.describePost = describePost; }

    public String getImage() {
        return image;
    }

    public void setImage(String image) { this.image = image; }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRequiredNumber() {
        return requiredNumber;
    }

    public void setRequiredNumber(Integer requiredNumber) {
        this.requiredNumber = requiredNumber;
    }
}
