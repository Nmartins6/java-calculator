# Calculadora

Descrição do Desafio: Desenvolva uma calculadora que realize operações básicas. (posteriormente iremos refatorar para aprimorar a calculadora)

## Funcionalidades Obrigatórias:

- Interface gráfica utilizando Swing ou JavaFX.
- Operações de adição, subtração, multiplicação e divisão.
- Validação de entrada para evitar erros (como divisão por zero, não aceitar nulos...).
- Botões para cada operação e um display para mostrar os resultados.


-------------------------------------------------------
### Proposta de resolução:
Projeto iniciado a fim aprender um pouco sobre interfaces gráficas do JAVA.

# Estrutura do Projeto
Para organizar melhor nosso código, utilizarei o padrão MVC (Model-View-Controller):

- Model: Representa a lógica da aplicação (as operações da calculadora).

- View: A interface gráfica (GUI) construída com Swing.

- Controller: Gerencia a interação entre a View e o Model.