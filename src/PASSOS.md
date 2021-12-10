Mapear entidade Produto com os seguintes atributos:
Exercício de Query Methods: Criar métodos no repositório para: - Buscar todos os produtos - Buscar produtos pelo nome - Buscar produtos no intervalo de valor (mínimo, máximo) XXX - Buscar o primeiro produto ativo com valor superior a 100 reais

Exercício de JPQL: Criar método no repositório para: - Listar produtos ativos filtrando por nome

Exercício de SQL:

- Listar todos os produtos ativos ordenando por preço
- contar a quantidade de produtos inativos

Agendamentos:

* Criar nova entidade Agendamento com os seguintes atributos (id, dataHoraInicio, dataHoraFim, observações)
* Criar Repositório com as seguintes consultas (uma utilizando QueryMethod, outra jpql e outra sql):
* Buscar agendamentos do dia.
* Buscar agendamentos dos próximos 7 dias. LocalDate.now().minusDays(7);
* Buscar agendamento por ID.

Estratégias com datas:
- deixar as datas no Java, e passar duas datas (between) pro SQL;
- direto no SQL, usando funções como o CURRENT_DATE()
  SELECT * FROM TABELA WHERE NASCIMENTO BETWEEN CURRENT_DATE()-7 AND CURRENT_DATE();

TODO: corrigir a partir daqui!

Excercício: Repositório de Agendamentos:

- Criar nova entidade Agendamento com os seguintes atributos (id, dataHoraInicio, dataHoraFim, observações)
- Criar Repositório com as seguintes consultas (uma utilizando QueryMethod, outra jpql e outra sql):
    - Buscar agendamentos do dia.
    - Buscar agendamentos dos próximos 7 dias.
    - Buscar agendamento por ID.
    - Para as buscas de data, escolha sua estratégia:
        - deixar as datas no Java, e passa duas datas (between) pro SQL.
        - direto no SQL usando funções do SQL como o CURRENT_DATE()
        - select * from tabela where nascimento between CURRENT_DATE()-7 and CURRENT_DATE()

Exercício: ProdutoService.listar:
- Criar Service ProdutoService.
- Criar método listar produtos.
- Criar DTO ProdutoListagem com ID, NOME, VALOR.
- Usando stream com .map, converter a entidade no DTO.
- Criar factory para fazer a criação do DTO.
- Criar método de teste da lista de produtos.

Exercício: ProdutoService.buscarPorId:
- Criar no Service de Produto o buscar por id
- Utilizar o ProdutoDetalhes como DTO com todos os campos.
- Criar teste positivo (produto encontrado)
- Criar teste negativo (produto não encontrado e exceção disparada)
- Mudar exceção para o tipo ItemNaoEncontradoException (pacote exception).

Exercício: AgendamentoService.buscarPorId e AgendamentoService.listar:
- Alterar a entidade Agendamento para conter os atributos (id, dataHoraInicio, dataHoraFim, observações, ativo)
- Utilizar atributos no dto de listagem: id, dataInicio e dataFim.
- Utilizar atributos no dto de detalhes: id, dataInicio, dataFim, observação e ativo.
- Criar métodos no service e testes conforme praticado no Produto e Cliente

Exercício: Implementar rotas REST de listagem, criação e deleção para o produto.



// status code: https://httpstatuses.com/


EXERCÍCIOS PARA 13/12:
- Validações com beans annotation https://www.journaldev.com/21577/spring-bean-annotation#:~:text=Spring%20%40Bean%20Annotation%20is%20applied,class%20by%20calling%20them%20directly.
- ver no git do gilberto