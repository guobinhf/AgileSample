import org.junit.Test;

import static org.junit.Assert.*;

/*
检查产生器是否能产生0,2,3，以及100以内的素数
0:没有素数
2: 一个素数2
3:2个素数2,3
100:25个素数，并且最后一个是97
* */

public class PrimeGeneratorTest {
    @Test
    public void generatePrimes() throws Exception {
        int[] nullArray = PrimeGenerator.generatePrimes(0);
        assertEquals(nullArray.length, 0);

        int[] minArray = PrimeGenerator.generatePrimes(2);
        assertEquals(minArray.length , 1);
        assertEquals(minArray[0], 2);

        int[] threeArray = PrimeGenerator.generatePrimes(3);
        assertEquals(threeArray.length, 2);
        assertEquals(threeArray[0], 2);
        assertEquals(threeArray[1], 3);

        int[] centArray = PrimeGenerator.generatePrimes(100);
        assertEquals(centArray.length, 25);
        assertEquals(centArray[24], 97);
    }
    @Test
    public void testExhaustive(){
        for(int i =2; i < 500; i ++){
            verifyPrimeList(PrimeGenerator.generatePrimes(i));
        }
    }

    private void verifyPrimeList(int[] list){
        for(int i =0;i < list.length; ++i){
            verifyPrime(list[i]);
        }
    }
    private void verifyPrime(int n){
        for (int factor = 2 ; factor< n ; factor++){
            assert(n % factor != 0);
        }
    }

}