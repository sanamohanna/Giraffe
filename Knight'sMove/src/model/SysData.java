package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.json.JSONObject;

public class SysData {
 
	private HashMap<Integer, Game> games;
	private HashMap<Integer, Question> questions;
	
	public void Initiate() {
		
	}
	public void	loadData() {
		
	}
	public void	writeData(){
		
	}
	public void	loadQuestions(){
		
	}
	public void	writeQuestions(Question ques)  {
		JSONObject questionDetails = new JSONObject();
		  
	        questionDetails.put("question", ques.getContext());
	        questionDetails.put("answers", ques.getAnswers());
	        questionDetails.put("correct_ans", ques.getCorrectAnswer());
	        questionDetails.put("level", ques.getCorrectAnswer());
	        questionDetails.put("team", ques.getTeam());
	        
	        JSONObject questionObject = new JSONObject(); 
	        questionObject.put("question", questionDetails);
	     
	        //Write JSON file
	        try (FileWriter file = new FileWriter("QuestionsAndAnswers.json")) {
	            //We can write any JSONArray or JSONObject instance to the file
	            file.write(questionObject.toString()); 
	            file.flush();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	   }
		
	
	public void	updateQuesthion() {
		
	}
	public void	addQuestion() {
		
	}
	public void	removeQuestion () {
		
	}
	public void addGame(){
		
	}
}
