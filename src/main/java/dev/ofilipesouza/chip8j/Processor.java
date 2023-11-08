package dev.ofilipesouza.chip8j;

public class Processor {

    private Memory memory;
    private Register register;
    private final Keyboard keyboard;

    public Processor(Memory memory, Register register, Keyboard keyboard) {
        this.memory = memory;
        this.register = register;
        this.keyboard = keyboard;
    }

    public void CLS(){

        for(int y = 0; y<32; y++){
            for(int x=0; x<64;x++){
                memory.pixels[x][y] = false;
            }
        }

        memory.drawFlag = true;
    }

    public void jump(byte b){
        register.PROGRAM_COUNTER = b;
    }

    /**
     * 6xkk - LD Vx, byte
     * @param x
     * @param vx
     */

    public void loadByteToVx(byte x, byte vx){
        register.V[x] = vx;
    }

    /**
     * 7xkk - ADD Vx, byte
     * @param x
     * @param vx
     */
    public void putByteOnVx(byte x, byte vx){
        var result = register.V[x] + vx;
        register.V[x] = (byte) (result > 256 ? result - 256 : result);
    }

    /**
     * Annn - LD I, addr
     * @param b
     */
    public void setIndexRegister(byte b){
        register.I = b;
    }
}
