package com.editor.filters;

import com.editor.model.Image;

public class ColorFilter implements Filter {
    private String color;

    public ColorFilter(String color) {
        this.color = color;
    }

    @Override
    public void apply(Image image) {
        System.out.println("Applying " + color + " color filter to " + image.getName());
    }
}
