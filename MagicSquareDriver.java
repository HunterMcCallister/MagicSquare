
public class MagicSquareDriver {

    public static void main(String[] args) {
        String usageMessage = "Usage: java MagicSquareDriver <-check | -create> <filename> [size]";

        if (args.length < 2 || args.length > 3) {
            System.out.println(usageMessage);
            return;
        }

        String option = args[0];
        String filename = args[1];

        if (!option.equals("-check") && !option.equals("-create")) {
            System.out.println(usageMessage);
            return;
        }

        try {
            if (option.equals("-check")) {
                MagicSquare magicSquare = new MagicSquare(filename);
                String result = magicSquare.isMagicSquare() ? "is a magic square." : "is not a magic square.";
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
