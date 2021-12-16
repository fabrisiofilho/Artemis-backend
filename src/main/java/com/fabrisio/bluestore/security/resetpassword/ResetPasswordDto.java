package com.fabrisio.bluestore.security.resetpassword;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResetPasswordDto {

    private String senha;
    private String senhaConfirma;

}
