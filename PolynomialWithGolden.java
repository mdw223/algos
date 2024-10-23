public class PolynomialWithGolden {
    // the ratio to multiply each letter's code by, using 33 makes it more efficient, reduces number of collisions 
    private static final int r = 7;
    // the size of the hash table (array), used to calculating the compressed hash function that serves as what index to add at 
    private static final int m = 29;
    // p 
    private static final double p = (1 + Math.sqrt(5)) / 2; 

    public static int calculateGoldenRatioCompressedHashCode(int fk) {
        double invP = Math.pow(p, -1);
        double x = m * (fk * invP - Math.floor(fk * invP));
        double hk = Math.floor(x);
        return (int)hk;
    }


    // Method to calculate polynomial hash code of a string
    public static int calculatePolynomialHashCode(String input) {
        int hashCode = 0;

        // Iterate over each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // Add ASCII value of the character to hashCode
            int value = (int) c;
            hashCode += value * Math.pow(r, i);
        }

        return hashCode;
    }

    public static void main(String[] args) {
        // Define the strings to be hashed
        String[] strings = {"SOIL", "OILS"};

        // Calculate and display the hash code for each string
        for (String s : strings) {
            int polynomialHashCode = calculatePolynomialHashCode(s);
            System.out.println("Polynomial hash code for " + s + " is: " + polynomialHashCode);
            
            int compressedHashCode = calculateGoldenRatioCompressedHashCode(polynomialHashCode);
            System.out.println("Compressed hash code for " + s + " is: " + compressedHashCode);

            System.out.println();
        }

    }
}


