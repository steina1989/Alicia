public class VixlaPorum
{
public static void main(String[] args)
{
int N = args.length;
String[] a = new String[N];
for (int i = 0; i < N; i++)
{
if (N%2 == 0)
{
if (i%2 == 0)
a[i] = args[i+1];
else if (i%2 != 0)
a[i] = args[i
-
1];
}
else if (N%2 != 0)
{
if (i == N 
-
1)
a[i] = args[i];
else if (i%2 == 0)
a[i] = args[i+1];
else if (i%2 != 0)
a[i] = args[i
-
1];
}
System.out.print(a[i] + " ");
}
System.out.println();
}
}