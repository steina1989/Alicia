
public class VixlaPorum { // dæmi 1
public static void main(String[] args) {
char N = args[0].charAt(0);
System.out.print(N);
char[] fylki = fylki.toCharArray(N);
for(int i = 0; i < N.length; i++) {
if(fylki[i] == 0 && fylki[i 
-
1] != 0) {
int temp = fylki
[i 
-
1];
fylki[i 
-
1] = fylki[i];
fylki[i] = temp;
}
System.out.print(fylki[i]);
}
}
}