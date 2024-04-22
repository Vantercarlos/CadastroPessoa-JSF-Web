# CadastroPessoa-JSF-Web

Esse projeto consiste na criação de:

	• Desenvolvido em Java utilizando as tecnologias Java EE (JPA, EJB, JSF) e PostgreSQL como banco de dados.
    • Um CRUD de cadastro pessoa
    • Salvar, Editar, Atualizar, Listar e Deletar na base de dados do PostgreSQL.
	
## Decisões Técnicas e Arquiteturais
O projeto segue uma arquitetura em camadas, com uma separação clara entre a camada de apresentação (JSF), 
a camada de negócios (EJB) e a camada de persistência (JPA). Isso permite uma melhor organização do código, 
facilita a manutenção e promove a reutilização de componentes.

Decidi usar o Wildfly como servidor de aplicativos devido à sua ampla adoção na comunidade Java EE 
e suas excelentes capacidades de gerenciamento de recursos e escalabilidade.

## Justificativa para o Uso de Frameworks ou Bibliotecas
	• JSF (JavaServer Faces): Escolhido pela facilidade de criação de interfaces de usuário baseadas em componentes e sua integração com tecnologias Java EE.
	• EJB (Enterprise JavaBeans): Utilizado para implementar a lógica de negócios devido à sua capacidade de gerenciamento de transações, segurança e escalabilidade.
	• JPA (Java Persistence API): Escolhido para a camada de persistência devido à sua integração com o modelo de objetos Java e sua capacidade de mapeamento objeto-relacional.
	• PostgreSQL: Banco de dados relacional escolhido por ser uma opção robusta, de código aberto e amplamente utilizada na comunidade.
	
## Instruções para Compilar e Executar o Projeto
	1. Clone o repositório para o seu ambiente de desenvolvimento:
		git clone https://github.com/seu_usuario/seu_repositorio.git
	2. Importe o projeto em sua IDE Java favorita (por exemplo, Eclipse, IntelliJ IDEA).
	3. Certifique-se de ter o servidor de aplicativos Wildfly instalado e configurado corretamente em seu ambiente.
	4. Configure o banco de dados PostgreSQL e o DataSource conforme descrito no arquivo persistence.xml.
	5. Compile o projeto e implante-o no servidor Wildfly.
	6. Acesse o aplicativo em um navegador da web usando o URL apropriado.
	
## Instruções para Executar os Testes da Solução
	• Certifique-se de que o ambiente de teste esteja configurado corretamente, incluindo as dependências do projeto e o ambiente de execução dos testes.
	• Execute os testes unitários usando sua IDE ou ferramenta de linha de comando preferida.
	• Verifique os resultados dos testes para garantir que todas as funcionalidades estejam implementadas corretamente e que não haja regressões.

## Regras de Negócio

A aplicação web terá uma tela, para cada funcionalidades:

    1. Uma área de cadastro
    2. Uma lista das pessoas cadastradas
    3. Uma área para a consulta
	4. Uma área para a deletar

### Cadastro de pessoa

Processo 1 - Cadastro/Alteração de Pessoa

    1. No formulario de pessoa, o usuario preenche os dados
    3. O usuario confirma o cadastro no botão “Salvar”
    4. O sistema registra o cliente no banco de dados
    5. O sistema valida os dados da pessoa (todos campos devem ser obrigatórios)
    6. O sistema salva no banco
    7. O sistema retorna a resposta para a aplicação Web com a situação de erro ou sucesso
	
### Consulta de pessoas

Processo 2 - Consulta de Pessoa

    1. O usuario, na aplicação WEB, vai informar o nome da pessoa
    2. A aplicação WEB vai consultar no banco de dados, pelo nome, os dados da pessoa
	
### Remoção de pessoas

Processo 3 - Remoção de Pessoa

    1. O usuario remove a pessoa na lista de pessoas
    2. A Aplicação WEB envia uma requisição de DELETE para O Banco de dados indicando a remoção
    3. O sistema retorna se foi removido
    4. Se foi removido do sistema, a aplicação WEB deve remover da base de dados
    5. O usuario é informado da remoção

### Listagem de pessoas

Processo 4 - Lista todas as Pessoas
	
	1. A tabela deve listar todas as pessoas cadastradas no banco de dados da aplicação Web
	2. A coluna cidade deve informar também o estado, no formato Cidade/Estado
	3. Botões de Ação
	- R1.1 - Editar, vai carregar os dados da pessoa no formulário


## Banco de Dados
As tabelas do banco de dados são criadas automaticamente.  
As seguintes entidades devem existir:  

	1. public.endereco

	2. public.pessoa


# Instruções para Execução do Projeto

## Versão JDK
Utilizar a versão 1.8.

## Download da IDE
Baixar e descompactar o Eclipse:

- [Windows][eclipse-windows]
- [Linux][eclipse-linux]
- [Mac][eclipse-mac]

Iniciar o Eclipse escolhendo uma workspace de sua preferência.

*Fique a vontade para usar outras IDE, com o IntelliJ ou VSCode.*

## Configuração do banco de dados

OBS: Se atentar que não pode haver nenhum servidor postgres rodando na máquina, se tiver, necessário fechar todos os serviços, assim como
qualquer outro serviço que esteja utilizando a porta 5432 (ou trocar a porta no PostgreSQL).  
Realize a conexão com o banco:
- host: localhost
- port: 5432
- database: cadastro-pessoa
- user: postgres
- password: postgres

[eclipse-windows]: https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2020-03/R/eclipse-jee-2020-03-R-incubation-win32-x86_64.zip
[eclipse-linux]: https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2020-03/R/eclipse-jee-2020-03-R-incubation-linux-gtk-x86_64.tar.gz
[eclipse-mac]: https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2020-03/R/eclipse-jee-2020-03-R-incubation-macosx-cocoa-x86_64.dmg


