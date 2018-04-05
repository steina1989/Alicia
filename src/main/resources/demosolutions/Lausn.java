public class VixlaPorum {
    public static void main(String[] args) {
        // Lausn frá kennara
        int N = args.length;
        
        for (int i=0; i<N-1; i+=2) {
            String temp = args[i];
            args[i] = args[i+1];
            args[i+1] = temp;
        }
        
        for (int i=0; i<N; i++)
            System.out.print(args[i] + " ");
        System.out.println();
        
    }
}