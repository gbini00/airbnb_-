package airbnbteam;

import airbnbteam.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class RoomviewViewHandler {


    @Autowired
    private RoomviewRepository roomviewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRoomRegistered_then_CREATE_1 (@Payload RoomRegistered roomRegistered) {
        try {

            if (!roomRegistered.validate()) return;

            // view 객체 생성
            Roomview roomview = new Roomview();
            // view 객체에 이벤트의 Value 를 set 함
            roomview.setId(roomRegistered.getRoomId());
            roomview.setDesc(roomRegistered.getDesc());
            roomview.setReviewCnt(roomRegistered.getReviewCnt());
            roomview.setRoomStatus(roomRegistered.getStatus());
            // view 레파지 토리에 save
            roomviewRepository.save(roomview);
        
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_CREATE_ (@Payload  ) {
        try {

            if (!.validate()) return;

            // view 객체 생성
            Roomview roomview = new Roomview();
            // view 객체에 이벤트의 Value 를 set 함
            roomview.setMemId(.getMemId());
            roomview.setMileage(.getMileage());
            roomview.setMemStatus(.getStatus());
            // view 레파지 토리에 save
            roomviewRepository.save(roomview);
        
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCreated_then_CREATE_3 (@Payload OrderCreated orderCreated) {
        try {

            if (!orderCreated.validate()) return;

            // view 객체 생성
            Roomview roomview = new Roomview();
            // view 객체에 이벤트의 Value 를 set 함
            roomview.setPrdId(orderCreated.getPrdId());
            roomview.setOrdId(orderCreated.getId());
            roomview.setQty(orderCreated.getQty());
            roomview.setOrdStatus(orderCreated.getStatus());
            // view 레파지 토리에 save
            roomviewRepository.save(roomview);
        
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenRoomModified_then_UPDATE_1(@Payload RoomModified roomModified) {
        try {
            if (!roomModified.validate()) return;
                // view 객체 조회
            Optional<Roomview> roomviewOptional = roomviewRepository.findById(roomModified.getRoomId());
            if( roomviewOptional.isPresent()) {
                Roomview roomview = roomviewOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                    roomview.setDesc(roomModified.getDesc());
                    roomview.setReviewCnt(roomModified.getReviewCnt());
                    roomview.setMemStatus(roomModified.getStatus());
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationConfirmed_then_UPDATE_2(@Payload ReservationConfirmed reservationConfirmed) {
        try {
            if (!reservationConfirmed.validate()) return;
                // view 객체 조회
            Optional<Roomview> roomviewOptional = roomviewRepository.findById(reservationConfirmed.getRoomId());
            if( roomviewOptional.isPresent()) {
                Roomview roomview = roomviewOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                    roomview.setRsvId(reservationConfirmed.getRsvId());
                    roomview.setRsvStatus(reservationConfirmed.getStatus());
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentApproved_then_UPDATE_3(@Payload PaymentApproved paymentApproved) {
        try {
            if (!paymentApproved.validate()) return;
                // view 객체 조회
            List<Roomview> roomviewList = roomviewRepository.findByRsvId(paymentApproved.getRsvId());
            for(Roomview roomview : roomviewList){
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                roomview.setPayId(paymentApproved.getPayId());
                roomview.setPayStatus(paymentApproved.getStatus());
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCancelled_then_UPDATE_4(@Payload ReservationCancelled reservationCancelled) {
        try {
            if (!reservationCancelled.validate()) return;
                // view 객체 조회
            List<Roomview> roomviewList = roomviewRepository.findByRsvId(reservationCancelled.getRsvId());
            for(Roomview roomview : roomviewList){
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                roomview.setRsvStatus(reservationCancelled.getStatus());
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCancelled_then_UPDATE_5(@Payload PaymentCancelled paymentCancelled) {
        try {
            if (!paymentCancelled.validate()) return;
                // view 객체 조회
            List<Roomview> roomviewList = roomviewRepository.findByPayId(paymentCancelled.getPayId());
            for(Roomview roomview : roomviewList){
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                roomview.setPayStatus(paymentCancelled.getStatus());
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_UPDATE_(@Payload  ) {
        try {
            if (!.validate()) return;
                // view 객체 조회
            List<Roomview> roomviewList = roomviewRepository.findByMemId(.getMemId());
            for(Roomview roomview : roomviewList){
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                roomview.setMileage(.getMileage());
                roomview.setMemStatus(.getStatus());
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_UPDATE_(@Payload  ) {
        try {
            if (!.validate()) return;
                // view 객체 조회
            List<Roomview> roomviewList = roomviewRepository.findByMemId(.getMemId());
            for(Roomview roomview : roomviewList){
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                roomview.setMemStatus(.getStatus());
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCreateConfirmed_then_UPDATE_8(@Payload OrderCreateConfirmed orderCreateConfirmed) {
        try {
            if (!orderCreateConfirmed.validate()) return;
                // view 객체 조회
            List<Roomview> roomviewList = roomviewRepository.findByOrdId(orderCreateConfirmed.getId());
            for(Roomview roomview : roomviewList){
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                roomview.setPrdId(orderCreateConfirmed.getPrdId());
                roomview.setQty(orderCreateConfirmed.getQty());
                roomview.setOrdStatus(orderCreateConfirmed.getStatus());
                roomview.setMemId(orderCreateConfirmed.getMemId());
                roomview.setMileage(orderCreateConfirmed.getMildageUsed());
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCancelConfirmed_then_UPDATE_9(@Payload OrderCancelConfirmed orderCancelConfirmed) {
        try {
            if (!orderCancelConfirmed.validate()) return;
                // view 객체 조회
            List<Roomview> roomviewList = roomviewRepository.findByOrdId(orderCancelConfirmed.getId());
            for(Roomview roomview : roomviewList){
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                roomview.setPrdId(orderCancelConfirmed.getPrdId());
                roomview.setQty(orderCancelConfirmed.getQty());
                roomview.setOrdStatus(orderCancelConfirmed.getStatus());
                roomview.setMemId(orderCancelConfirmed.getMemId());
                roomview.setMileage(orderCancelConfirmed.getMildageUsed());
                // view 레파지 토리에 save
                roomviewRepository.save(roomview);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRoomDeleted_then_DELETE_1(@Payload RoomDeleted roomDeleted) {
        try {
            if (!roomDeleted.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            roomviewRepository.deleteById(roomDeleted.getRoomId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}