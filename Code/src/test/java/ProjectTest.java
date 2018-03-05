import org.junit.Test;
import static org.junit.Assert.*;


public class ProjectTest {

  @Test(timeout = 1000)
  public void testAddStaff(){
    Project project = new Project("Test Project", "Test Manager");
    Staff staff = new Staff("Test Staff");
    project.addStaff(staff);
    if (project.getStaff().indexOf(staff) == -1) fail("Staff not found");
  }

  @Test(timeout = 1000)
  public void testAddTask(){
    Project project = new Project("Test Project", "Test Manager");
    Task task = new Task("Test task", false, 1);
    project.addTask(task);
    if (project.getTasks().indexOf(task) == -1) fail("Task not found");
  }

}
