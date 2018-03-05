import java.util.Vector;

public class Project {

  private String projectName;
  private String projectManager;
  private Vector<Staff> staff = new Vector<Staff>();
  private Vector<Task> tasks = new Vector<Task>();
  private boolean isProjectComplete;
  private int projectDuration;
  private int daysActive;


  public Project(String projectName, String projectManager) {
    this.projectName = projectName;
    this.projectManager = projectManager;
    isProjectComplete = false;
  }

  public void elapseTime() {
    assignStaff();
    for (Task x : tasks){
      x.elapseTime();
    }
    daysActive++;
    isProjectComplete = true;
    for (Task t : tasks){
      if (!t.isComplete()) isProjectComplete = false;
    }
  }

  public void addStaff(Staff s){
    staff.add(s);
  }

  public void addTask(Task t){
    tasks.add(t);
  }

  public String printTasks() {
    String tasksToPrint = "";
    for (Task x : tasks) {
      tasksToPrint += x.toString();
    }

    return tasksToPrint;
  }

  public void assignStaff(){
    Vector<Staff> expertStaff = new Vector<Staff>();
    Vector<Staff> normalStaff = new Vector<Staff>();
    Vector<Task> readyTasks = new Vector<Task>();

    //task loop
    for (Task t : tasks){
      if (t.checkIsReadyToStart() && t.getStaff() == null) readyTasks.add(t);
      else if (t.checkIsReadyToStart() && t.getStaff().isExpert() == false){
        readyTasks.add(t);
        t.getStaff().clearTask();
        t.clearStaff();
      }
    }

    //staff loop
    for (Staff s : staff){
      if (s.isExpert() && s.getCurrentTask() == null) expertStaff.add(s);
      else if (s.isExpert() && s.getCurrentTask().isHard() == false) {
        expertStaff.add(s);
        s.clearTask();
      }
      else if (s.getCurrentTask() == null) normalStaff.add(s);
    }

    for (Task t : readyTasks){
      if (t.isHard() && expertStaff.size() > 0){
        t.setStaff(expertStaff.firstElement());
        expertStaff.remove(0);
      }
      else if (normalStaff.size() > 0) {
        t.setStaff(normalStaff.firstElement());
        normalStaff.remove(0);
      }
      else if (expertStaff.size() > 0){
        t.setStaff(expertStaff.firstElement());
        expertStaff.remove(0);
      }
    }
  }

  public void removeStaff(Staff s){
    staff.remove(s);
  }

  public String printProject() {
    String outputString = "Project: \n";
    
    outputString += "       |";
    for (Task t : tasks) {
      outputString += "  " + t.getName() + "   |";
    }
    outputString += "\n";
    for (int day = 1; !isProjectComplete; day++){
      elapseTime();
      if (day < 10) outputString += "Day 0" + day + ":|";
      else outputString += "Day " + day + ":|";
      for (Task t : tasks){
        if (t.getProgress() == 0.0) outputString += "           |";
        else if (t.isComplete() && !t.printed100()) {
          outputString += "  " + t.getCompletedByStaff().getStaffInitials() + "| " + (int)t.getProgress() + "% |";
          t.setPrinted100(true);
        }
        else if (t.isComplete() && t.printed100()) outputString += "           |";
        else if (t.getProgress() < 10) outputString += "  " + t.getStaff().getStaffInitials() + "| " + (int)t.getProgress() + "%   |";
        else if (t.getProgress() < 100) outputString += "  " + t.getStaff().getStaffInitials() + "| " + (int)t.getProgress() + "%  |";
        else outputString += "  " + t.getStaff().getStaffInitials() + "|" + (int)t.getProgress() + "%  |";
      }
      outputString += "\n";
    }
    return outputString;
  }

  public boolean isProjectComplete() {
    return isProjectComplete;
  }

  public String getProjectName() {
    return projectName;
  }

  public String getProjectManager() {
    return projectManager;
  }

  public Vector<Task> getTasks() {
    return tasks;
  }

  public Vector<Staff> getStaff(){
    return staff;
  }

  public String printStaff(){
    String staffList = "";
    for (Staff s : staff) if(s.getName() != staff.lastElement().getName()) {
    	staffList += s.getName() + ", ";
    } else {
    	staffList += s.getName() + ".";
    }
    return staffList;
  }

  @Override
  public String toString (){
    if (staff != null && tasks != null) return "Manager Name: " + projectManager + "\nCurrent Assigned Staff Members: " + printStaff() + "\nTasks Assigned: " + printTasks() + "\nCompletion Status: " + isProjectComplete() + "\n";
    else if (staff == null && tasks != null) return "Manager Name: " + projectManager + "\nTasks Assigned: " + printTasks() + "\nCompletion Status: " + isProjectComplete() + "\n";
    else if (staff != null && tasks == null) return "Manager Name: " + projectManager + "\nCurrent Assigned Staff Members: " + printStaff() + "\nCompletion Status: " + isProjectComplete() + "\n";
    else return "Manager Name: " + projectManager + "\nCompletion Status: " + isProjectComplete();
  }

}
