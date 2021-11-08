package doselectpractice;

public class ExceptionProblem {

    public static void main(String[]  args){
        Source source = new Source();
        String msg=source.searchForJob(19,"B.A");
        System.out.println(msg);
    }

}

class Source {

    public String searchForJob(int age, String highestQualification) {
        try {
            if (age <= 0 || age >= 200) {
                throw new NotEligibleException("The age entered is not typical for a human being");
            }

            String prediction = CompanyJobPredictions.getJobPredictions(age, highestQualification);
            return prediction;
        } catch (NotEligibleException e) {
            return e.getMessage();
        }
    }
}

class CompanyJobPredictions {

    public static String getJobPredictions(int age, String highestQualification) throws NotEligibleException {
        if (age < 19) {
            throw new NotEligibleException("You are underage for any job");
        }

        if (age >= 19 &&
                !highestQualification.equalsIgnoreCase("B.E")
                && !highestQualification.equalsIgnoreCase("M.S")
                && !highestQualification.equalsIgnoreCase("Phd")) {
            throw new NotEligibleException("We do not have any job that matches your qualifications");
        }

        if (age >= 21 && highestQualification.equalsIgnoreCase("B.E")) {
            return "We have openings for junior developer";
        }

        if (age >= 26 && highestQualification.equalsIgnoreCase("M.S")) {
            return "We have openings for senior developer";
        }


        return "Sorry we have no openings for now";


    }


}

class NotEligibleException extends Exception {
    public NotEligibleException(String msg) {
        super(msg);
    }
}