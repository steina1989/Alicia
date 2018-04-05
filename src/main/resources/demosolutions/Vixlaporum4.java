
public class VixlaPorum {
    public static void main(String[] args) {
    String odd;
    String even;
    for (int i = 0; i < args.length; i++) {
    if (i % 2 == 0) {
    odd = args[i];
    if (i < args.length - 1) {
    even = args[i+1];
    args[i+1] = odd;
    args[i] = even;
    }
    }
    System.out.print(args[i]);
    }
    System.out.println();
    }
    }