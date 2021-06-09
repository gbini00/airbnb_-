package airbnbteam;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Room_table")
public class Room {

    private Long roomId;
    private String status;
    private String desc;
    private Long reviewCnt;
    private String lastAction;

    @PostPersist
    public void onPostPersist(){
        RoomRegistered roomRegistered = new RoomRegistered();
        BeanUtils.copyProperties(this, roomRegistered);
        roomRegistered.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        RoomModified roomModified = new RoomModified();
        BeanUtils.copyProperties(this, roomModified);
        roomModified.publishAfterCommit();


        RoomReserved roomReserved = new RoomReserved();
        BeanUtils.copyProperties(this, roomReserved);
        roomReserved.publishAfterCommit();


        RoomCancelled roomCancelled = new RoomCancelled();
        BeanUtils.copyProperties(this, roomCancelled);
        roomCancelled.publishAfterCommit();


    }

    @PreRemove
    public void onPreRemove(){
        RoomDeleted roomDeleted = new RoomDeleted();
        BeanUtils.copyProperties(this, roomDeleted);
        roomDeleted.publishAfterCommit();


    }


    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public Long getReviewCnt() {
        return reviewCnt;
    }

    public void setReviewCnt(Long reviewCnt) {
        this.reviewCnt = reviewCnt;
    }
    public String getLastAction() {
        return lastAction;
    }

    public void setLastAction(String lastAction) {
        this.lastAction = lastAction;
    }




}
