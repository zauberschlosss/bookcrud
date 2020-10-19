package com.bookstorage.bookdemo.entity;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "userr")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private Calendar dob;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<UserBookEntityRef> userBookEntityRefs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getDob() {
        return dob;
    }

    public void setDob(String dob) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(dob);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            this.dob = calendar;

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<UserBookEntityRef> getUserBookEntityRefs() {
        return userBookEntityRefs;
    }

    public void setUserBookEntityRefs(List<UserBookEntityRef> userBookEntityRefs) {
        this.userBookEntityRefs = userBookEntityRefs;
    }
}
