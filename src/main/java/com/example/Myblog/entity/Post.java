package com.example.Myblog.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts",
               uniqueConstraints = @UniqueConstraint(columnNames = {"title"}))
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name= "content", nullable = false)
    private String content;

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;



}
