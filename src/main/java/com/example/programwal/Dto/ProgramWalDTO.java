package com.example.programwal.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component

public class ProgramWalDTO {

    int id;
    String name;
    String surname;

}
