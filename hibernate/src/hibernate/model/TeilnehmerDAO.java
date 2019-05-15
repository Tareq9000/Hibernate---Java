package hibernate.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.List;

import hibernate.model.Teilnehmer;

/**
 * Kommentar block;
 * 
 * @author Felix Hüsler
 * @Date 5.4.2019
 * @version Version 1.0
 */
public class TeilnehmerDAO {

	/**
	 * Description This class should give Mehtods for actions with Databases! These
	 * are invert, delete, update, select
	 **/
	public TeilnehmerDAO() {
	}

	private EntityManagerFactory getEntityManagerFactory() {
		EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("kursverwaltung.jpa");
		return sessionFactory;
	}

	public void insertPayment(Teilnehmer teilnehmer) { // Hinzufügen eines Datensatzes
		EntityManager entityManager = getEntityManagerFactory().createEntityManager();// Datenbank festlegen
		entityManager.getTransaction().begin();// Verbindung herstellen
		entityManager.persist(teilnehmer);// Statment schreiben
		entityManager.getTransaction().commit();// Statement ausführen
		entityManager.close();// Verbingun schliesenn
	}

	public void removePayment(Teilnehmer teilnehmer) { // Löschen des angegebenen Datensatzes
		EntityManager entityManager = getEntityManagerFactory().createEntityManager();// Datenbank festlegen
		entityManager.getTransaction().begin();// Verbindung herstellen
		entityManager.remove(teilnehmer);// Statement schreiben
		entityManager.getTransaction().commit();// Statement ausführen
		entityManager.close();
	}

	public void updatePayment(Teilnehmer teilnehmer) { // Aktualisieren von Payment mit gegebener ID
		EntityManager entityManager = getEntityManagerFactory().createEntityManager();// Datenbank festlegen
		entityManager.getTransaction().begin();// Verbindung herstellen
		entityManager.find(Teilnehmer.class, teilnehmer.getIdTeilnehmer());// Datensatz finden/altes payment
																			// überschreiben!!
		entityManager.merge(teilnehmer);// Statement schreiben
		entityManager.getTransaction().commit();// Statement ausführen
		entityManager.close();// Verbingun schliesenn
	}

	public List<Teilnehmer> selectall() { // Darstellen der Daten
		EntityManager entityManager = getEntityManagerFactory().createEntityManager();// Datenbank festlegen
		Query query = entityManager.createNativeQuery("SELECT * FROM Teilnehmer", Teilnehmer.class);
		List list = query.getResultList();

		return list;

	}

	public static void tnraus(List<Teilnehmer> list, Teilnehmer teilnehmer) {

		for (int i = 0; i < list.size(); i++) {
			teilnehmer = list.get(i);
			System.out.println("Person  :   " + teilnehmer.getVorname() + "  " + teilnehmer.getName());

		}

	}

	public static void main(String[] args) {

		Teilnehmer t = new Teilnehmer("Tareq", "Kattit", "Applikationsentwicklung", "kattitt@bzz.ch", "3002044",
				"dkfjdlk"); // Daten definieren
		TeilnehmerDAO tDao = new TeilnehmerDAO(); // Instanz bilden -> Nutzen
//		tDao.insertPayment(t);;
//		tDao.updatePayment(t);
//		tDao.removePayment(t);
		List<Teilnehmer> tlist = tDao.selectall();
		tnraus(tlist,t);
	}

}
