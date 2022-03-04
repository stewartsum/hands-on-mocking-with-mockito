package de.rieckpil.courses.advanced;

import de.rieckpil.courses.JpaUserRepository;
import de.rieckpil.courses.User;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;

// since 3.5.0
class ConstructorMockTest {

  @Test
  void constructorMocking() {

    System.out.println(new JpaUserRepository().findByUsername("mike"));
    /*
    Retrieving a given user from the database
    null
     */


    try (MockedConstruction<JpaUserRepository> mocked = Mockito.mockConstruction(JpaUserRepository.class)) {

      JpaUserRepository jpaUserRepository = new JpaUserRepository();

      Mockito.when(jpaUserRepository.findByUsername("duke")).thenReturn(new User());

      assertNotNull(jpaUserRepository.findByUsername("duke"));

      Mockito.verify(jpaUserRepository).findByUsername("duke");
    }

    System.out.println(new JpaUserRepository().findByUsername("duke"));
    /*
    Retrieving a given user from the database
    null
     */
  }

  @Test
  void constructorMockingWithDirectStubbing() {
  }
}
