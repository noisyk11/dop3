package com.example.dop_zadanie_3;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

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