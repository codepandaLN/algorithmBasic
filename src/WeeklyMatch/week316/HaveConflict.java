package WeeklyMatch.week316;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HaveConflict {
    public static SimpleDateFormat format = new SimpleDateFormat("HH:mm");

    public boolean haveConflict(String[] event1, String[] event2) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date leftStartDate = null;

        Date leftEndDate = null;

        Date rightStartDate = null;

        Date rightEndDate = null;


            leftStartDate = format.parse(event1[0]);

            leftEndDate = format.parse(event1[1]);

            rightStartDate = format.parse(event2[0]);

            rightEndDate = format.parse(event2[1]);


        return

                ((leftStartDate.getTime() >= rightStartDate.getTime())

                        && leftStartDate.getTime() < rightEndDate.getTime())

                        ||

                        ((leftStartDate.getTime() > rightStartDate.getTime())

                                && leftStartDate.getTime() <= rightEndDate.getTime())

                        ||

                        ((rightStartDate.getTime() >= leftStartDate.getTime())

                                && rightStartDate.getTime() < leftEndDate.getTime())

                        ||

                        ((rightStartDate.getTime() > leftStartDate.getTime())

                                && rightStartDate.getTime() <= leftEndDate.getTime());

    }

}

