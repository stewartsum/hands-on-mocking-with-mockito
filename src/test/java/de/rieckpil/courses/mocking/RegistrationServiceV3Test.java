package de.rieckpil.courses.mocking;

import de.rieckpil.courses.BannedUsersClient;
import de.rieckpil.courses.RegistrationService;
import de.rieckpil.courses.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// @RunWith(MockitoJUnitRunner.class) // Junit 4
@ExtendWith(MockitoExtension.class) // JUnit 5
class RegistrationServiceV3Test {

  @Mock
  private UserRepository userRepository;

  @Mock
  private BannedUsersClient bannedUsersClient;

  @InjectMocks
  private RegistrationService cut;

  @Test
  void shouldRegisterUnknownUser() {
    System.out.println(userRepository.getClass()); // class de.rieckpil.courses.UserRepository$MockitoMock$1679342815
    System.out.println(bannedUsersClient.getClass()); // class de.rieckpil.courses.BannedUsersClient

    System.out.println(cut.toString()); // de.rieckpil.courses.RegistrationService@29b732a2
  }
}
