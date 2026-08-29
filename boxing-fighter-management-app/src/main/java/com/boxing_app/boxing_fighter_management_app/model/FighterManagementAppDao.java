package com.boxing_app.boxing_fighter_management_app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

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

    public List<Fighter> getFighter(Map<String, Object> fighterCriteria) {
        Object value;
        System.out.println("entered getFighter method");
        Specification<Fighter> spec = Specification.unrestricted();

        value = fighterCriteria.get("fighterID");
        if (value instanceof Long providedID && providedID > -1) {
            System.out.println("entered");
            spec.and(FighterSpecs.findById(providedID));
        }

        value = fighterCriteria.get("first_name");
        System.out.println("object: " + value);
        if (value instanceof String firstNameProvided && StringUtils.hasLength(firstNameProvided)) {
            System.out.println("entered 2");
            spec.and(FighterSpecs.firstNameStartsWith(firstNameProvided));
        }


        value = fighterCriteria.get("last_name");
        if (value instanceof String lastNameProvided && StringUtils.hasLength(lastNameProvided)) {
            System.out.println("entered 3");
            spec.and(FighterSpecs.lastNameStartsWith(lastNameProvided));
        }

        return repo.findAll(spec);
    }

}
