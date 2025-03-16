package excise3;

public class TwoDimensionArr {
    public static void main(String[] args) {
        int[][] arr={{22,66,44},{77,33,88}
                ,{25,45,65},{11,66,99}};

        int yearRev=0;
        for (int i = 0; i < arr.length; i++) {
            int seasonRev=0;
            for (int j = 0; j < arr[i].length; j++) {
                seasonRev+=arr[i][j];
                yearRev+=arr[i][j];
            }
            System.out.println("第"+(i+1)+"季度营业额:"+seasonRev);
        }
        System.out.println("全年的总营业额:"+yearRev);
    }
}
