package by.itacademy.auditservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "audits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @Column(nullable = false)
    private String user;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private long dt_create;

    @Column(nullable = false)
    private long dt_update;
}