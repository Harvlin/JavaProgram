package CompetitiveMaterial;

public class fbpkpk {
    static int fpb(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    static int kpk (int a, int b) {
        // KPk * FPB = a * b
        // KPk = (a * b) / FBP
        int FPB = fpb(a , b);
        int kpk = (a * b) / FPB;
        return kpk;
    }
    public static void main(String[] args) {
            // code
    }
}
