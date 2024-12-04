import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tela extends Canvas implements Runnable, KeyListener {
    public static int largura_tela = 450;
    public static int altura_tela = 400;
    public static Mars mars;
    public static Obstaculos[] obstaculos = new Obstaculos[10];

    public Tela() {
        this.setPreferredSize(new Dimension(largura_tela, altura_tela));
        this.addKeyListener(this);
    }

    public static void main(String[] args) throws Exception {
        Tela tela = new Tela();
        mars = new Mars(100, 100);

        obstaculos[0] = new Obstaculos(150, 100, 20, 20, "quadrado");
        obstaculos[1] = new Obstaculos(200, 150, 20, 20, "quadrado");
        obstaculos[2] = new Obstaculos(250, 200, 20, 20, "quadrado");
        obstaculos[3] = new Obstaculos(300, 250, 20, 20, "quadrado");
        obstaculos[4] = new Obstaculos(350, 300, 20, 20, "quadrado");
        obstaculos[5] = new Obstaculos(100, 300, 20, 20, "quadrado");
        obstaculos[6] = new Obstaculos(50, 200, 20, 20, "quadrado");
        obstaculos[7] = new Obstaculos(400, 150, 20, 20, "quadrado");
        obstaculos[8] = new Obstaculos(300, 50, 20, 20, "quadrado");
        obstaculos[9] = new Obstaculos(200, 50, 20, 20, "quadrado");

        JFrame jframe = new JFrame();
        jframe.setVisible(true);
        jframe.add(tela);
        tela.requestFocus();
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Thread(tela).start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                desenhar();
                atualizar();
                Thread.sleep(1000 / 30);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void desenhar() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics grafico = bs.getDrawGraphics();
        grafico.setColor(new Color(0, 0, 0));
        grafico.fillRect(0, 0, largura_tela, altura_tela);

        mars.desenhar(grafico);
        for (Obstaculos obstaculo : obstaculos) {
            obstaculo.desenhar(grafico);
        }

        bs.show();
    }

    private void atualizar() {
        mars.atualizar(obstaculos);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            mars.up = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            mars.down = true;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            mars.left = true;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            mars.right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            mars.up = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            mars.down = false;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            mars.left = false;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            mars.right = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
