package ru.job4j.design.srp;

public class Repository {
    public void save(AbstractEntity entity) throws ClassNotFoundException {
        // куфгирование на тип классакоторый пришел в метод неверно так как при добаление новой зависимости
        // условия будут добавляться
        if (entity.getClass().getName().equals("AbstractEntity")) {

        } else if (entity.getClass().getName().equals("RoleEntity")) {

        }
    }
}
