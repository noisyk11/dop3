# Animal App 

Это приложение для Android демонстрирует использование принципов объектно-ориентированного программирования (ООП) на примере работы с классами животных. Приложение позволяет пользователю вводить данные о животном, выбирать его тип (собака или кошка) и получать информацию о введенном животном.

---

##  Функционал

- Выбор типа животного: **Собака** или **Кошка**.
- Ввод данных:
  - Имя животного.
  - Возраст животного.
  - Уникальная характеристика: порода (для собаки) или цвет (для кошки).
- Отображение информации о животном:
  - Общие характеристики.
  - Уникальная характеристика.
  - Звук, издаваемый животным.

---

##  Структура проекта

### Классы:
1. **Animal**:
   - Родительский класс для всех животных.
   - Общие поля: `name` (имя) и `age` (возраст).
   - Методы:
     - `makeSound()`: общий метод для вывода звука животного.
     - `showInfo()`: выводит основную информацию о животном.

2. **Dog** (Собака):
   - Дочерний класс, наследуется от `Animal`.
   - Уникальное поле: `breed` (порода).
   - Методы:
     - Переопределение `makeSound()` для звука "Гав-гав".
     - `showInfo()` добавляет информацию о породе.

3. **Cat** (Кошка):
   - Дочерний класс, наследуется от `Animal`.
   - Уникальное поле: `color` (цвет).
   - Методы:
     - Переопределение `makeSound()` для звука "Мяу".
     - `showInfo()` добавляет информацию о цвете.

---

##  Интерфейс приложения

Приложение построено на простой разметке, включающей:

- **Spinner**: для выбора типа животного.
- **EditText**: для ввода имени, возраста и уникальной характеристики.
- **Button**: для обработки данных и отображения информации.
- **TextView**: для вывода результата.

---
## Код:
```java
// Родительский класс Animal
class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String makeSound() {
        return "Животное издает звук.";
    }

    public String showInfo() {
        return "Имя: " + name + ", Возраст: " + age;
    }
}

// Дочерний класс Dog
class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return name + " говорит: Гав-гав!";
    }

    @Override
    public String showInfo() {
        return super.showInfo() + ", Порода: " + breed;
    }
}

// Дочерний класс Cat
class Cat extends Animal {
    private String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    @Override
    public String makeSound() {
        return name + " говорит: Мяу!";
    }

    @Override
    public String showInfo() {
        return super.showInfo() + ", Цвет: " + color;
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerAnimalType = findViewById(R.id.spinnerAnimalType);
        EditText inputName = findViewById(R.id.inputName);
        EditText inputAge = findViewById(R.id.inputAge);
        EditText inputUniqueField = findViewById(R.id.inputUniqueField);
        Button buttonShowInfo = findViewById(R.id.buttonShowInfo);
        TextView textOutput = findViewById(R.id.textOutput);

        // Обработка нажатия кнопки
        buttonShowInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputName.getText().toString();
                int age = Integer.parseInt(inputAge.getText().toString());
                String uniqueField = inputUniqueField.getText().toString();

                Animal animal;
                if (spinnerAnimalType.getSelectedItem().toString().equals("Собака")) {
                    animal = new Dog(name, age, uniqueField);
                } else {
                    animal = new Cat(name, age, uniqueField);
                }

                // Вывод информации
                String result = animal.showInfo() + "\n" + animal.makeSound();
                textOutput.setText(result);
            }
        });
    }
}
