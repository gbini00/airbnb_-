package airbnbteam;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Review_table")
public class Review {

    private Long reviewId;
    private Long roomId;
    private String content;
    private Long memId;

    @PostPersist
    public void onPostPersist(){
        ReviewCreated reviewCreated = new ReviewCreated();
        BeanUtils.copyProperties(this, reviewCreated);
        reviewCreated.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        ReviewModified reviewModified = new ReviewModified();
        BeanUtils.copyProperties(this, reviewModified);
        reviewModified.publishAfterCommit();


    }

    @PreRemove
    public void onPreRemove(){
        ReviewDeleted reviewDeleted = new ReviewDeleted();
        BeanUtils.copyProperties(this, reviewDeleted);
        reviewDeleted.publishAfterCommit();


    }


    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }
    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Long getMemId() {
        return memId;
    }

    public void setMemId(Long memId) {
        this.memId = memId;
    }




}
