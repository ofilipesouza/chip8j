package dev.ofilipesouza.chip8j;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    private final Memory memory;
    public int[][] graphics = new int[64][32];
    private Graphics g;
    private final int SCALE = 12;
    private final int WIDTH = 64 * SCALE;
    private final int HEIGHT = 32 * SCALE;
    public Screen(Memory memory) {
        this.memory = memory;
    }


    @Override
    public Dimension getPreferredSize(){
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g){
       super.paintComponent(g);
       this.g = g;

        paintFullScreen();
    }

    private void paintFullScreen() {
        for(int x = 0; x < this.memory.pixels.length; x++){
            for(int y = 0; y < this.memory.pixels[y].length; y++){
                paintPixel(x,y);
            }
        }
        paintScreen();
    }

    public void paintPixel(int x, int y){
        if(memory.pixels[x][y] ==  1){
            g.setColor(Color.WHITE);
        }else{
            g.setColor(Color.BLACK);
        }
        g.fillRect(x * 12 , y * 12, 12, 12);

    }

    public void setPixel(int x, int y) {
        graphics[x][y] ^= 1;
    }

    public int getPixel(int x, int y) {
        return graphics[x][y];
    }

    public void paintScreen(){
        this.repaint();
    }
}
