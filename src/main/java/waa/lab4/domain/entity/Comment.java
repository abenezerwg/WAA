package waa.lab4.domain.entity;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    long id;
    String name;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

}
