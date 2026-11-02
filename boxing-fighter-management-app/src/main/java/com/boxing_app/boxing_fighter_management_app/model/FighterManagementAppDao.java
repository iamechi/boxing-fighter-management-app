package com.boxing_app.boxing_fighter_management_app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Component
public class FighterManagementAppDao {
    @Autowired
    FighterManagementAppRepository repo;

    //Handles returning all of the records for fighters
    public List<Fighter> getAllFighters() {
        return repo.AllFighters();
    }

    //Handles addition of a single fighter to a database
    public Fighter addFighter(Fighter fighter) { return repo.save(fighter); }

    //Handles the searching of fighter records
    public List<Fighter> getFighter(FighterSearchFormDTO fighterCriteria) {
        Object value;

        //This basically sets up a basic search query without a where clause
        Specification<Fighter> spec = Specification.unrestricted();

        /*Each one of these conditions lead to a condition being added to the where clause for the query
        if true. The spec object is basically being used as a tool for creating the database query that will
        be used*/
        value = fighterCriteria.fighterID();
        if (value instanceof Long providedId && providedId > -1) {
            System.out.println("Entered findById if-condition");
            spec = spec.and(FighterSpecs.findById(providedId));
        }

        value = fighterCriteria.first_name();
        if (value instanceof String providedFirstName && StringUtils.hasLength(providedFirstName)) {
            spec = spec.and(FighterSpecs.firstNameStartsWith(providedFirstName));
        }

        value = fighterCriteria.last_name();
        if (value instanceof String providedLastName && StringUtils.hasLength(providedLastName)) {
            spec = spec.and(FighterSpecs.lastNameStartsWith(providedLastName));
        }

        value = fighterCriteria.current_state_residence();
        if (value instanceof String providedState && StringUtils.hasLength(providedState)) {
            spec = spec.and(FighterSpecs.stateStartsWith(providedState));
        }

        /*The spec object gets passed to an inherited findAll method from JpaRepository that
        handles the querying of the database using the spec object to form the query*/
        return repo.findAll(spec);
    }

}
