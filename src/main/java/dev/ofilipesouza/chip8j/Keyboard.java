package dev.ofilipesouza.chip8j;

public class Keyboard {
    private boolean[] key = new boolean[16];

    public Keyboard(){
        for(int i = 0; i < key.length; i++){
            key[i] = false;
        }
    }
}
