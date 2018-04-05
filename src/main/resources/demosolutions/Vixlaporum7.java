public class VixlaPorum {
    public static void main(String[] args){
    String[] Skipta = new String[args.length];
    int m = args.length;
    for(int i = 0; i < args.length; i++){
    Skipta[i] = args[i];
    }
    if ( m/2.0 == 0) {
    for ( int j = 0; j <m; j++ ) {
    args[j] = Skipta[(j+1)];
    args[j+1] = Skipta[j];
    j = j+1;
    }
    }
    else if ( m/2.0 > 0.0) {
    for ( int j = 0; j < (m 
    -
    1); j++ ) {
    args[j] = Skipta[(j+1)];
    args[j+1] = Skipta[j];
    j = j+1;
    }
    }
    for(int l = 0; l < m; l++){
    System.out.print(args[l] + " ");
    }
    }
    }