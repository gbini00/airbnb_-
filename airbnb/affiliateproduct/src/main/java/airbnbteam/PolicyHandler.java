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
    @Autowired AffiliateproductRepository affiliateproductRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCreateConfirmed_ConfirmOrder(@Payload OrderCreateConfirmed orderCreateConfirmed){

        if(!orderCreateConfirmed.validate()) return;

        System.out.println("\n\n##### listener ConfirmOrder : " + orderCreateConfirmed.toJson() + "\n\n");

        // Sample Logic //
        Affiliateproduct affiliateproduct = new Affiliateproduct();
        affiliateproductRepository.save(affiliateproduct);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCancelConfirmed_CancelOrder(@Payload OrderCancelConfirmed orderCancelConfirmed){

        if(!orderCancelConfirmed.validate()) return;

        System.out.println("\n\n##### listener CancelOrder : " + orderCancelConfirmed.toJson() + "\n\n");

        // Sample Logic //
        Affiliateproduct affiliateproduct = new Affiliateproduct();
        affiliateproductRepository.save(affiliateproduct);
            
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
