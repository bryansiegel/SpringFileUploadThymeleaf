package com.bryansiegel.springfileuploadthymeleaf;

import jakarta.persistence.*;

@Entity
public class FileModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String fileName;
    @Lob
    @Column(name = "content")
    String content;
    @Column(name = "filetype")
    private String filetype;

    public FileModel() {
        super();
    }

    public FileModel(String fileName, String content, String filetype) {
        this.fileName = fileName;
        this.content = content;
        this.filetype = filetype;
    }

//    public FileModel(String fileName, String sourceFileContent, String fileContentType) {
//    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    @Override
    public String toString() {
        return "FileModel{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", content='" + content + '\'' +
                ", filetype='" + filetype + '\'' +
                '}';
    }
}
