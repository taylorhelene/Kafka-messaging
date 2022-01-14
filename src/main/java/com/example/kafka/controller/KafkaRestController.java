package com.example.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.kafka.message.repository.MessageRepository;
import com.example.kafka.sender.MessageProducer;
import com.example.kafka.consumer.MessageConsumer;
@RestController
public class KafkaRestController {

    @Autowired
      private MessageProducer producer;

      @Autowired
      private MessageConsumer consumer;

      @Autowired
       private MessageRepository messageRepo;

      //Send message to kafka
      @GetMapping("/send")
      public String sendMsg(
      @RequestParam("msg") String message) {
          producer.sendMessage(message);
          consumer.consume(message);
          return "" + message + " sent successfully!";
      }
      
      //Read all messages
      @GetMapping("/getAll")
      public String getAllMessages() {
       
         return messageRepo.getAllMessages() ;
      }
}
