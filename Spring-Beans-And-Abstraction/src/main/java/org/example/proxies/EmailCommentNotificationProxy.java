package org.example.proxies;

import org.example.main.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("EMAIL")
public class EmailCommentNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendCommentNotification(Comment comment) {
        System.out.println("Sending email notification for comment: " + comment.getText());
    }

}
