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
    @Autowired OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaymentApproved_ConfirmOrder(@Payload PaymentApproved paymentApproved){

        if(!paymentApproved.validate()) return;

        System.out.println("\n\n##### listener ConfirmOrder : " + paymentApproved.toJson() + "\n\n");

        // Sample Logic //
        Order order = new Order();
        orderRepository.save(order);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaymentCancelled_ConfirmCancel(@Payload PaymentCancelled paymentCancelled){

        if(!paymentCancelled.validate()) return;

        System.out.println("\n\n##### listener ConfirmCancel : " + paymentCancelled.toJson() + "\n\n");

        // Sample Logic //
        Order order = new Order();
        orderRepository.save(order);
            
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
