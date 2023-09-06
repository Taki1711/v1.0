package com.example.programwal.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Component
@Table(name = "ProgramWalEntity")
public class ProgramWalEntity implements Serializable {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "name")
    String name="";
    @Column(name = "surname")
    String surname="";

}
