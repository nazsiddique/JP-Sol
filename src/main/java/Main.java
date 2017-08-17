import model.Instruction;
import model.InstructionTypeEnum;
import model.Report;
import model.TestDataGenerator;

import java.util.List;

/**
 *
 */
public class Main {


    public static void main(String[] args) {

        // Generate data
        List<Instruction> list = TestDataGenerator.invoke();


        // create report object and pass the list to produce result
        Report r = new Report(list);

        // just to print list data
      //  r.print();


        // print incoming for the current day
        System.out.println(r.getDailyReport(InstructionTypeEnum.BUY));

        // print incoming rating for the current day against Instruction
        r.processDailyRating(InstructionTypeEnum.BUY);

        // print outgoing for the current day
        System.out.println(r.getDailyReport(InstructionTypeEnum.SELL));

        // print outgoing rating for the current day against Instruction

        r.processDailyRating(InstructionTypeEnum.SELL);




    }


}
