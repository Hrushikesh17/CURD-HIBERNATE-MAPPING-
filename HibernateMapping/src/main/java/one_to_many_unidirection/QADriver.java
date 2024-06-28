package one_to_many_unidirection;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class QADriver {
	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		
		//Create a Question
		
		Question q=new Question();
		q.setQ_name("What is java..?");
		q.setMarks(5);
		
		//Creating answer 1
		
		Answer a1=new Answer();
		a1.setA_name("High Level Language");
		
		//Creating answer 2
		
				Answer a2=new Answer();
				a2.setA_name("High Level Language");
				
		//Creating answer 1
				
				Answer a3=new Answer();
				a3.setA_name("Robust and Secure");
		
		//Storing all answers of a question in a list  		
		List<Answer>answers=new ArrayList<Answer>();
		answers.add(a1);
		answers.add(a2);
		answers.add(a3);
		//Setting to the list to the question
		q.setAnswers(answers);
		//Storing all object to Database
		transaction.begin();
		manager.persist(q);
		manager.persist(a1);
		manager.persist(a2);
		manager.persist(a3);
		transaction.commit();
		
		
	}
}
