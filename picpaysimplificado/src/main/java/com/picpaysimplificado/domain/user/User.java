package com.picpaysimplificado.domain.user;

import com.picpaysimplificado.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id") //definindo a chave primária

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String firstname;
    private String lastname;
    @Column(unique=true)
    private String document;
    @Column(unique=true)
    private String email;
    private String password;
    private BigDecimal balance; //saldo do usuário
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public UserType getUserType() {
        return userType;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public String getEmail() {
        return email;
    }
    public Long getId() {
        return id;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getDocument() {
        return document;
    }
    public String getPassword() {
        return password;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User(UserDTO data) {
        this.firstname = data.firstName();
        this.lastname = data.lastName();
        this.email = data.email();
        this.balance = data.balance();
        this.userType = data.userType();
        this.password = data.password();
        this.document = data.document();
    }

    public User() {}
}
