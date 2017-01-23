import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Fassade {
	Session session=null;
	Transaction tx=null;
	SessionFactory factory;
	
	public Fassade(){
		Configuration configuration = new Configuration();
		configuration.configure();
		factory = configuration.buildSessionFactory();
	}
	

	public boolean conection(){	
	 return session != factory.openSession();
	
	}
	
public void getAll(String tablename){//Class mitgeben, nicht void

	tx = session.beginTransaction();
	List<?> all = session.createQuery("from "+tablename).list();//class mit geben anstatt string
	//Person.class mitgeben
	for(Object p : all) {
		System.out.println(p.toString());
		}
	tx.commit();
}

public void sessionClose(){
	session.close();
}
public void connectionClose(){
	factory.close();
}
}


