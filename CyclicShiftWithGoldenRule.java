public class CyclicShiftWithGoldenRule {
    // the size of the hash table (array), used to calculating the compressed hash function that serves as what index to add at 
    private static final int m = 128;
    // left shift number
    private static final int shift = 5;
    // p 
    private static final double p = (1 + Math.sqrt(5)) / 2; 

    public static int calculateCyclicShiftHashCode(String input) {
        // hash code
        int h = 0;

        // Iterate over each character in the input string
        for (int i = 0; i < input.length(); i++) {
            //  shift by 5 left (remove the first 5 bits and put at the back)
            h = h << shift; 

            h += h + input.charAt(i);
        }

        return h;
    }

    public static int calculateGoldenRatioCompressedHashCode(int fk) {
        double invP = Math.pow(p, -1);
        double x = m * (fk * invP - Math.floor(fk * invP));
        double hk = Math.floor(x);
        return (int)hk;
    }

    public static void main(String[] args) {
        // Define the strings to be hashed
        String[] strings = {"CAT", "BOG", "HOA", "CAP", "CMD"};

        // Calculate and display the hash code for each string
        for (String s : strings) {
            // convert string to 32 bit number
            int num = s.hashCode();
            String str = String.valueOf(num);
            System.out.println("The 32 bit number for " + s + " is: " + str);

            int cyclicShiftHashCode = calculateCyclicShiftHashCode(str);
            System.out.println("Cyclic-Shift hash code for " + s + " is: " + cyclicShiftHashCode);
            
            int compressedHashCode = calculateGoldenRatioCompressedHashCode(cyclicShiftHashCode);
            System.out.println("Compressed hash code for " + s + " is: " + compressedHashCode);

            System.out.println();
        }

    }
}




