//Класс с некорректной аннотацией @Two - пустая строка в first
@Two(first = "", second = 123)  // first - пустая строка, second - валидный
public class TwoFirst {

    public TwoFirst() {
        // Пустой конструктор
    }

    @Override
    public String toString() {
        return "InvalidFirstClass{}";
    }
}