package pt.ulisboa.tecnico.meic.tvs;

import java.util.ArrayList;
import java.util.List;
import pt.ulisboa.tecnico.meic.tvs.exception.DuplicateNifException;
import pt.ulisboa.tecnico.meic.tvs.exception.InvalidOperationException;

class ClientManager {

  /**
   * Creates a new client of Vos and stores it. If phoneNumber is a number already assigned or it is
   * not valid, then InvalidOperationException is thrown. If there is already a registered client
   * with an identification number equal to nif, then the DuplicateNifException is thrown.
   */
  Client register(String clientName, int nif, int phoneNumber)
      throws DuplicateNifException, InvalidOperationException {
    // TODO: Implement stub method
    return new Client("", 0, 0);
  }

  /**
   * Returns the client with the desired NIF, null if not found.
   */
  Client getClient(int nif) {
    // TODO: Implement stub method
    return null;
  }

  /**
   * Assigns a free phone number of Vos to the client of Vos identified by nif. If it is not
   * possible to assign the phone number, then the InvalidOperationException is thrown.
   */
  final void assignPhoneNumber(int clientNif, int phoneNumber) throws InvalidOperationException {
    // TODO: Implement stub method
  }

  /**
   * Computes the bill of the client taking into account his communications.
   */
  float computeBill(Client client) {
    // TODO: Implement stub method
    return 0f;
  }

  /**
   * Returns the list of clients of Vos
   */
  List<Client> getClients() {
    // TODO: Implement stub method
    return new ArrayList<>();
  }
}
