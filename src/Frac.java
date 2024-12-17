import static java.lang.Math.*;
public class Frac {
    private long numerator; //числитель(Numerator)
    private long denumerator; //знаменатель (DeNumerator)
    private long remains; //целая часть (Remain)

    public Frac(long remains, long numerator,long denumerator)
    {
        int h1 =1;
        if (numerator*denumerator<0){                               //флаг знака целой части
            h1=-1;
        }

        this.remains = numerator/denumerator;
        numerator= abs(numerator);                                  //вычисление остатка и дробной части, она должна быть больше 0
        denumerator =abs(denumerator);
        numerator =numerator-(denumerator*abs(this.remains));

        long h=maxDev(numerator, denumerator);
        denumerator = denumerator/h;                                //упрощение дробной части
        numerator = numerator/h;

        if (h1<0){
            this.remains=this.remains-1;                            //перевод отрицательных значений к стандартному виду
            numerator=denumerator-numerator;
        }

        this.remains = this.remains +remains;
        this.denumerator = denumerator;                             //установка значений полей
        this.numerator = numerator;
    }

    public Frac(double fl){
        this(0,(long)(fl*100000000),100000000);
    }


    private long maxDev(long a,long b){
        long c =1;

        for(int i=2; i<=a; i++){
            if (a%i==0 & b%i==0){
                c=i;                                              //НОД
            }
        }
        return c;
    }



    public long getNumerator(){
        return this.numerator;
    }
    public long getDeNumerator(){                               //геттеры
        return this.denumerator;
    }
    public long getRemains(){
        return this.remains;
    }

    public float toFloat(){
        return remains+(float)numerator/(float)denumerator;
    }

    @Override
    public String toString() {
        if (remains ==0 & numerator ==0){
            return ("0");
        }
        if (remains == 0){
            return(numerator +"/"+ denumerator);                //вывод в строку
        }
        if (numerator == 0){
            return (Long.toString(remains));
        }
        return (remains +"+"+ numerator +"/"+ denumerator);
    }

    public static Frac sum(Frac a, Frac b){
        return new Frac(a.getRemains()+b.getRemains(),a.getNumerator()*b.getDeNumerator()+a.getDeNumerator()*b.getNumerator(),a.getDeNumerator()*b.getDeNumerator());
    }

}