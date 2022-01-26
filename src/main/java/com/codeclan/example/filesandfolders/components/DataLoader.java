package com.codeclan.example.filesandfolders.components;

import com.codeclan.example.filesandfolders.models.Extension;
import com.codeclan.example.filesandfolders.models.File;
import com.codeclan.example.filesandfolders.models.Folder;
import com.codeclan.example.filesandfolders.models.User;
import com.codeclan.example.filesandfolders.repositories.FileRepository;
import com.codeclan.example.filesandfolders.repositories.FolderRepository;
import com.codeclan.example.filesandfolders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {

        User user1 = new User("Ben");
        userRepository.save(user1);

        User user2 = new User("Ann");
        userRepository.save(user2);

        User user3 = new User("John");
        userRepository.save(user3);

        User user4 = new User("Juliet");
        userRepository.save(user4);

        User user5 = new User("Karen");
        userRepository.save(user5);

        User user6 = new User("Bob");
        userRepository.save(user6);

        Folder folder1 = new Folder("Documents", user1);
        folderRepository.save(folder1);

        Folder folder2 = new Folder("Photos", user5);
        folderRepository.save(folder2);

        Folder folder3 = new Folder("Downloads", user2);
        folderRepository.save(folder3);

        Folder folder4 = new Folder("Documents", user6);
        folderRepository.save(folder4);

        Folder folder5 = new Folder("Photos", user3);
        folderRepository.save(folder5);

        Folder folder6 = new Folder("Downloads", user4);
        folderRepository.save(folder6);

        File file1 = new File("test", Extension.JAVA, 200, folder1);
        fileRepository.save(file1);

        File file2 = new File("recipes", Extension.PPT, 500, folder4);
        fileRepository.save(file2);

        File file3 = new File("games", Extension.MD, 150, folder6);
        fileRepository.save(file3);

        File file4 = new File("cats", Extension.RB, 800, folder3);
        fileRepository.save(file4);

        File file5 = new File("songs", Extension.TXT, 350, folder2);
        fileRepository.save(file5);

        File file6 = new File("Series", Extension.PPT, 600, folder5);
        fileRepository.save(file6);

        folder1.addFile(file1);
        folder1.addFile(file3);
        folderRepository.save(folder1);

        user1.addFolder(folder4);
        user1.addFolder(folder2);
        userRepository.save(user1);

    }
}
