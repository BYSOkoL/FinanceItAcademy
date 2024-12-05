package by.itacademy.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double balance;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private long dt_create;

    @Column(nullable = false)
    private long dt_update;
}