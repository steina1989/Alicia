public class Vixlaporum {
    public static void main(String[] args) {
    int N = args.length;
    int[] h = new int[N];
    for(int i=1 ;i<N;i = i + 2)
    {
    String t = args[i];
    args[i]=args[i-1];
    args[i-1]= t  ;
    }
    for(int j=0;j < N;j++)
    {
    System.out.print(args[j]);
    }
    }
    }