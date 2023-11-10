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
        register.PROGRAM_COUNTER += 2;
    }

    public void decodeAndExecute(){

        switch (currentInstruction & 0xF000){
            case 0x0000:
                switch (currentInstruction & 0x000F){
                    case 0x0000:
                        processor.CLS();
                        break;
                    case 0x000E:
                    default:
                }
                break;
            case 0x1000:
                processor.jump( currentInstruction & 0x0FFF );
                break;
            case 0x6000:
                processor.loadByteToVx((currentInstruction & 0x0F00) >>> 8, currentInstruction & 0x00FF);
                break;
            case 0x7000:
                processor.putByteOnVx( (currentInstruction & 0x0F00) >>> 8, currentInstruction  & 0x00FF);
                break;
            case 0xA000:
                processor.setIndexRegister((currentInstruction & 0x0FFF));
                break;
            case 0xD000:
                processor.draw( (currentInstruction & 0x0F00) >> 8 ,  (currentInstruction & 0x00F0) >> 4,  currentInstruction & 0x000F);
                break;
        }

    }
}
