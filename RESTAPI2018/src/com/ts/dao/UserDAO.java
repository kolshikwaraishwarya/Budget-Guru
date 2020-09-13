package com.ts.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rest.dto.Answers;
import com.rest.dto.Bills;
import com.rest.dto.EditAnswerDetails;
import com.rest.dto.EditQuestionDetails;
import com.rest.dto.Expenses;
import com.rest.dto.Income;
import com.rest.dto.PostDetails;
import com.rest.dto.Questions;
import com.rest.dto.Savings;
import com.rest.dto.User;
import com.rest.dto.YearlyTotal;
import com.sendemail.SendAnswerNotification;
import com.sendemail.SendMail;
import com.sendemail.SendUpdateNotification;
import com.ts.db.HibernateTemplate;

public class UserDAO {

	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}


	public void register() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = new User();
		user.setuId("A4s8ozRDx3eRTg2aYgJUZGUftiO2");
		user.setMonth("jan");
		user.setYear(2019);


		Savings savings = new Savings();
		savings.setUser(user);
		savings.setEmergencyFunds(123);
		savings.setInvestments(56);
		savings.setOthers(89);

		Income income = new Income();
		income.setUser(user);
		income.setGrants(56);
		income.setOthers(12);
		income.setRefunds(90);
		income.setSalary(23);




		Expenses expense = new Expenses();
		expense.setUser(user);
		expense.setClothing(23);
		expense.setEducation(45);
		expense.setFood(4567);
		expense.setHealth(34);
		expense.setHousehold(98970);
		expense.setMiscellaneous(4524);
		expense.setPersonal(2133);
		expense.setShelter(66);
		expense.setTransportation(654);



		Bills bill = new Bills();
		bill.setUser(user);
		bill.setEmailId("dholakiadivya@gmail.com");
		bill.setBillName("food");
		bill.setAmount(42523);
		bill.setDueDate("2-2-2");

		session.save(savings);
		session.save(income);
		session.save(expense);
		session.save(bill);

		session.getTransaction().commit();
		session.close();

	}



	public Savings getUserSavings(String uId, String month,int year){
		
		String queryString = "from Savings where uId = :uId and month = :month and year = :year";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("uId", uId);
		query.setString("month", month);
		query.setInteger("year", year);
		Object queryResult = query.uniqueResult();
		Savings s = (Savings)queryResult;
		System.out.println("Savings :" + s.getEmergencyFunds() + " " + s.getInvestments() + " " + s.getOthers());
		return s; 

	}

	public Expenses getUserExpenses(String uId,String month,int year){

		String queryString = "from Expenses where uId = :uId and month = :month and year = :year";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("uId", uId);
		query.setString("month", month);
		query.setInteger("year", year);
		Object queryResult = query.uniqueResult();
		Expenses exp = (Expenses)queryResult;
		System.out.println("Expenses : " + exp.getClothing() + " " + exp.getEducation() + " " + exp.getFood() + " " + exp.getHealth() + " " + exp.getHousehold());
		return exp; 

	}
	
	public Income getUserIncome(String uId,String month,int year){

		String queryString = "from Income where uId = :uId and month = :month and year = :year";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("uId", uId);
		query.setString("month", month);
		query.setInteger("year", year);
		Object queryResult = query.uniqueResult();
		Income income = (Income)queryResult;
		System.out.println("Income : " + income.getSalary() + " " + income.getOthers() + " " + income.getRefunds() + " " + income.getSalary());
		return income; 

	}



	public void saveSavings(Savings savings) {
		// TODO Auto-generated method stub
		System.out.println(savings.getUser().getuId() + " " + savings.getEmergencyFunds() + " " + savings.getInvestments()+ " " + savings.getOthers());
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(savings);
		session.getTransaction().commit();
		session.close();
		
	}



	public void saveIncome(Income income) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(income);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public void saveExpenses(Expenses expenses) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(expenses);
		session.getTransaction().commit();
		session.close();
		
	}



	public double calculateSavings(String uId, String month, int year) {
		// TODO Auto-generated method stub
		String queryString = "from Savings where uId = :uId and month = :month and year = :year";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("uId", uId);
		query.setString("month", month);
		query.setInteger("year", year);
		Object queryResult = query.uniqueResult();
		Savings s = (Savings)queryResult;
		double total_savings = s.getEmergencyFunds() + s.getInvestments() + s.getOthers();
		return total_savings;
	}



	public double calculateIncome(String uId, String month, int year) {
		// TODO Auto-generated method stub
		String queryString = "from Income where uId = :uId and month = :month and year = :year";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("uId", uId);
		query.setString("month", month);
		query.setInteger("year", year);
		Object queryResult = query.uniqueResult();
		Income income = (Income)queryResult;
		
		double total_income = income.getGrants() + income.getOthers() + income.getRefunds() + income.getSalary();
		return total_income;
	}



	public double calculateExpenses(String uId, String month, int year) {
		// TODO Auto-generated method stub
		String queryString = "from Expenses where uId = :uId and month = :month and year = :year";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("uId", uId);
		query.setString("month", month);
		query.setInteger("year", year);
		Object queryResult = query.uniqueResult();
		Expenses exp = (Expenses)queryResult;
		double total_expenses = exp.getClothing() + exp.getEducation() + exp.getFood() + exp.getHealth() + exp.getHousehold() + exp.getMiscellaneous() + exp.getPersonal() + exp.getShelter() + exp.getTransportation();
		
		return total_expenses;
	}



	public Bills getUserBills(String uId,String month,int year) {
		String queryString = "from Bills where uId = :uId and month = :month and year = :year";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("uId", uId);
		query.setString("month", month);
		query.setInteger("year", year);
		Object queryResult = query.uniqueResult();
		Bills bills = (Bills)queryResult;
		System.out.println("Bill Name : " + bills.getBillName() + " " + bills.getAmount() + " " + bills.getAmount());
		return bills; 
		
		// TODO Auto-generated method stub
	}
	public void saveBills(Bills bills) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(bills);
		session.getTransaction().commit();
		session.close();
		
	}



	public void postQuestion(Questions question) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(question);
		session.getTransaction().commit();
		session.close();
		
	}



	public List<Questions> getQuestions() {
		// TODO Auto-generated method stub
		String queryString = "from Questions";
		Query query = sessionFactory.openSession().createQuery(queryString);
		List<Questions> list = (List) query.list();
		System.out.println("got questions!");
		return list;
	}



	public void postAnswer(Answers answers) {
		// TODO Auto-generated method stub
		String queryString = "select question from Questions where questionId = :questionId";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setInteger("questionId", answers.getQuestionId());
		Object queryResult = query.uniqueResult();
		String question = (String)queryResult;
		System.out.println(question);
		
		
		SendAnswerNotification notification = new SendAnswerNotification();
		notification.sendNotification(answers.getEmail(),question);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(answers);
		session.getTransaction().commit();
		session.close();
		
		
		
		
	}



	public List<Answers> getAnswers(int questionId) {
		// TODO Auto-generated method stub
		String queryString = "from Answers where questionId = :questionId";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setInteger("questionId", questionId);
		List<Answers> list = (List) query.list();
		System.out.println("done!");
		return list;
		
		
		
		
	}



	public List<String> getMyQuestions(String email) {
		
		String queryString = "select question from Questions where email = :email";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("email", email);
		List<String> list = (List) query.list();
		System.out.println("got questions!");
		return list;
		
		// TODO Auto-generated method stub
		
	}



	public List<String> getMyAnswers(String email) {
		// TODO Auto-generated method stub
		String queryString = "select answer from Answers where post_email = :email";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("email", email);
		List<String> list = (List) query.list();
		System.out.println("got questions!");
		return list;
		
	}



	public void deleteQuestion(String question) {
		// TODO Auto-generated method stub
		String queryString = "from Questions where question = :question";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("question", question);
		Object queryResult = query.uniqueResult();
		Questions q = (Questions)queryResult;
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(q);
		session.getTransaction().commit();
		session.close();
		System.out.println("deleted successfully");
		
		
	}



	public void deleteAnswer(String answer) {
		// TODO Auto-generated method stub
		String queryString = "from Answers where answer = :answer";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("answer", answer);
		Object queryResult = query.uniqueResult();
		Answers ans = (Answers)queryResult;
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(ans);
		session.getTransaction().commit();
		session.close();
		System.out.println("deleted successfully");
		
		
	}



	public void updateQuestion(EditQuestionDetails editQuestionDetails) {
		// TODO Auto-generated method stub
		String queryString = "from Questions where question = :question";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("question", editQuestionDetails.getQuestion());
		Object queryResult = query.uniqueResult();
		Questions q = (Questions)queryResult;
		
		q.setQuestion(editQuestionDetails.getEditQuestion());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(q);
		session.getTransaction().commit();
		session.close();
		System.out.println("updated successfully");
		
		
		
	}
	
	public void updateAnswer(EditAnswerDetails editAnswerDetails) {
		// TODO Auto-generated method stub
		String queryString = "from Answers where answer = :answer";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("answer", editAnswerDetails.getAnswer());
		Object queryResult = query.uniqueResult();
		Answers ans = (Answers)queryResult;
		
		String email = ans.getEmail();
		String post_email = ans.getPost_email();
		int questionId = ans.getQuestionId();
		
		queryString = "select question from Questions where questionId = :questionId";
		query = sessionFactory.openSession().createQuery(queryString);
		query.setInteger("questionId", questionId);
		queryResult = query.uniqueResult();
		String question = (String)queryResult;
		
		SendUpdateNotification sendUpdateNotification = new SendUpdateNotification();
		sendUpdateNotification.sendNotificationForUpdateAnswer(email, question, post_email);
		
		ans.setAnswer(editAnswerDetails.getEditAnswer());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(ans);
		session.getTransaction().commit();
		session.close();
		System.out.println("updated successfully");
		
	}
	



	public List<String> getTitles() {
		// TODO Auto-generated method stub
		String queryString = "select distinct title from Questions order by title";
		Query query = sessionFactory.openSession().createQuery(queryString);
		List<String> list = (List) query.list();
		System.out.println("got titles!");
		return list;
		
		
	}



	public List<Questions> getQuestionsByTitle(String title) {
		
		String queryString = "from Questions where title = :title";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("title", title);
		List<Questions> list = (List) query.list();
		System.out.println("got questions!");
		return list;
		
		
		
	}



	
	



	






}

/*public List<Employee> getAllEmployees() {
List<Employee> employees=(List)HibernateTemplate.getObjectListByQuery("From Employee");
System.out.println("Inside All Employees ..."+employees);
return employees;	
}

public Employee getEmployee(int id) {
return (Employee)HibernateTemplate.getObject(Employee.class,id);
}


public void getEmployees(int deptId) {
String query= "from Employee where deptId = 1";
System.out.println("get employees is called...");
List<Object> obj = (List<Object>) HibernateTemplate.getObjectListByQuery(query);
System.out.println("Testing get employees :" + obj); 
for(Object emp: obj){
	Employee employee = (Employee)emp;
	System.out.println(employee.getEmpName());
}
}

public Employee getEmpByEmail(String email) {
return (Employee)HibernateTemplate.getObjectByEmail(email);
}*/


