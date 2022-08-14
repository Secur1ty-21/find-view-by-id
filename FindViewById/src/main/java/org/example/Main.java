package org.example;

import org.example.models.View;
import org.example.models.ViewGroup;


public class Main {
    public static void main(String[] args) {
        UnitTest.unitTests();
    }

    /**
     * Поиск view по id
     *
     * @param rootView id view в которую вложены все остальные view
     * @param id       id view которую нужно найти
     * @return Возвращает view с искомым id, если такой не существует возвращает null
     */
    public static View findViewById(View rootView, int id) {
        if (rootView instanceof ViewGroup) { // Проверяем является rootView ли View ViewGroup
            ViewGroup viewGroup = (ViewGroup) rootView;
            int size = viewGroup.getChildCount();
            View view;
            for (int i = 0; i < size; i++) {
                if (viewGroup.getChildAt(i).id == id) {
                    return viewGroup.getChildAt(i);
                }
                if (viewGroup.getChildAt(i) instanceof ViewGroup) { // Если найден еще один объект ViewGroup, продолжаем рекурсию
                    view = findViewById(viewGroup.getChildAt(i), id);
                    if (view != null) { // Проверяем был ли найден элемент в рекурсии
                        return view;
                    }
                }
            }
        }
        if (rootView.id == id) { // Проверяем саму ViewGroup
            return rootView;
        } else {
            return null;
        }
    }
}