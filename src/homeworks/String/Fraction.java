package homeworks.String;

public class Fraction {
    private int num;
    private int denum;

    public Fraction(int num, int denum) {
        this.num = num;
        this.denum = denum;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDenum() {
        return denum;
    }

    public void setDenum(int denum) {
        this.denum = denum;
    }

    /*
           nod 5
          -------------------------------------------------
             1                        5
            --- * X (f2.denum/nod) + ---- * Y (f1.denum/nod)
             5                        30
        */
    public static Fraction sum(Fraction f1, Fraction f2) {
        int nod = nod(f1.denum, f2.denum);
        Fraction frRez = new Fraction((f1.num * f2.denum + f2.num * f1.denum)/nod, f1.denum * f2.denum/nod);
        nod = nod(frRez.num, frRez.denum);
        return new Fraction(frRez.num/nod, frRez.denum/nod);
    }

    public static void main(String[] args) throws Exception {
        Fraction f1 = new Fraction(1, 10);
        Fraction f2 = new Fraction(1, 15);
        Fraction f3 = sum(f1, f2);
        assertEquals(f3, new Fraction(1,6));
        System.out.println(f1 + " + " + f2 + " = " + f3);

        f1 = new Fraction(1, 15);
        f2 = new Fraction(2, 5);
        f3 = sum(f1, f2);
        assertEquals(f3, new Fraction(7,15));
        System.out.println(f1 + " + " + f2 + " = " + f3);

        f1 = new Fraction(7, 8);
        f2 = new Fraction(4, 9);
        f3 = sum(f1, f2);
        assertEquals(f3, new Fraction(95,72));
        System.out.println(f1 + " + " + f2 + " = " + f3);
    }

    public static void assertEquals(Fraction f1, Fraction f2) {
        if (f1.num == f2.num && f2.denum == f2.denum) {
            System.out.println("Test correct");
        } else {
            System.out.println("Error!!!");
        }
    }

    public static int nod(int denum1,int denum2) {
        while (denum2 !=0) {
            int tmp = denum1%denum2;
            denum1 = denum2;
            denum2 = tmp;
        }
        return denum1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return num == fraction.num && denum == fraction.denum;
    }

    @Override
    public String toString() {
        int total = num > denum ? num % denum : 0;
        return  total + " " + num + "/" + denum;
    }
}
