public class Vixlaporum {
    public static void main(String[] args) {
        int N = args.length;
        String[] a = new String[N];
        for (int i = 0; i < N; i++)
            a[i] = args[i];
        for (int i = 0; i < N - 1; i++) {
            if (i % 2 == 0) {
                String t = a[i];
                a[i] = a[i + 1];
                a[i + 1] = t;
            }
        }
        for (int i = 0; i < N; i++)
            System.out.print(a[i] + " ");
    }
}