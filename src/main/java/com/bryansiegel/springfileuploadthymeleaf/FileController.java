package com.bryansiegel.springfileuploadthymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FileController {

    @Autowired
    FileServiceImplementation fileServiceImplementation;


    @GetMapping("/")
    public String getData() {
        return "File";
    }

    @PostMapping("/")
  public String uploadMultiplepartFile(@RequestParam("files") MultipartFile[] files, Model model) {
      try {

          List<FileModel> fileList = new ArrayList<FileModel>();
          for (MultipartFile file : files) {
              String fileContentType = file.getContentType();
              String sourceFileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
              String fileName = file.getOriginalFilename();
              FileModel fileModel = new FileModel(fileName, sourceFileContent, fileContentType);

              fileList.add(fileModel);
          }

          //save to db
          fileServiceImplementation.saveAllFilesList(fileList);
      } catch (Exception e) {
          e.printStackTrace();
      }
      model.addAttribute("allFiles", fileServiceImplementation.getAllFiles());


      return "FileList";
  }
}
