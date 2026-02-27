package com.editor.service;

import com.editor.filters.Filter;
import com.editor.model.Image;
import com.editor.repository.ImageRepository;

public class ImageEditor {
    private Image image;

    public void clickImage() {
        this.image = new Image("Photo1", "ISO100", "010101");
        System.out.println("Image clicked.");
    }

    public void cropImage() {
        System.out.println("Image cropped.");
    }

    public void applyFilter(Filter filter) {
        filter.apply(image);
    }

    public void save(ImageRepository repository) {
        repository.save(image);
    }
}
