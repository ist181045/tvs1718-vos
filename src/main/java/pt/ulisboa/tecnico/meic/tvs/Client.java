package pt.ulisboa.tecnico.meic.tvs;

import java.util.ArrayList;
import java.util.List;
import pt.ulisboa.tecnico.meic.tvs.exception.InvalidOperationException;
import pt.ulisboa.tecnico.meic.tvs.exception.InvalidPhoneNumberException;

class Client {

  Client(String name, int nif, int phoneNumber) {
    // TODO: Implement stub method
  }

  /**
   * Adds a new phone number to the client.
   */
  void addPhoneNumber(int phoneNumber) throws InvalidOperationException {
    // TODO: Implement stub method
  }

  /**
   * Removes an existing phone number to the client.
   */
  void removePhoneNumber(int phoneNumber) throws InvalidOperationException {
    // TODO: Implement stub method
  }

  /**
   * Registers a phoneNumber of this client to a given type of mobile phone.
   */
  Mobile registerMobile(int phoneNumber) throws InvalidOperationException {
    // TODO: Implement stub method
    return new Mobile(new Client("", 0, 0), 0);
  }

  /**
   * Unregisters the mobile phone associated with a phoneNumber.
   */
  void unregisterMobile(int phoneNumber) throws InvalidOperationException {
    // TODO: Implement stub method
  }

  /**
   * Returns the mobiles of this client.
   */
  List<Mobile> getMobiles() {
    // TODO: Implement stub method
    return new ArrayList<>();
  }

  /**
   * Returns the phone numbers assigned to this client.
   */
  List<Integer> getPhoneNumbers() {
    // TODO: Implement stub method
    return new ArrayList<>();
  }

  /**
   * Returns the name of the client.
   */
  String getName() {
    // TODO: Implement stub method
    return "";
  }

  /**
   * Return the list of registered friends.
   */
  List<Integer> getFriends() {
    // TODO: Implement stub method
    return new ArrayList<>();
  }

  /**
   * Add a friend.
   */
  void addFriend(int phoneNumber) throws InvalidPhoneNumberException {
    // TODO: Implement stub method
  }

  /**
   * Remove a friend.
   */
  void removeFriend(int phoneNumber) throws InvalidOperationException {
    // TODO: Implement stub method
  }
}
