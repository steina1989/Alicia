public class VixlaPorum {
    public static void main(String[] args) {
    int N = args.length;
    for (int i= 0; i<(N
    -
    1); i= i+2){
    String t = args[i];
    args[i]= args[i+1];
    args[i+1]=t;
    }
    for(int i = 0; i<N; i++){
    System.out.print(args[i] + " ");
    }
    System.out.println();
    }
    }