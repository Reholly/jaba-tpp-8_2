package evgenii;

import evgenii.module.AppModuleContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication(scanBasePackages = "evgenii")
public class App {
    private static List<AppModuleContract> modules;

    @Autowired
    public App(List<AppModuleContract> modules) {
        App.modules = modules;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        var scanner = new Scanner(System.in);
        System.out.print("Enter path to file: ");
        String filePath = scanner.nextLine();
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

        var allAppModules = new ArrayList<AppModuleContract>();
        for (var module : modules) {
            if (module.CanBeExecuted(filePath)) {
                allAppModules.add(module);
            }
        }

        System.out.println("All functions of modules:");
        for (int i = 0; i < allAppModules.size(); i++) {
            System.out.println(Integer.valueOf(i).toString() + " " + allAppModules.get(i).GetDescription());
        }

        System.out.print("Enter needed function:");
        allAppModules.get(scanner.nextInt()).Execute(filePath);
    }
}