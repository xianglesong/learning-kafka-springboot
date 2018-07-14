package com.xianglesong.kafka.consumer;

import com.google.gson.Gson;

import com.xianglesong.kafka.entity.Message;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by rollin on 18/3/23.
 */

@Component
@Slf4j
public class KafkaReceiver {

//    @KafkaListener(topics = {"tester"})
//    public void listen(ConsumerRecord<?, ?> record) {
//
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//
//        if (kafkaMessage.isPresent()) {
//
//            Object message = kafkaMessage.get();
//
//            Gson gson = new Gson();
//            Message msg = gson.fromJson(message.toString(), Message.class);
//            log.info("xx ----------------- record =" + record);
//            log.info("yy ------------------ message =" + message);
//            log.info("msg: " + msg.getMsg());
//        }
//
//    }
//
//    @KafkaListener(id = "id1", topics = "tester")
//    public void listen4(@Payload String message) {
//        Gson gson = new Gson();
//        Message msg = gson.fromJson(message.toString(), Message.class);
//        log.info("yy ------------------ message =" + message);
//        log.info("msg payload: " + msg.getMsg());
//    }

    @KafkaListener(id = "id1", topics = "tester")
    public void listen4ack(@Payload String message, Acknowledgment ack) {
        Gson gson = new Gson();
        Message msg = gson.fromJson(message.toString(), Message.class);
        log.info("yy ------------------ message =" + message);
        log.info("msg payload: " + msg.getMsg());
        ack.acknowledge();
    }
}
