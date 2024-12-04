import java.awt.Graphics;
import java.awt.Color;

public class Obstaculos {
    public int x;
    public int y;
    public int larguraObstaculo;
    public int alturaObstaculo;
    public String tipo;

    public Obstaculos(int x, int y, int largura, int altura, String tipo) {
        this.x = x;
        this.y = y;
        this.larguraObstaculo = largura;
        this.alturaObstaculo = altura;
        this.tipo = tipo;
    }

    public void desenhar(Graphics grafico) {
        grafico.setColor(new Color(255, 0, 0));

        if ("quadrado".equals(tipo)) {
            grafico.fillRect(x, y, larguraObstaculo, larguraObstaculo);
        } else if ("retangulo".equals(tipo)) {
            grafico.fillRect(x, y, larguraObstaculo, alturaObstaculo);
        }
    }

    public boolean colideComObstaculo(int marsX, int marsY, int marsLargura, int marsAltura) {
        return marsX < x + larguraObstaculo &&
                marsX + marsLargura > x &&
                marsY < y + alturaObstaculo &&
                marsY + marsAltura > y;
    }
}
