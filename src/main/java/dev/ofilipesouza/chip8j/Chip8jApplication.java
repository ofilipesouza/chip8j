package dev.ofilipesouza.chip8j;

public class Chip8jApplication {

    public static void main(String[] args) {
        String romName = "/Users/filipesouza/Developer/projects/chip8j/src/main/resources/roms/IBM Logo.ch8";
        Chip8 chip8 = new Chip8();
        chip8.loadProgram(romName);
        chip8.initiateEmulationCycle();
    }
}
