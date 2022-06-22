package de.htwberlin.webtech.finview.web.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LibraryManipulationRequest {

    @NotBlank(message = "The Library Name cannot be empty.")
    private String libraryName;

    @Pattern(
            regexp = "JAVASCRIPT|PYTHON|JAVA|PHP|CSS|CSHARP|CPLUSPLUS|TYPESCRIPT|RUBY|C|SWIFT|R|OBJECTIVEC|SHELL|SCALA|GO|POWERSHELL|KOTLIN|RUST|DART|OTHER",
            message = "Please provide a known programming language. Otherwise choose 'OTHER'."
    )
    private String programmingLanguage;

    @NotBlank(message = "The latest version cannot be empty.")
    private String latestVersion;

    @Size(min=5, message = "Please give a little bit more detailed field of use. At least a minimum of 5 characters.")
    private String useField;

    public LibraryManipulationRequest(String libraryName, String programmingLanguage, String latestVersion, String useField) {
        this.libraryName = libraryName;
        this.programmingLanguage = programmingLanguage;
        this.latestVersion = latestVersion;
        this.useField = useField;
    }

    public LibraryManipulationRequest() {}

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getLatestVersion() {
        return latestVersion;
    }

    public void setLatestVersion(String latestVersion) {
        this.latestVersion = latestVersion;
    }

    public String getUseField() {
        return useField;
    }

    public void setUseField(String useField) {
        this.useField = useField;
    }
}
