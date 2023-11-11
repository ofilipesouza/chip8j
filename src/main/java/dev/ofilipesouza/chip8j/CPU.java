package dev.ofilipesouza.chip8j;

public class CPU {

    private Register register;
    private Memory memory;
    private Processor processor;

    private int currentInstruction;
    public CPU(Memory memory, Register register, Keyboard keyboard) {
        this.memory = memory;
        this.register = register;
        this.processor = new Processor(memory, register, keyboard);
    }

    public void fetch(){
         currentInstruction = memory.memory[register.PROGRAM_COUNTER] << 8 | memory.memory[register.PROGRAM_COUNTER + 1];
//        currentInstruction = (short) ((memory.get(register.PROGRAM_COUNTER)  << 8) | (memory.get(register.PROGRAM_COUNTER + 1)));
        System.out.printf("Opcode: 0x%04X\n", currentInstruction);
        register.PROGRAM_COUNTER += 2;
    }

    public void decodeAndExecute(){

        int X = currentInstruction & 0x0F00 >> 8;
        int Y = currentInstruction & 0x00F0 >> 4;
        int N = currentInstruction & 0x000F;
        int NN = currentInstruction & 0x00FF;
        int NNN = currentInstruction & 0x000F;

        if((currentInstruction & 0xF000) == 0xD000){
            System.out.println("draw");
        }

        switch (currentInstruction & 0xF000){
            case 0x0000:
                switch (currentInstruction & 0x000F) {
                    case 0x0000:
                        processor.CLS();
                        break;
                    case 0x000E:
                        break;
                    default:
                        break;
                }
                break;
            case 0x1000:
                processor.jump(NNN);
                break;
            case 0x6000:
                processor.loadByteToVx(X, NN);
                break;
            case 0x7000:
                processor.putByteOnVx( X, NN);
                break;
            case 0xA000:
                processor.setIndexRegister(NNN);
                break;
            case 0xD000:
                processor.draw( X, Y, N);
                break;
            default:
                break;
        }

    }
}
