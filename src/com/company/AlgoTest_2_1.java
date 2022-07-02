package com.company;


public class AlgoTest_2_1 {

    /**
     * 2차원 배열 회전 알고리즘
     *
     * @param column
     * @param column
     * @param arrStr
     * @return
     */
    public void solution(int row, int column, String arrStr, String order, String outputIndex) {
        int[][] resultArr = new int[row][column];
        int[] arr = splitStr(arrStr);
        int[] result = new int[arr.length];
        int index = 0;
        int turnYn = 0;         // Y축 증감 방향 선택. (0:왼쪽 아래 대각선(x축 증가) , 1:오른쪽 위 대각선(y축 증가), 2: 왼쪽 아래 대각선(예외경우 처리))

        int x = 0;
        int y = 0;

        resultArr = inputArr(row, column, arr, resultArr);



    }

    public int[][] inputArr(int x ,int y, int[] inputArr, int[][] intArr){
        int index = 0;
        for(int i = 0 ; i < x ;i++){
            for(int j = 0 ; j < y ; j++){
                intArr[i][j] = inputArr[index];
                index++;
            }
        }

        return  intArr;
    }


    public static int[] splitStr(String str) {
        String[] strArr = str.split(",");
        int[] intArr = new int[strArr.length];

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

}
