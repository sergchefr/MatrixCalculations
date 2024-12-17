public class FracMath {
    public FracMath() {
    }

    public static RegularFrac sum(RegularFrac a, RegularFrac b) {
        return new RegularFrac(a.getNumerator() * b.getDenumerator() + b.getNumerator() * a.getDenumerator(), a.getDenumerator() * b.getDenumerator());
    }

    public static RegularFrac sum(RegularFrac a, long b) {
        return new RegularFrac(a.getNumerator() + b*a.getDenumerator(), a.getDenumerator());
    }

    public static RegularFrac prod(RegularFrac a, RegularFrac b) {
        return new RegularFrac(a.getNumerator() * b.getNumerator(), a.getDenumerator() * b.getDenumerator());
    }

    public static RegularFrac prod(RegularFrac a,long b) {
        return new RegularFrac(a.getNumerator() * b, a.getDenumerator());
    }
}