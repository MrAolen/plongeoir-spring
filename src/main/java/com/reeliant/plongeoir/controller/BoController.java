package com.reeliant.plongeoir.controller;

import com.reeliant.plongeoir.dto.BackOfficeDataDTO;
import com.reeliant.plongeoir.dto.BookCreateDTO;
import com.reeliant.plongeoir.dto.CategoryDTO;
import com.reeliant.plongeoir.dto.UpdateMetaDataAjaxRequest;
import com.reeliant.plongeoir.service.AdminService;
import com.reeliant.plongeoir.service.CategoryService;
import com.reeliant.plongeoir.service.MetaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoController {
        @Autowired
        private AdminService adminService;

        @Autowired
        private CategoryService categoryService;

        @Autowired
        private MetaDataService metaDataService;

        @GetMapping("/bo/home")
        public String displayHomePage(Model model) {
                BackOfficeDataDTO backOfficeInformations = adminService.getDatasForHomeBackOffice();
                model.addAttribute("openHours",metaDataService.getMetaDataByKey("hours"));
                model.addAttribute("rules",metaDataService.getMetaDataByKey("rules"));
                model.addAttribute("homepage",metaDataService.getMetaDataByKey("home"));
                model.addAttribute("infos",backOfficeInformations);

                return "bo-home";
        }


        @PutMapping("/bo/metadata")
        @ResponseBody
        public ResponseEntity deleteBook(@RequestBody UpdateMetaDataAjaxRequest request) {
                metaDataService.updateMetaData(request.getData(),request.getKey());
                return ResponseEntity.ok(HttpStatus.OK);
        }
}
