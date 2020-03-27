//Caleb Fox
// g00327455@gmit.ie
//Design principlas
// Implementation of single responsibilty principal
package ie.gmit.single;

public class UserPersistenceService {
    private Store store = new Store();

    public void saveUser(User user)
    {
        store.store(user);
    }
}
