id
titulo
mensagem
data de criação
estado do tópico
autor
curso

Add annotations to create Topic table in database.

Cadastro de um novo tópico

A API deve possuir um endpoint para o cadastro de tópicos, sendo que ele deve aceitar requisições do tipo POST para a URI /topicos

Os dados do tópico (título, mensagem, autor e curso) devem ser enviados no corpo da requisição, no formato JSON.

→ Não se esqueça de utilizar a anotação @RequestBody para que seu projeto Spring receba os dados do corpo da requisição corretamente.

→ Além disso, lembre que o tópico deve ser salvo no banco de dados que foi construído para o projeto, então fica aí o lembrete de utilizar o método save do JpaRepository para realizar a persistência dos dados do tópico criado.

Sugestão: para auxiliar na validação dos dados, experimente utilizar a anotação Java integrada ao Spring @Valid.

Regras de negócio

Todos os campos são obrigatórios, nesse caso, é necessário realizar a verificação se todos os campos estão sendo inseridos corretamente.

A API não deve permitir o cadastro de tópicos duplicados (contendo o mesmo título e mensagem).

Sugestões complementares

Deixamos aqui sugestões presentes na documentação do Spring Data e no blog Baeldung (lembrando que o conteúdo é em inglês porém é possível realizar a tradução da página graças ao atalho do Google Tradutor em seu navegador):

Para começar com o JpaRepository:

Mais detalhes sobre o JpaRepository:

Sobre validação de dados em REST Controller:



Caso não saiba como realizar esta atividade, sugerimos que veja o seguinte conteúdo

https://cursos.alura.com.br/course/spring-boot-3-desenvolva-api-rest-java/task/115955

