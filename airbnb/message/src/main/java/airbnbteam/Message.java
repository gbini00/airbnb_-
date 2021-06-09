package airbnbteam;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Message_table")
public class Message {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long msgId;
    private Long roomId;
    private String content;
    private Long memId;
    private Long prdId;


    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
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
    public Long getPrdId() {
        return prdId;
    }

    public void setPrdId(Long prdId) {
        this.prdId = prdId;
    }




}
