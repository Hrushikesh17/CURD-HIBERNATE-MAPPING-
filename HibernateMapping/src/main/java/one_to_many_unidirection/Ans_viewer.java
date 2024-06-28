package one_to_many_unidirection;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ans_viewer 
{
	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		
		Question q=manager.find(Question.class,2);
		if(q!=null)
		{
			System.out.println("----------------------");
			System.out.println(q.getQ_name()+"  Mark:-"+q.getMarks());
			System.out.println("-----------------------");
			
			List<Answer>answers=q.getAnswers();
			
			System.out.println("---------------");
			for(Answer a:answers)
			{
				System.out.println(a.getA_name());
			}
		}
	}
	
}
