package com.bryansiegel.springfileuploadthymeleaf;

import java.util.List;

public interface FileUploadService {
    List<FileModel> getAllFiles();
    void saveAllFilesList(List<FileModel> fileList);
}
