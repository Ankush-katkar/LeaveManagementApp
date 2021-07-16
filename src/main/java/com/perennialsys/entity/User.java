package com.perennialsys.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String email;
    private String password;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "is_enabled")
    private boolean enabled;

   /* @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )*/
    /* private String roles;*/

    public int getId() {
        return id;
    }

}
