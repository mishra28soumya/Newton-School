import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    static int endr, endc;
    static char myArr[][];
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();

        endr = n-1;
        endc = m-1;

        myArr = new char[n][m];
        for(int i=0; i<n; i++) {
            String s = sc.next();
            for(int j=0; j<m; j++)
                myArr[i][j] = s.charAt(j);
        }

        solve(); // we compare and top and left element and see if it is possible to reach current position

        // print(myArr, n, m);


        /*
            Now we can block at 2 places,
            Either we can block the adjacent elements of start position (1,1)
            Or we can block the adjacent elements of the end position (n, m)
            Either of this will prevent Ketani from reaching the (n,m) cell

            Since we need to print the minimum of blocks we print the minimum of above 2 scenarios
        */
        int st = 0, en = 0;

        // count number of blocks adjacent to start position
        st += check(myArr, 0, 1);
        st += check(myArr, 1, 0);

        // count number of blocks adjacent to end position
        en += check(myArr, endr, endc-1);
        en += check(myArr, endr-1, endc);

        System.out.println(Math.min(st, en)); // print minimum number of blocks needed
    }

    public static void solve() {
        for (int i=1; i<=endr; i++) {
            for(int j=1; j<=endc; j++) {
                if (myArr[i-1][j] == '#' && myArr[i][j-1] == '#')
                    myArr[i][j] = '#';
            }
        }
    }

    public static int check (char arr[][], int r, int c) {

        if (r >= 0 && r <= endr && c >= 0 && c <= endc && arr[r][c] == '.')
            return 1;
        
        return 0;
    }

    public static void print(char arr[][], int n, int m) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++)
                System.out.print(arr[i][j]+" ");

            System.out.println();
        }
    }
}
