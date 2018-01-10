package com.reeliant.plongeoir.controller;

import com.reeliant.plongeoir.dto.form.UserCreationDTO;
import com.reeliant.plongeoir.dto.UserDTO;
import com.reeliant.plongeoir.service.BorrowService;
import com.reeliant.plongeoir.service.MetaDataService;
import com.reeliant.plongeoir.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

        @Autowired
        private MetaDataService metaDataService;

        @Autowired
        private UserService userService;

        @Autowired
        private BorrowService borrowService;

        @GetMapping({"/home","/"})
        public String displayHomePage(Model model) {
                model.addAttribute("homeMessage",metaDataService.getMetaDataByKey("home"));
                return "fo/home";
        }

        @GetMapping("/register")
        public String displayRegisterPage(Model model) {
                model.addAttribute("user",new UserCreationDTO());
                return "fo/register";
        }

        @PostMapping("/register")
        public String submitRegisterPage(@Valid @ModelAttribute("user") UserCreationDTO user, BindingResult bindingResult) {
                if (bindingResult.hasErrors()) {
                        return "fo/register";
                }
                userService.createUser(user);
                return "redirect:/login";
        }

        @GetMapping("/account")
        public String displayAccountPage(Model model) {
                UserDTO user = userService.getCurrentUser();
                UserCreationDTO userCreationDTO = new UserCreationDTO();
                userCreationDTO.setAge(user.getAge().intValue());
                userCreationDTO.setConfirmPassword("");
                userCreationDTO.setEmail(user.getEmail());
                userCreationDTO.setForname(user.getForname());
                userCreationDTO.setName(user.getName());
                userCreationDTO.setUsername(user.getUsername());

                model.addAttribute("user", userCreationDTO);
                model.addAttribute("borrows", borrowService.getBorrowedBookByUser(user.getId()));
                return "fo/account";
        }

        @PostMapping("/update")
        public String submitUpdateInformation(Model model, @ModelAttribute UserCreationDTO userCreationDTO) {
                userService.updateUser(userCreationDTO);
                return "redirect:/account";
        }

        @GetMapping("/cgu")
        public String displayCGUPage(Model model) {
                model.addAttribute("cgu",metaDataService.getMetaDataByKey("cgu"));
                return "fo/cgu";
        }

}