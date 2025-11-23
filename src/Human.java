public class Human {
    private String name;
    private int age;

    //Конструкторы
    public Human() {
        this.name = "null";
        this.age = 0;
    }

    public Human(String name, int age) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.name = name;
        this.age = age;
    }

    //Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = age;
    }

    //Поздороваться
    @Invoke
    public void sayHello() {
        System.out.println(name + " говорит: Привет! Мне " + age + " лет.");
    }

    //Представиться
    @Invoke
    public String introduce(String mood) {
        String introduction = "Меня зовут " + name + ", мне " + age + " лет. Настроение: " + mood;
        System.out.println(introduction);
        return introduction;
    }

    //Проверить на совершеннолетие
    @Invoke
    public void checkAdult() {
        if (age >= 18) {
            System.out.println(name + " совершеннолетний(яя)");
        } else {
            System.out.println(name + " несовершеннолетний(яя)");
        }
    }

    //Отметить день рождения
    @Invoke
    public void celebrateBirthday() {
        age++;
        System.out.println("С днем рождения, " + name + "! Теперь тебе " + age + " лет.");
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
