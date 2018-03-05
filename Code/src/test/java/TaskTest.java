import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class TaskTest {

  @Test(timeout = 1000)
  public void testSetStaff() {
    Task task = new Task("TestTask", false, 1);
    Staff staff = new Staff("TestStaff");
    task.setStaff(staff);
    assertEquals(staff, task.getStaff());
  }

  @Test(timeout = 1000)
  public void testSetIsComplete() {
    Task task = new Task("TestTask", false, 1);
    task.setIsComplete();
    assertTrue(task.isComplete());
  }

  @Test(timeout = 1000)
  public void testAddPrerequisit() {
    Task task1 = new Task("TestTask1", false, 1);
    Task task2 = new Task("TestTask2", false, 1);
    task1.addPrerequisit(task2);
    if (task1.getPrerequisits().indexOf(task2) == -1) fail("Task not found in prerequisits");
  }

}
