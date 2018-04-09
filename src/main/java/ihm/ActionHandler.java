package ihm;

import dao.Tirage;

public interface ActionHandler {

	void process(final Action action) throws TirageException;

	void process(final Action action, final Tirage tirage) throws TirageException;

}
