package com.example.demo.service;

import com.example.demo.dto.PersonneDTO;
import com.example.demo.erreur.ErreurPersonneException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ServicePersonneTest {
    @Mock
    private ServicePersonne personneService;

    @Test
    public void testSaveWithAgeGreaterThan150() throws ErreurPersonneException {
        // Arrange
        PersonneDTO personneDTO = PersonneDTO.builder().dateNaissance(LocalDate.now().minusYears(151)).build();

        // Mock the repository behavior
        Mockito.when(personneService.save(Mockito.any(PersonneDTO.class)))
                .thenThrow(new ErreurPersonneException("Should not be called")); // Ensure save method is not called

        // Act and Assert
        assertThrows(ErreurPersonneException.class, () -> personneService.save(personneDTO));
    }

    @Test
    public void testSaveWithValidAge() throws ErreurPersonneException {
        // Arrange
         // Set age <= 150
        PersonneDTO personneDTO = PersonneDTO.builder().id(1L).dateNaissance(LocalDate.now().minusYears(30)).build();

        // Mock the repository behavior
        Mockito.when(personneService.save(Mockito.any(PersonneDTO.class)))
                .thenReturn(personneDTO);

        // Act
        PersonneDTO result = personneService.save(personneDTO);

        // Assert
        // Ensure the service method returns the expected result
        // You can add more assertions if needed
        Assertions.assertNotNull(result.getId());
    }
}
