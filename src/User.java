package model;

import annotations.Validate;

/**
 * Класс, представляющий пользователя системы.
 * <p>Содержит информацию об имени пользователя и email. Класс демонстрирует
 * использование аннотации {@link annotations.Validate}.</p>
 *
 * @see annotations.Validate
 */
@Validate({String.class, Integer.class, User.class})
public class User {

    /** Имя пользователя в системе. */
    private String username;

    /** Email адрес пользователя. */
    private String email;

    /**
     * Создает пользователя с именем "user" и email "user@example.com".
     */
    public User() {
        this.username = "user";
        this.email = "user@example.com";
    }

    /**
     * Создает пользователя с указанными именем и email.
     *
     * @param username имя пользователя
     * @param email email адрес
     */
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    /**
     * Возвращает имя пользователя.
     *
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Возвращает email адрес пользователя.
     *
     * @return email адрес
     */
    public String getEmail() {
        return email;
    }

    /**
     * Возвращает строковое представление пользователя.
     *
     * @return строку в формате "User{username='[имя]', email='[email]'}"
     */
    @Override
    public String toString() {
        return "User{username='" + username + "', email='" + email + "'}";
    }
}
