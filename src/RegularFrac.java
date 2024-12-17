
public class RegularFrac {
        private long numerator = 1L;
        private long denumerator = 1L;

        public RegularFrac(long numerator, long denumerator) {
            if (denumerator == 0L) {
                throw new ArithmeticException("/ by zero");
            } else {
                if (numerator * denumerator < 0L) {
                    this.numerator = -1L;
                }

                long md = this.maxDev(Math.abs(numerator), Math.abs(denumerator));
                this.numerator *= Math.abs(numerator / md);
                this.denumerator *= Math.abs(denumerator / md);
            }
        }

        public RegularFrac(long c){
            this(c,1);
        }

        private long maxDev(long a, long b) {
            long c = 1L;

            for(long i = 2; (long)i <= Math.min(a, b); ++i) {
                if (a % (long)i == 0L & b % (long)i == 0L) {
                    c = (long)i;
                }
            }

            return c;
        }

        public String toString() {
            if (this.numerator == 0L) {
                return "0";
            } else {
                return this.denumerator == 1L ? "" + this.numerator : this.numerator + "/" + this.denumerator;
            }
        }

        public long getNumerator() {
            return this.numerator;
        }

        public long getDenumerator() {
            return this.denumerator;
        }
    }

