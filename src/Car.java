package model;

import annotations.Two;

/**
 * Класс, представляющий автомобиль.
 * <p>Содержит информацию о марке и годе выпуска автомобиля.</p>
 *
 * @see annotations.Two
 */
@Two(first = "Automobile", second = 2023)
public class Car {

    /** Марка автомобиля. Не может быть пустой. */
    private String brand;

    /** Год выпуска автомобиля. Должен быть в диапазоне 1900-2025. */
    private int year;

    /**
     * Создает автомобиль с маркой "Неизвестно" и нулевым годом выпуска.
     */
    public Car() {
        this.brand = "Неизвестно";
        this.year = 0;
    }

    /**
     * Создает автомобиль с указанными маркой и годом выпуска.
     *
     * @see #setBrand(String)
     * @see #setYear(int)
     */
    public Car(String brand, int year) {
        setBrand(brand);
        setYear(year);
    }

    /**
     * Возвращает марку автомобиля.
     *
     * @return марка автомобиля
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Устанавливает марку автомобиля.
     *
     * @param brand марка для установки
     * @throws IllegalArgumentException если марка {@code null} или пустая
     */
    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Марка не может быть пустой");
        }
        this.brand = brand.trim();
    }

    /**
     * Возвращает год выпуска автомобиля.
     *
     * @return год выпуска
     */
    public int getYear() {
        return year;
    }

    /**
     * Устанавливает год выпуска автомобиля.
     *
     * @param year год выпуска для установки
     * @throws IllegalArgumentException если год вне диапазона 1900-2025
     */
    public void setYear(int year) {
        if (year < 1900 || year > 2025) {
            throw new IllegalArgumentException("Год должен быть от 1900 до 2025");
        }
        this.year = year;
    }

    /**
     * Проверяет, является ли автомобиль новым (выпущен в 2025 году или позже).
     *
     * @return {@code true} если автомобиль выпущен в 2025 году или позже,
     *         {@code false} в противном случае
     */
    public boolean isNew() {
        return year >= 2025;
    }

    /**
     * Возвращает строковое представление автомобиля.
     *
     * @return строку в формате "Марка (Год)"
     */
    @Override
    public String toString() {
        return brand + " (" + year + ")";
    }
}
