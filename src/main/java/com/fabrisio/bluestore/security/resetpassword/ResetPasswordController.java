package com.fabrisio.bluestore.security.resetpassword;

import com.fabrisio.bluestore.security.forgotpassword.ForgotPasswordDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ResetPasswordController {

    private static final String RESET_PASSWORD = "/resetPassword";

    @GetMapping(RESET_PASSWORD)
    public String resetget(){
        return "pages/resetPassword";
    }

    @PostMapping(RESET_PASSWORD)
    public String resetpost(@RequestBody ResetPasswordDto dto){
        return "sucesso";
    }

}
