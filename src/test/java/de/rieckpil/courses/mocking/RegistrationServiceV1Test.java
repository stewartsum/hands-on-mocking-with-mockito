package de.rieckpil.courses.mocking;

import de.rieckpil.courses.BannedUsersClient;
import de.rieckpil.courses.JpaUserRepository;
import de.rieckpil.courses.RegistrationService;
import de.rieckpil.courses.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RegistrationServiceV1Test {

  private UserRepository userRepository = Mockito.mock(UserRepository.class);
  private BannedUsersClient bannedUsersClient = Mockito.mock(BannedUsersClient.class);
  private RegistrationService cut = new RegistrationService(userRepository, bannedUsersClient);

  @Test
  void shouldRegisterUnknownUser() {

    UserRepository realUserRepository = new JpaUserRepository();

    System.out.println(realUserRepository.toString()); // de.rieckpil.courses.JpaUserRepository@5fd9b663
    System.out.println(realUserRepository.getClass()); // class de.rieckpil.courses.JpaUserRepository

    System.out.println(userRepository.toString()); // Mock for UserRepository, hashCode: 1746578747
    System.out.println(userRepository.getClass()); // class de.rieckpil.courses.UserRepository$MockitoMock$1281950327

    System.out.println(bannedUsersClient.toString()); // Mock for BannedUsersClient, hashCode: 1008612116
    System.out.println(bannedUsersClient.getClass()); // class de.rieckpil.courses.BannedUsersClient
  }

}
