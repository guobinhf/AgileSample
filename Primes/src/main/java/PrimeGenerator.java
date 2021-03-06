public class PrimeGenerator {
    private static boolean[] isCrossed;
    private static int[] result;

    public static int[] generatePrimes(int maxValue) {
        if (maxValue < 2) {
            return new int[0];
        }else {
            initializeArrayOfIntegers(maxValue);
            crossOutMultiples();
            putUncrossedIntegerIntoResult();
            return result;
        }
    }

    private static void putUncrossedIntegerIntoResult() {
         result = new int[numberOfUncrossedIntegers()];
        for (int i = 2, j = 0; i < isCrossed.length; ++i) {
            if (notCrossed(i)) {
                result[j++] = i;
            }
        }
    }

    private static int numberOfUncrossedIntegers() {
        int count = 0;
        for (int i = 2; i < isCrossed.length; i++) {
            if (notCrossed(i)) {
                count++;
            }
        }
        return count;
    }

    private static void crossOutMultiples() {
        int maxPrimeFactor = determineIterationLimit();
        for(int i =2; i< maxPrimeFactor; i ++){
            if (notCrossed(i)){
                crossOutMultiples(i);
            }
        }
    }

    private static void crossOutMultiples(int i) {
        for(int multiple = 2 * i; multiple< isCrossed.length; multiple +=i){
            isCrossed[multiple] = true;
        }
    }

    private static boolean notCrossed(int i) {
        return isCrossed[i] == false;
    }

    private static int determineIterationLimit() {
        double iterationLimit = Math.sqrt(isCrossed.length);
        return (int)iterationLimit;
    }

    private static void initializeArrayOfIntegers(int maxValue) {
        isCrossed = new boolean[maxValue +1];
        for(int i =2; i < isCrossed.length; ++i){
            isCrossed[i] = false;
        }
    }
}
