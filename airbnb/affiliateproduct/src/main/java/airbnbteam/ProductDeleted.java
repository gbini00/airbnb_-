package airbnbteam;

public class ProductDeleted extends AbstractEvent {

    private Long prdId;
    private String prdNm;
    private Long qty;
    private String desc;

    public ProductDeleted(){
        super();
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
