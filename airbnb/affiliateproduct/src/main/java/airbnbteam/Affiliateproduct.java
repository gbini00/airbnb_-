package airbnbteam;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Affiliateproduct_table")
public class Affiliateproduct {

    private Long prdId;
    private String prdNm;
    private Long qty;
    private String desc;

    @PostPersist
    public void onPostPersist(){
        ProductRegistered productRegistered = new ProductRegistered();
        BeanUtils.copyProperties(this, productRegistered);
        productRegistered.publishAfterCommit();


        ProductModified productModified = new ProductModified();
        BeanUtils.copyProperties(this, productModified);
        productModified.publishAfterCommit();


        ProductDeleted productDeleted = new ProductDeleted();
        BeanUtils.copyProperties(this, productDeleted);
        productDeleted.publishAfterCommit();


        ProductOrdered productOrdered = new ProductOrdered();
        BeanUtils.copyProperties(this, productOrdered);
        productOrdered.publishAfterCommit();


        ProductCancelled productCancelled = new ProductCancelled();
        BeanUtils.copyProperties(this, productCancelled);
        productCancelled.publishAfterCommit();


    }


    public Long getPrdId() {
        return prdId;
    }

    public void setPrdId(Long prdId) {
        this.prdId = prdId;
    }
    public String getPrdNm() {
        return prdNm;
    }

    public void setPrdNm(String prdNm) {
        this.prdNm = prdNm;
    }
    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }




}
