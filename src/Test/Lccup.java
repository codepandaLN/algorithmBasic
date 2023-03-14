package Test;

public class Lccup {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;

        int[] dpA = new int[n];
        int[] dpB = new int[n];
        for(int i = 0;i < n - 1 ;++i){
            if(temperatureA[i+1] - temperatureA[i] > 0){
                dpA[i] = 1;
            }else if(temperatureA[i+1] - temperatureA[i] < 0){
                dpA[i] = -1;
            }else if(temperatureA[i+1] - temperatureA[i] == 0){
                dpA[i] = 0;
            }
        }



        for(int j = 0;j < n -1 ;++j){
            if(temperatureB[j+1] - temperatureB[j] > 0){
                dpB[j] = 1;
            }else if(temperatureB[j+1] - temperatureB[j] < 0){
                dpB[j] = -1;
            }else if(temperatureB[j+1] - temperatureB[j] == 0){
                dpB[j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dpA[i]);
        }
        System.out.print('\n');
        for (int i = 0; i < n; i++) {
            System.out.print(dpB[i]);
        }
        System.out.print('\n');
        int res = 0,sum = 0;
        for(int i = 0;i < n-1;++i){
            if(dpA[i] == dpB[i]){
                sum ++;
                res = Math.max(res,sum);
            }else{
                sum = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] temperatureA = {-14,7,-19,9,13,40,19,15,-18};
        int[] temperatureB = {3,16,28,32,25,12,13,-6,4};

        Lccup s = new Lccup();
        System.out.println(s.temperatureTrend(temperatureA,temperatureB));


    }



}
