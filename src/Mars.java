import java.awt.Graphics;
import java.awt.Color;

public class Mars {
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public int x;
    public int y;
    public int larguraMars;
    public int alturaMars;
    private int velocidade;
    private boolean parado;

    public Mars(int x, int y) {
        this.x = x;
        this.y = y;
        this.larguraMars = 40;
        this.alturaMars = 40;
        this.velocidade = 2;
        this.parado = false;
    }

    public void desenhar(Graphics grafico) {
        grafico.setColor(new Color(255, 255, 255));

        grafico.fillRect(x, y, larguraMars, alturaMars);

        desenharRodas(grafico);
    }

    private void desenharRodas(Graphics grafico) {
        grafico.setColor(new Color(0, 0, 0));

        int raioRoda = 6;

        grafico.fillOval(x - raioRoda, y - raioRoda, 2 * raioRoda, 2 * raioRoda);

        grafico.fillOval(x + larguraMars - raioRoda, y - raioRoda, 2 * raioRoda, 2 * raioRoda);

        grafico.fillOval(x - raioRoda, y + alturaMars - raioRoda, 2 * raioRoda, 2 * raioRoda);

        grafico.fillOval(x + larguraMars - raioRoda, y + alturaMars - raioRoda, 2 * raioRoda, 2 * raioRoda);
    }

    public void atualizar(Obstaculos[] obstaculos) {
        if (parado) {
            return;
        }

        int novoX = x;
        int novoY = y;

        if (up) {
            novoY -= velocidade;
        } else if (down) {
            novoY += velocidade;
        }

        if (left) {
            novoX -= velocidade;
        } else if (right) {
            novoX += velocidade;
        }

        for (Obstaculos obstaculo : obstaculos) {
            if (colideComObstaculo(novoX, novoY, obstaculo)) {
                System.out.println("Obstáculo identificado! Rover parou.");
                parado = true;
                return;
            }
        }

        x = novoX;
        y = novoY;

        if (y + alturaMars > Tela.altura_tela) {
            y = Tela.altura_tela - alturaMars;
        } else if (y < 0) {
            y = 0;
        }
        if (x + larguraMars > Tela.largura_tela) {
            x = Tela.largura_tela - larguraMars;
        } else if (x < 0) {
            x = 0;
        }
    }

    private boolean colideComObstaculo(int novoX, int novoY, Obstaculos obstaculo) {
        return novoX < obstaculo.x + obstaculo.larguraObstaculo &&
                novoX + larguraMars > obstaculo.x &&
                novoY < obstaculo.y + obstaculo.alturaObstaculo &&
                novoY + alturaMars > obstaculo.y;
    }
}
