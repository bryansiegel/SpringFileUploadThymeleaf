package com.bryansiegel.springfileuploadthymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImplementation implements FileUploadService{

    @Autowired
    FileUploadRepository fileUploadRepository;

    @Override
    public List<FileModel> getAllFiles() {
        return fileUploadRepository.findAll();
    }

    public void saveAllFilesList(List<FileModel> fileList) {

        for (FileModel fileModel : fileList) {
            fileUploadRepository.save(fileModel);
        }
    }
}
