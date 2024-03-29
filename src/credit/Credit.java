package credit;

public class Credit {

    private String bank;
    private int currentSum;
    private String creditName;
    private double percent;
    private int curr_term;
    private int termInMounths;
    private int maxSumOfCredit;

    @Override
    public String toString() {
        return  bank +" "+ creditName  +" "+ percent +
                "% yearly " + termInMounths +
                " monthes up to " + maxSumOfCredit +
                " UAH";
    }

    public Credit(String bank, String creditName, double percent, int termInMounths, int maxSumOfCredit) {
        setBank(bank);
        setCreditName(creditName);
        setPercent(percent);
        setTermInMounths(termInMounths);
        setMaxSumOfCredit(maxSumOfCredit);
        this.curr_term = 0;
    }

    public Credit() {
        setBank("unknown");
        setCreditName("unknown");
        setPercent(20.7);
        setTermInMounths(24);
        setMaxSumOfCredit(50000);
        this.curr_term = 0;
    }
    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
    public int getCurrentSum() {
        return currentSum;
    }

    public void setCurrentSum(int currentSum) throws Exception {
        if(currentSum <= maxSumOfCredit){
            this.currentSum = currentSum;
        }
        else throw new Exception();

    }

    public int changeCurrentSum(int sum){
        int newSum = getCurrentSum() + (int)(getCurrentSum() * getPercent()/ 100) - sum;
        return newSum;
    }

    public void payOff(int sum) throws Exception {
        setCurrentSum(changeCurrentSum(sum));
        curr_term++;
        if ((getCurrentSum() > 0) && (termInMounths - curr_term) <= 0) {
            System.out.println("you didn't repay the loan on time\n Your debt = " + getCurrentSum());
            percentRise();
            System.out.println("Your percent rised to " + getPercent() + "%");
        }
        else if ((getCurrentSum() <= 0) && (termInMounths - curr_term) == 0) {
            System.out.println("You are repay the loan on time");
        }
        else  if ((getCurrentSum() <= 0) && (termInMounths - curr_term) > 0)System.out.println("You are repay the loan earlier!");
    }

    public String getCreditName() {
        return creditName;
    }
    public double percentRise(){
        setPercent(getPercent() + getPercent()*0.1);
        double newPersent = getPercent();
        return newPersent;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public int getTermInMounths() {
        return termInMounths;
    }

    public void setTermInMounths(int termInMounths) {
        this.termInMounths = termInMounths;
    }

    public int getMaxSumOfCredit() {
        return maxSumOfCredit;
    }

    public void setMaxSumOfCredit(int maxSumOfCredit) {
        this.maxSumOfCredit = maxSumOfCredit;
    }
}
