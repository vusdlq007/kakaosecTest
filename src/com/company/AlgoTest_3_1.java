package com.company;


import java.util.ArrayList;


public class AlgoTest_3_1 {

    /**
     * 마지막 남는 자리
     *
     * @param persons
     * @param moveCnt
     */
    public void solution(int persons, int moveCnt) {
        ArrayList<Integer> position = new ArrayList<>();

        int finalPerson = 0;     // 최종 남은 사람 번호.
        int removeIndex = moveCnt-1;         // 0,1


        for (int i = 1; i <= persons; i++) {
            position.add(i);
        }

        // 최종 사람이 남을때까지 돌림.
        while (position.size() >= 1) {

            if (position.size() <= 1) {
                finalPerson = position.get(0);
                System.out.print(finalPerson);
                break;
            }

            if(removeIndex >= position.size()){
                removeIndex = removeIndex - position.size();
            }else{
                position.remove(removeIndex);
                removeIndex += moveCnt-1;
            }
        }

    }


    /**
     * String으로 받은 배열값 Int형으로 바꿔서 배열에 저장.
     *
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
     *
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
