



public class Job 
{
    private String title, company, location, description;
    private int hasApplied;

    public Job(String titleIn, String companyIn, 
        String locationIn, String descriptionIn)
    {
        title = titleIn;
        company = companyIn;
        location = locationIn;
        description = descriptionIn;
        hasApplied = 0;
    }


    public void setHasApplied()
    {
        this.hasApplied = 1;
    }
}