package com.dechristofaro.commentservice;
import com.dechristofaro.commentservice.util.messages.CommentMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @RabbitListener(queues = CommentServiceApplication.QUEUE_NAME)
    public void recieveMessage(CommentMessage message) {
        System.out.println(message.toString());
    }
}
