package com.editor.filters;

import com.editor.model.Image;

public class SharpenFilter implements Filter {
    @Override
    public void apply(Image image) {
        System.out.println("Applying sharpen filter to " + image.getName());
    }
}
