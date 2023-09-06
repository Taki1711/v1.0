package com.example.programwal.Repository;

import com.example.programwal.Entity.ProgramWalEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProgramWalRepo extends JpaRepository<ProgramWalEntity,Integer> {
}
