package org.example;

import org.example.models.View;
import org.example.models.ViewGroup;

import static org.example.Main.findViewById;

public class UnitTest {
    public static void unitTests() {
        // Test 1 - один массив вью с нужным id
        View[] views = new View[10];
        int size = views.length;
        for (int i = 0; i < size; i++) {
            views[i] = new View(i);
        }
        View view = new ViewGroup(20, views);
        View foundView = findViewById(view, 9);
        if (foundView != null && foundView.id == 9) {
            System.out.println("test 1 -> ✅");
        } else {
            System.out.println("test 1 -> ❌");
        }
        // Test 2 - 0 массивов вью с нужным id
        View view1 = new View(10);
        foundView = findViewById(view1, 10);
        if (foundView != null && foundView.id == 10) {
            System.out.println("test 2 -> ✅");
        } else {
            System.out.println("test 2 -> ❌");
        }
        // Test 3 - один массив вью без нужного id
        foundView = findViewById(view, 123);
        if (foundView == null) {
            System.out.println("test 3 -> ✅");
        } else {
            System.out.println("test 3 -> ❌");
        }
        // Test 4 - 0 массивов вью без нужного id
        foundView = findViewById(view1, 123);
        if (foundView == null) {
            System.out.println("test 4 -> ✅");
        } else {
            System.out.println("test 4 -> ❌");
        }
        // Test 5 - Один вложенный ViewGroup с нужным id
        View[] views1 = new View[20]; // Второй массив с вью. с id 30..49
        size = views1.length;
        for (int i = 0; i < size; i++) {
            views1[i] = new View(i + 30);
        }
        views[2] = new ViewGroup(100, views1); // Добавление вложенного массива к рутовому.
        view = new ViewGroup(101, views); // Создание вью с двумя массивами.
        foundView = findViewById(view, 35);
        if (foundView != null && foundView.id == 35) {
            System.out.println("test 5 -> ✅");
        } else {
            System.out.println("test 5 -> ❌");
        }
        // Test 6 - Один вложенный ViewGroup без нужного id
        foundView = findViewById(view, 1000);
        if (foundView == null) {
            System.out.println("test 6 -> ✅");
        } else {
            System.out.println("test 6-> ❌");
        }
        // Test 7 - 3 вложенных друг в друга ViewGroup с нужным id
        views = new View[10]; // 10 элементов с id 0..9
        views1 = new View[10]; // 10 элементов с id 10..19
        View[] views2 = new View[10]; // 10 элементов с id 20..29
        View[] views3 = new View[10]; // 10 элементов с id 30..39
        size = views1.length;
        for (int i = 0; i < size; i++) {
            views[i] = new View(i);
            views1[i] = new View(i + 10);
            views2[i] = new View(i + 20);
            views3[i] = new View(i + 30);
        }
        views2[5] = new ViewGroup(25, views3);
        views1[4] = new ViewGroup(14, views2);
        views[3] = new ViewGroup(3, views1);
        view = new ViewGroup(100, views);
        foundView = findViewById(view, 35);
        if (foundView != null && foundView.id == 35) { // Поиск рандомного элемента
            System.out.println("test 7 -> ✅");
        } else {
            System.out.println("test 7 -> ❌");
        }
        // Test 8 - 3 вложенных друг в друга ViewGroup с нужным id
        foundView = findViewById(view, 39);
        if (foundView != null && foundView.id == 39) { // Поиск крайнего элемента в последнем вложенном ViewGroup
            System.out.println("test 8 -> ✅");
        } else {
            System.out.println("test 8 -> ❌");
        }
        // Test 9 - 3 вложенных друг в друга ViewGroup с нужным id
        foundView = findViewById(view, 29);
        if (foundView != null && foundView.id == 29) { // Поиск крайнего элемента во втором вложенном ViewGroup
            System.out.println("test 9 -> ✅");
        } else {
            System.out.println("test 9 -> ❌");
        }
        // Test 10 - 3 вложенных друг в друга ViewGroup с нужным id
        foundView = findViewById(view, 19);
        if (foundView != null && foundView.id == 19) { // Поиск крайнего элемента в первом вложенном ViewGroup
            System.out.println("test 10 -> ✅");
        } else {
            System.out.println("test 10 -> ❌");
        }
        // Test 11 - 3 вложенных друг в друга ViewGroup с нужным id
        foundView = findViewById(view, 9);
        if (foundView != null && foundView.id == 9) { // Поиск крайнего элемента в rootView
            System.out.println("test 11 -> ✅");
        } else {
            System.out.println("test 11 -> ❌");
        }
        // Test 12 - 3 вложенных друг в друга ViewGroup с нужным id
        foundView = findViewById(view, 25);
        if (foundView != null && foundView.id == 25) { // Поиск последнего ViewGroup
            System.out.println("test 12 -> ✅");
        } else {
            System.out.println("test 12 -> ❌");
        }
        // Test 13 - 3 вложенных друг в друга ViewGroup с нужным id
        foundView = findViewById(view, 14);
        if (foundView != null && foundView.id == 14) { // Поиск второго ViewGroup
            System.out.println("test 13 -> ✅");
        } else {
            System.out.println("test 13 -> ❌");
        }
        // Test 14 - 3 вложенных друг в друга ViewGroup с нужным id
        foundView = findViewById(view, 3);
        if (foundView != null && foundView.id == 3) { // Поиск первого ViewGroup
            System.out.println("test 14 -> ✅");
        } else {
            System.out.println("test 14 -> ❌");
        }
    }
}
