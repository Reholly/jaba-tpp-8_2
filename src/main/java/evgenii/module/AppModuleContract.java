package evgenii.module;

public interface AppModuleContract {
    boolean CanBeExecuted(String filePath);
    String GetDescription();
    void Execute(String filePath);
}
