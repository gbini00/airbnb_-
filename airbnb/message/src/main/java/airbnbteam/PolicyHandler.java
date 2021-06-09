package airbnbteam;

import airbnbteam.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired MessageRepository messageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationConfirmed_SendConfirmMsg(@Payload ReservationConfirmed reservationConfirmed){

        if(!reservationConfirmed.validate()) return;

        System.out.println("\n\n##### listener SendConfirmMsg : " + reservationConfirmed.toJson() + "\n\n");

        // Sample Logic //
        Message message = new Message();
        messageRepository.save(message);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCancelled_SendCancelMsg(@Payload ReservationCancelled reservationCancelled){

        if(!reservationCancelled.validate()) return;

        System.out.println("\n\n##### listener SendCancelMsg : " + reservationCancelled.toJson() + "\n\n");

        // Sample Logic //
        Message message = new Message();
        messageRepository.save(message);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverMemberModified_SendMemberModifyMsg(@Payload MemberModified memberModified){

        if(!memberModified.validate()) return;

        System.out.println("\n\n##### listener SendMemberModifyMsg : " + memberModified.toJson() + "\n\n");

        // Sample Logic //
        Message message = new Message();
        messageRepository.save(message);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverMemberDeleted_SendMemberModifyMsg(@Payload MemberDeleted memberDeleted){

        if(!memberDeleted.validate()) return;

        System.out.println("\n\n##### listener SendMemberModifyMsg : " + memberDeleted.toJson() + "\n\n");

        // Sample Logic //
        Message message = new Message();
        messageRepository.save(message);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCreateConfirmed_SendOrderConfirmMsg(@Payload OrderCreateConfirmed orderCreateConfirmed){

        if(!orderCreateConfirmed.validate()) return;

        System.out.println("\n\n##### listener SendOrderConfirmMsg : " + orderCreateConfirmed.toJson() + "\n\n");

        // Sample Logic //
        Message message = new Message();
        messageRepository.save(message);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCancelConfirmed_SendOrderCancelMsg(@Payload OrderCancelConfirmed orderCancelConfirmed){

        if(!orderCancelConfirmed.validate()) return;

        System.out.println("\n\n##### listener SendOrderCancelMsg : " + orderCancelConfirmed.toJson() + "\n\n");

        // Sample Logic //
        Message message = new Message();
        messageRepository.save(message);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverMemberJoined_SendMemberJoinMsg(@Payload MemberJoined memberJoined){

        if(!memberJoined.validate()) return;

        System.out.println("\n\n##### listener SendMemberJoinMsg : " + memberJoined.toJson() + "\n\n");

        // Sample Logic //
        Message message = new Message();
        messageRepository.save(message);
            
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
