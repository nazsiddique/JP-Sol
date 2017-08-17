package model;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Generate result for daily data
 */
public class Report {

    private List<Instruction> list;

    /**
     * Constructor take date to process
     *
     * @param list list need to process
     */
    public Report(List<Instruction> list) {
        this.list = list;
    }

    /**
     * produce daily report based on type (buy/sell)
     *
     * @param instructionType InstructionType (buy/sell)
     * @return string with daily result
     */
    public String getDailyReport(InstructionTypeEnum instructionType) {
        Double total = 0.0;
        LocalDate date = LocalDate.now();
        String flag = "incoming";
        for (Instruction curr : list) {
            if (curr.getSettlementDate().equals(date) && curr.getInstructionType().is(instructionType)) {

                total += curr.getAmount();
                if (curr.getInstructionType().is(InstructionTypeEnum.BUY)) {
                    flag = "outgoing";
                }
            }
        }

        return String.format("Amount in USD settled %s %s  is  : %s", flag, date.toString(), total);
    }

    /**
     * produce daily rating list based on type (buy/sell)
     *
     * @param instructionType InstructionType (buy/sell)
     * @return list of rating desc order
     */
    public List<Instruction> getDailyRating(InstructionTypeEnum instructionType) {
        LocalDate date = LocalDate.now();

        // take current day Instruction need to process based on instruction type
        List<Instruction> ratingList = list.stream().filter(curr -> curr.getSettlementDate().equals(date) && curr.getInstructionType().is(instructionType)).collect(Collectors.toList());

        // sort it in revered order
        ratingList.sort(Comparator.comparing(Instruction::getAmount).reversed());

        return ratingList;
    }

    /**
     * print daily rating result on console
     *
     * @param instructionType InstructionType (buy/sell)
     */
    public void processDailyRating(InstructionTypeEnum instructionType) {
        List<Instruction> res = getDailyRating(instructionType);
        String flag = "incoming";
        System.out.println(" -------------------Rating  report Start ---------------------");
        for (int i = 0; i < res.size(); i++) {

            // check the type yo update (incoming /outgoing)
            if (res.get(i).getInstructionType().is(InstructionTypeEnum.BUY)) {
                flag = "outgoing";
            }
            System.out.println(String.format(" -------------------Rating : %s : %s for  %s with amount  :%s ---------------------", i + 1, flag, res.get(i).getEntity(), res.get(i).getAmount()));

        }
        System.out.println(" -------------------Rating  report Ends ---------------------");

    }

    /**
     * just to print list to check settlement date adjusted properly
     *
     */
    public void print() {

        for (int i = 0; i < list.size(); i++) {

            System.out.println(String.format(" ------------------- %s : for  %s with amount  :%s  user SettlementDate : %s  system SettlementDate : %s---------------------", i + 1, list.get(i).getEntity(), list.get(i).getAmount(), list.get(i).getInstructedSettlementDate(), list.get(i).getSettlementDate()));

        }
    }


}
