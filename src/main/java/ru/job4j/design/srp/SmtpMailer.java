package ru.job4j.design.srp;

public class SmtpMailer {
    private Logger logger;
    public SmtpMailer(){
        logger = new Logger();
    }

    public void SendMessage(String message) {
        logger.Log(String.format("Отправлено '{0}'", message));
    }
}