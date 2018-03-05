public class Staff{

  private String name;
  private Task currentTask;
  private boolean isExpert;
  private String staffInitials;

  public Staff(String n){
    name = n;
    currentTask = null;
    isExpert = false;
    String[] names = n.split(" ");
    String staffFirstName = names[0];
    if (names.length > 1){
      String staffLastName = names[1];
      staffInitials = Character.toString(staffFirstName.charAt(0)) + Character.toString(staffLastName.charAt(0));
    }
  }

  public Staff(String n, boolean b){
    name = n;
    currentTask = null;
    isExpert = b;
    if(n.contains(" ")){
    	String[] names = n.split(" ");
        String staffFirstName = names[0];
        if (names.length > 1){
          String staffLastName = names[1];
          staffInitials = Character.toString(staffFirstName.charAt(0)) + Character.toString(staffLastName.charAt(0));
        }
    } else {
    	staffInitials = name.charAt(0) + Character.toString(' ');
    }
  }

  public void setCurrentTask(Task t){
    currentTask = t;
  }

  public void clearTask(){
    currentTask = null;
  }

  public void setIsExpert(boolean b){
    isExpert = b;
  }

  public String getName(){
    return name;
  }

  public boolean isExpert(){
    return isExpert;
  }

  public String getExpertLevel() {
    if (isExpert == false) return "Not an expert";
    else return "Is an expert";
  }

  public Task getCurrentTask() {
    return currentTask;
  }

  public String getStaffInitials() {
    return staffInitials;
  }

  @Override
  public String toString (){
    return name;
  }

}
