import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StaffTest {

  @Test(timeout = 1000)
  public void testSetCurrentTask() {
    Staff staff = new Staff("TestStaff");
    Task task = new Task("TestTask", false, 1);
    staff.setCurrentTask(task);
    assertEquals(task, staff.getCurrentTask());
  }

  @Test(timeout = 1000)
  public void testSetCurrentTaskToSecondTask() {//task should not be set to a new task before the old one is cleared
    Staff staff = new Staff("TestStaff");
    Task task1 = new Task("TestTask", false, 1);
    staff.setCurrentTask(task1);
    Task task2 = new Task("TestTask", false, 1);
    task1.setStaff(staff);
    assertEquals(task1, staff.getCurrentTask());
  }

  @Test(timeout = 1000)
  public void testClearTask(){
    Staff staff = new Staff("TestStaff");
    Task task = new Task("TestTask", false, 1);
    staff.setCurrentTask(task);
    staff.clearTask();
    assertEquals(null, staff.getCurrentTask());
  }

  @Test(timeout = 1000)
  public void testSetExpert(){
    Staff staff = new Staff("TestStaff", false);
    staff.setIsExpert(true);
    assertEquals(true, staff.isExpert());
  }

}
