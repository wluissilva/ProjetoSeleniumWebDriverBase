# language: pt

  @login
  Funcionalidade: Login
    Eu como usuário do sistema
    Quero fazer login
    Para fazer uma compra no site

    Contexto: Dado que estou na tela de Login
      Dado que estou na tela de login

    @login-sucesso
    Cenário: Login com sucesso

      Quando preencho login "eduardo.finotti@qazando.com" e senha "123456"
      E clico em Login
      Então vejo mensagem de login com sucesso

    @email-inválido
    Esquema do Cenário: Validar <name> no login

      Quando preencho login "<user>" e senha "<password>"
      E clico em Login
      Então vejo mensagem "<message>" de campo não preenchido

      Exemplos:
      |   user         | password   |  message         | name             |
      |emailinválido   | 123456     | E-mail inválido. | E-mail inválido. |
      |                | 123456     | E-mail inválido. | E-mail Vazio.    |
      |teste@gmail.com | 12         | Senha inválida.  | Senha inválida.  |
      |teste@gmail.com |            | Senha inválida.  | Senha Vazia      |