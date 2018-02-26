**API ALIMENTOS**

Essa API REST foi desenvolvida utilizando Spring Boot, Eclipse Oxygen, Java 8, Maven, MockMVC, JUnit.

Foi escolhido o Spring como arquitetura da API, pois sua configuração é fácil e rápida e não precisamos nos preocupar com colocar algumas bibliotecas bases para o desenvolvimento, por exemplo JPA e assim focando mais nas regras de negócio.

Siga os passos abaixo para a inicialização da API.

- Clonar Repositório:

git clone https://github.com/gralves/api-alimentos.git

- Após a clonar, importar no Eclipse o projeto, abrir a classe com.alimentos.api.AlimentosApiApplication.java e rode como Java Application

A Api estará disponível em:
http://localhost:8080/

<b>Lista de Requisições REST:</b><br>

* Lista todos os lanches com seus devidos preços calculados<br>
/lanche/list-lanches

* Lista todos os ingredientens<br>
/lanche/list-ingredientes

* Adiciona Novo Pedido retornando valor total aplicando ou não as promoções disponíveis<br>
/pedido/save



