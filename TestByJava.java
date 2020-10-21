public class TestByJava {

        /*
             int fac(int x)=
             if x==0 then 1 else x * fac(x+(-1))
         */
        public static int fac(int x){
            if (x==0)
                return 1;
            else
                return x*fac(x-1);
        }

        /*
             int exp(int base, int exponent)=
             if exponent==0 then 1 else base * exp(base,exponent+(-1))
        */
        public static int exp(int base, int exponent){
            if (exponent==0)
                return 1;
            else
                return base*exp(base,exponent-1);
        }

        /*
             if n==0 then 1 else expsum(n+(-1))+exp(2,n)
             exp(5,3) + fac(5)
        */
        public static int expsum(int n){
            if (n==0)
                return 1;
            else
                return expsum(n-1+exp(2,n));
        }



        public static void main(String[] args) {
            // write your code here

            System.out.println("the result is: "+ (exp(5,3) + fac(5)));
        }
    }


