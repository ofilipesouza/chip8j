package dev.ofilipesouza.chip8j;

import java.util.Arrays;

public class Register {
    public int[] V;
    public int I;
    public short PROGRAM_COUNTER;
    public short STACK;
    public byte delayTimer;
    public byte soundTimer;

    public Register() {
        V = new int[16];
        I = 0;
        PROGRAM_COUNTER = 0x200;
        STACK = 0x00;
        delayTimer = 0x00;
        soundTimer = 0x00;
    }


    @Override
    public String toString() {
        return "Register{" +
                "V=" + Arrays.toString(V) +
                ", I=" + I +
                ", PROGRAM_COUNTER=" + PROGRAM_COUNTER +
                ", STACK=" + STACK +
                ", delayTimer=" + delayTimer +
                ", soundTimer=" + soundTimer +
                '}';
    }
}
