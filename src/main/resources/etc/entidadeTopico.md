Detalhamento de tópicos

A API deve possuir um endpoint para a listagem de todos os tópicos, sendo que ele deve aceitar requisições do tipo GET para a URI /topicos/{id}

Os dados dos tópicos (título, mensagem, data de criação, status, autor e curso) devem ser devolvidos no corpo da resposta, no formato JSON.

→ Lembre de utilizar a anotação @PathVariable em seu código para receber o campo de ID da requisição GET.

Regras de negócio

Solicitar o campo ID para realizar consulta é uma ação obrigatória, pois seu usuário precisa poder visualizar os detalhes de um tópico solicitando uma consulta aos dados no banco. Neste caso, é necessário verificar se o campo ID foi inserido corretamente.