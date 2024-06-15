Atualização de tópico
A API deve possuir um endpoint para a atualização dos dados de um determinado tópico, sendo que ele deve aceitar requisições do tipo PUT para a URI /topicos/{id}.

Obs: as mesmas regras de negócio do cadastro de um tópico devem ser realizadas também na atualização dele.
    
    -Todos os campos são obrigatórios, nesse caso, é necessário realizar a verificação se todos os campos estão sendo inseridos corretamente.
    -A API não deve permitir o cadastro de tópicos duplicados (contendo o mesmo título e mensagem).
    Como estamos realizando uma consulta no banco para então atualizar um tópico, é necessário solicitar e verificar o campo ID de sua requisição.

No código do projeto, sugerimos como no card de Detalhamento de Tópicos o uso da anotação @PathVariable para obter o ID da requisição PUT.

→ Lembre-se de verificar se o tópico existe no banco de dados para realizar sua atualização. Neste caso, sugerimos a utilização do método isPresent() da classe Java chamada Optional.

Caso não saiba como realizar esta atividade, sugerimos que veja o seguinte conteúdo

https://cursos.alura.com.br/course/spring-boot-3-desenvolva-api-rest-java/task/115968