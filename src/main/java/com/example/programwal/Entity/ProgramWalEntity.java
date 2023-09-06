package com.example.programwal.Entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "nome")
    String nome="";
    @Column(name = "cognome")
    String cognome="";
    @Column (name = "Numero di Telefono")
    String  numeroditelefono= null;
    @Column (name = "Email")
    String email= null;
}
