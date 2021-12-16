package com.fabrisio.bluestore.security.register;

import com.fabrisio.bluestore.dto.EmpresaDto;
import com.fabrisio.bluestore.dto.FuncionarioDto;
import com.fabrisio.bluestore.entity.EmpresaEntity;
import com.fabrisio.bluestore.entity.FuncionarioEntity;
import com.fabrisio.bluestore.enuns.EnumCargoFuncionario;
import com.fabrisio.bluestore.exceptions.UsuarioException;
import com.fabrisio.bluestore.service.EmpresaService;
import com.fabrisio.bluestore.service.FuncionarioService;
import com.fabrisio.bluestore.user.UsuarioDto;
import com.fabrisio.bluestore.user.UsuarioEntity;
import com.fabrisio.bluestore.user.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class RegisterServiceImpl implements RegisterService{

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    @Transactional
    public UsuarioEntity registerUserCompany(RegisterUserCompanyDto dto) {
        ///CADASTRAR EMPRESA
        EmpresaEntity entity = empresaService.cadastrar(new EmpresaDto(null, dto.getNomeEmpresa(), dto.getCnpj()));
        ///CADASTRAR FUNCIONARIO
        FuncionarioEntity entityFuncionario = funcionarioService.cadastrar(new FuncionarioDto(null,dto.getNome()
                , dto.getSobrenome(), entity.getId(), EnumCargoFuncionario.ADMINISTRADOR, LocalDateTime.now()
                , dto.getCpf(), dto.getDataNascimento(), dto.getEmail(), dto.getTelefone()));
        ///CADASTRAR USUARIO
        return usuarioService.cadastrar(new UsuarioDto(null, dto.getUsuario(), dto.getEmail()
                , dto.getSenha(), entityFuncionario.getId()));
    }

    @Override
    public UsuarioEntity registerUserEmployee(RegisterUserEmployeeDto dto) throws UsuarioException {
        ///VERIFICAR FUNCIONARIO
        FuncionarioEntity entityFuncionario = verificarFuncionario(dto.getEmail(), dto.getCpf(), dto.getNomeEmpresa());
        ///CADASTRAR USUARIO
        return usuarioService.cadastrar(new UsuarioDto(null, dto.getUsuario(), dto.getEmail()
                , dto.getSenha(), entityFuncionario.getId()));

    }

    public FuncionarioEntity verificarFuncionario(String email, String cpf, String nomeEmpresa) throws UsuarioException {
        FuncionarioEntity entity = funcionarioService.consultarPorEmail(email);
        EmpresaEntity entityEmpresa = empresaService.consultar(entity.getIdEmpresa());
        if(entity.getCpf() != cpf  || entityEmpresa.getNome() != nomeEmpresa ){
            throw new UsuarioException("Os dados do usuario não são compativeis");
        }
        return entity;
    }

}
