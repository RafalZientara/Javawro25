package pl.sda.rafal.zientara.game.lesson6;

import java.io.File;

public class MainFiles {

    public static void main(String[] args) {
        File file = new File("");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
    }
}
