# MarsRover-Java - Simulação de Rover em Marte

Este é um projeto implementado em Java, simulando o funcionamento de um rover em Marte. O projeto permite que o rover se mova, gire e envie comandos para explorar um ambiente de Marte, respeitando limites e coordenadas fornecidas pelo usuário.

# Funcionalidades

- Movimentação: O rover pode se mover para frente e para trás em um grid bidimensional.
- Giro: O rover pode girar à esquerda ou à direita, alterando sua direção de acordo com os comandos.
- Comandos: O usuário pode fornecer comandos para controlar o rover. Os comandos incluem movimentos (avançar, retroceder) e giros (esquerda, direita).
- Limitações de Movimento: O rover não pode ultrapassar os limites do ambiente. Caso tente se mover além dos limites, o comando será ignorado.
- Visualização de Posição: O usuário pode visualizar a posição atual do rover, incluindo suas coordenadas e direção

# Requisitos

- JDK 11 ou superior
- Ambiente de desenvolvimento de sua escolha (IDE como IntelliJ, Eclipse, NetBeans ou terminal)

# Como Rodar o Projeto

1.  Clonar o Repositório
Clone este repositório para sua máquina local:

```bash
git clone https://github.com/seu-usuario/mars-rover.git
```
2. Compilar e Rodar

- Importe o projeto na sua IDE favorita (IntelliJ, Eclipse, NetBeans).
- Abra a pasta src e abra os arquivos Mars.java, Tela.java e Obstaculos.java.
- Navegue até o diretório do projeto e compile o arquivo Tela.java.

3. Estrutura do Código
- Mars.java: Contém a lógica de controle do rover, incluindo o movimento, rotação e verificação de limites.
- Tela.java: Classe principal que gerencia a interação com o usuário, recebendo comandos e controlando o rover.
- Obstaculos.java: Possui a lógica por trás dos obstáculos que exsitem em marte.

  
