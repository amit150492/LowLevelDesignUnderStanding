package com.editor.repository;

import com.editor.model.Image;

public class SqlImageRepository implements ImageRepository {
    @Override
    public void save(Image image) {
        System.out.println("Saving " + image.getName() + " to SQL Database.");
    }
}