public class VixlaPorum {
    public static void main(String[]args) {
    int N= args.length;  
    String [] fylki= new String[N];
    for(int i=0; i<N; i++)
    {
    fylki[i]= args[i];
    }
    for (int i = 0; i < N/2; i++)
    {
    String temp= fylki[2*i];
    fylki[2*i]=fylki[2*i+1];
    fylki[2*i+1]=temp;
    }
    for (int i = 0; i < N; i++)
    {
    System.out.print(fylki[i]);
    }   }
    }