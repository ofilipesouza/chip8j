package dev.ofilipesouza.chip8j;

public class CPU {

    private Register register;
    private Memory memory;
    private Processor processor;

    private short currentInstruction;
    public CPU(Memory memory, Register register, Keyboard keyboard) {
        this.memory = memory;
        this.register = register;
        this.processor = new Processor(memory, register, keyboard);
    }

    public void fetch(){
        currentInstruction = (short) (register.PROGRAM_COUNTER  << 8 | register.PROGRAM_COUNTER + 1);
    }

    public void decodeAndExecute(){

        int x = currentInstruction & 0x0F00;
        int y = currentInstruction & 0x00F0;
        int n = currentInstruction & 0x000F;
        int nnn = currentInstruction & 0x0FFF;

    }
}
