public class ProcessSignal {
    public static void main (String[] args) {
        if (args.length < 3) {
            System.out.println("\n\nIncorrect input\nUsage: Signal knownSignal1 knownSignal2");
            System.out.println("For example: ProcessSignal 100010101 101 00");
            System.exit(1);
        }

        Signal signal = new Signal(args[0], args[1], args[2]);
        System.out.println(signal.isInterleaving());

        System.out.println(2%5);
    }
}
