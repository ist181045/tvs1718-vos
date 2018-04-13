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
