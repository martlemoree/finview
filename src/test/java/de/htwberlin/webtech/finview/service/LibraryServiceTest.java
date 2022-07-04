package de.htwberlin.webtech.finview.service;

import de.htwberlin.webtech.finview.persistence.LibraryRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LibraryServiceTest implements WithAssertions {

    @Mock
    private LibraryRepository libraryRepository;

    @InjectMocks
    private LibraryService underTest;

    @Test
    @DisplayName("should return true if delete was successful")
    void should_return_true_if_delete_was_successful() {
        // given
        Long givenId = 123L;
        doReturn(true).when(libraryRepository).existsById(givenId);

        // when
        boolean result = underTest.deleteById(givenId);

        // then
        verify(libraryRepository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if library to delete does not exist")
    void should_return_false_if_library_to_delete_does_not_exist() {
        // given
        Long givenId = 123L;
        doReturn(false).when(libraryRepository).existsById(givenId);

        // when
        boolean result = underTest.deleteById(givenId);

        // then
        verifyNoMoreInteractions(libraryRepository);
        assertThat(result).isFalse();
    }
}
