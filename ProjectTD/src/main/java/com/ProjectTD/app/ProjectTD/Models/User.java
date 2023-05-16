package com.ProjectTD.app.ProjectTD.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.intellij.lang.annotations.Pattern;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "userName"))
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    private long id;
@Column(length=50)
private String userName;
   // @Size(min=8, max=20, message="Password must be between {min} and {max} characters long.")

 @Column
 private String password;
@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinTable(name = "users_roles",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"))
 private Collection<Role> roles;

    public User(String userName, String password, Collection<Role> roles) {
        super();
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }
}
