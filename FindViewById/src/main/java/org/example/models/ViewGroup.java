package org.example.models;

public class ViewGroup extends View {

    private final View[] childList;

    public ViewGroup(int id, View[] childList) {
        super(id);
        this.childList = childList;
    }

    public View getChildAt(int index) {
        return childList[index];
    }

    public int getChildCount() {
        return childList.length;
    }
}
