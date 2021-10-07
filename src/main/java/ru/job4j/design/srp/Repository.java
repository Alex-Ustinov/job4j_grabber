package ru.job4j.design.srp;

public class Repository {
    public void save(AbstractEntity entity) throws ClassNotFoundException {

        if (entity.getClass().getName().equals("AbstractEntity")) {

        } else if (entity.getClass().getName().equals("RoleEntity")) {

        }
    }
}
