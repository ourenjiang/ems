package org.example.ems.learn;

/*
 * 位操作运算符
 *
 * */
public class BitOperatorTest {
    public static void main(String[] args) {
        int num = -3;

        {
            String baseStr = String.format("%32s", Integer.toBinaryString(num));
            String strWith0 = baseStr.replace(' ', '0');
            System.out.println("output0: " + strWith0);
        }

        {
            int baseNum = num >> 1;
            String baseStr = String.format("%32s", Integer.toBinaryString(baseNum));
            String strWith0 = baseStr.replace(' ', '0');
            System.out.println("output1: " + strWith0);
        }

        {
            int baseNum = num >>> 1;
            String baseStr = String.format("%32s", Integer.toBinaryString(baseNum));
            String strWith0 = baseStr.replace(' ', '0');
            System.out.println("output2: " + strWith0);
        }

        {
            int baseNum = num << 1;
            String baseStr = String.format("%32s", Integer.toBinaryString(baseNum));
            String strWith0 = baseStr.replace(' ', '0');
            System.out.println("output3: " + strWith0);
        }
    }
}
