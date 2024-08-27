public class MagicSquareDriver {
    public static void main(String[] args) {
        String usageMessage = "Usage: java MagicSquareDriver <-check | -create> <filename> [size]";

        if (args.length < 2 || args.length > 3) {
            System.out.println(usageMessage);
            return;
        }

        String option = args[0];
        
        if (!option.equals("-check") && !option.equals("-create")) {
            System.out.println(usageMessage);
            return;            
        }
    }
}