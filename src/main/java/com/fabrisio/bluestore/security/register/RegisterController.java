package com.fabrisio.bluestore.security.register;

import com.fabrisio.bluestore.exceptions.UsuarioException;
import com.fabrisio.bluestore.user.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/registeremployee")
    public UsuarioEntity cadastrarFuncionario(@RequestBody RegisterUserEmployeeDto dto) throws UsuarioException {
        return registerService.registerUserEmployee(dto);
    }

    @PostMapping("/registercompany")
    public UsuarioEntity cadastrarEmpresa(@RequestBody RegisterUserCompanyDto dto){
        return registerService.registerUserCompany(dto);
    }

}
