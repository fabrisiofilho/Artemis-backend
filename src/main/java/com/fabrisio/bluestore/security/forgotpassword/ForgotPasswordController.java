package com.fabrisio.bluestore.security.forgotpassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ForgotPasswordController {

    @Autowired
    ForgotPasswordService forgotPasswordService;

    private static final String FORGOT_PASSWORD = "/forgotPassword";

    @GetMapping(FORGOT_PASSWORD)
    public String forgotget(){
        return "pages/forgotPassword";
    }

    @PostMapping(FORGOT_PASSWORD)
    public String forgotpost(ForgotPasswordDto dto) throws Exception {
        try {
            forgotPasswordService.forgotPasswordProcess(dto);
            return "redirect:/forgotPassword?success";
        }catch (Exception e){
            return "redirect:/forgotPassword?error";
        }
    }

}
