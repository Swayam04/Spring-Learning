package org.example.main;

import org.example.config.ProjectConfig;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var commentService = context.getBean(CommentService.class);
        var comment = new Comment();
        comment.setAuthorName("Tyler Durden");
        comment.setText("The things you own end up owning you");
        commentService.publishComment(comment);

    }
}