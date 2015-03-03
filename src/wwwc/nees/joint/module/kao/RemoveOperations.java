package wwwc.nees.joint.module.kao;

import org.openrdf.model.Resource;
import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;

/**
 * @author Olavo
 */
public class RemoveOperations {

    /**
     * Removes the desired instance in the repository, passing the instance name
     *
     * @param ontologyURI
     * @param instanceName a <code>String</code> with the instance name.
     * @param connection an object representing the connection with the database
     * @param contexts an array of URIs that represent the contexts where
     * statements will be removed
     * @throws org.openrdf.repository.RepositoryException
     */
    public void remove(String ontologyURI, String instanceName, RepositoryConnection connection, URI... contexts)
            throws RepositoryException, Exception {

        ValueFactory f = connection.getValueFactory();
        // Creates the instance resource
        URI instance = f.createURI(ontologyURI + instanceName);
        connection.remove(instance, null, null, contexts);
        connection.remove((Resource) null, null, instance, contexts);
    }

    /**
     *
     * Removes the desired instance in the repository.
     *
     * @param <T>
     * @param instance an <code>Object</code> representing the instance.
     * @param connection an object representing the connection with the database
     * @param contexts an array of URIs that represent the contexts where
     * statements will be removed
     * @throws org.openrdf.repository.RepositoryException
     */
    public <T> void remove(T instance, RepositoryConnection connection, URI... contexts)
            throws RepositoryException, Exception {

        ValueFactory f = connection.getValueFactory();

        // Creates the instance resource
        URI instanceURI = f.createURI(instance.toString());

        connection.remove(instanceURI, null, null, contexts);
        connection.remove((Resource) null, null, instanceURI, contexts);
    }
}
