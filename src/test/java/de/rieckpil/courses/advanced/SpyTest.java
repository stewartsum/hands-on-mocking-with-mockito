package de.rieckpil.courses.advanced;

import de.rieckpil.courses.BannedUsersClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class SpyTest {

  @Spy
  private BannedUsersClient bannedUsersClient;

  @Test
  void spies() {

    Mockito.when(bannedUsersClient.amountOfBannedAccounts()).thenReturn(500);

    System.out.println(bannedUsersClient.banRate()); // 42.42
    System.out.println(bannedUsersClient.amountOfBannedAccounts()); // 500
    System.out.println(bannedUsersClient.bannedUserId()); // [1, 2, 3]
  }

  @Test
  void spiesGotcha() {

    List spiedList = Mockito.spy(ArrayList.class);

    // Mockito.when(spiedList.get(0)).thenReturn("spy"); // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0

    Mockito.doReturn("spy").when(spiedList).get(0);

    System.out.println(spiedList.get(0)); // spy
    System.out.println(spiedList.get(1)); // java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 0
  }
}
