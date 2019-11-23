package pl.sda.rafal.zientara.game.lesson3;

import java.util.Arrays;

public class MainArrayStream {
    public static void main(String[] args) {
        int[] numbers = new int[]{3, 5, 7, 1, 6};
        int[] ints = Arrays.stream(numbers)
                .map(num -> num)
                .map(num -> num * num)
//                .map(num -> database.findUserWithId(num))
                .toArray();//List<User>
        //RxJava
        for (int num : ints) {
            System.out.println(num);
        }

    }
}
