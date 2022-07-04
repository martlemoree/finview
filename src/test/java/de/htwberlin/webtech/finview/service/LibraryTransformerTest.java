package de.htwberlin.webtech.finview.service;

import de.htwberlin.webtech.finview.persistence.InstallEntity;
import de.htwberlin.webtech.finview.persistence.LibraryEntity;
import de.htwberlin.webtech.finview.persistence.ProgrammingLanguage;
import de.htwberlin.webtech.finview.persistence.ProjectEntity;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Timestamp;
import java.util.Set;

import static org.mockito.Mockito.doReturn;

class LibraryTransformerTest implements WithAssertions {

    private final LibraryTransformer underTest = new LibraryTransformer();

    @Test
    @DisplayName("should transofrm LibraryEntity to Library")
    void should_transform_library_entity_to_person() {
        // given
        var libraryEntity = Mockito.mock(LibraryEntity.class);
        doReturn(123L).when(libraryEntity).getId();
        doReturn("KotlinTestLibrary").when(libraryEntity).getLibraryName();
        doReturn(ProgrammingLanguage.Kotlin).when(libraryEntity).getProgrammingLanguage();
        doReturn("1.2.3").when(libraryEntity).getLatestVersion();
        doReturn("Backend Testing").when(libraryEntity).getUseField();
        doReturn("www.ktl.com").when(libraryEntity).getWebsite();
        doReturn(123).when(libraryEntity).getUpvotes();
        doReturn(14).when(libraryEntity).getDownvotes();
        doReturn(Timestamp.valueOf("2022-07-02 01:02:03.123456789")).when(libraryEntity).getCreatedAt();
        doReturn(Timestamp.valueOf("2022-07-02 01:02:03.123456789")).when(libraryEntity).getUpdatedAt();
        doReturn(Set.of(new ProjectEntity())).when(libraryEntity).getProjects();
        doReturn(Set.of(new InstallEntity())).when(libraryEntity).getInstalls();

        // when
        var result = underTest.transformEntity(libraryEntity);

        // then
        assertThat(result.getId()).isEqualTo(123);
        assertThat(result.getLibraryName()).isEqualTo("KotlinTestLibrary");
        assertThat(result.getProgrammingLanguage()).isEqualTo("Kotlin");
        assertThat(result.getLatestVersion()).isEqualTo("1.2.3");
        assertThat(result.getUseField()).isEqualTo("Backend Testing");
        assertThat(result.getWebsite()).isEqualTo("www.ktl.com");
        assertThat(result.getUpvotes()).isEqualTo(123);
        assertThat(result.getDownvotes()).isEqualTo(14);
        assertThat(result.getCreatedAt()).isEqualTo("2022-7-2");
        assertThat(result.getUpdatedAt()).isEqualTo("2022-7-2");
        assertThat(result.getProjectIds()).hasSize(1);
        assertThat(result.getInstallIds()).hasSize(1);
    }
}
