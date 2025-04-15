package kafka.sample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "event-topic", groupId = "group_id")
    void listener(String data) {
        System.out.println("Listener received: " + data);
    }
}
