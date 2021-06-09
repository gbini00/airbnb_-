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
    @Autowired PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCancelRequested_CancelPayment(@Payload ReservationCancelRequested reservationCancelRequested){

        if(!reservationCancelRequested.validate()) return;

        System.out.println("\n\n##### listener CancelPayment : " + reservationCancelRequested.toJson() + "\n\n");

        // Sample Logic //
        Payment payment = new Payment();
        paymentRepository.save(payment);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCancelled_CancelPayment(@Payload OrderCancelled orderCancelled){

        if(!orderCancelled.validate()) return;

        System.out.println("\n\n##### listener CancelPayment : " + orderCancelled.toJson() + "\n\n");

        // Sample Logic //
        Payment payment = new Payment();
        paymentRepository.save(payment);
            
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
