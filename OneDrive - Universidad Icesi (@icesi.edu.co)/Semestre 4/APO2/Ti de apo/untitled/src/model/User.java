package model;

public class User {

    public User(int score, String nickname) {
        this.score = score;
        this.nickname = nickname;
    }

    private User right;

    private User left;

    private int score;

    private String nickname;

    public User(User user) {
    }


    public User getRight() {
        return right;
    }

    public void setRight(User right) {
        this.right = right;
    }

    public User getLeft() {
        return left;
    }

    public void setLeft(User left) {
        this.left = left;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public User getUser() {
        return null;
    }

    public User getRigth() {
     return null;
    }
}