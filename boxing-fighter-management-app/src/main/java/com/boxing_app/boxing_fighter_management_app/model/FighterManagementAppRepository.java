package com.boxing_app.boxing_fighter_management_app.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FighterManagementAppRepository extends JpaRepository<Fighter, Long>, JpaSpecificationExecutor<Fighter> {
    @Query(value="SELECT * FROM boxers", nativeQuery = true)
    List<Fighter> AllFighters();

}
