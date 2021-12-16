package com.fabrisio.bluestore.security.register;

import com.fabrisio.bluestore.exceptions.UsuarioException;
import com.fabrisio.bluestore.user.UsuarioEntity;

public interface RegisterService {

    UsuarioEntity registerUserCompany(RegisterUserCompanyDto dto);
    UsuarioEntity registerUserEmployee(RegisterUserEmployeeDto dto) throws UsuarioException;
    
}
