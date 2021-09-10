package ru.job4j.design.srp;

public class SentPost extends SentMessage{

    private int amountLikes;

    SentPost(String from, String to, String message, int amountLikes) {
        super(from, to, message);
        this.amountLikes = amountLikes;
    }

    @Override
    public String sent() {
        StringBuilder rsl = new StringBuilder();
        rsl.append("From ").append(super.getFrom())
                .append("To ").append(super.getTo())
                .append("likes ").append(this.amountLikes)
                .append(super.getMessage());
        return rsl.toString();
    }
}
