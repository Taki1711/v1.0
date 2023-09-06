package com.example.programwal.Controller;


import com.example.programwal.Entity.ProgramWalEntity;
import com.example.programwal.Repository.ProgramWalRepo;
import com.example.programwal.Service.ProgramWalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/controller")
public class ProgramWalController {


    @Autowired
    ProgramWalRepo programWalRepo;
    @Autowired
    ProgramWalService programWalService;

    @PostMapping("/addUser")
    public ResponseEntity<?> registration(@RequestBody ProgramWalEntity user) {
        try {
            programWalService.registration(user);
            return new ResponseEntity<>("Utente inserito con successo", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/modifyUser")
    public ResponseEntity<?> modifyUser(@RequestBody ProgramWalEntity user) {
        return programWalService.updateUser(user);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<Object> visualizzaListaUtenti() {
        return new ResponseEntity<>(programWalService.getAllUser(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        return programWalService.deleteUser(id);
    }
}
