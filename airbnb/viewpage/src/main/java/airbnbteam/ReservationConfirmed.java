package airbnbteam;

public class ReservationConfirmed extends AbstractEvent {

    private Long rsvId;
    private Long roomId;
    private String status;
    private Long payId;
    private Long memId;
    private Long mileageUsed;

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