public class VixlaPorum {
    public static void main(String[] args) {
    String t;
    for(int i=0; i<args.length-1;i+=2){
    t = args[i];
    args[i] = args[i+1];
    args[i+1] = t;
    }
    for(int i=0; i<args.length;i++){
    System.out.print(args[i]);
    }
    }
    }