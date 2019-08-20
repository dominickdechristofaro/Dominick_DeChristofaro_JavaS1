/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.16.2019
 *  Description:    Instantiate and test both ConverterIf and ConverterSwitch.
 *************************************************************************************************/
public class ConverterApplication {
    public static void main(String[] args) {
        // Instantiate both ConverterIf and ConverterSwitch
        ConverterIf converterIf = new ConverterIf();
        ConverterSwitch converterSwitch = new ConverterSwitch();

        // Show convertDay method is working for ConverterIf class
        System.out.println("ConverterIf Day Method");
        System.out.println("--------------------");
        System.out.println("ConverterIf Day 1: " + converterIf.convertDay(1));
        System.out.println("ConverterIf Day 2: " + converterIf.convertDay(2));
        System.out.println("ConverterIf Day 3: " + converterIf.convertDay(3));
        System.out.println("ConverterIf Day 4: " + converterIf.convertDay(4));
        System.out.println("ConverterIf Day 5: " + converterIf.convertDay(5));
        System.out.println("ConverterIf Day 6: " + converterIf.convertDay(6));
        System.out.println("ConverterIf Day 7: " + converterIf.convertDay(7));
        System.out.println("ConverterIf Day Error: " + converterIf.convertDay(8));
        System.out.println(" ");
        System.out.println(" ");

        // Show convertMonth method is working for ConverterIf class
        System.out.println("ConverterIf Month Method");
        System.out.println("----------------------");
        System.out.println("ConverterIf Month 01: " + converterIf.convertMonth(1));
        System.out.println("ConverterIf Month 02: " + converterIf.convertMonth(2));
        System.out.println("ConverterIf Month 03: " + converterIf.convertMonth(3));
        System.out.println("ConverterIf Month 04: " + converterIf.convertMonth(4));
        System.out.println("ConverterIf Month 05: " + converterIf.convertMonth(5));
        System.out.println("ConverterIf Month 06: " + converterIf.convertMonth(6));
        System.out.println("ConverterIf Month 07: " + converterIf.convertMonth(7));
        System.out.println("ConverterIf Month 08: " + converterIf.convertMonth(8));
        System.out.println("ConverterIf Month 09: " + converterIf.convertMonth(9));
        System.out.println("ConverterIf Month 10: " + converterIf.convertMonth(10));
        System.out.println("ConverterIf Month 11: " + converterIf.convertMonth(11));
        System.out.println("ConverterIf Month 12: " + converterIf.convertMonth(12));
        System.out.println("ConverterIf Month Error: " + converterIf.convertMonth(13));
        System.out.println(" ");
        System.out.println(" ");

        // Show convertDay method is working for ConverterSwitch class
        System.out.println("ConverterSwitch Day Method");
        System.out.println("------------------------");
        System.out.println("ConverterSwitch Day 1: " + converterSwitch.convertDay(1));
        System.out.println("ConverterSwitch Day 2: " + converterSwitch.convertDay(2));
        System.out.println("ConverterSwitch Day 3: " + converterSwitch.convertDay(3));
        System.out.println("ConverterSwitch Day 4: " + converterSwitch.convertDay(4));
        System.out.println("ConverterSwitch Day 5: " + converterSwitch.convertDay(5));
        System.out.println("ConverterSwitch Day 6: " + converterSwitch.convertDay(6));
        System.out.println("ConverterSwitch Day 7: " + converterSwitch.convertDay(7));
        System.out.println("ConverterSwitch Day Error: " + converterSwitch.convertDay(8));
        System.out.println(" ");
        System.out.println(" ");

        // Show convertMonth method is working for ConverterIf class
        System.out.println("ConverterSwitch Month Method");
        System.out.println("--------------------------");
        System.out.println("ConverterSwitch Month 01: " + converterSwitch.convertMonth(1));
        System.out.println("ConverterSwitch Month 02: " + converterSwitch.convertMonth(2));
        System.out.println("ConverterSwitch Month 03: " + converterSwitch.convertMonth(3));
        System.out.println("ConverterSwitch Month 04: " + converterSwitch.convertMonth(4));
        System.out.println("ConverterSwitch Month 05: " + converterSwitch.convertMonth(5));
        System.out.println("ConverterSwitch Month 06: " + converterSwitch.convertMonth(6));
        System.out.println("ConverterSwitch Month 07: " + converterSwitch.convertMonth(7));
        System.out.println("ConverterSwitch Month 08: " + converterSwitch.convertMonth(8));
        System.out.println("ConverterSwitch Month 09: " + converterSwitch.convertMonth(9));
        System.out.println("ConverterSwitch Month 10: " + converterSwitch.convertMonth(10));
        System.out.println("ConverterSwitch Month 11: " + converterSwitch.convertMonth(11));
        System.out.println("ConverterSwitch Month 12: " + converterSwitch.convertMonth(12));
        System.out.println("ConverterSwitch Month Error: " + converterSwitch.convertMonth(13));
    }
}
