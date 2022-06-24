package de.htwberlin.webtech.finview.persistence;

public enum ProgrammingLanguage {
    PYTHON,
    JAVASCRIPT,
    JavaScript,
    Python,
    Java,
    PHP,
    CSS,
    CSharp {
        public String toString() {
            return "C#";
        }
    },
    CPlusPlus {
        public String toString() {
            return "C++";
        }
    },
    TypeScript,
    Ruby,
    C,
    Swift,
    R,
    ObjectiveC {
        public String toString() {
            return "Objective-C";
        }
    },
    Shell,
    Scala,
    Go,
    PowerShell,
    Kotlin,
    Rust,
    Dart,
    other
}
