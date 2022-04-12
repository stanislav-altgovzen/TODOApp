package com.yotpo.todoapp.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "task")
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String title;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String description;

    @CreationTimestamp
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime startDate;
    private LocalDateTime endDate;


    private Boolean scheduled;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", user=" + user +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", scheduled=" + scheduled +
                '}';
    }
}
