public class Main {
    //计算1-100偶数和
    public static void main(String[] args) {
//       int sum = 0;
//       for(int i = 0;  i <= 100; i+=2 ){
//           sum = sum + i;
//       }
//        System.out.println(sum);
         int sum = 0 ;
         for(int i = 0;i <=100;i++){
             if(i%2==0){
                 sum = sum + i;
             }
         }
        System.out.println(sum);
    }
}