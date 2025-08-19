import java.time.LocalDate;

public class Task {
	private String Name;
	private int ID;
	private LocalDate dueDate;
	private boolean isUrgent;
	private String category;
	private boolean isComplete;
	
	public Task(String Name, int ID, LocalDate dueDate, boolean isUrgent, String category) {
		setName(Name);
		setID(ID);
		setDueDate(dueDate);
		setUrgent(isUrgent);
		setCategory(category);
		this.isComplete = false;
	}

	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		
		this.dueDate = dueDate;
	}

	public boolean isUrgent() {
		return isUrgent;
	}

	public void setUrgent(boolean urgent) {
		this.isUrgent = urgent;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean complete) {
		this.isComplete = complete;
	}

	
	
}
