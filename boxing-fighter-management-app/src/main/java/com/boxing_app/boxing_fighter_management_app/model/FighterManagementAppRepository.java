package com.boxing_app.boxing_fighter_management_app.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FighterManagementAppRepository extends JpaRepository<Fighter, Long>, JpaSpecificationExecutor<Fighter> {
    @Query(value="SELECT * FROM boxers", nativeQuery = true)
    List<Fighter> AllFighters();

    /*
    @Modifying //This tells spring to use executeUpdate, which handles updates to a table instead of executeQuery, which handles querying a table
    @Transactional//grants database transaction permissions
    @Query(value="INSERT INTO boxers (fighterID, " +
            "first_name, " +
            "last_name, " +
            "height, " +
            "weight, " +
            "fights, " +
            "wins, " +
            "losses, " +
            "draws, " +
            "KOS, " +
            "current_state_residence, " +
            "years_of_boxing, " +
            "knockout_percentage, " +
            "photo_attachment) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14)",
            nativeQuery = true)
    void addFighter(Long fighterID,
                       String first_name,
                       String last_name,
                       double height,
                       double weight,
                       int fights,
                       int wins,
                       int loses,
                       int draws,
                       int KOS,
                       String current_state_residence,
                       int years_of_boxing,
                       double knockout_percentage,
                       String photo_attachment);

     */

    /*
    Fighter updateFighters(Fighter fighter);
     */
}
