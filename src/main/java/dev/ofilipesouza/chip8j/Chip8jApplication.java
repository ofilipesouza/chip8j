package dev.ofilipesouza.chip8j;

import java.io.IOException;

public class Chip8jApplication {

    public static void main(String[] args) {
        String romName = "/Users/filipesouza/Developer/projects/chip8j/src/main/resources/roms/IBM Logo.ch8";
        Chip8 chip8 = new Chip8();
        try {
            chip8.loadProgram(romName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        chip8.initiateEmulationCycle();
    }
}
