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
  
