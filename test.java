import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        Jobs jobs=new Jobs();
        System.out.println(jobs);
        try {
            jobs.addJob("hello");
            System.out.println(jobs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
        finally{
            System.out.println("Final");
        }
    }
}


public class Jobs{
    public List<String> jobList=new ArrayList<>();
    public void addJob(String job){
        this.jobList.add(job);
        System.out.println("Okay");
    }
    public List<String> getJobList() {
        return jobList;
    }

    public void setJobList(List<String> jobList) {
        this.jobList = jobList;
    }

    @Override
    public String toString() {
        return "Jobs [jobList=" + jobList + "]";
    }
    
    
}