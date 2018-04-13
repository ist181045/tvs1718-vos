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

import java.util.ArrayList;
import java.util.List;
import pt.ulisboa.tecnico.meic.tvs.vos.exception.InvalidOperationException;
import pt.ulisboa.tecnico.meic.tvs.vos.exception.InvalidPhoneNumberException;

class Client {

  private final ArrayList<Integer> phoneNumbers;
  private final ArrayList<Mobile> mobiles;
  private final ArrayList<Integer> friends;
  private String name;
  private int nif;

  Client(String name, int nif, int phoneNumber) throws InvalidOperationException {
    setName(name);
    setNif(nif);
    phoneNumbers = new ArrayList<>();
    addPhoneNumber(phoneNumber);

    friends = new ArrayList<>();
    mobiles = new ArrayList<>();
  }

  /**
   * Returns the name of the client.
   */
  String getName() {
    return name;
  }

  /**
   * Sets the client's name.
   */
  void setName(String name) throws InvalidOperationException {
    if (name.length() < 5) {
      throw new InvalidOperationException();
    }
    this.name = name;
  }

  /**
   * Returns the client's nif.
   */
  int getNif() {
    return nif;
  }

  /**
   * Sets client's nif.
   */
  void setNif(int nif) throws InvalidOperationException {
    if (String.valueOf(nif).length() != 9) {
      throw new InvalidOperationException();
    }
    this.nif = nif;
  }

  /**
   * Returns the phone numbers assigned to this client.
   */
  List<Integer> getPhoneNumbers() {
    return phoneNumbers;
  }

  /**
   * Adds a new phone number to the client.
   */
  void addPhoneNumber(int phoneNumber) throws InvalidOperationException {
    if (phoneNumbers.size() >= 5) {
      throw new InvalidOperationException();
    }
    phoneNumbers.add(phoneNumber);
  }

  /**
   * Removes an existing phone number to the client.
   */
  void removePhoneNumber(int phoneNumber) throws InvalidOperationException {
    if (phoneNumbers.isEmpty() || friends.size() > (phoneNumbers.size() - 1) * 3 + 5) {
      throw new InvalidOperationException();
    }
    phoneNumbers.remove(phoneNumber);
  }

  /**
   * Return the list of registered friends.
   */
  List<Integer> getFriends() {
    return friends;
  }

  /**
   * Add a friend.
   */
  void addFriend(int phoneNumber) throws InvalidPhoneNumberException, InvalidOperationException {
    if (friends.size() == 3 * phoneNumbers.size() + 5) {
      throw new InvalidPhoneNumberException();
    }
    friends.add(phoneNumber);
  }

  /**
   * Remove a friend.
   */
  void removeFriend(int phoneNumber) throws InvalidOperationException {
    if (!friends.remove(new Integer(phoneNumber))) {
      throw new InvalidOperationException();
    }
  }

  /**
   * Returns the mobiles of this client.
   */
  List<Mobile> getMobiles() {
    return mobiles;
  }

  /**
   * Registers a phoneNumber of this client to a given type of mobile phone.
   */
  Mobile registerMobile(int phoneNumber) throws InvalidOperationException {
    if (!phoneNumbers.contains(phoneNumber)) {
      throw new InvalidOperationException();
    }

    Mobile mobile = new Mobile(this, phoneNumber);
    mobiles.add(mobile);
    return mobile;
  }

  /**
   * Unregisters the mobile phone associated with a phoneNumber.
   */
  void unregisterMobile(int phoneNumber) throws InvalidOperationException {
    Mobile mobile = new Mobile(this, phoneNumber);
    if (!mobiles.remove(mobile)) {
      throw new InvalidOperationException();
    }
  }
}
