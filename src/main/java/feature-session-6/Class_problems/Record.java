class Record {
    String studentName;
    String company;
    double packageLpa;

    Record(String name, String company, double pkg) {
        studentName = name;
        this.company = company;
        packageLpa = pkg;
    }

    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class Main {
    public static void main(String[] args) {

        Record[] records = {
            new Record("Ravi", "TCS", 4.5),
            new Record("Anitha", "Zoho", 6.2),
            new Record("Karthik", "Infosys", 4.0)
        };

        for (Record r : records) {
            r.printRecord();
        }
    }
}