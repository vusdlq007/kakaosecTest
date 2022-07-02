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
        int[][] resultArr = new int[row][column];         // 회전 한 2차원 배열
        int[] arr = splitStrToInt(arrStr);                // 2차원 배열에 들어갈 값
        char[] orderArr = splitStr(order);       // 이동 명령 배열
        String[] resultIndex = outputIndex.split(",");       // 이동 명령 배열

        int result = 0;                                   // 최종 출력 결과값.

        int x = Integer.parseInt(resultIndex[0]) -1;
        int y = Integer.parseInt(resultIndex[1]) -1;

        resultArr = inputArr(row, column, arr, resultArr);

//        printArr(resultArr);
        for(int i = 0 ; i < orderArr.length ; i++){
            switch (Character.toString(orderArr[i]).toUpperCase()){
                case "R" : resultArr = rightTurn(row,column,resultArr); break;          // 오른쪽 90도 회전
                case "L" : resultArr = leftTurn(row,column,resultArr); break;          // 왼쪽 90도 회전
                case "T" : resultArr = reverse(row,column,resultArr);  break;          // 뒤집기 (180도 회전)
            }
        }

        printArr(resultArr);
        // 문제 설명 보기 기준으로 출력함. (문제에서의 가로세로 의미가 행,열이 거꾸로 표현됨.)
        System.out.println(resultArr[y][x]);

        // 출력해야할 Index위치를 기준으로 출력함. (입력받은 위치를 Index기준으로 출력.)
//        System.out.println(resultArr[x][y]);

    }

    /**
     * 직,정사각형일때 고려 오른쪽으로 90도 회전.
     * @param
     * @return
     */
    public int[][] rightTurn(int n,int m,int [][] intputArr){
        int[][] resultArr = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                resultArr[i][j] = intputArr[n-j-1][i];
            }
        }

        return resultArr;
    }

    /**
     * 직,정사각형일때 고려 왼쪽으로 90도 회전.
     * @param
     * @return
     */
    public int[][] leftTurn(int n,int m,int [][] intputArr){
        int[][] resultArr = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                resultArr[i][j] = intputArr[j][m -1 -i];
            }
        }

        return resultArr;
    }

    /**
     * 직,정사각형일때 고려 좌우 반전 뒤집기.
     * @param
     * @return
     */
    public int[][] reverse(int n,int m,int [][] intputArr){
        int[][] resultArr = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                resultArr[i][j] = intputArr[i][(m -1) - j];
            }
        }
        return resultArr;
    }


    /**
     * 2차원 배열 출력.
     * @param arr
     */
    public void printArr(int [][] arr){
        for(int i = 0 ; i < arr.length ; i++){
            for (int j = 0 ; j < arr[i].length ; j++){
                System.out.print(arr[i][j]+"");
            }
            System.out.println();
        }
        System.out.println();
    }


    /**
     * 입력받은 배열 값 2차원 배열에 삽입.
     * @param x
     * @param y
     * @param inputArr
     * @param intArr
     * @return
     */
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

    /**
     * String으로 받은 배열값 Int형으로 바꿔서 배열에 저장.
     * @param str
     * @return
     */
    public static int[] splitStrToInt(String str) {
        String[] strArr = str.split(",");
        int[] intArr = new int[strArr.length];

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    /**
     * String으로 받은 배열값 Char형으로 바꿔서 배열에 저장.
     * @param str
     * @return
     */
    public static char[] splitStr(String str) {
        char[] orderArr = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            orderArr[i] = str.charAt(i);
        }
        return orderArr;
    }
    

}
