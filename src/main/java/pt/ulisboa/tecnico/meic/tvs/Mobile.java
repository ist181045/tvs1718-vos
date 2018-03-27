package pt.ulisboa.tecnico.meic.tvs;

import pt.ulisboa.tecnico.meic.tvs.exception.InvalidOperationException;
import pt.ulisboa.tecnico.meic.tvs.exception.InvalidPhoneNumberException;

class Mobile {

  /**
   * Creates a mobile with the specified phone number associated with the specified client.
   */
  Mobile(Client client, int phoneNumber) {
    // TODO: Implement stub method
  }

  /**
   * Turns on the mobile with both modes disabled.
   */
  void turnOn() throws InvalidOperationException {
    // TODO: Implement stub method
  }

  /**
   * Turns off the mobile.
   */
  void turnOff() throws InvalidOperationException {
    // TODO: Implement stub method
  }

  /**
   * Changes the silent mode of a turned on mobile.
   */
  void setSilentMode(boolean silentMode) throws InvalidOperationException {
    // TODO: Implement stub method
  }

  /**
   * Changes the friend mode of a turned on mobile.
   */
  void setFriendMode(boolean friendMode) throws InvalidOperationException {
    // TODO: Implement stub method
  }

  /**
   * Send an SMS message to the specified phone number.
   */
  void sendSMS(String smsMessage, int calledPhoneNumber)
      throws InvalidPhoneNumberException, InvalidOperationException {
    // TODO: Implement stub method
  }

  /**
   * Receives an SMS from the specified the phone number.
   */
  void receiveSMS(String smsMessage, int callerPhoneNumber) throws InvalidOperationException {
    // TODO: Implement stub method
  }

  /**
   * Makes a call to the specified phone number.
   */
  void makeCall(int calledPhoneNumber)
      throws InvalidPhoneNumberException, InvalidOperationException {
    // TODO: Implement stub method
  }

  /**
   * Accepts a phone call from a callerPhoneNumber
   */
  void acceptCall(int callerPhoneNumber) throws InvalidOperationException {
    // TODO: Implement stub method
  }

  /**
   * Returns a string describing the status of this mobile phone: turned off/on and silent/friend
   * mode.
   */
  String getStatus() {
    return "";
  }
}
