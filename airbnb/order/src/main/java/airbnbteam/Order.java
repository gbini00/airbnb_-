package airbnbteam;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Order_table")
public class Order {

    private Long ordId;
    private Long prdId;
    private Long qty;
    private Long memId;
    private Long payId;
    private String status;
    private Long mildageUsed;

    @PostPersist
    public void onPostPersist(){
        OrderCreated orderCreated = new OrderCreated();
        BeanUtils.copyProperties(this, orderCreated);
        orderCreated.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        airbnbteam.external.Payment payment = new airbnbteam.external.Payment();
        // mappings goes here
        Application.applicationContext.getBean(airbnbteam.external.PaymentService.class)
            .approvePayment(payment);


        OrderCancelled orderCancelled = new OrderCancelled();
        BeanUtils.copyProperties(this, orderCancelled);
        orderCancelled.publishAfterCommit();


        OrderCreateConfirmed orderCreateConfirmed = new OrderCreateConfirmed();
        BeanUtils.copyProperties(this, orderCreateConfirmed);
        orderCreateConfirmed.publishAfterCommit();


        OrderCancelConfirmed orderCancelConfirmed = new OrderCancelConfirmed();
        BeanUtils.copyProperties(this, orderCancelConfirmed);
        orderCancelConfirmed.publishAfterCommit();


    }


    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }
    public Long getPrdId() {
        return prdId;
    }

    public void setPrdId(Long prdId) {
        this.prdId = prdId;
    }
    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }
    public Long getMemId() {
        return memId;
    }

    public void setMemId(Long memId) {
        this.memId = memId;
    }
    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Long getMildageUsed() {
        return mildageUsed;
    }

    public void setMildageUsed(Long mildageUsed) {
        this.mildageUsed = mildageUsed;
    }




}
