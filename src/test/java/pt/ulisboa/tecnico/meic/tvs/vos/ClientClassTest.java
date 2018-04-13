/*
 * Copyright (c) 2018 Francisca Cambra, Rui Ventura
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package pt.ulisboa.tecnico.meic.tvs.vos;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pt.ulisboa.tecnico.meic.tvs.vos.exception.InvalidOperationException;

public class ClientClassTest {

  private static final String NAME_ON = "Kevin";
  private static final int NAME_ON_LENGTH = 5;
  private static final String NAME_OFF = "Mike";
  private static final int NAME_OFF_LENGTH = 4;

  private static final int NIF_LO_OFF = 100000000 - 1;
  private static final int NIF_LO_ON = 100000000;
  private static final int NIF_HI_OFF = 1000000000 - 1;
  private static final int NIF_HI_ON = 1000000000;

  private static final Integer[] PHONE_NUMBERS = new Integer[5];

  @BeforeMethod
  public void setUp() {
    for (int i = 0; i < PHONE_NUMBERS.length; i++) {
      PHONE_NUMBERS[i] = 910000000 + new Random().nextInt(90000000);
    }
  }

  @Test(testName = "TC01 -- name.length() == " + NAME_ON_LENGTH + " -- ctor")
  void testCase1a() throws Exception {
    Client client = new Client(NAME_ON, 100000001, PHONE_NUMBERS[0]);

    assertEquals(client.getName(), NAME_ON);
    assertEquals(client.getNif(), 100000001);
    assertEquals(client.getPhoneNumbers(), Collections.singletonList(PHONE_NUMBERS[0]));
    assertEquals(client.getMobiles(), Collections.emptyList());
    assertEquals(client.getFriends(), Collections.emptyList());
  }

  @Test(testName = "TC01 -- name.length() == " + NAME_ON_LENGTH + " -- setName")
  void testCase1b() throws Exception {
    Client client = new Client("Angela", 100000001, PHONE_NUMBERS[0]);

    client.addPhoneNumber(PHONE_NUMBERS[1]);
    client.setName(NAME_ON);
    assertEquals(client.getNif(), 100000001);
    assertEquals(client.getName(), NAME_ON);
    assertEquals(client.getPhoneNumbers().toArray(), Arrays.copyOfRange(PHONE_NUMBERS, 0, 2));
    assertEquals(client.getMobiles(), Collections.emptyList());
    assertEquals(client.getFriends(), Collections.emptyList());
  }

  @Test(testName = "TC02 -- name.length() == " + NAME_OFF_LENGTH + " -- ctor",
        expectedExceptions = InvalidOperationException.class)
  void testCase2a() throws Exception {
    new Client(NAME_OFF, 100000002, PHONE_NUMBERS[0]);
  }

  @Test(testName = "TC02 -- name.length() == " + NAME_OFF_LENGTH + " -- setName")
  void testCase2b() throws Exception {
    Client client = new Client("Watson", 100000002, PHONE_NUMBERS[0]);
    int friend = 900000000 + new Random().nextInt(100000000);

    for (int i = 0; i < 2; i++) {
      client.addPhoneNumber(PHONE_NUMBERS[i + 1]);
    }
    client.addFriend(friend);

    try {
      client.setName(NAME_OFF);
      fail();
    } catch (InvalidOperationException ioe) {
      assertEquals(client.getName(), "Watson");
      assertEquals(client.getNif(), 100000002);
      assertEquals(client.getMobiles(), Collections.emptyList());
      assertEquals(client.getPhoneNumbers().toArray(), Arrays.copyOfRange(PHONE_NUMBERS, 0, 3));
      assertEquals(client.getFriends(), Collections.singletonList(friend));
    }
  }

  @Test(testName = "TC03 -- nif == " + NIF_LO_ON + " -- ctor")
  void testCase3a() throws Exception {
    Client client = new Client("Pamela", NIF_LO_ON, PHONE_NUMBERS[0]);

    assertEquals(client.getNif(), NIF_LO_ON);
    assertEquals(client.getMobiles(), Collections.emptyList());
    assertEquals(client.getFriends(), Collections.emptyList());
    assertEquals(client.getName(), "Pamela");
    assertEquals(client.getPhoneNumbers(), Collections.singletonList(PHONE_NUMBERS[0]));
  }

  @Test(testName = "TC03 -- nif == " + NIF_LO_ON + " -- setNif")
  public void testCase3b() throws Exception {
    Client client = new Client("Pamela", 123456789, PHONE_NUMBERS[0]);
    List<Integer> friends = Arrays.stream(new Integer[2])
        .map(f -> 900000000 + new Random().nextInt(100000000))
        .collect(Collectors.toList());

    for (int i = 0; i < 3; i++) {
      client.addPhoneNumber(PHONE_NUMBERS[i + 1]);
    }
    for (Integer friend : friends) {
      client.addFriend(friend);
    }

    client.setNif(NIF_LO_ON);
    assertEquals(client.getNif(), NIF_LO_ON);
    assertEquals(client.getFriends(), friends);
    assertEquals(client.getName(), "Pamela");
    assertEquals(client.getMobiles(), Collections.emptyList());
    assertEquals(client.getPhoneNumbers().toArray(), Arrays.copyOfRange(PHONE_NUMBERS, 0, 4));
  }

  @Test(testName = "TC04 -- nif == " + NIF_LO_OFF + " -- ctor",
        expectedExceptions = InvalidOperationException.class)
  void testCase4a() throws Exception {
    new Client("Schrute", NIF_LO_OFF, PHONE_NUMBERS[0]);
  }

  @Test(testName = "TC04 -- nif == " + NIF_LO_OFF + " -- setNif")
  void testCase4b() throws Exception {
    Client client = new Client("Schrute", 123456789, PHONE_NUMBERS[0]);
    List<Integer> friends = Arrays.stream(new Integer[3])
        .map(f -> 900000000 + new Random().nextInt(100000000))
        .collect(Collectors.toList());

    for (int i = 0; i < 2; i++) {
      client.addPhoneNumber(PHONE_NUMBERS[i + 1]);
    }
    for (Integer friend : friends) {
      client.addFriend(friend);
    }

    try {
      client.setNif(NIF_LO_OFF);
      fail();
    } catch (InvalidOperationException ioe) {
      assertEquals(client.getMobiles(), Collections.emptyList());
      assertEquals(client.getName(), "Schrute");
      assertEquals(client.getNif(), 123456789);
      assertEquals(client.getPhoneNumbers().toArray(), Arrays.copyOfRange(PHONE_NUMBERS, 0, 3));
      assertEquals(client.getFriends(), friends);
    }
  }

  @Test(testName = "TC05 -- nif == " + NIF_HI_ON + " -- ctor",
        expectedExceptions = InvalidOperationException.class)
  void testCase5a() throws Exception {
    new Client("Mendeley", NIF_HI_ON, PHONE_NUMBERS[0]);
  }

  @Test(testName = "TC05 -- nif == " + NIF_HI_ON + " -- setNif")
  void testCase5b() throws Exception {
    Client client = new Client("Mendeley", 132659847, PHONE_NUMBERS[0]);
    List<Integer> friends = Arrays.stream(new Integer[4])
        .map(f -> 900000000 + new Random().nextInt(100000000))
        .collect(Collectors.toList());

    client.addPhoneNumber(PHONE_NUMBERS[1]);
    for (Integer friend : friends) {
      client.addFriend(friend);
    }

    try {
      client.setNif(NIF_HI_ON);
      fail();
    } catch (InvalidOperationException ioe) {
      assertEquals(client.getMobiles(), Collections.emptyList());
      assertEquals(client.getName(), "Mendeley");
      assertEquals(client.getFriends(), friends);
      assertEquals(client.getPhoneNumbers().toArray(), Arrays.copyOfRange(PHONE_NUMBERS, 0, 2));
      assertEquals(client.getNif(), 132659847);
    }
  }

  @Test(testName = "TC06 -- nif == " + NIF_HI_OFF + " -- ctor")
  void testCase6a() throws Exception {
    Client client = new Client("Charlotte", NIF_LO_ON, PHONE_NUMBERS[0]);

    assertEquals(client.getFriends(), Collections.emptyList());
    assertEquals(client.getName(), "Charlotte");
    assertEquals(client.getMobiles(), Collections.emptyList());
    assertEquals(client.getNif(), NIF_LO_ON);
    assertEquals(client.getPhoneNumbers(), Collections.singletonList(PHONE_NUMBERS[0]));
  }

  @Test(testName = "TC06 -- nif == " + NIF_HI_OFF + " -- setNif")
  public void testCase6b() throws Exception {
    Client client = new Client("Charlotte", 147258369, PHONE_NUMBERS[0]);
    List<Integer> friends = Arrays.stream(new Integer[5])
        .map(f -> 900000000 + new Random().nextInt(100000000))
        .collect(Collectors.toList());

    for (int i = 0; i < 2; i++) {
      client.addPhoneNumber(PHONE_NUMBERS[i + 1]);
    }
    for (Integer friend : friends) {
      client.addFriend(friend);
    }

    client.setNif(NIF_HI_OFF);
    assertEquals(client.getPhoneNumbers().toArray(), Arrays.copyOfRange(PHONE_NUMBERS, 0, 3));
    assertEquals(client.getFriends(), friends);
    assertEquals(client.getNif(), NIF_HI_OFF);
    assertEquals(client.getMobiles(), Collections.emptyList());
    assertEquals(client.getName(), "Charlotte");
  }

}
