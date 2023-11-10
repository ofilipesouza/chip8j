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
                memory.pixels[x][y] = 0;
            }
        }

        memory.drawFlag = true;
    }

    public void jump( int b){
        register.PROGRAM_COUNTER = (short) b;
    }

    /**
     * 6xkk - LD Vx, byte
     * @param x
     * @param vx
     */

    public void loadByteToVx(int x, int vx){
        register.V[x] = vx;
    }

    /**
     * 7xkk - ADD Vx, byte
     * @param x
     * @param vx
     */
    public void putByteOnVx(int x, int vx){
        var result = register.V[x] + vx;
        register.V[x] = (byte) result;
    }

    /**
     * Annn - LD I, addr
     * @param b
     */
    public void setIndexRegister(int b){
        register.I = b;
    }

    public void draw(int x, int y, int n ){
        //draw
        int real_x = register.V[x];
        int real_y = register.V[y];
        register.V[0xF] = 0;
        for(int yLine = 0; yLine < n; yLine++){
            int pixel = memory.get(register.I + yLine);
            for(int xLine = 0; xLine < 8; xLine++){
                if((pixel & (0x80 >> xLine)) != 0){
                    int xCoord = real_x+xLine;
                    int yCoord = real_y+yLine;

                    if(xCoord < 64 && yCoord < 32){
                        if(memory.pixels[xCoord][yCoord]==1){
                            register.V[0xF] = 1;
                        }
                        //Draw Pixel
                        memory.pixels[xCoord][yCoord] ^=1;
                    }
                }
            }
        }
        memory.drawFlag = true;
    }
}
