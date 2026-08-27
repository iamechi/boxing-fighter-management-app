package com.boxing_app.boxing_fighter_management_app.rest;

import com.boxing_app.boxing_fighter_management_app.model.Fighter;
import com.boxing_app.boxing_fighter_management_app.model.FighterManagementAppDao;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(
        origins = "http://localhost:5173",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}
)
public class FighterManagementAppController {
    @Autowired
    FighterManagementAppDao service;

    @GetMapping("/fighters")
    public List<Fighter> getAllFighters() {
        return service.getAllFighters();
    }

    /*returns a http response to the front end after saving,
     let the user know if save was successful or not */
    @PostMapping("/fighters/add")
    public ResponseEntity<?> addFighters(@RequestBody Fighter fighter) {
        Fighter savedFighter;

        if (fighter.getFighterID() == 0) {
            fighter.setFighterID(null);
        }

        if (fighterExists(fighter)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A fighter with this name already exists");
        }

        savedFighter = service.addFighter(fighter);

        return ResponseEntity.ok(savedFighter);
    }

    @PostMapping("fighters/update")
    public ResponseEntity<?> updateFighter(@RequestBody Fighter fighter) {
        Fighter savedFighter;
        savedFighter = service.addFighter(fighter);

        return ResponseEntity.ok(savedFighter);
    }

    //A check to see if a fighter already has been added
    public boolean fighterExists(Fighter fighter) {
        boolean hasMatch;
        List<Fighter> allFighters = service.getAllFighters();

        hasMatch = allFighters.stream().anyMatch(listFighter ->
                listFighter.getFirst_name().equalsIgnoreCase(fighter.getFirst_name()) &&
                        listFighter.getLast_name().equalsIgnoreCase(fighter.getLast_name()));

        return hasMatch;
    }

}
