# Ferramenta para cadastro de funcionários.

Esta ferramenta web será utilizada pela empresa *Feijanitos estrelares* para registrar seus funcionários, qualquer funcionário poderá acessar este site, entrar com um login e senha e ver os funcionários cadastrados. 

Nem todos poderam alterar, excluir ou cadastrar novos funcionários. A distribuição de permissões vai funcionar da seguinte forma:
- Diretor: Cadastra, altera, exclui e visualiza qualquer registro. Apenas o Diretor pode ver ou editar os salários e cargos dos funcionário;
- Gerente: Cadastra, altera e apenas não vê ou altera os salários e cargos;
- Funcionário: Visualiza todos os seus dados e visualizar apenas o nome e data de aniversário os outros funcionários.

Qualquer funcionário pode alterar os seu dados, menos o campo do salário e cargo a não ser o diretor.

Os campos necessários para o registro:
- Nome completo;
- Data de nascimento;
- Endereço completo;
- CPF com validação;
- Foto;
- Cargo com histórico de atualização;
- Salário com histórico de atualização;

Os cargos e salários iniciais disponíveis na empresa serão:
- Confeiteiro - R$3.000,00;
- Robôpiscicologo - R$10.000,00;
- Extrator de Magglato de penas vulcanicas marciânas - R$5.000,00;
- Abastecedor de estrelas - R$2.000,00;
- Programador de feijões - R$50.000,00;

A alteração do salário nunca pode ser menor que o valor inicial a não ser que o funcionário estiver trocando de cargo.

O Gerente pode solicitar a exclusão de um funcionário para o diretor, esta solicitação vai ser um botão na listagem de funcionários e o diretor vai receber um email com esta solicitação. No email vai ter um link que vai direto para a tela de edição do funcionário e lá o direto pode excluir.

O funcionário pode solicitar ferias selecionando o mês, e apenas o mês na tela de visualização dos seus dados, o gerente vai ter uma tela com esta lista de pedidos e caso mais de um funcionário pedir férias para o mesmo mês do mesmo ano estes items conflitantes vão ficar destacados na lista e apenas os não conflitantes que o gerente pode dar o ok para o funcionário sair de férias. Férias em outros planetas precisam da permissão do diretor, estas o gerente vai apenas visualizar.

Telas necessárias:
- Login;
- Home com listagem de todos os funcionários;
- Tela para cadastrar novos funcionário;
- Tela para visualizar os dados do funcionário;
- Tela para editar os dados do funcionário;
- Tela para listar férias solicitadas;
