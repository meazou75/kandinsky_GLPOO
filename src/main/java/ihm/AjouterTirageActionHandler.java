package ihm;

import org.apache.log4j.Logger;
import dao.Tirage;
import model.ModeleDynamique;

public class AjouterTirageActionHandler implements ActionHandler {

	private static final Logger LOGGER = Logger.getLogger(AjouterTirageActionHandler.class);

	private ModeleDynamique modele;

	public AjouterTirageActionHandler(ModeleDynamique modele) {
		this.modele = modele;
	}

	@Override
	public void process(final Action action) throws TirageException {
		LOGGER.debug("process");
		process(action, null);
	}

	@Override
	public void process(final Action action, final Tirage tirage) throws TirageException {
		LOGGER.debug("process");

		switch (action) {

		case CREER:
			ajouter(tirage);
			break;

		default:
			throw new IllegalArgumentException("L'action demandee n'est pas disponible");
		}

	}

	private void ajouter(final Tirage tirage) throws TirageException {
		LOGGER.debug("Ajouter");

		if (!valider(tirage)) {
			// System.out.println("pas de bonnes valeurs pour le tirage");
		}

		// On a acces au modele et on peut donc demander l'ajout.
		modele.ajouterTirage(tirage);
	}

	private void annuler() {
		LOGGER.debug("Annuler");
		// Ici rien � faire
	}

	/**
	 * Valide que les attributs du chien sont bien renseignes.
	 */
	private boolean valider(final Tirage tirage) {

		return true;
	}

}
