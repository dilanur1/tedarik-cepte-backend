package com.tedarik_cepte.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String first_name;
    private String last_name;
    private String firm;
    private String address;
    private String phone;

    @Column(unique = true)
    private String username;
    private String password;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Cart cart;

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", firm='" + firm + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id);
    }
}
