package JianZhiOffer.Chapter3;

/**
 * 实现整数次方
 */
public class P113_Power {
    public static boolean isInvalidInput =true;
    public static double power(double base,int exponent){
        if(Math.abs(base)<0.00000001&&exponent==0){
            isInvalidInput = false;
            return -1;
        }else if(exponent==0){
            return 0;
        }else if(Math.abs(base)<0.00000001&&exponent<0){
            isInvalidInput = false;
            return -1;
        }
        if(exponent<0){
            return 1/powerWithPositiveExponent(base,-exponent);
        }else{
            return powerWithPositiveExponent(base,exponent);
        }

    }
    public static double powerWithPositiveExponent(double base,int exponent){
        double result=1.0;
        for(int i=0;i<exponent;++i){
            result*=base;
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println("2^3="+power(2,3)+"\t是否有效:"+isInvalidInput);
        System.out.println("2^-3="+power(2,-3)+"\t是否有效:"+isInvalidInput);
        System.out.println("0^3="+power(0,3)+"\t是否有效:"+isInvalidInput);
        System.out.println("0^-3="+power(0,-3)+"\t是否有效:"+isInvalidInput);
    }
}
