package com.company;


public class AlgoTest_1_1 {

    /**
     * 2차원 배열 (완전)탐색 알고리즘
     *
     * @param column
     * @param column
     * @param arrStr
     * @return
     */
    public void solution(int row, int column, String arrStr) {
        int[][] resultArr = new int[row][column];
        int[] arr = splitStrToInt(arrStr);
        int[] result = new int[arr.length];
        int index = 0;
        int turnYn = 0;         // Y축 증감 방향 선택. (0:왼쪽 아래 대각선(x축 증가) , 1:오른쪽 위 대각선(y축 증가), 2: 왼쪽 아래 대각선(예외경우 처리))

        int x = 0;
        int y = 0;

        resultArr = inputArr(row, column, arr, resultArr);

        // 총 row * column 번 돌림
        while (index < arr.length){
            // 최초 인덱스 [0][0] 채움.
             if(x == 0 && y == 0){
                result[index] = resultArr[x][y];
                y++;
                index++;
            }

            if(turnYn == 0){
                if(y >= 0){             // y 가 0이 될때까지 (왼쪽 아래 대각선 모양)
                    result[index] = resultArr[x][y];
                    if(x != row -1){
                        x++;
                        y--;
                    }else{
                        turnYn = 1;
                        y++;
                    }
                    index++;
                }else{
                    turnYn = 1;     // 방향 변경.
                    y++;            // 아래로 한칸내림.

                }
            }else if(turnYn == 1){
                if(x >= 0){             // x 가 0이 될때까지 (오른쪽 위 대각선 모양)
                    result[index] = resultArr[x][y];
                    if(y < column -1){
                        x--;
                        y++;
                        index++;
                    }else{
                        x++;
                        turnYn = 0;
                        index++;
                    }
                }else{
                    if(y >= column){
                        turnYn = 2;
                        y--;
                        x++;
                        x++;
                    }else{
                        turnYn = 0;     // 방향 변경.
                        x++;            // 오른쪽으로 한칸더함.
                    }
                }
            }else if(turnYn == 2){
                if(x < row){             // x 가 row크기가 될때까지 (왼쪽 아래 대각선 모양)
                    result[index] = resultArr[x][y];
                    if(x != row -1){
                        x++;
                        y--;
                    }else{
                        turnYn = 1;     // 방향 변경.
                        y++;            // 아래로 한칸내림.
                    }
                    index++;
                }
            }
        }

        for(int i = 0; i < result.length ; i++){
                System.out.print(result[i]);
                if(i < result.length -1){
                    System.out.print(",");
                }
        }

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

}
