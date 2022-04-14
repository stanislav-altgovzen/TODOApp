package com.yotpo.todoapp.entities;


import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "user")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String firstName;

    @NotNull
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String lastName;



    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

    @CreationTimestamp
    private LocalDateTime createDate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tasks=" + tasks +
                ", createDate=" + createDate +
                '}';
    }
}
