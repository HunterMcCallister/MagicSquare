public class MagicSquareDriver {
    public static void main(String[] args) {
        String usageMessage = "Usage: java MagicSquareDriver <-check | -create> <filename> [size]";

        if (args.length < 2 || args.length > 3) {
            System.out.println(usageMessage);
            return;
        }

        String arg = args[0];
        String file = args[1];
        int length = args.length;
        
        
        if (!arg.equals("-check") && !arg.equals("-create")) {
            System.out.println(usageMessage);
            return;            
        }
    }
}