package com.fabrisio.bluestore.security.forgotpassword;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ForgotPasswordController {

    private static final String FORGOT_PASSWORD = "/forgotPassword";

    @GetMapping(FORGOT_PASSWORD)
    public String forgotget(){
        return "pages/forgotPassword";
    }

    @PostMapping(FORGOT_PASSWORD)
    public String forgotpost(){
        return "sucesso";
    }

}
