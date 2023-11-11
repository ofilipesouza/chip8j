package dev.ofilipesouza.chip8j;

import java.util.Arrays;

public class Memory {

    private short[] stack = new short[16];
    public int[] memory = new int[4096];
    public int[][] pixels;
    boolean drawFlag;
    private final int[] FONT_SET = {
            0xF0, 0x90, 0x90, 0x90, 0xF0, // 0
            0x20, 0x60, 0x20, 0x20, 0x70, // 1
            0xF0, 0x10, 0xF0, 0x80, 0xF0, // 2
            0xF0, 0x10, 0xF0, 0x10, 0xF0, // 3
            0x90, 0x90, 0xF0, 0x10, 0x10, // 4
            0xF0, 0x80, 0xF0, 0x10, 0xF0, // 5
            0xF0, 0x80, 0xF0, 0x90, 0xF0, // 6
            0xF0, 0x10, 0x20, 0x40, 0x40, // 7
            0xF0, 0x90, 0xF0, 0x90, 0xF0, // 8
            0xF0, 0x90, 0xF0, 0x10, 0xF0, // 9
            0xF0, 0x90, 0xF0, 0x90, 0x90, // A
            0xE0, 0x90, 0xE0, 0x90, 0xE0, // B
            0xF0, 0x80, 0x80, 0x80, 0xF0, // C
            0xE0, 0x90, 0x90, 0x90, 0xE0, // D
            0xF0, 0x80, 0xF0, 0x80, 0xF0, // E
            0xF0, 0x80, 0xF0, 0x80, 0x80  // F
    };

    public Memory() {
        this.pixels = new int[64][32];
        loadFontSetOnMemory ();
    }

    private void loadFontSetOnMemory() {
        for(short i = 0; i < 80; i++){
            set(i, FONT_SET[i]);
        }
    }

    public void set(int address, int b){
        if(address > 4096){
            System.out.println("out of bounds");
        }else{
            memory[address] = (b & 0xFF);
        }
    }
    public int get(int address){
        if(address > 4096){
            System.out.println("out of bounds");
            return 0x0;
        }else{
            return memory[address];
        }
    }
    public void setPixel(int x, int y) {
        pixels[x][y] ^= 1;
    }

    public int getPixel(int x, int y) {
        return pixels[x][y];
    }


    @Override
    public String toString() {
        return "Memory{" +
                "memory=" + Arrays.toString(memory) +
                '}';
    }

}
