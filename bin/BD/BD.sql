
CREATE TABLE tb_alunos (
    alu_matricula SERIAL PRIMARY KEY,
    alu_cpf VARCHAR(14) NOT NULL,
    alu_nome VARCHAR(255) NOT NULL,
    alu_sobrenome VARCHAR(255) NOT NULL,
    alu_email VARCHAR(255) NOT NULL,
    alu_senha VARCHAR(255) not null,
    alu_idade INT NOT NULL,
    alu_datanascimento Date NOT NULL,
    alu_datamatricula Date NOT null,
    alu_telefone  VARCHAR(18) not null,
    pais_codigo int not null,
 	end_codigo int not null,
    FOREIGN KEY (pais_codigo) REFERENCES tb_pais (pais_codigo),
   	FOREIGN KEY (end_codigo) REFERENCES tb_enderecos (end_codigo)
);

-- Tabela de Pais
CREATE TABLE tb_pais ( 
    pais_codigo SERIAL PRIMARY KEY,
    pais_email VARCHAR(250) not null,
    pais_senha varchar(50) not null,
    mae_nome VARCHAR(250) not null,
    mae_sobrenome varchar(250) not null,
    mae_cpf VARCHAR(14) not null,
    mae_idade VARCHAR(20) not null,
    mae_telefone varchar(18) not null,
    mae_datanascimento Date not null,
    pai_nome VARCHAR(250) not null,
    pai_sobrenome varchar(250) not null,
    pai_cpf VARCHAR(14) not null,
    pai_idade VARCHAR(20) not null,
    pai_telefone varchar(18) not null,
    pai_datanascimento Date not null
);

-- Tabela de Endereço
CREATE TABLE tb_enderecos (
    end_codigo SERIAL PRIMARY KEY,
    end_rua VARCHAR(100) not null,
    end_bairro VARCHAR(100) not null,
    end_cidade VARCHAR(50) not null,
    end_casanumero int not null,
    end_cep VARCHAR(10) not null
);

CREATE TABLE tb_funcionarios (
    func_codigo SERIAL PRIMARY KEY,
	func_nome VARCHAR(100) not null,
    func_sobrenome VARCHAR(100) not null,
    func_cpf VARCHAR(100) not null,
    func_email VARCHAR(100) not null,
    func_senha VARCHAR(100) not null,
    func_idade int not null,
    func_telefone VARCHAR(100) not null,
    func_datanascimento Date not null,
    func_cargo VARCHAR(100) not null
);

create table tb_mensagem (
    mens_codigo SERIAL PRIMARY KEY,
    func_codigo int not null, 
    mens_assunto varchar(100) not null,
    mens_conteudo varchar(1000) not null,
    mens_data Date not null,
    mens_hora Time not null,
    FOREIGN KEY (func_codigo) REFERENCES tb_funcionarios (func_codigo)
);


create table tb_mensagemDestinatario(
    mens_codigo int not null,
    alu_matricula int not null,
    FOREIGN KEY (mens_codigo) REFERENCES tb_mensagem(mens_codigo)
);