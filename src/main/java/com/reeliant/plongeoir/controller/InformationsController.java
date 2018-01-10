package com.reeliant.plongeoir.controller;

import com.reeliant.plongeoir.service.MetaDataService;
import java.sql.Blob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class InformationsController{

    @Autowired
    private MetaDataService metaDataService;

    @GetMapping("/hours")
    public String displayOpeningHoursPage(Model model) {
        String hours = metaDataService.getMetaDataByKey("hours");
        model.addAttribute("hours",hours);
        return "fo/hours";
    }

    @GetMapping("/rules")
    public String displayRulesPage(Model model) {
        String rules = metaDataService.getMetaDataByKey("rules");
        model.addAttribute("rules",rules);
        return "fo/rules";
    }
}
