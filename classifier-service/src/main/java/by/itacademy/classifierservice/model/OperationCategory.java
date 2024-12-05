package by.itacademy.classifierservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "operation_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private long dt_create;

    @Column(nullable = false)
    private long dt_update;
}