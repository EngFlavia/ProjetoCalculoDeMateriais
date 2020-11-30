drop database projeto;
create database projeto;
use projeto;
create table usuario(id_user int auto_increment primary key, nome_user varchar(70), senha_user varchar(20), email_user varchar(70), tel_user varchar(15));

create table cliente(id_cli int auto_increment primary key, NomeCliente varchar(70), email_cli varchar(70), tel_cli varchar(15));

create table cadastroProjeto(id int auto_increment primary key, id_cliente int, foreign key(id_cliente) references cliente(id_cli), id_puser int, foreign key(id_puser) 
references usuario(id_user), NomeProjeto varchar(50), ART varchar(50), Endereço varchar(70), Cidade varchar(70));

create table cadastroAmbiente (id int auto_increment primary key, nome varchar(50), id_projeto int, foreign key(id_projeto) references cadastroProjeto(id));

create table cadastroObjeto(id int auto_increment primary key, nome varchar(50), altura float, largura float, area float,
						id_ambiente int, foreign key(id_ambiente) references cadastroAmbiente(id));
                        
create table cadastroRecorte(id int auto_increment primary key, nome varchar(50), altura float, largura float, area float,
						id_Objeto int, foreign key(id_Objeto) references cadastroObjeto(id));                       

create table categoria(id_categ int auto_increment primary key, nome_categ varchar(50));

create table materiais(id_mat int auto_increment primary key, nome_mat varchar(50), id_mcateg int, foreign key(id_mcateg) references categoria(id_categ), 
qntVenda_mat float, qntRendimento_mat float, Custo_mat float, Quebra_mat float, altura_mat float, largura_mat float);

create table objCalcMat_mat(id_ocm int auto_increment primary key, quantidade int, id_ocmMat int, foreign key(id_ocmMat) references materiais(id_mat),
id_ocmMatCalc int, foreign key(id_ocmMatCalc) references cadastroObjeto(id), qntDmao_ocm int);

INSERT INTO `usuario` (`id_user`, `nome_user`, `senha_user`, `email_user`, `tel_user`) VALUES (NULL, 'flavia', '123', 'flavia@gmail.com', '15981641578');
INSERT INTO `cliente` (`id_cli`, `NomeCliente`, `email_cli`, `tel_cli`) VALUES (NULL, 'Nader', 'cliente@mail.com', '15981641579');
INSERT INTO `cliente` (`id_cli`, `NomeCliente`, `email_cli`, `tel_cli`) VALUES (NULL, 'Murilo', 'cliente@mail.com', '15981641579');
INSERT INTO `cadastroProjeto` (`id`, `id_cliente`, `id_puser`, `NomeProjeto`, `ART`, `Endereço`, `Cidade`) VALUES (NULL, '1', '1', 'projetoInicial', '123', 'Rua Joao Correa', 'Sorocaba');
INSERT INTO `categoria` (`id_categ`, `nome_categ`) VALUES (NULL, 'Aproveitamento');
INSERT INTO `categoria` (`id_categ`, `nome_categ`) VALUES (NULL, 'Lote');
INSERT INTO `categoria` (`id_categ`, `nome_categ`) VALUES (NULL, 'Unitario');
INSERT INTO `materiais` (`id_mat`, `nome_mat`, `id_mcateg`, `qntVenda_mat`, `qntRendimento_mat`, `Custo_mat`, `Quebra_mat`,  `altura_mat`, `largura_mat`) VALUES (NULL, 'Tinta Suvinil', '1', '10.00', '3', '20.00', '2', NULL, NULL);
INSERT INTO `materiais` (`id_mat`, `nome_mat`, `id_mcateg`, `qntVenda_mat`, `qntRendimento_mat`, `Custo_mat`, `Quebra_mat`, `altura_mat`, `largura_mat`) VALUES ('2', 'Tinta Coral', '1', '10.00', '3', '20.00', '2', NULL, NULL);
INSERT INTO `cadastroAmbiente` (`id`, `nome`, `id_projeto`) VALUES (NULL, 'Quarto', '1'), (NULL, 'Sala', '1');
INSERT INTO `cadastroObjeto` (`id`, `nome`, `altura`, `largura`,`area`, `id_ambiente`) VALUES (NULL, 'Parede', '3', '3','9', '1');
INSERT INTO `cadastroRecorte` (`id`, `nome`, `altura`, `largura`, `area`, `id_Objeto`) VALUES (NULL, 'Janela', '1', '1','1', '1');
