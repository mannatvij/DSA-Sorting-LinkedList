class kStacks
{
    int arr[];
    int top[];
    int next[];
    int cap, k;
    int freeTop;

    kStacks(int k1, int n){
        k = k1; cap = n;
        arr = new int[cap];
        top = new int[k];
        next = new int[cap];

        for (int i = 0; i < k; i++)
            top[i] = -1;

        freeTop = 0;
        for (int i=0; i<cap-1; i++)
            next[i] = i+1;
        next[cap-1] = -1;
    }

    boolean isFull()   {  return (freeTop == -1);  }

    boolean isEmpty(int sn)  {  return (top[sn] == -1); }

    void push(int x, int sn)
    {
        if (isFull())
        {
            System.out.print("\nStack Overflow\n");
            return;
        }

        int i = freeTop;
        freeTop = next[i];
        next[i] = top[sn];
        top[sn] = i;
        arr[i] = x;
    }

    int pop(int sn)
    {
        if (isEmpty(sn))
        {
            System.out.print("\nStack Underflow\n");
            return Integer.MAX_VALUE;
        }

        int i = top[sn];
        top[sn] = next[i];
        next[i] = freeTop;
        freeTop = i;
        return arr[i];
    }

}

public class InsertKstacks{

    public static void main (String[] args) {

        int k = 3, n = 10;
        kStacks ks=new kStacks(k, n);

        ks.push(15, 2);
        ks.push(45, 2);

        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);

        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);

        System.out.println("Popped element from stack 2 is " + ks.pop(2) );
        System.out.println("Popped element from stack 1 is " + ks.pop(1) );
        System.out.println("Popped element from stack 0 is " + ks.pop(0) );

    }

}

