package ru.job4j.design.srp;

public class Progress {
    private File file;
    Progress(File file) {
        this.file = file;
    }

    public Double getAsPercent() {
        return file.sent * 100 / file.length;
    }
}
