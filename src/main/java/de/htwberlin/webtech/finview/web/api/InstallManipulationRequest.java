package de.htwberlin.webtech.finview.web.api;

public class InstallManipulationRequest {

    private String command;
    private String operatingSystem;
    private String packageManager;
    private Long libraryId;

    public InstallManipulationRequest(String command, String operatingSystem, String packageManager, Long libraryId) {
        this.command = command;
        this.operatingSystem = operatingSystem;
        this.packageManager = packageManager;
        this.libraryId = libraryId;
    }

    public InstallManipulationRequest() {}

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

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }
}
