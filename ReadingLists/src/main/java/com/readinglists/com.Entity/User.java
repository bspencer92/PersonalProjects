package com.readinglists.com.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<ReadingList> readingList;

    public String getPassword() {return password; }

    public void setPassword(String password){
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ReadingList> getReadingList() {
        return readingList;
    }

    public void setReadingList(List<ReadingList> readingList) {
        this.readingList = readingList;
    }
}