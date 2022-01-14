package com.example.kafka.consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.example.kafka.message.repository.MessageRepository;

@Component
public class MessageConsumer {
    private Logger log = LoggerFactory.getLogger(MessageConsumer.class);

    @Autowired
    private MessageRepository messageRepo;

    @KafkaListener(topics = "${myapp.kafka.topic}", groupId = "test-consumer-group")
    public void consume(String message) {
       log.info("MESSAGE RECEIVED AT CONSUMER END -> " + message);
       messageRepo.addMessage(message);
    }
}
