package UnitTests;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Enum.DifficultyLevel;
import model.Answer;
import model.Question;
import model.SysData;

import java.util.ArrayList;

public class SysDataTest {
    private SysData sysData;
    private Question question;
 // "setup" method
    @Before
    public void setUp() {
        sysData = SysData.getInstance();
        ArrayList<Answer> answers=new ArrayList<Answer>();
       question = new Question(1,"Is Singlton consider as a disign pattern?",answers,DifficultyLevel.EASY,"SAFA");
    }
    @Test
    //id:15
    //check generation of two instance if they equal
    public void testGetInstance() {
        SysData instance1 = SysData.getInstance();
        SysData instance2 = SysData.getInstance();
        assertSame(instance1, instance2);
    }
    @Test
    //id:16
    //check adding question in sysData
    public void addQuestionTest() {
        sysData.addQuestion(question);
        ArrayList<Question> questions = sysData.getQuestions();
        assertTrue(questions.contains(question));
    }

    @After
 // reset the arraylist 
    public void tearDown() {
        sysData.setQuestions(new ArrayList<>());
    }
}

