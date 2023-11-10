package dev.ofilipesouza.chip8j;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Random;

public class Chip8 {

    private Memory memory;
    private CPU cpu;
    private Register register;
    private Screen screen;
    private Keyboard keyboard;

    public Chip8(){
        memory = new Memory();
        register = new Register();
        keyboard = new Keyboard();
        cpu = new CPU(memory, register, keyboard);
        prepareScreen(memory);
    }

    private void prepareScreen(Memory memory){
        JFrame frame = new JFrame("Chip8j");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen = new Screen(memory);
        frame.add(screen);
        frame.pack();
        frame.setVisible(true);
    }

    public void loadProgram(String program) throws IOException {

        File file = new File(program);
        byte[] bytes = Files.readAllBytes(file.toPath());
        short currentAddress = (short)0x200;
        int loadedBytes = 0;
        for(byte b: bytes){
            memory.set(currentAddress,b);
            loadedBytes++;
            currentAddress = (short)(currentAddress +0x1);

        }
        System.out.println("[INFO] ROM \"" + program + "\" loaded in memory starting at 0x200 ("+loadedBytes+" Bytes).");

    }

    public void initiateEmulationCycle() {
        while (true){
            cpu.fetch();
            cpu.decodeAndExecute();

            if(memory.drawFlag){
                screen.paintScreen();
                memory.drawFlag = false;
            }
        }
    }
}
