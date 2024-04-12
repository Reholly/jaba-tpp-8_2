package evgenii.module.directory;

import evgenii.module.AppModuleContract;
import org.springframework.stereotype.Component;

import java.io.File;


@Component
public class DirFileAndSubdirCounter implements AppModuleContract {
    @Override
    public boolean CanBeExecuted(String filePath) {
        File fileSystemElement = new File(filePath);
        return fileSystemElement.isDirectory();
    }

    @Override
    public String GetDescription() {
        return null;
    }

    @Override
    public void Execute(String filePath) {
        File directory = new File(filePath);
        File[] files = directory.listFiles();
        int fls = 0;
        int dirs = 0;
        if (files != null)
            for (File file : files)
                if(file.isFile())
                    fls++;
                else
                    dirs++;
        System.out.printf("There are files - " +fls  );
        System.out.printf("There are directories - " + dirs);
    }
}
