public class Signal {
    private char[] signal;
    private char[] knownSignal1;
    private char[] knownSignal2;

    public Signal(String signal, String knownSignal1, String knownSignal2) {
        this.signal = signal.toCharArray();
        this.knownSignal1 = knownSignal1.toCharArray();
        this.knownSignal2 = knownSignal2.toCharArray();
    }

    public boolean isInterleaving() {
        boolean result;
//        int a = signal.length / knownSignal1.length;
//        int aMod = signal.length % knownSignal1.length;
//        int b = signal.length / knownSignal2.length;
//        int bMod = signal.length % knownSignal2.length;
        boolean temp[][] = new boolean[knownSignal1.length + 1][knownSignal2.length + 1];

        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < temp[i].length; j++){
                int l = (i + j - 1) % (knownSignal1.length + knownSignal2.length);
                if(i == 0 && j == 0){
                    temp[i][j] = true;
                }
                else if(i == 0){
                    if(signal[l] == knownSignal2[j-1]){
                        temp[i][j] = temp[i][j-1];
                    }
                }
                else if(j == 0){
                    if(signal[l] == knownSignal1[i-1]){
                        temp[i][j] = temp[i-1][j];
                    }
                }
                else{
                    temp[i][j] = (knownSignal1[i-1] == signal[l] ? temp[i-1][j] : false) || (knownSignal2[j-1] == signal[l] ? temp[i][j-1] : false);
                }
            }
        }
        result = temp[knownSignal1.length][knownSignal2.length];

        print2Dtable(temp);



        return result;
    }

    public void print2Dtable(boolean[][] t) {
        for(int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }
}
