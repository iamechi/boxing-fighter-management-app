package com.boxing_app.boxing_fighter_management_app.model;

public record FighterSearchFormDTO(
        Long fighterID,
        String first_name,
        String last_name,
        Double height,
        Double weight,
        Integer fights,
        Integer wins,
        Integer losses,
        Integer draws,
        Integer KOS,
        String current_state_residence,
        String current_city_residence,
        Integer years_of_boxing,
        Double knockout_percentage,
        String photo_attachment
) {}
