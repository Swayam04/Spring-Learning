package org.example.repositories;

import org.example.main.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class DBCommentRepository implements CommentRepository {

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Comment: " + comment.getText() + " stored in database.");
    }

}
