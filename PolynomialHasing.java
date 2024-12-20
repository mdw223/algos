public class PolynomialHasing {
    // the ratio to multiply each letter's code by, using 33 makes it more efficient, reduces number of collisions 
    private static final int r = 7;
    // the size of the hash table (array), used to calculating the compressed hash function that serves as what index to add at 
    private static final int m = 23;


    // alpha for multiply and divide compression, a > 0
    private static final int a = 5;
    // beta for multiply and divide compression, b >= 0. a mod b != 0
    private static final int b = 31;




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

    // also called division compression 
    public static int calculateCompressedPolynomialHashCode(int polynomialHashCode) {
        return polynomialHashCode % m;
    }

    public static int multiplyAndDivideCompression(int fk) {
        return (a * fk + b) % m;
    }

    public static void main(String[] args) {
        // Define the strings to be hashed
        String[] strings = {"STOP", "POTS"};

        // Calculate and display the hash code for each string
        for (String s : strings) {
            int polynomialHashCode = calculatePolynomialHashCode(s);
            System.out.println("Polynomial hash code for " + s + " is: " + polynomialHashCode);
            
            int compressedHashCode = calculateCompressedPolynomialHashCode(polynomialHashCode);
            System.out.println("Compressed hash code for " + s + " is: " + compressedHashCode);

            int mdchc = multiplyAndDivideCompression(polynomialHashCode);
            System.out.println("Multiply & Divide Compressed hash code for " + s + " is: " + mdchc);

            System.out.println();
        }

    }
}


