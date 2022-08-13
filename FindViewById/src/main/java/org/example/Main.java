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
            return goInViewGroup(viewGroup, id);
        } else { // Если не является, проверяем не является ли rootView искомой
            if (rootView.id == id) {
                return rootView;
            } else {
                return null;
            }
        }
    }

    /**
     * Рекурсивный метод который вызывает сам себя в случае если во ViewGroup был найден еще один ViewGroup
     *
     * @param viewGroup Экземпляр класса ViewGroup
     * @param id        id искомой view
     * @return Если во viewGroup существует view с искомым ид возвращает view.
     * Если такового нет возвращает null
     */
    public static View goInViewGroup(ViewGroup viewGroup, int id) {
        int size = viewGroup.getChildCount();
        View view;
        for (int i = 0; i < size; i++) {
            if (viewGroup.getChildAt(i).id == id) {
                return viewGroup.getChildAt(i);
            }
            if (viewGroup.getChildAt(i) instanceof ViewGroup) { // Если найден еще один объект ViewGroup, продолжаем рекурсию
                view = goInViewGroup((ViewGroup) viewGroup.getChildAt(i), id);
                if (view != null) { // Проверяем был ли найден элемент в рекурсии
                    return view;
                }
            }
        }
        return null;
    }
}