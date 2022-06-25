package de.htwberlin.webtech.finview.persistence;

import javax.persistence.*;

@Entity(name = "installations")
public class InstallEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "install_id")
    private Long id;

    @Column(name = "command", nullable = false)
    private String command;

    @Column(name = "operating_system")
    @Enumerated(value = EnumType.STRING)
    private OperatingSystem operatingSystem;

    @Column(name = "package_manager")
    private String packageManager;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "library_id", referencedColumnName = "library_id")
    private LibraryEntity library;

    public InstallEntity() {

    }

    public InstallEntity(String command, OperatingSystem operatingSystem, String packageManager, LibraryEntity library) {
        this.command = command;
        this.operatingSystem = operatingSystem;
        this.packageManager = packageManager;
        this.library = library;
    }

    public Long getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getPackageManager() {
        return packageManager;
    }

    public void setPackageManager(String packageManager) {
        this.packageManager = packageManager;
    }

    public LibraryEntity getLibrary() {
        return library;
    }

    public void setLibrary(LibraryEntity library) {
        this.library = library;
    }
}
