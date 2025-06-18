package com.MainProject.FlightBooking.Controller;

import com.MainProject.FlightBooking.DTO.FlightSearchRequestDTO;
import com.MainProject.FlightBooking.DTO.FlightSearchResultDTO;
import com.MainProject.FlightBooking.SearchService.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/")
public class SearchController {

    private final SearchServiceImpl searchService;

    @Autowired
    public SearchController(SearchServiceImpl searchService) {
        this.searchService = searchService;
    }
    
    @GetMapping("/")
    public String home() {
        return "redirect:/searchInputs";
    }

    @GetMapping("/searchInputs")
    public String searchInputs(){
        return "search-inputs";
    }

    @PostMapping("/listFlights")
    public String listFlights(
            @RequestParam("departureCity") String departureCity,
            @RequestParam("arrivalCity") String arrivalCity,
            @RequestParam("departureDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate,
            @RequestParam("travelClass") String travelClass,
            @RequestParam("numberOfTravellers") Integer numberOfTravellers,
            Model model) {
        
        FlightSearchRequestDTO request = new FlightSearchRequestDTO(
                departureCity, 
                numberOfTravellers, 
                travelClass, 
                departureDate, 
                arrivalCity
        );
        
        List<FlightSearchResultDTO> flights = searchService.searchFlights(request);
        model.addAttribute("flights", flights);
        
        return "list-flights";
    }
}