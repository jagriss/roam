package com.travelwithme.TravelLog.controllers;


import com.travelwithme.TravelLog.models.data.WishListRepository;
import com.travelwithme.TravelLog.models.WishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("wishlist")
public class WishListController {

    @Autowired
    private WishListRepository wishListRepository;

    //displays travel log
    @RequestMapping("")
    public String displayAllPlacesTraveled(Model model){
        model.addAttribute("title", "Travel Log");
        model.addAttribute("wishlist", wishListRepository.findAll());
        return "wishList/index";
    }

    //adds new travels to empty constructor Places()
    @GetMapping("create")
    public String renderCreateWishlistForm(Model model){
        model.addAttribute("wishlist", new WishList());
//        model.addAttribute("places", placesRepository.findAll());
        return "wishList/create";
    }

    //adds new travels to places repository
    @PostMapping("create")
    public String createWishlist(@ModelAttribute @Valid WishList newWishlist, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Travels");
//            model.addAttribute("errorMsg", "Bad data!");
            return "wishList/create";
        }
        wishListRepository.save(newWishlist);
        return "redirect:"; //updates places list
    }

    //check delete function
    @GetMapping("delete")
    public String displayDeleteWishlistForm(Model model){
        model.addAttribute("title", "Delete Travels");
        model.addAttribute("wishlist", wishListRepository.findAll());
        return "wishList/delete";
    }

    @PostMapping("delete")
    public String processDeleteWishlistForm(@RequestParam(required = false) int[] wishlistsIds){

        if(wishlistsIds != null) {
            for (int id : wishlistsIds) {
                wishListRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

}
