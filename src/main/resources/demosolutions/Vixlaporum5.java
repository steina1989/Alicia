public class VixlaPorum
{
public static void main(String[] args)
{
char[] stafir = new char[args.length];
for ( int i = 0; i < args.length; i++)
{
stafir[i] = args[i].charAt(0);
}
for (int i = 0; i <= args.length/2; i+=2)
{ 
char t = stafir[i];
stafir[i] = stafir[i+1]; 
stafir[i+1] = t;
}
for ( int i = 0; i < args.length; i++)
{
System.out.print(stafir[i] + " " );    
}
}
}