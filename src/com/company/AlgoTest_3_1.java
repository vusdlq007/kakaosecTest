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


}
