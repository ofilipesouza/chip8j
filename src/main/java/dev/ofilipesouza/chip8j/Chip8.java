package dev.ofilipesouza.chip8j;

import javax.swing.*;
import java.io.*;

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

    public void loadProgram(String program) {
        try {
            File file = new File(program);
            DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            byte[] b = new byte[(int) file.length()];
            in.read(b);

            loadProgramOnMemory(b);

        } catch (IOException e) {
            e.printStackTrace();
        }
 }

    private void loadProgramOnMemory(byte[] b){
        for(int i = 0; i<b.length; i++) {
            memory.set((short) (i + register.PROGRAM_COUNTER), b[i]);
        }
    }
    public void initiateEmulationCycle() {

    }
}
