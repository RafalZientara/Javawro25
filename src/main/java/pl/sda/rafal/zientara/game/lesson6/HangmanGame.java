package pl.sda.rafal.zientara.game.lesson6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HangmanGame {
    private String secret = "";
    private Set<String> guessedLetters = new HashSet<>();
    private int hp = 7;

    public void setSecret(String secret) {
        if (!isCorrectSecret(secret)) {
            throw new IllegalArgumentException("No numbers allowed!");
        }
        this.secret = secret;
    }

    private boolean isCorrectSecret(String secret) {
        Pattern correctPattern = Pattern.compile("([a-zA-Z]* *)*");
        Matcher matcher = correctPattern.matcher(secret);
        return matcher.matches();
    }

    public String getCurrentResult() {
        Optional<String> maskedSecret = Arrays.stream(secret.split(""))
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        if (" ".equals(s))
                            return s;
                        else {
                            if (guessedLetters.contains(s.toLowerCase())) {
                                return s;
                            }
                            return ".";
                        }
                    }
                })
                .reduce((acc, txt) -> acc + txt);
        return maskedSecret.get();
    }

    public void guessLetter(String letter) {
        guessedLetters.add(letter.toLowerCase());
        if (hp > 0 && !secret.toLowerCase().contains(letter.toLowerCase())) {
            hp--;
        }
        if (hp == 0) {
            throw new GameOverException();
        }
    }

    public int getHP() {
        return hp;
    }
}
