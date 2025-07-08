package backend.shai.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${upload.directory}")
    private String uploadDir;

    public String storeFile(MultipartFile file) throws IOException {
        String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filepath = Paths.get(uploadDir, filename);
        Files.copy(file.getInputStream(), filepath, StandardCopyOption.REPLACE_EXISTING);
        return "/uploads/" + filename;
    }

}
