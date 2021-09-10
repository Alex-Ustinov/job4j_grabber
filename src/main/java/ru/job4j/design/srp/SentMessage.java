package ru.job4j.design.srp;

public class SentMessage {
    private String from;
    private String to;
    private String message;

    SentMessage(String from, String to, String message) {
        this.from = from;
        this.message = message;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getMessage() {
        return message;
    }

    public String sent() {
        StringBuilder rsl = new StringBuilder();
        rsl.append("From ").append(this.from)
                .append("To ").append(this.to)
                .append(this.message);
        return rsl.toString();
    }
}
