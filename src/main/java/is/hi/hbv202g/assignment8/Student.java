package is.hi.hbv202g.assignment8;

/**
 * Represents a student user in the library system.
 * A student user has a name and information about whether they have paid the fee.
 */
public class Student extends User {

  private boolean feePaid;

  /**
   * Creates a new student with the specified name and fee payment status.
   * 
   * @param name The name of the student
   * @param feePaid Whether the student has paid the library fee
   */
  public Student(String name, boolean feePaid){
    super(name);
    this.feePaid = feePaid;
  }

  /**
   * Checks if the student has paid the fee.
   * 
   * @return true if the fee is paid, false otherwise
   */
  public boolean isFeePaid() {
    return feePaid;
  }

  /**
   * Sets the fee payment status for the student.
   * 
   * @param feePaid true if the fee is paid, false otherwise
   */
  public void setFeePaid(boolean feePaid) {
    this.feePaid = feePaid;
  }

}
