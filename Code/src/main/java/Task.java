import java.util.Vector;
import java.lang.Math;

public class Task{

  private String name;
  private boolean isHard; //if true, experts will complete faster (2x)
  private double time; //estimate, input by manager
  private Staff staff;
  private Vector<Task> prerequisits = new Vector<Task>();
  private boolean isComplete;
  private boolean isReadyToStart;
  private boolean isActive;
  private double progress;
  private int daysActive;//days it has been worked on
  private boolean printed100;
  private Staff completedByStaff;


  public Task(String n, boolean h, int t) {
    name = n;
    isHard = h;
    time = t;
    daysActive = 0;
    progress = 0.0;
    isActive = false;
    isComplete = false;
    isReadyToStart = false;
    printed100 = false;
  }

  public void elapseTime() {//progresses task at the end of each day
    if (checkIsReadyToStart() && staff != null){
      checkIsReadyToStart();

      if (staff.isExpert() && isHard)  progress = progress + 200/time;//progress doubled if expert assigned to hard task
      else progress = progress + 100/time;

      if (progress >= 100) {
        progress = 100;
        isComplete = true;
        completedByStaff = staff;
        staff.clearTask();
        staff = null;
        isActive = false;
      }
      daysActive++;
    }
  }


  public void setStaff(Staff s){
    if (staff != null){
      staff.clearTask();
    }
    staff = s;
    staff.setCurrentTask(this);
    isActive = true;
  }

  public void setIsComplete(){
    isComplete = true;
  }

  public boolean isComplete(){
    return isComplete;
  }

  public void addPrerequisit(Task t){
    prerequisits.add(t);
    checkIsReadyToStart();
  }

  public Vector<Task> getPrerequisits(){
    return prerequisits;
  }

  public boolean checkIsReadyToStart(){
    isReadyToStart = true;
    for (Task t : prerequisits){
      if (!t.isComplete) {
        isReadyToStart = false;
      }
    }
    if (isComplete) isReadyToStart = false;
    return isReadyToStart;
  }

  public void clearStaff() {
    if (staff != null) staff.clearTask();
    staff = null;
  }

  public String getName() {
    return name;
  }

  public void setPrinted100(boolean b){
    printed100 = b;
  }

  public Staff getStaff() {
    return staff;
  }

  public double getProgress() {
    return progress;
  }

  public int getDaysActive() {
    return daysActive;
  }

  public boolean isActive(){
    return isActive;
  }

  public boolean isHard() {
    return isHard;
  }

  public boolean printed100(){
    return printed100;
  }

  public Staff getCompletedByStaff(){
    return completedByStaff;
  }

  @Override
  public String toString(){
    return name;
  }

}
