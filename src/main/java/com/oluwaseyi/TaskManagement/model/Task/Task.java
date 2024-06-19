package com.oluwaseyi.TaskManagement.model.Task;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.oluwaseyi.TaskManagement.model.User;

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

    public User getUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUser'");
    }

    public String getTitle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTitle'");
    }

    public Date getDueDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDueDate'");
    }

    public String getDescription() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescription'");
    }

    public boolean isCompleted() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isCompleted'");
    }

    
}

