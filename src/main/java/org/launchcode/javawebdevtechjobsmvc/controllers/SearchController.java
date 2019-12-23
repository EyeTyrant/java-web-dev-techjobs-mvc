package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.launchcode.javawebdevtechjobsmvc.models.Job;
import org.launchcode.javawebdevtechjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

/**
 * Created by LaunchCode
 */

@Controller
@RequestMapping("search")
public class SearchController  extends TechJobsController{

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.

    @RequestMapping(value = "results")
    public String displaySearchResults(Model model, @RequestParam String searchType,
                                       @RequestParam String searchTerm){
        ArrayList<Job> jobs;
//        if (searchTerm.equals("all") || searchTerm == null){
//            jobs = JobData.findAll();
//        } else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        model.addAttribute("title", "Jobs with " + TechJobsController.columnChoices.get(searchType) + ": " + searchTerm);
//        }
        model.addAttribute("jobs", jobs);
        model.addAttribute("columns", columnChoices);
        model.addAttribute("checked", searchType);
        return "search";
    }


}
