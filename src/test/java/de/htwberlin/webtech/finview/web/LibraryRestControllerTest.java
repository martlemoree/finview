package de.htwberlin.webtech.finview.web;

import de.htwberlin.webtech.finview.service.LibraryService;
import de.htwberlin.webtech.finview.web.api.Library;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LibraryRestController.class)
class LibraryRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LibraryService libraryService;

    @Test
    @DisplayName("should return found libraries from library service")
    void should_return_found_libraries_from_library_service() throws Exception {
        // given
        var libraries = List.of(
            new Library(1, "JavaTestLibrary", "Java", "1.2.3", "Test Backend", "www.jtl.com", 23, 4, Timestamp.valueOf("2022-07-02 01:02:03.123456789"), Timestamp.valueOf("2022-07-02 01:02:03.123456789"), Collections.emptySet(), Collections.emptySet()),
            new Library(2, "CTestLibrary", "C", "1.2.4", "Test Rest Controller", "www.ctl.com", 13, 17, Timestamp.valueOf("2022-07-02 01:02:03.123456789"), Timestamp.valueOf("2022-07-02 01:02:03.123456789"), Collections.emptySet(), Collections.emptySet())
        );
        doReturn(libraries).when(libraryService).findAll();

        // when
        mockMvc.perform(get("/api/v1/libraries"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].libraryName").value("JavaTestLibrary"))
                .andExpect(jsonPath("$[0].programmingLanguage").value("Java"))
                .andExpect(jsonPath("$[0].latestVersion").value("1.2.3"))
                .andExpect(jsonPath("$[0].useField").value("Test Backend"))
                .andExpect(jsonPath("$[0].website").value("www.jtl.com"))
                .andExpect(jsonPath("$[0].upvotes").value(23))
                .andExpect(jsonPath("$[0].downvotes").value(4))
                .andExpect(jsonPath("$[0].createdAt").value("2022-7-2"))
                .andExpect(jsonPath("$[0].updatedAt").value("2022-7-2"))
                .andExpect(jsonPath("$[1].libraryName").value("CTestLibrary"))
                .andExpect(jsonPath("$[1].programmingLanguage").value("C"))
                .andExpect(jsonPath("$[1].latestVersion").value("1.2.4"))
                .andExpect(jsonPath("$[1].useField").value("Test Rest Controller"))
                .andExpect(jsonPath("$[1].website").value("www.ctl.com"))
                .andExpect(jsonPath("$[1].upvotes").value(13))
                .andExpect(jsonPath("$[1].downvotes").value(17))
                .andExpect(jsonPath("$[1].createdAt").value("2022-7-2"))
                .andExpect(jsonPath("$[1].updatedAt").value("2022-7-2"));
    }

    @Test
    @DisplayName("should return 404 if library is not found")
    void should_return_404_if_library_is_not_found() throws Exception {
        // given
        doReturn(null).when(libraryService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/libraries/123"))
                // then
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating a library")
    void should_return_201_http_status_and_location_header_when_creating_a_library() throws Exception {
        // given
        String libraryToCreateAsJson = "{\"libraryName\": \"pyTest\", \"programmingLanguage\": \"Python\", \"latestVersion\": \"7.11\", \"useField\": \"Create Test\", \"website\": \"www.pytest.com\", \"upvotes\": 37, \"downvotes\": 2, \"createdAt\": 1656806400000, \"updatedAt\": 1656806400000, \"projectIds\": [], \"installIds\": []}";
        var library = new Library(123, null, null, null, null, null, 0, 0, null, null, null, null);
        doReturn(library).when(libraryService).create(any());

        // when
        mockMvc.perform(
                post("/api/v1/libraries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(libraryToCreateAsJson)
                )
                // then
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/libraries/" + library.getId()))));
    }

    @Test
    @DisplayName("should validate create library request")
    void should_validate_create_library_request() throws Exception {
        // given
        String libraryToCreateAsJson = "{\"libraryName\": \"pyTest\", \"programmingLanguage\": \"Pytho\", \"latestVersion\": \"7.11\", \"useField\": \"Create Test\", \"website\": \"www.pytest.com\", \"upvotes\": 37, \"downvotes\": 2, \"createdAt\": 1656806400000, \"updatedAt\": 1656806400000, \"projectIds\": [], \"installIds\": []}";

        // when
        mockMvc.perform(
                post("/api/v1/libraries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(libraryToCreateAsJson)
                )
                // then
                .andExpect(status().isBadRequest());
    }
}
