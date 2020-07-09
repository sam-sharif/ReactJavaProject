package telus.server.exception;

public class ExceptionErrorResponse {
	private String projectIdentifier;

	public ExceptionErrorResponse() {
		super();
	}

	public ExceptionErrorResponse(String message) {
		super();
		this.projectIdentifier = message;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	
	

}
