package com.fabrisio.bluestore.security.resetpassword;

import lombok.Data;

@Data
public class ResetPasswordDto {

    private String senha;
    private String senhaConfirma;

}
