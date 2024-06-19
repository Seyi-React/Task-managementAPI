package com.oluwaseyi.TaskManagement.model.Task;



import javax.persistence.*;

import com.oluwaseyi.TaskManagement.model.User;

import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @SuppressWarnings("unused")
    private String title;
    @SuppressWarnings("unused")
    private String description;
    @SuppressWarnings("unused")
    private Date dueDate;
    @SuppressWarnings("unused")
    private boolean completed;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
}

