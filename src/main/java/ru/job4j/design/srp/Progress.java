package ru.job4j.design.srp;

public class Progress {
    private File file;
    // Если потребуется получать данные не в процентах степени использования
    // Если потребуется показать обьем просмотреной части не только файла или мызыкального клипа в других единицах измерения
    Progress(File file) {
        this.file = file;
    }

    public Double getAsPercent() {
        return file.sent * 100 / file.length;
    }
}
