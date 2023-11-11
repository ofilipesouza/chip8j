package dev.ofilipesouza.chip8j;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPUTest {


    private Memory memory;
    private Register register;
    private Keyboard keyboard;
    private Processor processor;

    @BeforeEach
    void init(){
        memory = new Memory();
        register = new Register();
        keyboard = new Keyboard();
        processor = new Processor(memory, register, keyboard);

    }
    @Test
    void fetch() {
    }
}
