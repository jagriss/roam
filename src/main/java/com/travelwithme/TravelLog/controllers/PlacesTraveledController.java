package com.travelwithme.TravelLog.controllers;

import com.travelwithme.TravelLog.models.data.PlacesRepository;
import com.travelwithme.TravelLog.models.Places;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("places")
public class PlacesTraveledController {

    //link places repository
    @Autowired
    private PlacesRepository placesRepository;

    //displays travel log
    @RequestMapping("")
    public String displayAllPlacesTraveled(Model model){
        model.addAttribute("title", "Travel Log");
        model.addAttribute("places", placesRepository.findAll());
        return "places/index";
    }

    //adds new travels to empty constructor Places()
    @GetMapping("create")
    public String renderCreatePlacesForm(Model model){
        model.addAttribute("places", new Places());
//        model.addAttribute("places", placesRepository.findAll());
        return "places/create";
    }

    //adds new travels to places repository
    @PostMapping("create")
    public String createPlaces(@ModelAttribute @Valid Places newPlaces, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Travels");
//            model.addAttribute("errorMsg", "Bad data!");
            return "places/create";
        }
        placesRepository.save(newPlaces);
        return "redirect:"; //updates places list
    }

    //check delete function
    @GetMapping("delete")
    public String displayDeletePlacesForm(Model model){
        model.addAttribute("title", "Delete Travels");
        model.addAttribute("places", placesRepository.findAll());
        return "places/delete";
    }

//function to delete selected travels
    @PostMapping("delete")
    public String processDeletePlacesForm(@RequestParam(required = false) int[] placesIds){

        if(placesIds != null) {
            for (int id : placesIds) {
                placesRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

}
