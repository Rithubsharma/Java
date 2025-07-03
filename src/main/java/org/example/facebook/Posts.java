package org.example.facebook;

import java.sql.Timestamp;
import java.util.List;

public class Posts {
    private User postedBy;
    private Timestamp timestamp;
    private String content;
    private List<Like> likes;
    private List<Comment> comments;
}
