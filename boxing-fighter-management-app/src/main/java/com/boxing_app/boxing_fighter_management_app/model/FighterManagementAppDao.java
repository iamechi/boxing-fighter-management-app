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
    public List<Fighter> getFighter(Map<String, Object> fighterCriteria) {
        Object value;

        //This basically sets up a basic search query without a where clause
        Specification<Fighter> spec = Specification.unrestricted();

        /*Each one of these conditions lead to a condition being added to the where clause for the query
        if true. The spec object is basically being used as a tool for creating the database query that will
        be used*/
        value = fighterCriteria.get("fighterID");
        if (value instanceof Long providedID && providedID > -1) {
            spec = spec.and(FighterSpecs.findById(providedID));
        }

        value = fighterCriteria.get("first_name");
        if (value instanceof String firstNameProvided && StringUtils.hasLength(firstNameProvided)) {
            spec = spec.and(FighterSpecs.firstNameStartsWith(firstNameProvided));
        }


        value = fighterCriteria.get("last_name");
        if (value instanceof String lastNameProvided && StringUtils.hasLength(lastNameProvided)) {
            spec = spec.and(FighterSpecs.lastNameStartsWith(lastNameProvided));
        }

        value = fighterCriteria.get("current_state_residence");
        if (value instanceof String stateProvided && StringUtils.hasLength(stateProvided)) {
            spec = spec.and(FighterSpecs.stateStartsWith(stateProvided));
        }

        /*The spec object gets passed to an inherited findAll method from JpaRepository that
        handles the querying of the database using the spec object to form the query*/
        return repo.findAll(spec);
    }

}
