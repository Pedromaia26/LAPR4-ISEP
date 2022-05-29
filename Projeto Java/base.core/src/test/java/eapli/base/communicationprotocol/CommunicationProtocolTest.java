package eapli.base.communicationprotocol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommunicationProtocolTest {

    @Test
    void dataLengthCalculator() {


        byte[] array=CommunicationProtocol.dataLengthCalculator("abcdefghijklmnopqrstuvwxyz");

        byte[] arrayC= new byte[]{26,0};

        assertEquals(array[0],arrayC[0]);
        assertEquals(array[1],arrayC[1]);
    }

    @Test
    void dataLengthCalculatorG256() {


        byte[] array=CommunicationProtocol.dataLengthCalculator("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");

        byte[] arrayC= new byte[]{4,1};

        assertEquals(array[0],arrayC[0]);
        assertEquals(array[1],arrayC[1]);
    }
}