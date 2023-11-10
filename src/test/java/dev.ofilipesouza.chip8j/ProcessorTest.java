package dev.ofilipesouza.chip8j;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ProcessorTest {
    private Memory memory;
    private Register register;
    private Keyboard keyboard;
    private Processor processor;

    @BeforeEach
    public void init(){
        memory = new Memory();
        register = new Register();
        keyboard = new Keyboard();
        processor = new Processor(memory, register, keyboard);
    }


    @Test
    public void CLS(){
        turnOnAllPixels();
        processor.CLS();
        Assertions.assertTrue(allPixelsAreOff());
    }

    @Test
    public void Jump(){
        byte b = 0x0021;
        processor.jump((byte) 0x0021);
        Assertions.assertEquals(register.PROGRAM_COUNTER, (byte) 0x0021, b);
    }

    @Test
    void loadByteToVx() {
    }

    @Test
    void putByteOnVx() {
    }

    @Test
    void setIndexRegister() {
    }

    private boolean allPixelsAreOff(){
        for(int[] row : memory.pixels){
            for(int element : row){
                if(element==1){
                    return false;
                }
            }
        }
        return true;
    }

    private void turnOnAllPixels(){
        for(int x = 0; x < memory.pixels.length; x++){
            Arrays.fill(memory.pixels[x], 1);
        }
    }
}
