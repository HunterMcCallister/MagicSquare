/**
 * MagicSquareDriver provides the command line interface to check if a file contains a magic square or creates one 
 * of the specified size
 * 
 * it handles the input and performs the actions using "-check" to verify and "-create" to generate.
 * @author Hunter McCallister
 */
public class MagicSquareDriver {

    /**
     * This is the main method. It processes the command line args to check the matrix and to create magic
     * squares to write in a file
     * @param args Command line args are (-check or -create) the filename and the size of the square.
     */
    public static void main(String[] args) {
        String usageMessage = "Usage: java MagicSquareDriver <-check | -create> <filename> [size]";

        //Check if args are with in bounds
        if (args.length < 2 || args.length > 3) {
            System.out.println(usageMessage);
            return;
        }

        //Assign the arguments as variables
        String option = args[0];
        String filename = args[1];

        // see if it is -check or -create
        if (!option.equals("-check") && !option.equals("-create")) {
            System.out.println(usageMessage);
            return;
        }

        try {
            if (option.equals("-check")) {
                MagicSquare magicSquare = new MagicSquare(filename);
                String result;
                if (magicSquare.isMagicSquare()) {
                    result = "is a magic square.";
                } else {
                    result = "is not a magic square.";
                }
                System.out.println("The matrix in " + filename + " " + result);
            } else if (option.equals("-create")) {
                if (args.length != 3) {
                    System.out.println(usageMessage);
                    return; 
                }

                int size = Integer.parseInt(args[2]);
                MagicSquare magicSquare = new MagicSquare(filename, size);
                System.out.println("Created a " + size + "x" + size + " magic square in " + filename);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
