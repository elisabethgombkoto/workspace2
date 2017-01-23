

public class MainHibernate {

	public static void main(String[] args) {
		
		Fassade fassade= new Fassade();
		
		fassade.conection();//anders lösen, connection sollte in if in get All aufgerufen werden oder bei get all ein session mitgeben was schon besteht mit geben
		fassade.getAll("Person");
		fassade.sessionClose();
		fassade.connectionClose();
		
//		Configuration configuration = new Configuration();
//		configuration.configure();
//		
////		StandardServiceRegistry serviceRegistry = new
////		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//		SessionFactory factory = configuration.buildSessionFactory();
//		Session session = null;
//		Transaction tx = null;
//		try {
//		session = factory.openSession();
//		tx = session.beginTransaction();
//		//session.Save(myObject);
//		
//		List<Person> persons = session.createQuery("from Person").list();
//		for(Person p : persons) {
//			System.out.println(p.toString());
//			
//	
//		}
//		tx.commit();
//		} catch(Exception ex) {
//		if(tx != null) tx.rollback();
//		} finally {
//		if(session != null) session.close();
//		}
}

}
