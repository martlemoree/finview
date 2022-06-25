package de.htwberlin.webtech.finview.web.api;

public class Install {

    private Long id;
    private String command;
    private String operatingSystem;
    private String packageManager;
    private Library library;

    public Install(Long id, String command, String operatingSystem, String packageManager, Library library) {
        this.id = id;
        this.command = command;
        this.operatingSystem = operatingSystem;
        this.packageManager = packageManager;
        this.library = library;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getPackageManager() {
        return packageManager;
    }

    public void setPackageManager(String packageManager) {
        this.packageManager = packageManager;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
