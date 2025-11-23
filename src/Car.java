@Two(first = "Automobile", second = 2023)
public class Car {
    private String brand;
    private int year;

    public Car() {
        this.brand = "Неизвестно";
        this.year = 0;
    }

    public Car(String brand, int year) {
        setBrand(brand);
        setYear(year);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Марка не может быть пустой");
        }
        this.brand = brand.trim();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1900 || year > 2025) {
            throw new IllegalArgumentException("Год должен быть от 1900 до 2025");
        }
        this.year = year;
    }

    //Проверить, является ли автомобиль новым
    public boolean isNew() {
        return year >= 2025;
    }

    @Override
    public String toString() {
        return brand + " (" + year + ")";
    }
}

