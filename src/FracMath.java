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

    public static RegularFrac revert(RegularFrac a){
        return new RegularFrac(a.getDenumerator(),a.getNumerator());
    }

    public static RegularFrac FracPow(RegularFrac a, int p){
        return new RegularFrac((long)Math.pow(a.getNumerator(),p),(long)Math.pow(a.getDenumerator(),p));
    }

    public static RegularFrac devide(RegularFrac a, RegularFrac devidor){
        return prod(a,revert(devidor));
    }


}