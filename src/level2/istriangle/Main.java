package level2.istriangle;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for(int i=0;i<n;i++){
            String[] str = scanner.nextLine().split(" ");
            long x1 = Long.parseLong(str[0]);
            long y1 = Long.parseLong(str[1]);
            long x2 = Long.parseLong(str[2]);
            long y2 = Long.parseLong(str[3]);
            long x3 = Long.parseLong(str[4]);
            long y3 = Long.parseLong(str[5]);

            if((x1==x2)&&(y1==y2) || (x2==x3)&&(y2==y3) || (x3==x1)&&(y3==y1)){
                System.out.println("No");
            }
            else{
                double grad1 = (double)(y1-y2)/(x1-x2);
                double grad2 = (double)(y2-y3)/(x2-x3);
                double grad3 = (double)(y3-y1)/(x3-x1);
                if(grad1==grad2 || grad2==grad3 || grad3 == grad1) System.out.println("No");
                else System.out.println("Yes");
            }
        }
    }
}