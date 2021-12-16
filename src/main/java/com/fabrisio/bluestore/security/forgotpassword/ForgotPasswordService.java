package com.fabrisio.bluestore.security.forgotpassword;

public interface ForgotPasswordService {

    void forgotPasswordProcess(ForgotPasswordDto dto) throws Exception;

}
