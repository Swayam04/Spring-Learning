package org.example.proxies;

import org.example.main.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier("PUSH")
public class CommentPushNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendCommentNotification(Comment comment) {
        System.out.println("Sending push notification for comment: " + comment.getText());
    }

}
