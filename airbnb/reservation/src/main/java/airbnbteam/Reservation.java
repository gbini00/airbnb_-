package airbnbteam;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Reservation_table")
public class Reservation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long rsvId;
    private Long roomId;
    private String status;
    private Long payId;
    private Long memId;
    private Long mileageUsed;

    @PostPersist
    public void onPostPersist(){
        ReservationCreated reservationCreated = new ReservationCreated();
        BeanUtils.copyProperties(this, reservationCreated);
        reservationCreated.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        airbnbteam.external.Room room = new airbnbteam.external.Room();
        // mappings goes here
        Application.applicationContext.getBean(airbnbteam.external.RoomService.class)
            .chkAndReqReserve(room);


    }

    @PostUpdate
    public void onPostUpdate(){
        ReservationCancelRequested reservationCancelRequested = new ReservationCancelRequested();
        BeanUtils.copyProperties(this, reservationCancelRequested);
        reservationCancelRequested.publishAfterCommit();


        ReservationConfirmed reservationConfirmed = new ReservationConfirmed();
        BeanUtils.copyProperties(this, reservationConfirmed);
        reservationConfirmed.publishAfterCommit();


        ReservationCancelled reservationCancelled = new ReservationCancelled();
        BeanUtils.copyProperties(this, reservationCancelled);
        reservationCancelled.publishAfterCommit();


    }


    public Long getRsvId() {
        return rsvId;
    }

    public void setRsvId(Long rsvId) {
        this.rsvId = rsvId;
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
    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }
    public Long getMemId() {
        return memId;
    }

    public void setMemId(Long memId) {
        this.memId = memId;
    }
    public Long getMileageUsed() {
        return mileageUsed;
    }

    public void setMileageUsed(Long mileageUsed) {
        this.mileageUsed = mileageUsed;
    }




}
