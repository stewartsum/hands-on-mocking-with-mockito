package de.rieckpil.courses.advanced;

import de.rieckpil.courses.Address;
import de.rieckpil.courses.ContactInformation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DeepStubTest {

  @Test
  void withoutDeepStubs() {

    ContactInformation contactInformation = Mockito.mock(ContactInformation.class);
    Address address = Mockito.mock(Address.class);

    Mockito.when(contactInformation.getAddress()).thenReturn(address);
    Mockito.when(address.getCity()).thenReturn("Berlin");

    System.out.println(contactInformation.getAddress().getCity()); // Berlin
  }

  @Test
  void deepStubs() {
    ContactInformation contactInformation = Mockito.mock(ContactInformation.class, Answers.RETURNS_DEEP_STUBS);

    Mockito.when(contactInformation.getAddress().getCity()).thenReturn("Berlin");

    System.out.println(contactInformation.getAddress().getCity()); // Berlin
  }
}
