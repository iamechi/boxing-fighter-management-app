package com.boxing_app.boxing_fighter_management_app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FighterManagementAppDao {
    @Autowired
    FighterManagementAppRepository repo;

    public List<Fighter> getAllFighters() {
        return repo.AllFighters();
    }

    public Fighter addFighter(Fighter fighter) {
        /*
        repo.addFighter(fighter.getFighterID(),
                                fighter.getFirst_name(),
                                fighter.getLast_name(),
                                fighter.getHeight(),
                                fighter.getWeight(),
                                fighter.getFights(),
                                fighter.getWins(),
                                fighter.getLosses(),
                                fighter.getDraws(),
                                fighter.getKOS(),
                                fighter.getCurrent_state_residence(),
                                fighter.getYears_of_boxing(),
                                fighter.getKnockout_percentage(),
                                fighter.getPhoto_attachment());

         */
        return repo.save(fighter);

    }

}
