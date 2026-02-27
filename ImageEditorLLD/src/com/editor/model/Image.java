package com.editor.model;

public class Image {
    private String name;
    private String metadata;
    private String content;

    public Image(String name, String metadata, String content) {
        this.name = name;
        this.metadata = metadata;
        this.content = content;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
