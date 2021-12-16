create table cliente(
                        id UUID DEFAULT gen_random_uuid (),
                        nome varchar not null,
                        cpf varchar not null,
                        data_Ultima_Compra timestamp,
                        data_de_criacao timestamp,
                        data_da_ultima_atualizacao timestamp,
                        PRIMARY KEY (id)
);

create table empresa(
                        id UUID DEFAULT gen_random_uuid (),
                        nome varchar not null,
                        cnpj varchar not null,
                        data_de_criacao timestamp,
                        data_da_ultima_atualizacao timestamp,
                        PRIMARY KEY (id)
);


create table funcionario(
                            id UUID DEFAULT gen_random_uuid (),
                            nome varchar not null,
                            sobrenome varchar not null,
                            cargo varchar not null,
                            id_Empresa UUID not null,
                            data_Admissao timestamp not null,
                            cpf varchar not null,
                            data_Nascimento timestamp not null,
                            email varchar not null,
                            telefone varchar not null,
                            flag_Ativo boolean not null,
                            data_de_criacao timestamp,
                            data_da_ultima_atualizacao timestamp,
                            PRIMARY KEY (id),
                            FOREIGN key (id_Empresa) REFERENCES empresa(id)
);


create table fabricante(
                           id UUID DEFAULT gen_random_uuid (),
                           nome varchar not null,
                           cnpj varchar not null,
                           data_de_criacao timestamp,
                           data_da_ultima_atualizacao timestamp,
                           PRIMARY KEY (id)
);

create  table produto(
                         id UUID DEFAULT gen_random_uuid (),
                         nome varchar not null,
                         valor bigint not null,
                         categoria varchar not null,
                         id_Fabricante UUID not null,
                         data_de_criacao timestamp,
                         data_da_ultima_atualizacao timestamp,
                         PRIMARY KEY (id),
                         FOREIGN key (id_Fabricante) REFERENCES fabricante(id)
);

create table itemVenda(
                          id UUID DEFAULT gen_random_uuid (),
                          id_Produto UUID not null,
                          venda_id UUID not null,
                          qtd bigint not null,
                          valor_Total bigint not null,
                          desconto integer not null,
                          data_de_criacao timestamp,
                          data_da_ultima_atualizacao timestamp,
                          PRIMARY KEY (id),
                          FOREIGN key (id_Produto) REFERENCES produto(id)
);

create table itemEstoque(
                            id UUID DEFAULT gen_random_uuid (),
                            id_Produto UUID not null,
                            qtd_Estoque integer not null,
                            data_de_criacao timestamp,
                            data_da_ultima_atualizacao timestamp,
                            PRIMARY KEY (id),
                            FOREIGN key (id_Produto) REFERENCES produto(id)
);

create table movimentacaoEstoque(
                                    id UUID DEFAULT gen_random_uuid (),
                                    id_Item_Estoque UUID not null,
                                    qtd integer not null,
                                    tipo varchar not null,
                                    data timestamp not null,
                                    data_de_criacao timestamp,
                                    data_da_ultima_atualizacao timestamp,
                                    PRIMARY KEY (id),
                                    FOREIGN key (id_Item_Estoque) REFERENCES itemEstoque(id)
);

create table caixa(
                      id UUID DEFAULT gen_random_uuid (),
                      id_Empresa UUID not NULL,
                      id_Funcionario UUID not null,
                      valor_Movimentado bigint not null,
                      quantidade_Vendas integer not null,
                      abertura_Caixa Timestamp not null,
                      fechamento_Caixa timestamp,
                      data_de_criacao timestamp,
                      data_da_ultima_atualizacao timestamp,
                        PRIMARY KEY (id),
                      FOREIGN key (id_Empresa) REFERENCES empresa(id),
                      FOREIGN key (id_Funcionario) REFERENCES funcionario(id)
);

create table venda(
                      id UUID DEFAULT gen_random_uuid (),
                      id_Caixa UUID not null,
                      id_funcionario UUID not null,
                      id_Cliente UUID not null,
                      valor_total bigint not null,
                      forma_de_pagamento varchar not null,
                      flag_ativa boolean,
                      data_de_criacao timestamp,
                      data_da_ultima_atualizacao timestamp,
                      PRIMARY KEY (id),
                      FOREIGN key (id_Caixa) REFERENCES caixa(id),
                      FOREIGN key (id_funcionario) REFERENCES funcionario(id),
                      FOREIGN key (id_Cliente) REFERENCES cliente(id)
);

create table usuario(
                        id UUID DEFAULT gen_random_uuid (),
                        usuario varchar not null,
                        email varchar not null,
                        senha varchar not null,
                        id_funcionario UUID not null,
                        data_de_criacao timestamp,
                        data_da_ultima_atualizacao timestamp,
                        PRIMARY KEY (id),
                        FOREIGN key (id_funcionario) REFERENCES funcionario(id)
);


create table vendadiaria(
                        id UUID DEFAULT gen_random_uuid (),
                        data_de_criacao timestamp,
                        data_da_ultima_atualizacao timestamp,
                        PRIMARY KEY (id)
);

create table vendapormes(
                            id UUID DEFAULT gen_random_uuid (),
                            data_de_criacao timestamp,
                            data_da_ultima_atualizacao timestamp,
                            PRIMARY KEY (id)
);

create table vendaporhora(
                            id UUID DEFAULT gen_random_uuid (),
                            data_de_criacao timestamp,
                            data_da_ultima_atualizacao timestamp,
                            PRIMARY KEY (id)
);

create table vendaporsemana(
                             id UUID DEFAULT gen_random_uuid (),
                             data_de_criacao timestamp,
                             data_da_ultima_atualizacao timestamp,
                             PRIMARY KEY (id)
);