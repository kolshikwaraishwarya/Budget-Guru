package com.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.dto.Answers;
import com.rest.dto.Bills;
import com.rest.dto.EditAnswerDetails;
import com.rest.dto.EditQuestionDetails;
import com.rest.dto.Expenses;
import com.rest.dto.Income;
import com.rest.dto.PostDetails;
import com.rest.dto.Questions;
import com.rest.dto.Savings;
import com.rest.dto.Total;
import com.rest.dto.User;
import com.rest.dto.YearlyTotal;
import com.sendemail.SendMail;
import com.ts.dao.UserDAO;
@Path("myresource1")
public class MyResource1 {
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    @Path("regUser")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String daoTest() {
    	
    	UserDAO userDao = new UserDAO();
    	userDao.register();
    	return "Success";
    }
    
    @Path("getUserSavings/{uId}/{month}/{year}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Savings getUserSavings(@PathParam("uId")String uId,@PathParam("month") String month,@PathParam("year") int year){
    	UserDAO userDao = new UserDAO();
    	System.out.println(uId + " " + month + " " + year);
    	Savings savings = userDao.getUserSavings(uId, month, year);
    	return savings;
    }
    
    @Path("getUserBills/{uId}/{month}/{year}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Bills getUserBills(@PathParam("uId")String uId,@PathParam("month") String month,@PathParam("year") int year){
    	UserDAO userDao = new UserDAO();
    	System.out.println(uId + " " + month + " " + year);
    	Bills bills = userDao.getUserBills(uId, month, year);
    	return bills;
    }
    
    @Path("getUserExpenses/{uId}/{month}/{year}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Expenses getUserExpenses(@PathParam("uId")String uId,@PathParam("month") String month,@PathParam("year") int year){
    	UserDAO userDao = new UserDAO();
    	return userDao.getUserExpenses(uId, month, year);
    	
    }
    
    
    @Path("getUserIncome/{uId}/{month}/{year}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Income getUserIncome(@PathParam("uId")String uId,@PathParam("month") String month,@PathParam("year") int year){
    	UserDAO userDao = new UserDAO();
    	return userDao.getUserIncome(uId, month, year);
    	
    }
    
    @Path("/saveSavings")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveSavings(Savings savings){
    	System.out.println("hi");
    	UserDAO userDao = new UserDAO();
    	userDao.saveSavings(savings);
    	System.out.println("done!");
    	
    }
    
    @Path("/saveBills")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveBills(Bills bills){
    	System.out.println("hi");
    	UserDAO userDao = new UserDAO();
    	userDao.saveBills(bills);
    	System.out.println("done!");
    	SendMail sendMail = new SendMail();
    	sendMail.sendReminder(bills);
    }
    
    @Path("/saveIncome")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveIncome(Income income){
    	System.out.println("hi");
    	UserDAO userDao = new UserDAO();
    	userDao.saveIncome(income);
    	System.out.println("done!");
    }
    
    @Path("/saveExpenses")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveExpenses(Expenses expenses){
    	
    	UserDAO userDao = new UserDAO();
    	userDao.saveExpenses(expenses);
    	
    }
    
    @Path("calculateBudget/{uId}/{month}/{year}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Total calculateBudget(@PathParam("uId")String uId,@PathParam("month") String month,@PathParam("year") int year){
    	UserDAO userDao = new UserDAO();
    	double savings = userDao.calculateSavings(uId, month, year);
    	double income = userDao.calculateIncome(uId, month, year);
    	double expenses = userDao.calculateExpenses(uId, month, year);
    	Total total = new Total();
    	total.setTotal_savings(savings);
    	total.setTotal_income(income);
    	total.setTotal_expenses(expenses);
    	return total;
    	
    }
    
    @Path("getYearlyAnalysis/{uId}/{year}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public YearlyTotal getYearlyAnalysis(@PathParam("uId")String uId,@PathParam("year") int year){
    	System.out.println(uId);
    	System.out.println(year);
    	UserDAO userDao = new UserDAO();
    	YearlyTotal yearlyTotal = new YearlyTotal();
    	
    	
    	
    	//jan
    	double totalExpenses1 = userDao.calculateExpenses(uId, "jan", year);
    	double totalIncome1 = userDao.calculateIncome(uId, "jan", year);
    	double totalSavings1 = userDao.calculateSavings(uId, "jan", year);
    	Total total1 = new Total();
    	total1.setTotal_expenses(totalExpenses1);
    	total1.setTotal_income(totalIncome1);
    	total1.setTotal_savings(totalSavings1);
    	yearlyTotal.setJan(total1);
    	
    	
    	//feb
    	double totalExpenses2 = userDao.calculateExpenses(uId, "feb", year);
    	double totalIncome2 = userDao.calculateIncome(uId, "feb", year);
    	double totalSavings2 = userDao.calculateSavings(uId, "feb", year);
    	Total total2 = new Total();
    	total2.setTotal_expenses(totalExpenses2);
    	total2.setTotal_income(totalIncome2);
    	total2.setTotal_savings(totalSavings2);
    	yearlyTotal.setFeb(total2);
    	
    	
    	//march
    	double totalExpenses3 = userDao.calculateExpenses(uId, "mar", year);
    	double totalIncome3 = userDao.calculateIncome(uId, "mar", year);
    	double totalSavings3 = userDao.calculateSavings(uId, "mar", year);
    	Total total3 = new Total();
    	total3.setTotal_expenses(totalExpenses3);
    	total3.setTotal_income(totalIncome3);
    	total3.setTotal_savings(totalSavings3);
    	yearlyTotal.setMar(total3);
    	
    	
    	//april
    	double totalExpenses4 = userDao.calculateExpenses(uId, "apr", year);
    	double totalIncome4 = userDao.calculateIncome(uId, "apr", year);
    	double totalSavings4 = userDao.calculateSavings(uId, "apr", year);
    	Total total4 = new Total();
    	total4.setTotal_expenses(totalExpenses4);
    	total4.setTotal_income(totalIncome4);
    	total4.setTotal_savings(totalSavings4);
    	yearlyTotal.setApr(total4);    	
    	
    	
    	//may
    	double totalExpenses5 = userDao.calculateExpenses(uId, "may", year);
    	double totalIncome5 = userDao.calculateIncome(uId, "may", year);
    	double totalSavings5 = userDao.calculateSavings(uId, "may", year);
    	Total total5 = new Total();
    	total5.setTotal_expenses(totalExpenses5);
    	total5.setTotal_income(totalIncome5);
    	total5.setTotal_savings(totalSavings5);
    	yearlyTotal.setMay(total5);    
    	
    	
    	//june
    	double totalExpenses6 = userDao.calculateExpenses(uId, "june", year);
    	double totalIncome6 = userDao.calculateIncome(uId, "june", year);
    	double totalSavings6 = userDao.calculateSavings(uId, "june", year);
    	Total total6 = new Total();
    	total6.setTotal_expenses(totalExpenses6);
    	total6.setTotal_income(totalIncome6);
    	total6.setTotal_savings(totalSavings6);
    	yearlyTotal.setJune(total6); 
    	
    	
    	//july
    	double totalExpenses7 = userDao.calculateExpenses(uId, "july", year);
    	double totalIncome7 = userDao.calculateIncome(uId, "july", year);
    	double totalSavings7 = userDao.calculateSavings(uId, "july", year);
    	Total total7 = new Total();
    	total7.setTotal_expenses(totalExpenses7);
    	total7.setTotal_income(totalIncome7);
    	total7.setTotal_savings(totalSavings7);
    	yearlyTotal.setJuly(total7);
    	
    	
    	//august
    	double totalExpenses8 = userDao.calculateExpenses(uId, "aug", year);
    	double totalIncome8 = userDao.calculateIncome(uId, "aug", year);
    	double totalSavings8 = userDao.calculateSavings(uId, "aug", year);
    	Total total8 = new Total();
    	total8.setTotal_expenses(totalExpenses8);
    	total8.setTotal_income(totalIncome8);
    	total8.setTotal_savings(totalSavings8);
    	yearlyTotal.setAug(total8);    	
    	
    	
    	//september
    	double totalExpenses9 = userDao.calculateExpenses(uId, "sept", year);
    	double totalIncome9 = userDao.calculateIncome(uId, "sept", year);
    	double totalSavings9 = userDao.calculateSavings(uId, "sept", year);
    	Total total9 = new Total();
    	total9.setTotal_expenses(totalExpenses9);
    	total9.setTotal_income(totalIncome9);
    	total9.setTotal_savings(totalSavings9);
    	yearlyTotal.setSept(total9);    	
    	
    	//october
    	double totalExpenses10 = userDao.calculateExpenses(uId, "oct", year);
    	double totalIncome10 = userDao.calculateIncome(uId, "oct", year);
    	double totalSavings10 = userDao.calculateSavings(uId, "oct", year);
    	Total total10 = new Total();
    	total10.setTotal_expenses(totalExpenses10);
    	total10.setTotal_income(totalIncome10);
    	total10.setTotal_savings(totalSavings10);
    	yearlyTotal.setOct(total10);    	
    	
    	//november
    	double totalExpenses11 = userDao.calculateExpenses(uId, "nov", year);
    	double totalIncome11 = userDao.calculateIncome(uId, "nov", year);
    	double totalSavings11 = userDao.calculateSavings(uId, "nov", year);
    	Total total11 = new Total();
    	total11.setTotal_expenses(totalExpenses11);
    	total11.setTotal_income(totalIncome11);
    	total11.setTotal_savings(totalSavings11);
    	yearlyTotal.setNov(total11);    	
    	
    	
    	//december
    	double totalExpenses12 = userDao.calculateExpenses(uId, "dec", year);
    	double totalIncome12 = userDao.calculateIncome(uId, "dec", year);
    	double totalSavings12 = userDao.calculateSavings(uId, "dec", year);
    	Total total12 = new Total();
    	total12.setTotal_expenses(totalExpenses12);
    	total12.setTotal_income(totalIncome12);
    	total12.setTotal_savings(totalSavings12);
    	yearlyTotal.setDec(total12);  
    	
		return yearlyTotal;
    	
    	
    	
    }
    
    @Path("/postQuestion")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(Questions question){
    	UserDAO userDao = new UserDAO();
    	userDao.postQuestion(question);
    }
    
    @Path("getQuestions")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Questions> getQuestions(){
    	UserDAO userDao = new UserDAO();
    	
		return userDao.getQuestions();
    	
    }
    
    @Path("/postAnswer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postAnswer(Answers answers){
    	UserDAO userDao = new UserDAO();
    	
    	userDao.postAnswer(answers);
   
    }
    
    @Path("getAnswers/{questionId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Answers> getAnswers(@PathParam("questionId")int questionId) {
    	System.out.println(questionId);
    	UserDAO userDao = new UserDAO();
    	return userDao.getAnswers(questionId);
    }
    
    @Path("getMyQuestions/{email}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<String> getMyQuestions(@PathParam("email")String email){
    	UserDAO userDao = new UserDAO();
    	return userDao.getMyQuestions(email);
    }
    
    @Path("getMyAnswers/{email}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getMyAnswers(@PathParam("email")String email){
    	UserDAO userDao = new UserDAO();
    	return userDao.getMyAnswers(email);
    }
    
    @Path("deleteQuestion/{question}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteQuestion(@PathParam("question")String question) {
    	question += "?";
    	System.out.println(question);
    	
    	UserDAO userDao = new UserDAO();
    	userDao.deleteQuestion(question);
    }
	
    
    @Path("deleteAnswer/{answer}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteAnswer(@PathParam("answer")String answer) {
    	System.out.println(answer);
    	
    	UserDAO userDao = new UserDAO();
    	userDao.deleteAnswer(answer);
    }
	
    @Path("/updateQuestion")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateQuestion(EditQuestionDetails editQuestionDetails){
    	
    	UserDAO userDao = new UserDAO();
    	userDao.updateQuestion(editQuestionDetails);
    }
    
    @Path("/updateAnswer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAnswer(EditAnswerDetails editAnswerDetails){
    	UserDAO userDao = new UserDAO();
    	userDao.updateAnswer(editAnswerDetails);
    	
    }
    
    
    
    @Path("getTitles")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getTitles(){
    	UserDAO userDao = new UserDAO();
    	return userDao.getTitles();
    }
    
    @Path("getQuestionsByTitle/{questionTitle}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Questions> getQuestionsByTitle(@PathParam("questionTitle")String title){
    	System.out.println(title);
    	UserDAO userDao = new UserDAO();
    	
    	return userDao.getQuestionsByTitle(title);
    }
    
}
