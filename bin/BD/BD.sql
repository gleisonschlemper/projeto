
CREATE TABLE tb_matriculados ( 
    mat_codigo SERIAL PRIMARY KEY,
    mat_cpf VARCHAR(11) NOT NULL,
    mat_nome VARCHAR(255) NOT NULL,
    mat_sobrenome VARCHAR(255) NOT NULL,
    mat_email VARCHAR(255) NOT NULL,
    mat_senha VARCHAR(255) NOT NULL,
    mat_idade INT NOT NULL,
    mat_datanascimento DATE NOT NULL,
    mat_datamatricula DATE NOT NULL,
    mat_telefone VARCHAR(18) NOT NULL,
    pais_codigo INT NOT NULL,
    end_codigo INT NOT NULL,
    FOREIGN KEY (pais_codigo) REFERENCES tb_pais (pais_codigo),
    FOREIGN KEY (end_codigo) REFERENCES tb_enderecos (end_codigo)
);

CREATE TABLE tb_pais ( 
    pais_codigo SERIAL PRIMARY KEY,
    pais_email VARCHAR(250) NOT NULL,
    pais_senha VARCHAR(50) NOT NULL,
    mae_nome VARCHAR(250) NOT NULL,
    mae_sobrenome VARCHAR(250) NOT NULL,
    mae_cpf VARCHAR(11) NOT NULL,
    mae_idade INT NOT NULL,
    mae_telefone VARCHAR(18) NOT NULL,
    mae_cargo VARCHAR(100) NOT NULL,
    mae_datanascimento DATE NOT NULL,
    pai_nome VARCHAR(250) NOT NULL,
    pai_sobrenome VARCHAR(250) NOT NULL,
    pai_cpf VARCHAR(11) NOT NULL,
    pai_idade INT NOT NULL,
    pai_telefone VARCHAR(18) NOT NULL,
  	pai_cargo VARCHAR(100) NOT NULL,
    pai_datanascimento DATE NOT NULL
);

CREATE TABLE tb_enderecos (
    end_codigo SERIAL PRIMARY KEY,
    end_rua VARCHAR(100) NOT NULL,
    end_bairro VARCHAR(100) NOT NULL,
    end_cidade VARCHAR(50) NOT NULL,
    end_casanumero INT NOT NULL,
    end_cep VARCHAR(10) NOT NULL
);

CREATE TABLE tb_funcionarios (
    func_codigo SERIAL PRIMARY KEY,
    func_nome VARCHAR(100) NOT NULL,
    func_sobrenome VARCHAR(100) NOT NULL,
    func_cpf VARCHAR(11) NOT NULL,
    func_email VARCHAR(100) NOT NULL,
    func_senha VARCHAR(255) NOT NULL,
    func_idade INT NOT NULL,
    func_telefone VARCHAR(18) NOT NULL,
    func_datanascimento DATE NOT NULL,
    func_cargo VARCHAR(100) NOT NULL
);

CREATE TABLE tb_mensagem (
    mens_codigo SERIAL PRIMARY KEY,
    func_codigo INT NOT NULL, 
    mens_assunto VARCHAR(100) NOT NULL,
    mens_conteudo VARCHAR(1000) NOT NULL,
    mens_data DATE NOT NULL,
    mens_hora TIME NOT NULL,
    FOREIGN KEY (func_codigo) REFERENCES tb_funcionarios (func_codigo)
);

CREATE TABLE tb_mensagemDestinatario(
    mens_codigo INT NOT NULL,
    mat_codigo INT NOT NULL,
    FOREIGN KEY (mat_codigo) REFERENCES tb_matriculados (mat_codigo)
);

CREATE TABLE tb_escola (
    esc_codigo SERIAL PRIMARY KEY,
    esc_nome VARCHAR(255) NOT NULL,
    esc_rua VARCHAR(255) NOT NULL,
    esc_bairro VARCHAR(255) NOT NULL,
    esc_cidade VARCHAR(255) not null,
    esc_telefone VARCHAR(18) NOT NULL,
    esc_email VARCHAR(255) NOT NULL,
);

INSERT INTO tb_escola (
	esc_nome, 
	esc_rua, 
	esc_bairro, 
	esc_cidade, 
	esc_telefone, 
	esc_email)
VALUES ('EEB Paulo Cordeiro', 'Rua XV de Novembro, 1441', 'Laranjeiras', 'Rio do Sul', '(47) 3526-3143', 'eebpc@sed.sc.gov.br');

insert into tb_funcionarios (
	func_nome,
	func_sobrenome,
	func_cpf,
	func_email,
	func_senha,
	func_idade,
	func_telefone,
	func_datanascimento,
	func_cargo
) values('Gleison', 'Schlemper','11682546985','gleisonschlemper532@gmail.com','12345',20,'47-989073723','2003-08-11','Administrador');
