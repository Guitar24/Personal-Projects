package testing;
import java.io.*;
import java.util.*;

public class Testing_1 {

	
    public static void main(String args[]) throws InterruptedException
    {
    	int pos = 33;
        int dir = 1;

        char[] clear = new char[100];
        Arrays.fill(clear, '\b');
        String clearString = new String(clear);

        while (true) {
            String str = "";
            for (int i = 0; i < 100; i++) {
                str += (i == pos) ? 'O' : '.';
            }
            System.out.print(str);
            Thread.sleep(50);
            System.out.print(clearString);

            pos += dir;
            if (pos >= 99) dir = -1;
            if (pos <= 0) dir = 1;
        }
    }
	
}