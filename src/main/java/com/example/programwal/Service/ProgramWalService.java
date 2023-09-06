package com.example.programwal.Service;

import com.example.programwal.Dto.ProgramWalDTO;
import com.example.programwal.Entity.ProgramWalEntity;
import com.example.programwal.Repository.ProgramWalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProgramWalService {
    @Autowired
    ProgramWalRepo programWalRepo;
    @Autowired
    ProgramWalDTO dto;

    public ResponseEntity<ProgramWalEntity> registration(ProgramWalEntity utente) {
        Optional<ProgramWalEntity> findById = programWalRepo.findById(utente.getId());
        if (findById.isPresent()) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Message", "utente esistente");
            return new ResponseEntity<>(null, httpHeaders, 404);
        } else {
            return ResponseEntity.ok(programWalRepo.save(utente));
        }
    }

    public ResponseEntity<ProgramWalEntity> updateUser(ProgramWalEntity utente){
        ProgramWalEntity user = programWalRepo.findById(utente.getId()).get();
        System.out.println(utente.getId());
        if(user!=null){
            user.setNome(utente.getNome());
            user.setCognome(utente.getCognome());
            user.setEmail(utente.getEmail());
            user.setNumeroditelefono(utente.getNumeroditelefono());
            ProgramWalEntity newUser = programWalRepo.save(utente);
            return ResponseEntity.ok(newUser);
        }else {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Message", "il record non esiste");
            return new ResponseEntity<>(null, httpHeaders, 404);
        }
    }

    public List<ProgramWalEntity> getAllUser(){
        return programWalRepo.findAll();
    }

    public ResponseEntity<?> deleteUser(Integer id){
        programWalRepo.deleteById(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Message", "utente cancellato");
        return new ResponseEntity<>(null, httpHeaders, 200);
    }

    }
