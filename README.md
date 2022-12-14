# Pet Shop - Gato Feliz

Trabalho em grupo da matéria de Orientação a Objeto.

Gestão do projeto: shorturl.at/rHSUY

## Arquitetura:

<p align="center">
  <img src="./Architeture.png" width="250" title="Arquitetura">
</p>



### Repository:
As classes Repository são as responsáveis por trazer os dados à aplicação, seja de arquivos, banco de dados ou API's, e persisti-los, em caso de mudança.

### Models:
Os Models serão responsáveis por receber os dados recuperados pelos repositories e formar objetos, implementando seus métodos e propriedades específicas.

### Business:
As classes desse pacote serão responsáveis por implementar as regras de negócio e contratos e fazer as manipulações necessárias. Elas também serão as responsáveis por receber os dados dos repositories e formar os models.

### Controller: 
Os controllers serão responsáveis por fazer a interface entre as classes view e as classes business.

### View:
Esse pacote é responsável por exibir informações de forma gráfica e interagir com o usuário.

