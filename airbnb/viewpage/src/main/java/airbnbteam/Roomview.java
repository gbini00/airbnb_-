package airbnbteam;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Roomview_table")
public class Roomview {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String desc;
        private Long reviewCnt;
        private String roomStatus;
        private Long rsvId;
        private String rsvStatus;
        private Long payId;
        private String payStatus;
        private Long memId;
        private Long mileage;
        private String memStatus;
        private Long prdId;
        private Long ordId;
        private Long qty;
        private String ordStatus;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
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
        public String getRoomStatus() {
            return roomStatus;
        }

        public void setRoomStatus(String roomStatus) {
            this.roomStatus = roomStatus;
        }
        public Long getRsvId() {
            return rsvId;
        }

        public void setRsvId(Long rsvId) {
            this.rsvId = rsvId;
        }
        public String getRsvStatus() {
            return rsvStatus;
        }

        public void setRsvStatus(String rsvStatus) {
            this.rsvStatus = rsvStatus;
        }
        public Long getPayId() {
            return payId;
        }

        public void setPayId(Long payId) {
            this.payId = payId;
        }
        public String getPayStatus() {
            return payStatus;
        }

        public void setPayStatus(String payStatus) {
            this.payStatus = payStatus;
        }
        public Long getMemId() {
            return memId;
        }

        public void setMemId(Long memId) {
            this.memId = memId;
        }
        public Long getMileage() {
            return mileage;
        }

        public void setMileage(Long mileage) {
            this.mileage = mileage;
        }
        public String getMemStatus() {
            return memStatus;
        }

        public void setMemStatus(String memStatus) {
            this.memStatus = memStatus;
        }
        public Long getPrdId() {
            return prdId;
        }

        public void setPrdId(Long prdId) {
            this.prdId = prdId;
        }
        public Long getOrdId() {
            return ordId;
        }

        public void setOrdId(Long ordId) {
            this.ordId = ordId;
        }
        public Long getQty() {
            return qty;
        }

        public void setQty(Long qty) {
            this.qty = qty;
        }
        public String getOrdStatus() {
            return ordStatus;
        }

        public void setOrdStatus(String ordStatus) {
            this.ordStatus = ordStatus;
        }

}
