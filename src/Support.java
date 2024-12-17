import java.util.Date;

public class Support {
    private String ticketID;
    private String userID;
    private String problemScript;
    private String status;
    private Date creationDate;
    private Date resolutionDate;
    private String comments;// комменты от поддержки
    private String supTelNumber;
    private String email;

    public Support(String ticketID, String userID, String problemScript, String status, Date creationDate, String comments, Date resolutionDate, String supTelNumber, String eMail) {
        this.ticketID = ticketID;
        this.userID = userID;
        this.problemScript = problemScript;
        this.status = "Open"; //открыт по умолчанию
        this.creationDate = new Date();
        this.resolutionDate = resolutionDate;
        this.supTelNumber = supTelNumber;
        this.email = email;
        this.comments = "";
    }

    public String getTicketID() {return ticketID;}
    public void setTicketID() {this.ticketID=ticketID;}
    public String getUserID() {return userID;}
    public void setUserID() {this.userID=userID;}

    public String getProblemScript() {return problemScript;}
    public void setProblemScript() {this.problemScript=problemScript;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public void setCreationDate(Date creationDate) {this.creationDate = creationDate;}

    public void setResolutionDate(Date resolutionDate) {this.resolutionDate = resolutionDate;}

    public Date getCreationDate() {return creationDate;}

    public Date getResolutionDate() {return resolutionDate;}
    public void callSupport() {
        System.out.println("Call to support by number: " + supTelNumber);}
    public void sendEmail(String message) {
        System.out.println("If you still have questions, write on email: " + email + "\nMessage" + message);
    }

    public String getComments() {return comments;}
    public void addComments() {this.comments+=comments+ "\n";}
    public void closeTicket() {
        this.status = "closed";
        this.resolutionDate = new Date();
    }

        public String displayTicketInfo() {
        return "Support{" +
                "Request ID'" + ticketID + '\'' +
                "User ID: " + userID + '\'' +
                ", Problem description='" + problemScript + '\'' +
                ", Status='" + status + '\'' +
                ", Date of creation=" + creationDate +
                ", Date of authorization=" + (resolutionDate !=null ? resolutionDate: "not resolved yet") +
                ", Comments='" + comments + '\'' +
                ", Support tel.number='" + supTelNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
